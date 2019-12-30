package com.hxgis.send.service.impl;

import com.hxgis.send.entity.SendLog;
import com.hxgis.send.enums.DriverEnum;
import com.hxgis.send.enums.SendStatusEnum;
import com.hxgis.send.model.content.FtpContent;
import com.hxgis.send.model.userinfo.BaseUserInfo;
import com.hxgis.send.model.userinfo.FtpUserInfo;
import com.hxgis.send.service.FtpService;
import com.hxgis.send.service.SendLogService;
import com.hxgis.send.utils.FtpUtil;
import com.hxgis.send.utils.UUIDUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sk on 2019/4/25
 */
@Service
public class FtpServiceImpl implements FtpService {

    private SendLogService sendLogService;

    public FtpServiceImpl(SendLogService sendLogService) {
        this.sendLogService = sendLogService;
    }

    @Override
    public void send(String taskId, FtpContent ftpContent, FtpUserInfo[] users) throws Exception {

        FtpUtil ftpUtil = new FtpUtil();

        for (FtpUserInfo user : users) {
            user.setId(UUIDUtils.getUUID());
            ftpUtil.connect(user.getFtpAddress(), 21, user.getFtpAccount(), user.getFtpPassWord());
            ftpUtil.ftpEncode();
            ftpUtil.upload(ftpContent.getFileName(), ftpContent.getFile());
            ftpUtil.disconnect();
        }
    }

    @Override
    public void insertLog(String taskId, SendStatusEnum status, String message, FtpUserInfo[] users) {
        Date date = new Date();

        List<SendLog> insertList = new ArrayList<>();
        for (BaseUserInfo user : users) {
            SendLog sendLog = new SendLog(user.getId(), taskId, date, date, status.getStatus(),
                    message, user.getSendTo(), DriverEnum.FTP.getId(), user.getMark());
            insertList.add(sendLog);
        }

        sendLogService.insertBatch(insertList);
    }

}
