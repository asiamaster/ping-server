package com.dili.ping.server.api.enums;

/**
 * 用户状态
 * Created by wm on 2017/1/9.
 */
public enum UserStateEnum {
    NORMAL(1,"普通用户"),
    LOCKED(0,"锁定用户");

    private Integer code;
    private String desc;

    UserStateEnum(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static UserStateEnum getUserStateEnum(Integer code) {
        for (UserStateEnum use : UserStateEnum.values()) {
            if (use.getCode()==code) {
                return use;
            }
        }
        return null;
    }
}
