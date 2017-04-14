package com.dili.ping.server.service.impl;

import com.dili.ping.server.dao.DeviceMapper;
import com.dili.ping.server.domain.Device;
import com.dili.ping.server.service.DeviceService;
import com.dili.utils.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2017-04-14 16:26:15.
 */
@Service
public class DeviceServiceImpl extends BaseServiceImpl<Device, Long> implements DeviceService {

    public DeviceMapper getActualDao() {
        return (DeviceMapper)getDao();
    }

    @Override
    public List<Device> selectChildren(Long id) {
        return getActualDao().selectChildren(id);
    }
}