package com.hxgis.send.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;


@TableName("send_log")
public class SendLog {

    @TableId
    private String guid;
    private String taskId;
    private Date createTime;
    private Date updateTime;
    //0发送中；1等待发送；2成功；3失败
    private int status;
    private String message;
    private String sendTo;
    private String driverId;
    private String mark;

    public SendLog() {
    }

    public SendLog(String guid, String taskId, Date createTime, Date updateTime, int status, String message, String sendTo, String driverId, String mark) {
        this.guid = guid;
        this.taskId = taskId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
        this.message = message;
        this.sendTo = sendTo;
        this.driverId = driverId;
        this.mark = mark;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

}
