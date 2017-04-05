package com.dili.ping.server.service.impl;

import com.dili.ping.server.dao.Device2ScheduelJobMapper;
import com.dili.ping.server.dao.DeviceMapper;
import com.dili.ping.server.domain.Device;
import com.dili.ping.server.domain.Device2ScheduelJob;
import com.dili.ping.server.service.Device2ScheduelJobService;
import com.dili.ping.server.service.DeviceService;
import com.dili.utils.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asiam on 2017/3/27 0027.
 */
@Service
public class DeviceServiceImpl extends BaseServiceImpl<Device, Long> implements DeviceService {

    @Autowired
    private DeviceMapper mapper;

    @Autowired
    private Device2ScheduelJobService device2ScheduelJobService;

    @Override
    public int insertList(List<Device> devices){
        List<Device2ScheduelJob> device2ScheduelJobs = new ArrayList<>(devices.size());
        for(Device d : devices){
            Device2ScheduelJob dsj = new Device2ScheduelJob();
            dsj.setDeviceId(d.getId());
            dsj.setScheduelJobId(1l);
            device2ScheduelJobs.add(dsj);
        }
        device2ScheduelJobService.insertList(device2ScheduelJobs);
        return mapper.insertList(devices);
    }


    @Override
    public int deleteList(List<Long> ids) {
        Example example = new Example(Device.class);
        example.createCriteria().andIn("id", ids);
        return mapper.deleteByExample(example);
    }
}
