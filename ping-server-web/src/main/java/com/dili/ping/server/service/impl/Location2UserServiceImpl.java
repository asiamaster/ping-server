package com.dili.ping.server.service.impl;

import com.dili.ping.server.dao.Location2UserMapper;
import com.dili.ping.server.domain.Location2User;
import com.dili.ping.server.service.Location2UserService;
import com.dili.utils.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2017-04-14 16:26:15.
 */
@Service
public class Location2UserServiceImpl extends BaseServiceImpl<Location2User, Long> implements Location2UserService {

    public Location2UserMapper getActualDao() {
        return (Location2UserMapper)getDao();
    }
}