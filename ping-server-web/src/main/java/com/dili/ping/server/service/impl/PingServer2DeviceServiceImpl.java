package com.dili.ping.server.service.impl;

import com.dili.ping.server.dao.PingServer2DeviceMapper;
import com.dili.ping.server.domain.PingServer2Device;
import com.dili.ping.server.service.PingServer2DeviceService;
import com.dili.utils.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2017-04-14 16:26:15.
 */
@Service
public class PingServer2DeviceServiceImpl extends BaseServiceImpl<PingServer2Device, Long> implements PingServer2DeviceService {

    public PingServer2DeviceMapper getActualDao() {
        return (PingServer2DeviceMapper)getDao();
    }
}