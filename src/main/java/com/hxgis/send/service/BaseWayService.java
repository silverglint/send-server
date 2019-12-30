package com.hxgis.send.service;

import com.hxgis.send.enums.SendStatusEnum;
import com.hxgis.send.model.baseway.BaseSendModel;
import com.hxgis.send.model.userinfo.BaseUserInfo;

/**
 * Created by sk on 2019/12/28
 */
public interface BaseWayService {

    void send(String taskId, BaseSendModel model);

    void insertLog(String taskId, SendStatusEnum status, String message, BaseUserInfo[] users);
}
