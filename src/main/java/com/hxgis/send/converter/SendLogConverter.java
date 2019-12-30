package com.hxgis.send.converter;

import com.hxgis.send.entity.SendLog;
import com.hxgis.send.enums.DriverEnum;
import com.hxgis.send.model.UserResult;

/**
 * Created by sk on 2019/4/25
 */
public class SendLogConverter {

    public static UserResult convertToUserResult(SendLog sendLog) {

        UserResult userResult = new UserResult();

        String driverId = sendLog.getDriverId();
        DriverEnum driverEnum = DriverEnum.withId(driverId);

        userResult.setDriverId(driverId);
        userResult.setDriverName(driverEnum.getName());
        userResult.setDriverType(driverEnum.getType());
        userResult.setMessage(sendLog.getMessage());
        userResult.setRemark(sendLog.getMark());
        userResult.setSendTo(sendLog.getSendTo());
        userResult.setStatus(sendLog.getStatus());
        userResult.setTime(sendLog.getUpdateTime());

        return userResult;
    }
}
