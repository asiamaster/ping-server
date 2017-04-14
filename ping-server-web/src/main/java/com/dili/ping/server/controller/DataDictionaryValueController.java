package com.dili.ping.server.controller;

import com.dili.ping.server.domain.DataDictionaryValue;
import com.dili.ping.server.service.DataDictionaryValueService;
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
@RequestMapping("/dataDictionaryValue")
public class DataDictionaryValueController {
    @Autowired
    DataDictionaryValueService dataDictionaryValueService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap, @ModelAttribute DataDictionaryValue dataDictionaryValue) {
        modelMap.put("list", dataDictionaryValueService.list(dataDictionaryValue));
        return "dataDictionaryValue/list";
    }

    @RequestMapping("/insert")
    public String insert(ModelMap modelMap, @ModelAttribute DataDictionaryValue dataDictionaryValue) {
        dataDictionaryValueService.insertSelective(dataDictionaryValue);
        return "dataDictionaryValue/insert";
    }

    @RequestMapping("/update")
    public String update(ModelMap modelMap, @ModelAttribute DataDictionaryValue dataDictionaryValue) {
        dataDictionaryValueService.update(dataDictionaryValue);
        return "dataDictionaryValue/update";
    }

    @RequestMapping("/delete")
    public @ResponseBody ResponseMessage delete(ModelMap modelMap, Long id) {
        dataDictionaryValueService.delete(id);
        return ResponseMessage.success();
    }
}