package com.dili.ping.server.service.impl;

import com.dili.ping.server.dao.Device2ScheduelJobMapper;
import com.dili.ping.server.domain.Device2ScheduelJob;
import com.dili.ping.server.service.Device2ScheduelJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by asiam on 2017/3/27 0027.
 */
@Service
public class Device2ScheduelJobServiceImpl implements Device2ScheduelJobService{
    @Autowired
    private Device2ScheduelJobMapper mapper;
    @Override
    public List<Device2ScheduelJob> select(Device2ScheduelJob device2ScheduelJob) {
        return mapper.select(device2ScheduelJob);
    }

    @Override
    public int insert(Device2ScheduelJob device2ScheduelJob) {
        return mapper.insert(device2ScheduelJob);
    }

    @Override
    public int delete(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteList(List<Long> ids) {
        Example example = new Example(Device2ScheduelJob.class);
        example.createCriteria().andIn("id", ids);
        return mapper.deleteByExample(example);
    }

    @Override
    public int insertList(List<Device2ScheduelJob> device2ScheduelJobs) {
        return mapper.insertList(device2ScheduelJobs);
    }
}
