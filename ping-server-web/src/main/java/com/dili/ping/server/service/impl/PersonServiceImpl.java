package com.dili.ping.server.service.impl;

import com.dili.ping.server.dao.PersonMapper;
import com.dili.ping.server.domain.Person;
import com.dili.ping.server.service.PersonService;
import com.dili.utils.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2017-04-14 16:26:15.
 */
@Service
public class PersonServiceImpl extends BaseServiceImpl<Person, Long> implements PersonService {

    public PersonMapper getActualDao() {
        return (PersonMapper)getDao();
    }
}