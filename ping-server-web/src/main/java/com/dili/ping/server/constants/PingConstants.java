package com.dili.ping.server.constants;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by asiam on 2017/3/22 0022.
 */
public class PingConstants {
    //缓存每个调度器的调度次数，key为调度器组名+名称，value为调度次数
    public static Map<String, Integer> sheduelTimes = new ConcurrentHashMap<>();
    public static final String jobDataMapSheduelTimesKey = "JOB_DATA_SHEDUEL_TIMES_KEY";
    public static final String jobDataMapScheduleJobKey = "JOB_DATA_MAPSCHEDULE_JOB_KEY";
    public static final String jobDataMapTargetIdsKey = "JOB_DATA_TARGET_IDS_KEY";

}
