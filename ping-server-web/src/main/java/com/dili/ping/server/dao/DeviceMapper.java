package com.dili.ping.server.dao;

import com.dili.ping.server.domain.Device;
import com.dili.utils.base.MyMapper;

import java.util.List;

public interface DeviceMapper extends MyMapper<Device> {
    public List<Device> selectChildren(Long id);
}