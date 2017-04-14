package com.dili.ping.server.service.impl;

import com.dili.ping.server.dao.DataDictionaryMapper;
import com.dili.ping.server.domain.DataDictionary;
import com.dili.ping.server.service.DataDictionaryService;
import com.dili.utils.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2017-04-14 16:26:15.
 */
@Service
public class DataDictionaryServiceImpl extends BaseServiceImpl<DataDictionary, Long> implements DataDictionaryService {

    public DataDictionaryMapper getActualDao() {
        return (DataDictionaryMapper)getDao();
    }
}