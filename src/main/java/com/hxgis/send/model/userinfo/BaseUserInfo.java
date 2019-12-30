package com.hxgis.send.model.userinfo;

/**
 * Created by sk on 2019/4/24
 */
public abstract class BaseUserInfo {
    private String id;
    private String mark;

    private String sendTo;

    BaseUserInfo() {
    }

    BaseUserInfo(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }


    public abstract String getSendTo();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
