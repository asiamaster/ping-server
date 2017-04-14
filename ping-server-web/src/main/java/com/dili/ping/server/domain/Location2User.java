package com.dili.ping.server.domain;

import javax.persistence.*;

/**
 * 由MyBatis Generator工具自动生成
 * 
 * This file was generated on 2017-04-14 16:26:15.
 */
@Table(name = "location_2_user")
public class Location2User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "location_id")
    private String locationId;

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
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return location_id
     */
    public String getLocationId() {
        return locationId;
    }

    /**
     * @param locationId
     */
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
}