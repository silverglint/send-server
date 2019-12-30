package com.hxgis.send.model;

import java.util.Date;

/**
 * Created by sk on 2019/4/25
 */
public class SendResult {

    private String taskId;
    private Date beginTime;
    private Date endTime;
    private UserResult[] results;

    public SendResult() {
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public UserResult[] getResults() {
        return results;
    }

    public void setResults(UserResult[] results) {
        this.results = results;
    }
}
