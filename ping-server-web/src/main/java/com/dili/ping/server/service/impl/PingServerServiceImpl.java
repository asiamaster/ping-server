package com.dili.ping.server.service.impl;

import com.dili.ping.server.dao.PingServerMapper;
import com.dili.ping.server.domain.PingServer;
import com.dili.ping.server.service.PingServerService;
import com.dili.utils.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2017-04-14 16:26:15.
 */
@Service
public class PingServerServiceImpl extends BaseServiceImpl<PingServer, Long> implements PingServerService {

    public PingServerMapper getActualDao() {
        return (PingServerMapper)getDao();
    }
}