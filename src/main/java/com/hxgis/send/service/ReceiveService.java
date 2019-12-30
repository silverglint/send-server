package com.hxgis.send.service;

import com.hxgis.send.model.SendResult;

/**
 * Created by sk on 2019/4/25
 */
public interface ReceiveService {

    SendResult getReceive(String taskId);
}
