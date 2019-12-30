package com.hxgis.send.service;

import com.baomidou.mybatisplus.service.IService;
import com.hxgis.send.entity.SendLog;
import com.hxgis.send.enums.DriverEnum;

import java.util.List;

/**
 * Created by sk on 2019/4/25
 */
public interface SendLogService extends IService<SendLog> {

    List<SendLog> selectByTaskId(String taskId);

    List<SendLog> selectNotFinish(DriverEnum driver);
}
