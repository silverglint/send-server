package com.hxgis.send.service.impl;

import com.hxgis.send.enums.DriverEnum;
import com.hxgis.send.enums.SendStatusEnum;
import com.hxgis.send.exception.DriverException;
import com.hxgis.send.model.baseway.BaseSendModel;
import com.hxgis.send.model.baseway.EmailSendModel;
import com.hxgis.send.model.baseway.FtpSendModel;
import com.hxgis.send.model.baseway.SmbSendModel;
import com.hxgis.send.service.EmailService;
import com.hxgis.send.service.FtpService;
import com.hxgis.send.service.SendService;
import com.hxgis.send.service.SmbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sk on 2019/4/25
 */
@Service
@Slf4j
public class SendServiceImpl implements SendService {

    private EmailService emailService;
    private FtpService ftpService;
    private SmbService smbService;

    @Autowired
    public SendServiceImpl(EmailService emailService, FtpService ftpService, SmbService smbService) {
        this.emailService = emailService;
        this.ftpService = ftpService;
        this.smbService = smbService;
    }

    @Override
    public String send(String taskId, BaseSendModel baseSendModel) {

        String driverId = baseSendModel.getDriverId();
        DriverEnum driver = DriverEnum.withId(driverId);

        switch (driver) {
            case EMAIL:
                EmailSendModel emailSendModel = (EmailSendModel) baseSendModel;
                try {
                    emailService.send(taskId, emailSendModel.getConfig(), emailSendModel.getContent(), emailSendModel.getUsers());
                    emailService.insertLog(taskId, SendStatusEnum.SUCCESS, "", emailSendModel.getUsers());
                } catch (Exception e) {
                    emailService.insertLog(taskId, SendStatusEnum.FAIL, e.getMessage(), emailSendModel.getUsers());
                    log.warn(driver.getType() + driver.getId() + "发送失败", e);
                }
                break;
            case FTP:
                FtpSendModel ftpSendModel = (FtpSendModel) baseSendModel;
                try {
                    ftpService.send(taskId, ftpSendModel.getContent(), ftpSendModel.getUsers());
                    ftpService.insertLog(taskId, SendStatusEnum.SUCCESS, "", ftpSendModel.getUsers());
                } catch (Exception e) {
                    ftpService.insertLog(taskId, SendStatusEnum.FAIL, e.getMessage(), ftpSendModel.getUsers());
                    log.warn(driver.getType() + driver.getId() + "发送失败", e);
                }
                break;
            case SMB:
                SmbSendModel smbSendModel = (SmbSendModel) baseSendModel;
                try {
                    smbService.send(taskId, smbSendModel.getContent(), smbSendModel.getUsers());
                    smbService.insertLog(taskId, SendStatusEnum.SUCCESS, "", smbSendModel.getUsers());
                } catch (Exception e) {
                    smbService.insertLog(taskId, SendStatusEnum.FAIL, e.getMessage(), smbSendModel.getUsers());
                    log.warn(driver.getType() + driver.getId() + "发送失败", e);
                }
                break;
            case ILLEGAL:
            default:
                throw DriverException.NOT_FIND_EXCEPTION;
        }

        return taskId;
    }

}
