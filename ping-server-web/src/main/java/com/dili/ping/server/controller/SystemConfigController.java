package com.dili.ping.server.controller;

import com.dili.ping.server.domain.SystemConfig;
import com.dili.ping.server.service.SystemConfigService;
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
@RequestMapping("/systemConfig")
public class SystemConfigController {
    @Autowired
    SystemConfigService systemConfigService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap, @ModelAttribute SystemConfig systemConfig) {
        modelMap.put("list", systemConfigService.list(systemConfig));
        return "systemConfig/list";
    }

    @RequestMapping("/insert")
    public String insert(ModelMap modelMap, @ModelAttribute SystemConfig systemConfig) {
        systemConfigService.insertSelective(systemConfig);
        return "systemConfig/insert";
    }

    @RequestMapping("/update")
    public String update(ModelMap modelMap, @ModelAttribute SystemConfig systemConfig) {
        systemConfigService.update(systemConfig);
        return "systemConfig/update";
    }

    @RequestMapping("/delete")
    public @ResponseBody ResponseMessage delete(ModelMap modelMap, Long id) {
        systemConfigService.delete(id);
        return ResponseMessage.success();
    }
}