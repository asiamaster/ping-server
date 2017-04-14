package com.dili.ping.server.service.impl;

import com.dili.ping.server.dao.DataDictionaryValueMapper;
import com.dili.ping.server.domain.DataDictionaryValue;
import com.dili.ping.server.service.DataDictionaryValueService;
import com.dili.utils.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2017-04-14 16:26:15.
 */
@Service
public class DataDictionaryValueServiceImpl extends BaseServiceImpl<DataDictionaryValue, Long> implements DataDictionaryValueService {

    public DataDictionaryValueMapper getActualDao() {
        return (DataDictionaryValueMapper)getDao();
    }
}