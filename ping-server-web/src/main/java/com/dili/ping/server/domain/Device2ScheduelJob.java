package com.dili.ping.server.domain;

import javax.persistence.*;

/**
 * 由MyBatis Generator工具自动生成
 * 
 * This file was generated on 2017-04-19 08:57:24.
 */
@Table(name = "device_2_scheduel_job")
public class Device2ScheduelJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_id")
    private Long deviceId;

    @Column(name = "scheduel_job_id")
    private Long scheduelJobId;

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

    /**
     * @return scheduel_job_id
     */
    public Long getScheduelJobId() {
        return scheduelJobId;
    }

    /**
     * @param scheduelJobId
     */
    public void setScheduelJobId(Long scheduelJobId) {
        this.scheduelJobId = scheduelJobId;
    }
}