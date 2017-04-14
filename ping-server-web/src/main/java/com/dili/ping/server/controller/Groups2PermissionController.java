package com.dili.ping.server.controller;

import com.dili.ping.server.domain.Groups2Permission;
import com.dili.ping.server.service.Groups2PermissionService;
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
@RequestMapping("/groups2Permission")
public class Groups2PermissionController {
    @Autowired
    Groups2PermissionService groups2PermissionService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap, @ModelAttribute Groups2Permission groups2Permission) {
        modelMap.put("list", groups2PermissionService.list(groups2Permission));
        return "groups2Permission/list";
    }

    @RequestMapping("/insert")
    public String insert(ModelMap modelMap, @ModelAttribute Groups2Permission groups2Permission) {
        groups2PermissionService.insertSelective(groups2Permission);
        return "groups2Permission/insert";
    }

    @RequestMapping("/update")
    public String update(ModelMap modelMap, @ModelAttribute Groups2Permission groups2Permission) {
        groups2PermissionService.update(groups2Permission);
        return "groups2Permission/update";
    }

    @RequestMapping("/delete")
    public @ResponseBody ResponseMessage delete(ModelMap modelMap, Long id) {
        groups2PermissionService.delete(id);
        return ResponseMessage.success();
    }
}