package com.hxgis.send.service;

import com.hxgis.send.model.baseway.BaseSendModel;

/**
 * Created by sk on 2019/4/25
 */
public interface SendService {

    String send(String taskId, BaseSendModel baseSendModel);
}
