package com.dili.ping.server.controller;

import com.dili.ping.server.domain.Group2Person;
import com.dili.ping.server.service.Group2PersonService;
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
@RequestMapping("/group2Person")
public class Group2PersonController {
    @Autowired
    Group2PersonService group2PersonService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap, @ModelAttribute Group2Person group2Person) {
        modelMap.put("list", group2PersonService.list(group2Person));
        return "group2Person/list";
    }

    @RequestMapping("/insert")
    public String insert(ModelMap modelMap, @ModelAttribute Group2Person group2Person) {
        group2PersonService.insertSelective(group2Person);
        return "group2Person/insert";
    }

    @RequestMapping("/update")
    public String update(ModelMap modelMap, @ModelAttribute Group2Person group2Person) {
        group2PersonService.update(group2Person);
        return "group2Person/update";
    }

    @RequestMapping("/delete")
    public @ResponseBody ResponseMessage delete(ModelMap modelMap, Long id) {
        group2PersonService.delete(id);
        return ResponseMessage.success();
    }
}