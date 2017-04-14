package com.dili.ping.server.service;

import com.dili.ping.server.domain.Device;
import com.dili.utils.base.BaseService;

import java.util.List;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2017-04-14 16:26:15.
 */
public interface DeviceService extends BaseService<Device, Long> {
    public List<Device> selectChildren(Long id);
}