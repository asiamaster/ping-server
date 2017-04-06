package com.dili.ping.server.utils.bootquartz.service;

import com.dili.ping.server.constants.PingConstants;
import com.dili.ping.server.dao.DeviceMapper;
import com.dili.ping.server.domain.Device;
import com.dili.ping.server.service.DeviceService;
import com.dili.ping.server.utils.bootquartz.domain.ScheduleJob;
import com.dili.ping.server.utils.bootquartz.job.QuartzJobDisallowConcurrentExecutionFactory;
import com.dili.ping.server.utils.bootquartz.job.QuartzJobFactory;
import com.dili.utils.SpringUtil;
import com.google.common.collect.Lists;
import io.reactivex.Flowable;
import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by asiam on 2017/3/21 0021.
 */
@Service
public class JobTaskService implements ApplicationListener<ContextRefreshedEvent> {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DeviceMapper mapper;
    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    private DeviceService deviceService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(contextRefreshedEvent.getApplicationContext().getParent() == null) {
            //        Scheduler scheduler = schedulerFactoryBean.getScheduler();
            // 这里获取任务信息数据
//        List<QuartzJobFactory> test = scheduleJobMapper.getAll();
            List<ScheduleJob> jobList = new ArrayList<>();
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
            scheduleJob.setRepeatInterval(10);
            jobList.add(scheduleJob);
//        scheduleJob = new ScheduleJob();
//        scheduleJob.setSpringId("pingService");
//        scheduleJob.setCreateTime(new Date());
//        scheduleJob.setDescription("ping任务2");
//        scheduleJob.setIsConcurrent(1);
//        scheduleJob.setId(2l);
//        scheduleJob.setJobName("job2");
//        scheduleJob.setJobGroup("group2");
//        scheduleJob.setMethodName("ping");
//        scheduleJob.setStartDelay(0);
//        scheduleJob.setRepeatInterval(10);
//        jobList.add(scheduleJob);

            //只循环一次，测试放入多台设备ping
//        mapper.selectAll();
            System.out.println();
            for (ScheduleJob job : jobList) {
                Device tmp = new Device();
                List<Device> devices = deviceService.list(tmp);
                List<Long> ids = Lists.newArrayList();
                for(Device device : devices){
                    ids.add(device.getId());
                    break;
                }
                try {
                    addJob(job, ids);
                } catch (SchedulerException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 添加任务
     *
     * @param job
     * @throws SchedulerException
     */
    public void addJob(ScheduleJob job, List<Long> targetIds) throws SchedulerException {
        if (job == null || ScheduleJob.STATUS_RUNNING.equals(job.getJobStatus())) {
            return;
        }
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        log.debug(scheduler + ".......................................................................................add");
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
        Trigger trigger = scheduler.getTrigger(triggerKey);
        // 不存在，创建一个
        if (null == trigger) {
            Class clazz = ScheduleJob.CONCURRENT_IS.equals(job.getIsConcurrent()) ? QuartzJobFactory.class : QuartzJobDisallowConcurrentExecutionFactory.class;
            JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(job.getJobName(), job.getJobGroup()).build();
            jobDetail.getJobDataMap().put(PingConstants.jobDataMapScheduleJobKey, job);
            jobDetail.getJobDataMap().put(PingConstants.jobDataMapTargetIdsKey, targetIds);
            jobDetail.getJobDataMap().put(PingConstants.jobDataMapSheduelTimesKey,job.getJobGroup()+job.getJobName());
            ScheduleBuilder scheduleBuilder = null;
            //优先执行有表达式的job，没有表达式则使用简单调度器，间隔调度
            if (StringUtils.isBlank(job.getCronExpression())) {
                scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().repeatSecondlyForever(job.getRepeatInterval());
            } else {
                scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
            }
            if (job.getStartDelay() != null && job.getStartDelay() > 0) {
                Long startDelayTime = System.currentTimeMillis() + (job.getStartDelay() * 1000);
                trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).startAt(new Date(startDelayTime)).withSchedule(scheduleBuilder).build();
            } else {
                trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();
            }
            scheduler.scheduleJob(jobDetail, trigger);
        } else {
            //优先执行有表达式的job，没有表达式则使用简单调度器，间隔调度
            if (StringUtils.isBlank(job.getCronExpression())) {
                //按新的间隔构建trigger
                SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().repeatSecondlyForever(job.getRepeatInterval());
                SimpleTrigger simpleTrigger = (SimpleTrigger) trigger;
                trigger = simpleTrigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            } else {
                // Trigger已存在，那么更新相应的定时设置
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
                CronTrigger cronTrigger = (CronTrigger) trigger;
                // 按新的cronExpression表达式重新构建trigger
                trigger = cronTrigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            }
            Class clazz = ScheduleJob.CONCURRENT_IS.equals(job.getIsConcurrent()) ? QuartzJobFactory.class : QuartzJobDisallowConcurrentExecutionFactory.class;
            JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(job.getJobName(), job.getJobGroup()).storeDurably(true).build();
            List<Long> currentTargetIds = (List)scheduler.getJobDetail(JobKey.jobKey(job.getJobName(),job.getJobGroup())).getJobDataMap().get(PingConstants.jobDataMapTargetIdsKey);
            Flowable.fromArray(targetIds).filter(s->!currentTargetIds.contains(s)).subscribe(ids ->currentTargetIds.addAll(ids));
            // durable, 指明任务就算没有绑定Trigger仍保留在Quartz的JobStore中,
            jobDetail.getJobDataMap().put(PingConstants.jobDataMapScheduleJobKey, job);
            jobDetail.getJobDataMap().put(PingConstants.jobDataMapTargetIdsKey, currentTargetIds);
            jobDetail.getJobDataMap().put(PingConstants.jobDataMapSheduelTimesKey,job.getJobGroup()+job.getJobName());
            scheduler.addJob(jobDetail, true);
            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        }
    }

    /**
     * 所有正在运行的job
     *
     * @return
     * @throws SchedulerException
     */
    public List<ScheduleJob> getRunningJob() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
        List<ScheduleJob> jobList = new ArrayList<ScheduleJob>(executingJobs.size());
        for (JobExecutionContext executingJob : executingJobs) {
            ScheduleJob job = new ScheduleJob();
            JobDetail jobDetail = executingJob.getJobDetail();
            JobKey jobKey = jobDetail.getKey();
            Trigger trigger = executingJob.getTrigger();
            job.setJobName(jobKey.getName());
            job.setJobGroup(jobKey.getGroup());
            job.setDescription("触发器:" + trigger.getKey());

            Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
            job.setJobStatus(triggerState.name());
            if (trigger instanceof CronTrigger) {
                CronTrigger cronTrigger = (CronTrigger) trigger;
                String cronExpression = cronTrigger.getCronExpression();
                job.setCronExpression(cronExpression);
            }else{
                SimpleTrigger simpleTrigger = (SimpleTrigger) trigger;
                job.setRepeatInterval(new Long(simpleTrigger.getRepeatInterval()).intValue()/1000);
            }
            jobList.add(job);
        }
        return jobList;
    }

    /**
     * 暂停一个job
     *
     * @param scheduleJob
     * @throws SchedulerException
     */
    public void pauseJob(ScheduleJob scheduleJob) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
        scheduler.pauseJob(jobKey);
    }

    /**
     * 恢复一个job
     *
     * @param scheduleJob
     * @throws SchedulerException
     */
    public void resumeJob(ScheduleJob scheduleJob) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
        scheduler.resumeJob(jobKey);
    }

    /**
     * 删除一个job
     *
     * @param scheduleJob
     * @throws SchedulerException
     */
    public void deleteJob(ScheduleJob scheduleJob) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
        scheduler.deleteJob(jobKey);

    }

    /**
     * 立即执行job
     *
     * @param scheduleJob
     * @throws SchedulerException
     */
    public void runJobNow(ScheduleJob scheduleJob) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
        scheduler.triggerJob(jobKey);
    }

    /**
     * 更新job时间表达式
     *
     * @param scheduleJob
     * @throws SchedulerException
     */
    public void updateJob(ScheduleJob scheduleJob) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
        Trigger trigger = null;
        //优先执行有表达式的job，没有表达多则使用简单调度器，间隔调度
        if (StringUtils.isBlank(scheduleJob.getCronExpression())) {
            trigger = (SimpleTrigger)scheduler.getTrigger(triggerKey);
        }else{
            trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        }
        //优先执行有表达式的job，没有表达多则使用简单调度器，间隔调度
        if (StringUtils.isBlank(scheduleJob.getCronExpression())) {
            //按新的间隔构建trigger
            SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().repeatSecondlyForever(scheduleJob.getRepeatInterval());
            SimpleTrigger simpleTrigger = (SimpleTrigger) trigger;
            trigger = simpleTrigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
        } else {
            // Trigger已存在，那么更新相应的定时设置
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
            CronTrigger cronTrigger = (CronTrigger) trigger;
            // 按新的cronExpression表达式重新构建trigger
            trigger = cronTrigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
        }
        scheduler.rescheduleJob(triggerKey, trigger);
    }

}
