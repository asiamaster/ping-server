package com.other;

import com.github.pagehelper.autoconfigure.MapperAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * 暂时保留，用于以后启动加载调用
 * Created by asiam on 2017/3/21 0021.
 */
@Configuration
@AutoConfigureAfter({MapperAutoConfiguration.class})
public class PingAutoConfiguration {
    @PostConstruct
    public void init() {
//        ((DeviceMapper)SpringUtil.getBean(DeviceMapper.class)).selectAll();
//        System.out.println("PingAutoConfiguration.init");
    }
}
