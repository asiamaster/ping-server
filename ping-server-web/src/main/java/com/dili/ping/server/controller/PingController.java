package com.dili.ping.server.controller;

import com.alibaba.fastjson.JSONArray;
import com.dili.ping.server.dao.DeviceMapper;
import com.dili.ping.server.domain.Device;
import com.dili.ping.server.service.DeviceService;
import com.dili.ping.server.utils.PingUtil;
import com.dili.utils.quartz.domain.ScheduleJob;
import com.dili.utils.quartz.domain.ScheduleMessage;
import com.dili.utils.quartz.service.JobTaskService;
import com.google.common.collect.Lists;
import io.reactivex.Flowable;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;

/**
 * Created by asiam on 2017/3/21 0021.
 */
@Controller
@RequestMapping()
public class PingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PingController.class);

    @Autowired
    private JobTaskService jobTaskService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private DeviceMapper mapper;

//    @ApiOperation(value="mysql使用示例", notes="mysql使用示例")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", paramType = "query",value = "用户ID", required = true, dataType = "id")
//    })
    @RequestMapping("/refreshDevice")
    public String refreshDevice(Long deviceId, ModelMap model) {

        //根据设备ID找到对应的调度器

//        更新设备上报调度器的情况有三种，
//         1：检查当前调度器下如果没有设备，则删除当前调度器；
//         2：检查当前调度器下如果还有设备，首先要更新原调度器，然后又有两种情况：
//              2.1 新的调度模式是否已经存在，如果存在，则需要更新该调度器
//              2.2 新的调度模式如果不存在，则需要添加新的调度器

        //这里先测试下刷新调度器是否成功

        ScheduleJob scheduleJob = getRemoteJobByDeviceId(deviceId);
        try {
            jobTaskService.addJob(scheduleJob, false);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        model.put("result","刷新完成!");
        return "result";
    }

    @RequestMapping("/ping")
    public @ResponseBody void ping(@RequestBody ScheduleMessage scheduleMessage){
        List<String> deviceIds = JSONArray.parseArray(scheduleMessage.getJobData(), String.class);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("线程:"+Thread.currentThread().getName()+",当前调度Job:"+scheduleMessage.getJobGroup()+scheduleMessage.getJobName()+"运行第"+scheduleMessage.getSheduelTimes()+"次.");
        Flowable.fromArray(deviceIds).subscribe(System.out::println);
        try {
            LOGGER.debug("[PingController]扫描待执行消息...");
            if (deviceIds == null || deviceIds.isEmpty()) {
                return;
            }
            LOGGER.debug("[PingController]待执行数：" + (deviceIds == null ? 0 : deviceIds.size()) + "条");
            //获取设备
            Example example = new Example(Device.class);
            example.createCriteria().andIn("id", deviceIds);
            example.orderBy("id").desc();
            List<Device> devices = mapper.selectByExample(example);
            System.out.println(devices.size());
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private ScheduleJob getRemoteJobByDeviceId(Long deviceId){
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setUrl("http://localhost:8082/ping");
        scheduleJob.setCreateTime(new Date());
        scheduleJob.setDescription("ping任务1");
        scheduleJob.setId(1l);
        scheduleJob.setIsConcurrent(0);
        scheduleJob.setJobName("job1");
        scheduleJob.setJobGroup("group1");
        scheduleJob.setStartDelay(0);
        scheduleJob.setRepeatInterval(2);
        scheduleJob.setJobData(JSONArray.toJSONString(Lists.newArrayList(deviceId)));
        return scheduleJob;
    }

    private ScheduleJob getJobByDeviceId(Long deviceId){
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setSpringId("pingService");
        scheduleJob.setCreateTime(new Date());
        scheduleJob.setDescription("ping任务1");
        scheduleJob.setId(1l);
        scheduleJob.setIsConcurrent(0);
        scheduleJob.setJobName("job1");
        scheduleJob.setJobGroup("group1");
        scheduleJob.setMethodName("ping");
        scheduleJob.setStartDelay(0);
        scheduleJob.setRepeatInterval(2);
        scheduleJob.setJobData(JSONArray.toJSONString(Lists.newArrayList(deviceId)));
        return scheduleJob;
    }

    @RequestMapping("/deleteDevice")
    public String deleteDevice(Long deviceId, ModelMap model) {
        try {
            jobTaskService.deleteJob(getJobByDeviceId(deviceId));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        model.put("result","刷新完成!");
        return "result";
    }

    @RequestMapping("/pauseJob")
    public String pauseJob( ModelMap model) {
        try {
            jobTaskService.pauseJob(getJobByDeviceId(0l));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        model.put("result","刷新完成!");
        return "result";
    }

    @RequestMapping("/resumeJob")
    public String resumeJob( ModelMap model) {
        try {
            jobTaskService.resumeJob(getJobByDeviceId(0l));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        model.put("result","刷新完成!");
        return "result";
    }

    @RequestMapping("/getRunningJob")
    public String getRunningJob( ModelMap model) {
        try {
            List<ScheduleJob> scheduleJobs = jobTaskService.getRunningJob();
            for(ScheduleJob scheduleJob : scheduleJobs){
                System.out.println("运行中的job:"+scheduleJob.getJobGroup()+":"+scheduleJob.getJobName()+",repeatInterval:"+scheduleJob.getRepeatInterval()+"s");
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        model.put("result","刷新完成!");
        return "result";
    }

    @RequestMapping("/beetl")
    public String beetl(@ModelAttribute Device deivce, ModelMap model) {

        List<Device> devices = Lists.newArrayList();
        Device device = new Device();
        device.setYn(1);
        device.setId(1010l);
        device.setLaunchTime(new Date());
        devices.add(device);
        device = new Device();
        device.setYn(0);
        devices.add(device);
        device.setId(360l);
        device.setLaunchTime(new Date(System.currentTimeMillis()-3600000l));
        List<Long> ids = Lists.newArrayList(1l);
        deviceService.delete(ids);
        model.put("devices", devices);
        model.put("result","刷新完成!");
        return "beetl";
    }

    @RequestMapping("/addDevices")
    public String addDevices( ModelMap model) {
        List<Device> devices = deviceService.list(new Device());
        System.out.println(devices);
        //添加设备
        List<Device> ds = Lists.newArrayList();
        for(int j=1;j<2;j++) {
            String hostPrefix = "10.28."+j+".";
            for (int i = 1; i < 254; i++) {
                Device d = new Device();
                d.setYn(1);

                d.setId(new Long(i + ""));
                d.setLaunchTime(new Date());
                d.setHost(hostPrefix+i);
                d.setName(hostPrefix+i);
                ds.add(d);
            }
        }
        deviceService.batchInsert(ds);
        model.put("result","设备添加完成!");
        return "result";
    }

    @RequestMapping("/addDeviceJob")
    public String addDeviceJob( ModelMap model) {
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setSpringId("pingService");
        scheduleJob.setCreateTime(new Date());
        scheduleJob.setDescription("ping任务1");
        scheduleJob.setId(1l);
        scheduleJob.setIsConcurrent(1);
        scheduleJob.setJobName("job1");
        scheduleJob.setJobGroup("group1");
        scheduleJob.setMethodName("ping");
        scheduleJob.setStartDelay(0);
        scheduleJob.setRepeatInterval(4);
        scheduleJob.setJobData(JSONArray.toJSONString(Lists.newArrayList(3038l)));
        try {
            jobTaskService.addJob(scheduleJob, true);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        model.put("result","设备添加完成!");
        return "result";
    }

}
