package com.dili.ping.server.domain;

import javax.persistence.*;

/**
 * 由MyBatis Generator工具自动生成
 * 
 * This file was generated on 2017-04-14 16:26:15.
 */
@Table(name = "group_2_person")
public class Group2Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "person_id")
    private Long personId;

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
     * @return group_id
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * @return person_id
     */
    public Long getPersonId() {
        return personId;
    }

    /**
     * @param personId
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}