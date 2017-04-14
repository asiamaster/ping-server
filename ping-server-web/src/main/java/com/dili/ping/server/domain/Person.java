package com.dili.ping.server.domain;

import javax.persistence.*;

/**
 * 由MyBatis Generator工具自动生成
 * 
 * This file was generated on 2017-04-14 16:26:15.
 */
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * 多个以逗号分隔
     */
    private String mobilephone;

    /**
     * 多个以逗号分隔
     */
    private String telephone;

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
     * 获取多个以逗号分隔
     *
     * @return mobilephone - 多个以逗号分隔
     */
    public String getMobilephone() {
        return mobilephone;
    }

    /**
     * 设置多个以逗号分隔
     *
     * @param mobilephone 多个以逗号分隔
     */
    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    /**
     * 获取多个以逗号分隔
     *
     * @return telephone - 多个以逗号分隔
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置多个以逗号分隔
     *
     * @param telephone 多个以逗号分隔
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}