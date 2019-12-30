package com.hxgis.send.model.baseway;

import com.hxgis.send.model.content.FtpContent;
import com.hxgis.send.model.userinfo.FtpUserInfo;

/**
 * Created by sk on 2019/12/28
 */
public class FtpSendModel extends BaseSendModel {

    private FtpContent content;
    private FtpUserInfo[] users;

    public FtpSendModel() {
    }

    public FtpContent getContent() {
        return content;
    }

    public void setContent(FtpContent content) {
        this.content = content;
    }

    public FtpUserInfo[] getUsers() {
        return users;
    }

    public void setUsers(FtpUserInfo[] users) {
        this.users = users;
    }
}
