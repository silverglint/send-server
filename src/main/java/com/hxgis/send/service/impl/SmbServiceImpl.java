package com.hxgis.send.service.impl;

import com.hxgis.send.entity.SendLog;
import com.hxgis.send.enums.DriverEnum;
import com.hxgis.send.enums.SendStatusEnum;
import com.hxgis.send.model.content.SmbContent;
import com.hxgis.send.model.userinfo.BaseUserInfo;
import com.hxgis.send.model.userinfo.SmbUserInfo;
import com.hxgis.send.service.SendLogService;
import com.hxgis.send.service.SmbService;
import com.hxgis.send.utils.UUIDUtils;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sk on 2019/4/26
 */
@Service
public class SmbServiceImpl implements SmbService {

    private SendLogService sendLogService;

    public SmbServiceImpl(SendLogService sendLogService) {
        this.sendLogService = sendLogService;
    }

    @Override
    public void send(String taskId, SmbContent smbContent, SmbUserInfo[] users) throws IOException {

        for (SmbUserInfo user : users) {

            user.setId(UUIDUtils.getUUID());
            //smb://hu:hu@172.20.48.1/wh/Forecast/Decision/Rain/test.doc
            String address = user.getShareLocation();
            if (!address.endsWith("/")) {
                address = address + "/";
            }
            String url = "smb://" + user.getShareAccount() + ":" + user.getSharePassword() + "@" + address + smbContent.getFileName();
            SmbFile smbFile = new SmbFile(url);
            OutputStream out = new SmbFileOutputStream(smbFile);
            out.write(smbContent.getFile());
            out.close();
        }
    }

    @Override
    public void insertLog(String taskId, SendStatusEnum status, String message, SmbUserInfo[] users) {
        Date date = new Date();

        List<SendLog> insertList = new ArrayList<>();
        for (BaseUserInfo user : users) {
            SendLog sendLog = new SendLog(user.getId(), taskId, date, date, status.getStatus(),
                    message, user.getSendTo(), DriverEnum.SMB.getId(), user.getMark());
            insertList.add(sendLog);
        }

        sendLogService.insertBatch(insertList);
    }
}
