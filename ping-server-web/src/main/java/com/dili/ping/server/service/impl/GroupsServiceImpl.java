package com.dili.ping.server.service.impl;

import com.dili.ping.server.dao.GroupsMapper;
import com.dili.ping.server.domain.Groups;
import com.dili.ping.server.service.GroupsService;
import com.dili.utils.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2017-04-14 16:26:15.
 */
@Service
public class GroupsServiceImpl extends BaseServiceImpl<Groups, Long> implements GroupsService {

    public GroupsMapper getActualDao() {
        return (GroupsMapper)getDao();
    }
}