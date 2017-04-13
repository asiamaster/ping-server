package com.dili.ping.server.controller;

import com.dili.ping.server.domain.Device;
import com.dili.ping.server.service.DeviceService;
import com.dili.ping.server.utils.bootquartz.domain.ScheduleJob;
import com.dili.ping.server.utils.bootquartz.service.JobTaskService;
import com.google.common.collect.Lists;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * Created by asiam on 2017/3/21 0021.
 */
@Controller
@RequestMapping()
public class PingController {

    @Autowired
    private JobTaskService jobTaskService;

    @Autowired
    private DeviceService deviceService;
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

        ScheduleJob scheduleJob = getJobByDeviceId(deviceId);
        try {
            jobTaskService.updateJob(scheduleJob);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        model.put("result","刷新完成!");
        return "result";
    }

    private ScheduleJob getJobByDeviceId(Long deviceId){
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
        scheduleJob.setRepeatInterval(2);
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
        deviceService.del(ids);
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
        try {
            jobTaskService.addJob(scheduleJob, Lists.newArrayList(3038l));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        model.put("result","设备添加完成!");
        return "result";
    }

}
