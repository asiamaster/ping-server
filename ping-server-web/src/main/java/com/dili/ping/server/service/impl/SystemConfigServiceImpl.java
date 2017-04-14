package com.dili.ping.server.service.impl;

import com.dili.ping.server.dao.SystemConfigMapper;
import com.dili.ping.server.domain.SystemConfig;
import com.dili.ping.server.service.SystemConfigService;
import com.dili.utils.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2017-04-14 16:26:15.
 */
@Service
public class SystemConfigServiceImpl extends BaseServiceImpl<SystemConfig, Long> implements SystemConfigService {

    public SystemConfigMapper getActualDao() {
        return (SystemConfigMapper)getDao();
    }
}