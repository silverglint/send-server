package com.hxgis.send.exception;

import com.hxgis.send.model.ResultInfo;

/**
 * Created by sk on 2019/4/25
 */
public class SendMsgException extends BaseException {

    public static final SendMsgException SEND_FAIL_EXCEPTION = new SendMsgException("发送失败");

    public static final SendMsgException EMPTY_TASKID = new SendMsgException("任务id为空");

    public static final SendMsgException EMPTY_RESULT = new SendMsgException("任务不存在");

    public static final SendMsgException WRONG_AUTH = new SendMsgException("没有访问权限");

    public static final SendMsgException EMPTY_EXCEPTION = new SendMsgException("值不能为空");

    public static final SendMsgException EMPTY_PHONE = new SendMsgException("号码不能为空");

    public static final SendMsgException EMPTY_CONTENT = new SendMsgException("内容不能为空");

    public SendMsgException(String message) {
        super(message);
    }

    public SendMsgException(Object data) {
        super(data);
    }

    public SendMsgException(Object data, Object... results) {
        super(data, results);
    }

    @Override
    public Object getResultInfoDo() {
        return ResultInfo.error(this.getMessage());
    }
}
