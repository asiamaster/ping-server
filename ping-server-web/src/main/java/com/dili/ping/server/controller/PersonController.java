package com.dili.ping.server.controller;

import com.dili.ping.server.domain.Person;
import com.dili.ping.server.service.PersonService;
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
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap, @ModelAttribute Person person) {
        modelMap.put("list", personService.list(person));
        return "person/list";
    }

    @RequestMapping("/insert")
    public String insert(ModelMap modelMap, @ModelAttribute Person person) {
        personService.insertSelective(person);
        return "person/insert";
    }

    @RequestMapping("/update")
    public String update(ModelMap modelMap, @ModelAttribute Person person) {
        personService.update(person);
        return "person/update";
    }

    @RequestMapping("/delete")
    public @ResponseBody ResponseMessage delete(ModelMap modelMap, Long id) {
        personService.delete(id);
        return ResponseMessage.success();
    }
}