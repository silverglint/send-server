package com.hxgis.send.service.impl;

import com.hxgis.send.entity.SendLog;
import com.hxgis.send.enums.DriverEnum;
import com.hxgis.send.enums.SendStatusEnum;
import com.hxgis.send.model.config.EmailConfig;
import com.hxgis.send.model.content.EmailContent;
import com.hxgis.send.model.userinfo.BaseUserInfo;
import com.hxgis.send.model.userinfo.EmailUserInfo;
import com.hxgis.send.service.EmailService;
import com.hxgis.send.service.SendLogService;
import com.hxgis.send.utils.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sk on 2019/4/24
 */
@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    static {
        System.setProperty("mail.mime.splitlongparameters", "false");
    }

    private SendLogService sendLogService;

    public EmailServiceImpl(SendLogService sendLogService) {
        this.sendLogService = sendLogService;
    }

    @Override
    public void send(String taskId, EmailConfig emailConfig, EmailContent emailContent, EmailUserInfo[] users) throws MessagingException {

        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(emailConfig.getHost());
        sender.setUsername(emailConfig.getUserName());
        sender.setPassword(emailConfig.getPassword());

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        // 设置邮件接收者
        String[] emails = new String[users.length];
        for (int i = 0; i < users.length; i++) {
            emails[i] = users[i].getEmail();
            users[i].setId(UUIDUtils.getUUID());
        }

        helper.setSubject(emailContent.getSubject());
        helper.setFrom(emailConfig.getUserName());
        helper.setTo(emails);
        helper.setSentDate(new Date());
        helper.setText(emailContent.getText());

        String name = emailContent.getAttachmentName();
        byte[] bytes = emailContent.getAttachment();
        if (!StringUtils.isEmpty(name) && !ArrayUtils.isEmpty(bytes)) {
            helper.addAttachment(name, new ByteArrayResource(bytes));
        }

        sender.send(message);
    }

    @Override
    public void insertLog(String taskId, SendStatusEnum status, String message, EmailUserInfo[] users) {
        Date date = new Date();

        List<SendLog> insertList = new ArrayList<>();
        for (BaseUserInfo user : users) {
            SendLog sendLog = new SendLog(user.getId(), taskId, date, date, status.getStatus(),
                    message, user.getSendTo(), DriverEnum.EMAIL.getId(), user.getMark());
            insertList.add(sendLog);
        }

        sendLogService.insertBatch(insertList);
    }

}
