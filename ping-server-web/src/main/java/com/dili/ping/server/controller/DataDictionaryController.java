package com.dili.ping.server.controller;

import com.dili.ping.server.domain.DataDictionary;
import com.dili.ping.server.service.DataDictionaryService;
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
@RequestMapping("/dataDictionary")
public class DataDictionaryController {
    @Autowired
    DataDictionaryService dataDictionaryService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap, @ModelAttribute DataDictionary dataDictionary) {
        modelMap.put("list", dataDictionaryService.list(dataDictionary));
        return "dataDictionary/list";
    }

    @RequestMapping("/insert")
    public String insert(ModelMap modelMap, @ModelAttribute DataDictionary dataDictionary) {
        dataDictionaryService.insertSelective(dataDictionary);
        return "dataDictionary/insert";
    }

    @RequestMapping("/update")
    public String update(ModelMap modelMap, @ModelAttribute DataDictionary dataDictionary) {
        dataDictionaryService.update(dataDictionary);
        return "dataDictionary/update";
    }

    @RequestMapping("/delete")
    public @ResponseBody ResponseMessage delete(ModelMap modelMap, Long id) {
        dataDictionaryService.delete(id);
        return ResponseMessage.success();
    }
}