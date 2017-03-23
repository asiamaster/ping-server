package com.dili.ping.server.service.impl;

import com.dili.ping.server.constants.PingConstants;
import com.dili.ping.server.dao.DeviceMapper;
import com.dili.ping.server.domain.Device;
import com.dili.ping.server.schedule.PingScheduleExecutor;
import com.dili.ping.server.utils.PingUtil;
import io.reactivex.Flowable;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.PostConstruct;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.*;

/**
 * ping服务
 */
@Service
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PingService.class);

    //    初始线程数
    private int corePoolSize = 8;
    //    极限线程数，初始线程不够用时 申请新的线程
    private int maximumPoolSize = 128;
    //    30秒   配合allowCoreThreadTimeOut参数
    private int keepAliveTime = 30;
    //    多线程执行器
    private ThreadPoolExecutor executor;
    @Autowired
    private DeviceMapper mapper;

    /**
     * 运行PingServer机器地址
     */
    private String serverName;

    @PostConstruct
    public void init() {
        try {
            InetAddress inetAddress = Inet4Address.getLocalHost();
            if (StringUtils.isNotBlank(inetAddress.getHostAddress())) {
                serverName = "PingServer[" + inetAddress.getHostAddress() + "]";
            }
        } catch (Exception e) {
            LOGGER.warn("[PingServer]获取运行机器名失败，发生异常：" + e.getMessage());
            serverName = "";
        }
        executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        executor.allowCoreThreadTimeOut(true);
        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                LOGGER.error(serverName + "[PingServer]消息处理线程池：线程池已满，无法接收处理-新任务：" + r.toString());
                LOGGER.info(serverName + "[PingServer]消息处理线程池：使用非线程池线程处理");
                if (!executor.isShutdown()) {
                    Thread th = new Thread(r);
                    th.start();
                }
            }
        });
    }

    //    @Scheduled(fixedRate = 5000)
    public void ping(List<String> deviceIds, String key) {

        Integer callTimes = PingConstants.sheduelTimes.get(key);
        System.out.println("线程:"+Thread.currentThread().getName()+",当前调度Job:"+key+"运行第"+callTimes+"次.");
        Flowable.fromArray(deviceIds).subscribe(System.out::println);
        try {
            LOGGER.debug(serverName + "[PingServer]扫描待执行消息...");
            if (deviceIds == null || deviceIds.isEmpty()) {
                return;
            }
            LOGGER.debug(serverName + "[PingServer]待执行数：" + (deviceIds == null ? 0 : deviceIds.size()) + "条");
            //获取设备
            Example example = new Example(Device.class);
            example.createCriteria().andIn("id", deviceIds);
            example.orderBy("id").desc();
            List<Device> devices = mapper.selectByExample(example);
            CompletionService<Device> completionService = new ExecutorCompletionService<Device>(executor);
            for (Device device : devices) {
                completionService.submit(
                        () -> {
                            long start = System.currentTimeMillis();
                            device.setRunning(PingUtil.isPing(device.getHost()));
                            device.setCost(System.currentTimeMillis() - start);
                            Thread.sleep(3000);
                            return device;
                        }
                );
            }
            System.out.println("===================================");
            for (int i = 0; i < devices.size(); i++) {
                Device device = completionService.take().get();
                System.out.println("ping " + device.getHost() + ",running:" + device.getRunning() + ",cost:" + device.getCost() + "ms");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

}
