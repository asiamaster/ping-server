package com.dili.ping.server.service;

import com.dili.ping.server.domain.Device;

import java.util.List;

/**
 * Created by asiam on 2017/3/27 0027.
 */
public interface DeviceService {

    public List<Device> list(Device device);

    public int insert(Device device);

    public int del(Long id);

    public int deleteList(List<Long> ids);

    public int insertList(List<Device> devices);

}
