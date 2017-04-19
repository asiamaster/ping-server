package com.dili.ping.server.domain;

import java.util.Date;
import javax.persistence.*;

/**
 * 由MyBatis Generator工具自动生成
 * 
 * This file was generated on 2017-04-19 08:57:24.
 */
@Table(name = "data_dictionary_value")
public class DataDictionaryValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dd_id")
    private Long ddId;

    private Integer sort;

    private String code;

    private String value;

    private String remark;

    @Column(name = "period_begin")
    private Date periodBegin;

    @Column(name = "period_end")
    private Date periodEnd;

    private Date created;

    private Date modified;

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
     * @return dd_id
     */
    public Long getDdId() {
        return ddId;
    }

    /**
     * @param ddId
     */
    public void setDdId(Long ddId) {
        this.ddId = ddId;
    }

    /**
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return period_begin
     */
    public Date getPeriodBegin() {
        return periodBegin;
    }

    /**
     * @param periodBegin
     */
    public void setPeriodBegin(Date periodBegin) {
        this.periodBegin = periodBegin;
    }

    /**
     * @return period_end
     */
    public Date getPeriodEnd() {
        return periodEnd;
    }

    /**
     * @param periodEnd
     */
    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    /**
     * @return created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * @return modified
     */
    public Date getModified() {
        return modified;
    }

    /**
     * @param modified
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    /**
     * @return yn
     */
    public Integer getYn() {
        return yn;
    }

    /**
     * @param yn
     */
    public void setYn(Integer yn) {
        this.yn = yn;
    }
}