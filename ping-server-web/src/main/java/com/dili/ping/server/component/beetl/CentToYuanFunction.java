package com.dili.ping.server.component.beetl;

import com.dili.utils.MoneyUtils;
import org.beetl.core.Context;
import org.beetl.core.Function;
import org.springframework.stereotype.Component;

/**
 * 分转元函数
 * Created by asiamastor on 2017/3/22.
 */
@Component("centToYuanFunction")
public class CentToYuanFunction implements Function {
    @Override
    public Object call(Object[] objects, Context context) {
        Object o = objects[0];
        if (o != null)
        {
            try
            {
                context.byteWriter.writeString(MoneyUtils.centToYuan(Long.parseLong(o.toString())));
            }
            catch (Exception e)
            {
//                throw new RuntimeException(e);
                return "分转元失败,参数:"+o;
            }
        }
        return "";
    }
}
