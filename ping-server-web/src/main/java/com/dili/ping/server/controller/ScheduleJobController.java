package com.dili.ping.server.controller;

import com.dili.ping.server.service.ScheduleJobService;
import com.dili.utils.domain.ResponseMessage;
import com.dili.utils.quartz.domain.ScheduleJob;
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
@RequestMapping("/scheduleJob")
public class ScheduleJobController {
    @Autowired
    ScheduleJobService scheduleJobService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap, @ModelAttribute ScheduleJob scheduleJob) {
        modelMap.put("list", scheduleJobService.list(scheduleJob));
        return "scheduleJob/list";
    }

    @RequestMapping("/insert")
    public String insert(ModelMap modelMap, @ModelAttribute ScheduleJob scheduleJob) {
        scheduleJobService.insertSelective(scheduleJob);
        return "scheduleJob/insert";
    }

    @RequestMapping("/update")
    public String update(ModelMap modelMap, @ModelAttribute ScheduleJob scheduleJob) {
        scheduleJobService.update(scheduleJob);
        return "scheduleJob/update";
    }

    @RequestMapping("/delete")
    public @ResponseBody ResponseMessage delete(ModelMap modelMap, Long id) {
        scheduleJobService.delete(id);
        return ResponseMessage.success();
    }
}