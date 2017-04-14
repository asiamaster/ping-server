package com.dili.ping.server.controller;

import com.dili.ping.server.domain.Permission;
import com.dili.ping.server.service.PermissionService;
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
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap, @ModelAttribute Permission permission) {
        modelMap.put("list", permissionService.list(permission));
        return "permission/list";
    }

    @RequestMapping("/insert")
    public String insert(ModelMap modelMap, @ModelAttribute Permission permission) {
        permissionService.insertSelective(permission);
        return "permission/insert";
    }

    @RequestMapping("/update")
    public String update(ModelMap modelMap, @ModelAttribute Permission permission) {
        permissionService.update(permission);
        return "permission/update";
    }

    @RequestMapping("/delete")
    public @ResponseBody ResponseMessage delete(ModelMap modelMap, Long id) {
        permissionService.delete(id);
        return ResponseMessage.success();
    }
}