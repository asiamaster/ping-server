package com.dili.ping.server.utils.bootquartz.job;

import com.dili.ping.server.constants.PingConstants;
import com.dili.ping.server.utils.bootquartz.TaskUtils;
import com.dili.ping.server.utils.bootquartz.domain.ScheduleJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Author: wangmi
 * @Description: 并行job
 */
public class QuartzJobFactory implements Job {

    protected Logger log = LoggerFactory.getLogger(this.getClass());
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        ScheduleJob scheduleJob = (ScheduleJob) jobExecutionContext.getMergedJobDataMap().get(PingConstants.jobDataMapScheduleJobKey);
        List<String> targetIds = (List)jobExecutionContext.getMergedJobDataMap().get(PingConstants.jobDataMapTargetIdsKey);
        String jobDataMapSheduelTimesKey = (String)jobExecutionContext.getMergedJobDataMap().get(PingConstants.jobDataMapSheduelTimesKey);
        TaskUtils.invokeMethod(scheduleJob, targetIds, jobDataMapSheduelTimesKey);

    }
}
