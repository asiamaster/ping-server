package com.dili.ping.server.controller;

import com.dili.ping.server.domain.Device;
import com.dili.ping.server.service.DeviceService;
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
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap, @ModelAttribute Device device) {
        modelMap.put("list", deviceService.list(device));
        return "device/list";
    }

    @RequestMapping("/listChildren")
    public String listChildren(ModelMap modelMap, Long id) {
        modelMap.put("list", deviceService.selectChildren(id));
        return "device/list";
    }

    @RequestMapping("/insert")
    public String insert(ModelMap modelMap, @ModelAttribute Device device) {
        deviceService.insertSelective(device);
        return "device/insert";
    }

    @RequestMapping("/update")
    public String update(ModelMap modelMap, @ModelAttribute Device device) {
        deviceService.update(device);
        return "device/update";
    }

    @RequestMapping("/delete")
    public @ResponseBody ResponseMessage delete(ModelMap modelMap, Long id) {
        deviceService.delete(id);
        return ResponseMessage.success();
    }
}