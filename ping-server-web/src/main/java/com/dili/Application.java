package com.dili;

import com.dili.ping.server.utils.bootquartz.SchedulerConfig;
import com.dili.utils.base.MyMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.autoconfigure.velocity.VelocityAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.mapper.provider.base.BaseSelectProvider;

/**
 * Created by asiamastor on 2016/12/21.
 */
//@EnableDiscoveryClient
//@EnableFeignClients
//@EnableHystrix
//@EnableHystrixDashboard
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication
//@EnableScheduling
@EnableTransactionManagement
@EnableAutoConfiguration(exclude = {ThymeleafAutoConfiguration.class, VelocityAutoConfiguration.class})
@MapperScan(basePackages = "com.dili.ping.server.dao", markerInterface = MyMapper.class)
//@ImportResource(locations = "classpath:applicationContext.xml")
//@ComponentScan(basePackages={"com.dili.utils","com.dili.ping.server"}, excludeFilters = {@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,value=MyMapper.class)})
@Import({SchedulerConfig.class})
/**
 * 除了内嵌容器的部署模式，Spring Boot也支持将应用部署至已有的Tomcat容器, 或JBoss, WebLogic等传统Java EE应用服务器。
 * 以Maven为例，首先需要将<packaging>从jar改成war，然后取消spring-boot-maven-plugin，然后修改Application.java
 * 继承SpringBootServletInitializer
 */
public class Application extends SpringBootServletInitializer {

    protected static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
            SpringApplication.run(Application.class, args);
//        Class.forName(BaseSelectProvider.class.getName()).newInstance();
//        long old = System.currentTimeMillis();
//        System.out.println(PingUtil.isReachable("10.28.6.50"));
//        System.out.println("cost:"+(System.currentTimeMillis()-old));
    }


}
