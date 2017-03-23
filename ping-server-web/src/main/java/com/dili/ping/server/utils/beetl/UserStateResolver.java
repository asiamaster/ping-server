package com.dili.ping.server.utils.beetl;

import com.dili.ping.server.api.enums.UserStateEnum;
import com.dili.utils.beetl.VirtualAttributeResolver;
import org.springframework.stereotype.Component;

/**
 * 用户状态虚拟属性解析器示例
 * Created by asiamastor on 2017/1/23.
 */
//@Component
//public class UserStateResolver implements VirtualAttributeResolver {
//    @Override
//    public String resolve(Object o, String attrName) {
//        User user = (User) o;
//        if(attrName.equals("userState") && user.getUserState() != null)
//        return UserStateEnum.getUserStateEnum((Integer)user.getUserState()).getDesc();
//        return "";
//    }
//
//    @Override
//    public Class resolveClass() {
//        return User.class;
//    }
//}
