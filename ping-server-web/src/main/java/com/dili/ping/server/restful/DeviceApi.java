package com.dili.ping.server.restful;

import com.dili.ping.server.domain.Device;
import com.dili.ping.server.service.DeviceService;
import com.dili.utils.domain.BaseOutput;
import com.dili.utils.domain.ResponseMessage;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2017-04-14 16:26:15.
 */
@Controller
@RequestMapping("/deviceApi")
public class DeviceApi {
    @Autowired
    DeviceService deviceService;


    @RequestMapping("/query")
    public @ResponseBody BaseOutput<List<Device>> query(@RequestBody Device device) {
        return BaseOutput.success().setData(deviceService.list(device));
    }

    @RequestMapping("/queryById")
    public @ResponseBody BaseOutput<Device> query(@RequestBody Long id) {
        return BaseOutput.success().setData(deviceService.get(id));
    }

    @RequestMapping("/get")
    public @ResponseBody BaseOutput<Device> get(Long id) {
        return BaseOutput.success().setData(deviceService.get(id));
    }

    @RequestMapping("/delete")
    public @ResponseBody BaseOutput delete(Long id) {
        deviceService.delete(id);
        return BaseOutput.success();
    }
}