package com.dili.ping.server.domain;

import java.util.Date;
import javax.persistence.*;

/**
 * 由MyBatis Generator工具自动生成
 * 
 * This file was generated on 2017-04-13 10:35:32.
 */
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parent_id")
    private Long parentId;

    private String name;

    private String host;

    private Integer port;

    /**
     * 1:运行，0:未运行
     */
    @Column(name = "running_state")
    private Boolean runningState;

    @Column(name = "launch_time")
    private Date launchTime;

    /**
     * 单位:ms
     */
    private Long cost;

    @Column(name = "recover_time")
    private Date recoverTime;

    @Column(name = "disconnect_time")
    private Date disconnectTime;

    /**
     * pc，路由。。。可在系统中增加类型，不同类型不同ico/图片
     */
    private Integer type;

    /**
     * 1:可用；0:停用
     */
    private Integer yn;

    private String icon;

    /**
     * 在位置节点设置，下面所有设备生效
     */
    @Column(name = "disconnect_times")
    private Integer disconnectTimes;

    /**
     * 1:位置，0:设备
     */
    @Column(name = "is_location")
    private Integer isLocation;

    /**
     * 子网掩码，用于区分网段
     */
    @Column(name = "mask_code")
    private String maskCode;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return parent_id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return port
     */
    public Integer getPort() {
        return port;
    }

    /**
     * @param port
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * 获取1:运行，0:未运行
     *
     * @return running_state - 1:运行，0:未运行
     */
    public Boolean getRunningState() {
        return runningState;
    }

    /**
     * 设置1:运行，0:未运行
     *
     * @param runningState 1:运行，0:未运行
     */
    public void setRunningState(Boolean runningState) {
        this.runningState = runningState;
    }

    /**
     * @return launch_time
     */
    public Date getLaunchTime() {
        return launchTime;
    }

    /**
     * @param launchTime
     */
    public void setLaunchTime(Date launchTime) {
        this.launchTime = launchTime;
    }

    /**
     * 获取单位:ms
     *
     * @return cost - 单位:ms
     */
    public Long getCost() {
        return cost;
    }

    /**
     * 设置单位:ms
     *
     * @param cost 单位:ms
     */
    public void setCost(Long cost) {
        this.cost = cost;
    }

    /**
     * @return recover_time
     */
    public Date getRecoverTime() {
        return recoverTime;
    }

    /**
     * @param recoverTime
     */
    public void setRecoverTime(Date recoverTime) {
        this.recoverTime = recoverTime;
    }

    /**
     * @return disconnect_time
     */
    public Date getDisconnectTime() {
        return disconnectTime;
    }

    /**
     * @param disconnectTime
     */
    public void setDisconnectTime(Date disconnectTime) {
        this.disconnectTime = disconnectTime;
    }

    /**
     * 获取pc，路由。。。可在系统中增加类型，不同类型不同ico/图片
     *
     * @return type - pc，路由。。。可在系统中增加类型，不同类型不同ico/图片
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置pc，路由。。。可在系统中增加类型，不同类型不同ico/图片
     *
     * @param type pc，路由。。。可在系统中增加类型，不同类型不同ico/图片
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取1:可用；0:停用
     *
     * @return yn - 1:可用；0:停用
     */
    public Integer getYn() {
        return yn;
    }

    /**
     * 设置1:可用；0:停用
     *
     * @param yn 1:可用；0:停用
     */
    public void setYn(Integer yn) {
        this.yn = yn;
    }

    /**
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取在位置节点设置，下面所有设备生效
     *
     * @return disconnect_times - 在位置节点设置，下面所有设备生效
     */
    public Integer getDisconnectTimes() {
        return disconnectTimes;
    }

    /**
     * 设置在位置节点设置，下面所有设备生效
     *
     * @param disconnectTimes 在位置节点设置，下面所有设备生效
     */
    public void setDisconnectTimes(Integer disconnectTimes) {
        this.disconnectTimes = disconnectTimes;
    }

    /**
     * 获取1:位置，0:设备
     *
     * @return is_location - 1:位置，0:设备
     */
    public Integer getIsLocation() {
        return isLocation;
    }

    /**
     * 设置1:位置，0:设备
     *
     * @param isLocation 1:位置，0:设备
     */
    public void setIsLocation(Integer isLocation) {
        this.isLocation = isLocation;
    }

    /**
     * 获取子网掩码，用于区分网段
     *
     * @return mask_code - 子网掩码，用于区分网段
     */
    public String getMaskCode() {
        return maskCode;
    }

    /**
     * 设置子网掩码，用于区分网段
     *
     * @param maskCode 子网掩码，用于区分网段
     */
    public void setMaskCode(String maskCode) {
        this.maskCode = maskCode;
    }
}