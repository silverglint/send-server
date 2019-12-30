package com.hxgis.send.service;

import com.hxgis.send.enums.SendStatusEnum;
import com.hxgis.send.model.content.SmbContent;
import com.hxgis.send.model.userinfo.SmbUserInfo;

import java.io.IOException;

/**
 * Created by sk on 2019/4/26
 */
public interface SmbService {

    void send(String taskId, SmbContent smbContent, SmbUserInfo[] smbUserInfos) throws IOException;

    void insertLog(String taskId, SendStatusEnum status, String message, SmbUserInfo[] users);
}
