package com.dili.ping.server.service.impl;

import com.dili.ping.server.dao.Group2PersonMapper;
import com.dili.ping.server.domain.Group2Person;
import com.dili.ping.server.service.Group2PersonService;
import com.dili.utils.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2017-04-14 16:26:15.
 */
@Service
public class Group2PersonServiceImpl extends BaseServiceImpl<Group2Person, Long> implements Group2PersonService {

    public Group2PersonMapper getActualDao() {
        return (Group2PersonMapper)getDao();
    }
}