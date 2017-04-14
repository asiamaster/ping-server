package com.dili.ping.server.domain;

import java.util.Date;
import javax.persistence.*;

/**
 * 由MyBatis Generator工具自动生成
 * 
 * This file was generated on 2017-04-14 16:26:15.
 */
@Table(name = "schedule_job")
public class ScheduleJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createTime")
    private Date createtime;

    @Column(name = "updateTime")
    private Date updatetime;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "job_group")
    private String jobGroup;

    /**
     * 是否启动任务
     */
    @Column(name = "job_status")
    private Integer jobStatus;

    @Column(name = "cron_expression")
    private String cronExpression;

    @Column(name = "repeat_interval")
    private Integer repeatInterval;

    @Column(name = "start_delay")
    private Integer startDelay;

    private String description;

    /**
     * 任务执行时调用哪个类的方法 包名+类名
     */
    @Column(name = "bean_class")
    private String beanClass;

    @Column(name = "is_concurrent")
    private Integer isConcurrent;

    @Column(name = "spring_id")
    private String springId;

    @Column(name = "method_name")
    private String methodName;

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
     * @return createTime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return updateTime
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * @param updatetime
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * @return job_name
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * @param jobName
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * @return job_group
     */
    public String getJobGroup() {
        return jobGroup;
    }

    /**
     * @param jobGroup
     */
    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    /**
     * 获取是否启动任务
     *
     * @return job_status - 是否启动任务
     */
    public Integer getJobStatus() {
        return jobStatus;
    }

    /**
     * 设置是否启动任务
     *
     * @param jobStatus 是否启动任务
     */
    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }

    /**
     * @return cron_expression
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     * @param cronExpression
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    /**
     * @return repeat_interval
     */
    public Integer getRepeatInterval() {
        return repeatInterval;
    }

    /**
     * @param repeatInterval
     */
    public void setRepeatInterval(Integer repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    /**
     * @return start_delay
     */
    public Integer getStartDelay() {
        return startDelay;
    }

    /**
     * @param startDelay
     */
    public void setStartDelay(Integer startDelay) {
        this.startDelay = startDelay;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取任务执行时调用哪个类的方法 包名+类名
     *
     * @return bean_class - 任务执行时调用哪个类的方法 包名+类名
     */
    public String getBeanClass() {
        return beanClass;
    }

    /**
     * 设置任务执行时调用哪个类的方法 包名+类名
     *
     * @param beanClass 任务执行时调用哪个类的方法 包名+类名
     */
    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass;
    }

    /**
     * @return is_concurrent
     */
    public Integer getIsConcurrent() {
        return isConcurrent;
    }

    /**
     * @param isConcurrent
     */
    public void setIsConcurrent(Integer isConcurrent) {
        this.isConcurrent = isConcurrent;
    }

    /**
     * @return spring_id
     */
    public String getSpringId() {
        return springId;
    }

    /**
     * @param springId
     */
    public void setSpringId(String springId) {
        this.springId = springId;
    }

    /**
     * @return method_name
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * @param methodName
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}