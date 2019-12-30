package com.hxgis.send.model;

import com.hxgis.send.model.baseway.BaseSendModel;

/**
 * Created by sk on 2019/4/24
 */
public class SendBaseCont {
    private String userName;
    private String password;
    private String taskId;
    private BaseSendModel[] data;

    public SendBaseCont() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public BaseSendModel[] getData() {
        return data;
    }

    public void setData(BaseSendModel[] data) {
        this.data = data;
    }
}
