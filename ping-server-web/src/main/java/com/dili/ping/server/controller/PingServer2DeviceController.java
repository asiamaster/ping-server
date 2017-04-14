package com.dili.ping.server.controller;

import com.dili.ping.server.domain.PingServer2Device;
import com.dili.ping.server.service.PingServer2DeviceService;
import com.dili.utils.domain.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2017-04-14 16:26:15.
 */
@Controller
@RequestMapping("/pingServer2Device")
public class PingServer2DeviceController {
    @Autowired
    PingServer2DeviceService pingServer2DeviceService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap, @ModelAttribute PingServer2Device pingServer2Device) {
        modelMap.put("list", pingServer2DeviceService.list(pingServer2Device));
        return "pingServer2Device/list";
    }

    @RequestMapping("/insert")
    public String insert(ModelMap modelMap, @ModelAttribute PingServer2Device pingServer2Device) {
        pingServer2DeviceService.insertSelective(pingServer2Device);
        return "pingServer2Device/insert";
    }

    @RequestMapping("/update")
    public String update(ModelMap modelMap, @ModelAttribute PingServer2Device pingServer2Device) {
        pingServer2DeviceService.update(pingServer2Device);
        return "pingServer2Device/update";
    }

    @RequestMapping("/delete")
    public @ResponseBody ResponseMessage delete(ModelMap modelMap, Long id) {
        pingServer2DeviceService.delete(id);
        return ResponseMessage.success();
    }
}