package com.hxgis.send.model.baseway;

import com.hxgis.send.model.content.SmbContent;
import com.hxgis.send.model.userinfo.SmbUserInfo;

/**
 * Created by sk on 2019/12/28
 */
public class SmbSendModel extends BaseSendModel {

    private SmbContent content;
    private SmbUserInfo[] users;

    public SmbSendModel() {
    }

    public SmbContent getContent() {
        return content;
    }

    public void setContent(SmbContent content) {
        this.content = content;
    }

    public SmbUserInfo[] getUsers() {
        return users;
    }

    public void setUsers(SmbUserInfo[] users) {
        this.users = users;
    }
}
