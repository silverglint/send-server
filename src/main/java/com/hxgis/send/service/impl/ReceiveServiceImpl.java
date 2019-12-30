package com.hxgis.send.service.impl;

import com.hxgis.send.converter.SendLogConverter;
import com.hxgis.send.entity.SendLog;
import com.hxgis.send.exception.SendMsgException;
import com.hxgis.send.model.SendResult;
import com.hxgis.send.model.UserResult;
import com.hxgis.send.service.ReceiveService;
import com.hxgis.send.service.SendLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by sk on 2019/4/25
 */

@Service
public class ReceiveServiceImpl implements ReceiveService {

    private SendLogService sendLogService;

    @Autowired
    public ReceiveServiceImpl(SendLogService sendLogService) {
        this.sendLogService = sendLogService;
    }

    @Override
    public SendResult getReceive(String taskId) {

        if (StringUtils.isEmpty(taskId)) {
            throw SendMsgException.EMPTY_TASKID;
        }

        SendResult sendResult = new SendResult();
        sendResult.setTaskId(taskId);

        List<SendLog> sendLogs = sendLogService.selectByTaskId(taskId);

        if (CollectionUtils.isEmpty(sendLogs)) {
            throw SendMsgException.EMPTY_RESULT;
        }

        UserResult[] userResults = new UserResult[sendLogs.size()];
        for (int i = 0; i < sendLogs.size(); i++) {
            UserResult userResult = SendLogConverter.convertToUserResult(sendLogs.get(i));
            userResults[i] = userResult;
        }
        sendResult.setResults(userResults);

        return sendResult;
    }
}
