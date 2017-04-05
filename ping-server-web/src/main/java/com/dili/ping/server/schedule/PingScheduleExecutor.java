package com.dili.ping.server.schedule;

import com.dili.ping.server.domain.Client;
import com.dili.ping.server.utils.PingUtil;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.*;

/**
 * Ping服务端定时调度器
 */
@Component
public class PingScheduleExecutor {
    private static final Logger LOGGER = LoggerFactory.getLogger(PingScheduleExecutor.class);
    private final static int IDLE = 0;
    private final static int RUNNING = 1;
    //    初始线程数
    private int corePoolSize = 8;
    //    极限线程数，初始线程不够用时 申请新的线程
    private int maximumPoolSize = 128;
    //    30秒   配合allowCoreThreadTimeOut参数
    private int keepAliveTime = 30;
    //    多线程执行器
    private ThreadPoolExecutor executor;
    private volatile int state = IDLE;

    /**
     * 运行PingServer机器地址
     */
    private String serverName;

//    @PostConstruct
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
    public void execute() {
        if (isRunning()) {
            return;
        }
        try {
            synchronized (this) {
                if (isRunning()) {
                    return;
                }
                setState(RUNNING);
                LOGGER.debug(serverName + "[DTMS]扫描待执行消息...");
                List<Client> clients = getClients();
                if (clients == null || clients.isEmpty()) {
                    return;
                }
                LOGGER.debug(serverName + "[PingServer]待执行数：" + (clients == null ? 0 : clients.size()) + "条");
                CompletionService<Client> completionService = new ExecutorCompletionService<Client>(executor);
                for(Client client : clients){
                    completionService.submit(
                            () -> {
                                long start = System.currentTimeMillis();
                                client.setRunning(PingUtil.isReachable(client.getHost()));
                                client.setCost(System.currentTimeMillis()-start);
                                return client;
                            }
                    );
                }
                System.out.println("===================================");
                for(int i = 0; i< clients.size(); i++){
                    Client client = completionService.take().get();
                    System.out.println("ping "+ client.getHost()+",running:"+ client.getRunning()+",cost:"+ client.getCost()+"ms");
                }

                setState(IDLE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            setState(IDLE);
        }
    }

    private boolean isRunning() {
        final int _state = state;
        return _state == RUNNING;
    }

    private void setState(int state) {
        this.state = state;
    }

    private List<Client> getClients(){
        List<Client> clients = Lists.newArrayList();
        Client client = new Client();
        client.setHost("10.28.6.51");
        clients.add(client);
        client = new Client();
        client.setHost("10.28.10.161");
        clients.add(client);
        client = new Client();
        client.setHost("10.28.10.162");
        clients.add(client);
        client = new Client();
        client.setHost("10.28.10.160");
        clients.add(client);
        client = new Client();
        client.setHost("10.28.10.177");
        clients.add(client);
        client = new Client();
        client.setHost("192.168.222.222");
        clients.add(client);
        return clients;
    }


}
