package com.dili.ping.server.service.impl;

import com.dili.ping.server.dao.ScheduleJobMapper;
import com.dili.ping.server.domain.ScheduleJob;
import com.dili.ping.server.service.ScheduleJobService;
import com.dili.utils.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2017-04-14 16:26:15.
 */
@Service
public class ScheduleJobServiceImpl extends BaseServiceImpl<ScheduleJob, Long> implements ScheduleJobService {

    public ScheduleJobMapper getActualDao() {
        return (ScheduleJobMapper)getDao();
    }
}