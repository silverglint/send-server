package com.hxgis.send.model.userinfo;

/**
 * Created by sk on 2019/4/24
 */
public class EmailUserInfo extends BaseUserInfo {

    private String email;

    public EmailUserInfo() {
    }

    @Override
    public String getSendTo() {
        return this.email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
