package com.github.arsiac.psychology.utils.entity;

import java.util.Date;

/**
 * <p>系统日志信息</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/27
 */
public class LogDetail {
    private Long id;
    /**
     * 用户名
     * */
    private String username;

    /**
     * 用户操作
     * */
    private String operation;

    /**
     * 请求方法
     * */
    private String method;

    /**
     * 请求参数
     * */
    private String params;

    /**
     * 执行时长(毫秒)
     * */
    private Long time;

    /**
     * IP地址
     * */
    private String ip;

    /**
     * 创建时间
     * */
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "LogInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", operation='" + operation + '\'' +
                ", method='" + method + '\'' +
                ", params='" + params + '\'' +
                ", time=" + time +
                ", ip='" + ip + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
