package com.dili.ping.server.domain;

import java.util.Date;
import javax.persistence.*;

public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parent_id")
    private Long parentId;

    private String name;

    /**
     * 最后一次响应时长(ms)
     */
    private Long cost;

    private String host;

    private Integer port;

    /**
     * 1:运行，0:未运行
     */
    private Boolean running;

    @Column(name = "launch_time")
    private Date launchTime;

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
     * 获取最后一次响应时长(ms)
     *
     * @return cost - 最后一次响应时长(ms)
     */
    public Long getCost() {
        return cost;
    }

    /**
     * 设置最后一次响应时长(ms)
     *
     * @param cost 最后一次响应时长(ms)
     */
    public void setCost(Long cost) {
        this.cost = cost;
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
     * @return running - 1:运行，0:未运行
     */
    public Boolean getRunning() {
        return running;
    }

    /**
     * 设置1:运行，0:未运行
     *
     * @param running 1:运行，0:未运行
     */
    public void setRunning(Boolean running) {
        this.running = running;
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
}