package com.dili.ping.server.dao;

import com.dili.ping.server.domain.Device;
import com.dili.ping.server.domain.DeviceExample;
import com.dili.utils.base.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceMapper extends MyMapper<Device> {
    long countByExample(DeviceExample example);

    int deleteByExample(DeviceExample example);

    List<Device> selectByExample(DeviceExample example);

    int updateByExampleSelective(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByExample(@Param("record") Device record, @Param("example") DeviceExample example);
}