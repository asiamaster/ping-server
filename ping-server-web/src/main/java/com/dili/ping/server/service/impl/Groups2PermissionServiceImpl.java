package com.dili.ping.server.service.impl;

import com.dili.ping.server.dao.Groups2PermissionMapper;
import com.dili.ping.server.domain.Groups2Permission;
import com.dili.ping.server.service.Groups2PermissionService;
import com.dili.utils.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2017-04-14 16:26:15.
 */
@Service
public class Groups2PermissionServiceImpl extends BaseServiceImpl<Groups2Permission, Long> implements Groups2PermissionService {

    public Groups2PermissionMapper getActualDao() {
        return (Groups2PermissionMapper)getDao();
    }
}