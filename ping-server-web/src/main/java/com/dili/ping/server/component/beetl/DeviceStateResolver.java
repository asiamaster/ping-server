package com.dili.ping.server.component.beetl;

import com.dili.ping.server.domain.Device;
import com.dili.ping.server.domain.DeviceStateEnum;
import com.dili.utils.beetl.VirtualAttributeResolver;
import org.springframework.stereotype.Component;

/**
 * 设备状态虚拟属性解析器示例
 * Created by asiamastor on 2017/3/23.
 */
@Component
public class DeviceStateResolver implements VirtualAttributeResolver {
    @Override
    public String resolve(Object o, String attrName) {
        Device user = (Device) o;
        if(attrName.equals("state") && user.getYn() != null)
            return DeviceStateEnum.getDeviceStateEnum(user.getYn()).getDesc();
        return "";
    }

    @Override
    public Class resolveClass() {
        return Device.class;
    }
}
