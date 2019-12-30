package com.hxgis.send.service;

import com.hxgis.send.enums.SendStatusEnum;
import com.hxgis.send.model.content.FtpContent;
import com.hxgis.send.model.userinfo.FtpUserInfo;

/**
 * Created by sk on 2019/4/25
 */
public interface FtpService {

    void send(String taskId, FtpContent ftpContent, FtpUserInfo[] ftpUserInfos) throws Exception;

    void insertLog(String taskId, SendStatusEnum status, String message, FtpUserInfo[] users);
}
