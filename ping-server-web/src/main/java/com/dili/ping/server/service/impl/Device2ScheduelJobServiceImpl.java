package com.dili.ping.server.service.impl;

import com.dili.ping.server.dao.Device2ScheduelJobMapper;
import com.dili.ping.server.domain.Device2ScheduelJob;
import com.dili.ping.server.service.Device2ScheduelJobService;
import com.dili.utils.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2017-04-14 16:26:15.
 */
@Service
public class Device2ScheduelJobServiceImpl extends BaseServiceImpl<Device2ScheduelJob, Long> implements Device2ScheduelJobService {

    public Device2ScheduelJobMapper getActualDao() {
        return (Device2ScheduelJobMapper)getDao();
    }
}