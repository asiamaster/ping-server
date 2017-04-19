package com.dili.ping.server.domain;

import javax.persistence.*;

/**
 * 由MyBatis Generator工具自动生成
 * 
 * This file was generated on 2017-04-19 08:57:24.
 */
@Table(name = "ping_server_2_device")
public class PingServer2Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ping_server_id")
    private Long pingServerId;

    @Column(name = "device_id")
    private Long deviceId;

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
     * @return ping_server_id
     */
    public Long getPingServerId() {
        return pingServerId;
    }

    /**
     * @param pingServerId
     */
    public void setPingServerId(Long pingServerId) {
        this.pingServerId = pingServerId;
    }

    /**
     * @return device_id
     */
    public Long getDeviceId() {
        return deviceId;
    }

    /**
     * @param deviceId
     */
    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }
}