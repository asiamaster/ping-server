package com.dili.ping.server.controller;

import com.dili.ping.server.domain.Groups;
import com.dili.ping.server.service.GroupsService;
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
@RequestMapping("/groups")
public class GroupsController {
    @Autowired
    GroupsService groupsService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap, @ModelAttribute Groups groups) {
        modelMap.put("list", groupsService.list(groups));
        return "groups/list";
    }

    @RequestMapping("/insert")
    public String insert(ModelMap modelMap, @ModelAttribute Groups groups) {
        groupsService.insertSelective(groups);
        return "groups/insert";
    }

    @RequestMapping("/update")
    public String update(ModelMap modelMap, @ModelAttribute Groups groups) {
        groupsService.update(groups);
        return "groups/update";
    }

    @RequestMapping("/delete")
    public @ResponseBody ResponseMessage delete(ModelMap modelMap, Long id) {
        groupsService.delete(id);
        return ResponseMessage.success();
    }
}