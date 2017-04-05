package com.dili.ping.server.service;

import com.dili.ping.server.domain.Device2ScheduelJob;

import java.util.List;

/**
 * Created by asiam on 2017/3/27 0027.
 */
public interface Device2ScheduelJobService {

    public List<Device2ScheduelJob> select(Device2ScheduelJob device2ScheduelJob);

    public int insert(Device2ScheduelJob device2ScheduelJob);

    public int delete(Long id);

    public int deleteList(List<Long> ids);

    public int insertList(List<Device2ScheduelJob> device2ScheduelJobs);
}
