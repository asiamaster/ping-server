package com.dili.ping.server.domain;

/**
 * Created by asiam on 2017/3/23 0023.
 */
public enum DeviceStateEnum {

    ONLINE(1,"在线"),
    OFFLINE(0,"离线");

    private Integer code;
    private String desc;

    DeviceStateEnum(Integer code, String desc){
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

    public static DeviceStateEnum getDeviceStateEnum(Integer code) {
        for (DeviceStateEnum use : DeviceStateEnum.values()) {
            if (use.getCode()==code) {
                return use;
            }
        }
        return null;
    }
}
