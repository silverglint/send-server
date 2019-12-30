package com.hxgis.send.exception;

import com.hxgis.send.model.ResultInfo;

/**
 * Created by sk on 2019/4/25
 */
public class DriverException extends BaseException {

    public static final DriverException NOT_FIND_EXCEPTION = new DriverException("没有该驱动");

    public DriverException(String message) {
        super(message);
    }

    public DriverException(Object data) {
        super(data);
    }

    public DriverException(Object data, Object... results) {
        super(data, results);
    }

    @Override
    public Object getResultInfoDo() {
        return ResultInfo.error(this.getMessage());
    }
}
