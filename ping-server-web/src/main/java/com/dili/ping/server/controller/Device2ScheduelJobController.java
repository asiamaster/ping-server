package com.dili.ping.server.controller;

import com.dili.ping.server.domain.Device2ScheduelJob;
import com.dili.ping.server.service.Device2ScheduelJobService;
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
@RequestMapping("/device2ScheduelJob")
public class Device2ScheduelJobController {
    @Autowired
    Device2ScheduelJobService device2ScheduelJobService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap, @ModelAttribute Device2ScheduelJob device2ScheduelJob) {
        modelMap.put("list", device2ScheduelJobService.list(device2ScheduelJob));
        return "device2ScheduelJob/list";
    }

    @RequestMapping("/insert")
    public String insert(ModelMap modelMap, @ModelAttribute Device2ScheduelJob device2ScheduelJob) {
        device2ScheduelJobService.insertSelective(device2ScheduelJob);
        return "device2ScheduelJob/insert";
    }

    @RequestMapping("/update")
    public String update(ModelMap modelMap, @ModelAttribute Device2ScheduelJob device2ScheduelJob) {
        device2ScheduelJobService.update(device2ScheduelJob);
        return "device2ScheduelJob/update";
    }

    @RequestMapping("/delete")
    public @ResponseBody ResponseMessage delete(ModelMap modelMap, Long id) {
        device2ScheduelJobService.delete(id);
        return ResponseMessage.success();
    }
}