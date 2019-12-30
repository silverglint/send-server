package com.hxgis.send.service;

import com.hxgis.send.enums.SendStatusEnum;
import com.hxgis.send.model.config.EmailConfig;
import com.hxgis.send.model.content.EmailContent;
import com.hxgis.send.model.userinfo.EmailUserInfo;

import javax.mail.MessagingException;

/**
 * Created by sk on 2019/4/24
 */
public interface EmailService {

    void send(String taskId, EmailConfig emailConfig, EmailContent emailContent, EmailUserInfo[] users) throws MessagingException;

    void insertLog(String taskId, SendStatusEnum status, String message, EmailUserInfo[] users);
}
