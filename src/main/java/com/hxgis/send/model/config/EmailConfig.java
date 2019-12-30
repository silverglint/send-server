package com.hxgis.send.model.config;

/**
 * Created by sk on 2019/4/24
 */
public class EmailConfig extends BaseConfig {

    private String host;
    private String userName;
    private String password;

    public EmailConfig() {
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
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

}
