package com.dili.ping.server.controller;

import com.dili.ping.server.domain.Location2User;
import com.dili.ping.server.service.Location2UserService;
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
@RequestMapping("/location2User")
public class Location2UserController {
    @Autowired
    Location2UserService location2UserService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap, @ModelAttribute Location2User location2User) {
        modelMap.put("list", location2UserService.list(location2User));
        return "location2User/list";
    }

    @RequestMapping("/insert")
    public String insert(ModelMap modelMap, @ModelAttribute Location2User location2User) {
        location2UserService.insertSelective(location2User);
        return "location2User/insert";
    }

    @RequestMapping("/update")
    public String update(ModelMap modelMap, @ModelAttribute Location2User location2User) {
        location2UserService.update(location2User);
        return "location2User/update";
    }

    @RequestMapping("/delete")
    public @ResponseBody ResponseMessage delete(ModelMap modelMap, Long id) {
        location2UserService.delete(id);
        return ResponseMessage.success();
    }
}