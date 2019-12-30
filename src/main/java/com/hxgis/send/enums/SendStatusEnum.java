package com.hxgis.send.enums;

/**
 * Created by sk on 2019/4/25
 */
public enum SendStatusEnum {

    SUCCESS(2),
    SENDING(0),
    WAITING(1),
    FAIL(3);

    private final int status;

    SendStatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
