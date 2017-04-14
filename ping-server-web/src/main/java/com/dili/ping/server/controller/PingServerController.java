package com.dili.ping.server.controller;

import com.dili.ping.server.domain.PingServer;
import com.dili.ping.server.service.PingServerService;
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
@RequestMapping("/pingServer")
public class PingServerController {
    @Autowired
    PingServerService pingServerService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap, @ModelAttribute PingServer pingServer) {
        modelMap.put("list", pingServerService.list(pingServer));
        return "pingServer/list";
    }

    @RequestMapping("/insert")
    public String insert(ModelMap modelMap, @ModelAttribute PingServer pingServer) {
        pingServerService.insertSelective(pingServer);
        return "pingServer/insert";
    }

    @RequestMapping("/update")
    public String update(ModelMap modelMap, @ModelAttribute PingServer pingServer) {
        pingServerService.update(pingServer);
        return "pingServer/update";
    }

    @RequestMapping("/delete")
    public @ResponseBody ResponseMessage delete(ModelMap modelMap, Long id) {
        pingServerService.delete(id);
        return ResponseMessage.success();
    }
}