package com.dili.ping.server.service.impl;

import com.dili.ping.server.dao.PermissionMapper;
import com.dili.ping.server.domain.Permission;
import com.dili.ping.server.service.PermissionService;
import com.dili.utils.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2017-04-14 16:26:15.
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission, Long> implements PermissionService {

    public PermissionMapper getActualDao() {
        return (PermissionMapper)getDao();
    }
}