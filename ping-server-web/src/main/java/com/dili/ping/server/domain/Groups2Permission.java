package com.dili.ping.server.domain;

import javax.persistence.*;

/**
 * 由MyBatis Generator工具自动生成
 * 
 * This file was generated on 2017-04-14 16:26:15.
 */
@Table(name = "groups_2_permission")
public class Groups2Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "groups_id")
    private Long groupsId;

    @Column(name = "permission_id")
    private Long permissionId;

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
     * @return groups_id
     */
    public Long getGroupsId() {
        return groupsId;
    }

    /**
     * @param groupsId
     */
    public void setGroupsId(Long groupsId) {
        this.groupsId = groupsId;
    }

    /**
     * @return permission_id
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * @param permissionId
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}