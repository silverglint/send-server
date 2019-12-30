package com.hxgis.send.model.baseway;

import com.hxgis.send.model.config.EmailConfig;
import com.hxgis.send.model.content.EmailContent;
import com.hxgis.send.model.userinfo.EmailUserInfo;

/**
 * Created by sk on 2019/12/28
 */

public class EmailSendModel extends BaseSendModel {

    private EmailConfig config;
    private EmailContent content;
    private EmailUserInfo[] users;

    public EmailSendModel() {
    }

    public EmailConfig getConfig() {
        return config;
    }

    public void setConfig(EmailConfig config) {
        this.config = config;
    }

    public EmailContent getContent() {
        return content;
    }

    public void setContent(EmailContent content) {
        this.content = content;
    }

    public EmailUserInfo[] getUsers() {
        return users;
    }

    public void setUsers(EmailUserInfo[] users) {
        this.users = users;
    }
}
