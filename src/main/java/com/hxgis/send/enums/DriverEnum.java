package com.hxgis.send.enums;

/**
 * Created by sk on 2019/4/25
 */
public enum DriverEnum {
//    MSG("0001", "短信", "默认"),
    EMAIL("0100", "邮件", "默认"),
    FTP("0300", "FTP", "默认"),
    SMB("1200", "共享目录", "默认"),
//    FAX("0201", "FAX", "GFax"),
    ILLEGAL("9999", "非法驱动", "默认"),
    ;

    private final String id;
    private final String type;
    private final String name;

    DriverEnum(String id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static DriverEnum withId(String id) {
        for (DriverEnum driverEnum : DriverEnum.values()) {
            if (driverEnum.getId().equals(id)) {
                return driverEnum;
            }
        }
        return DriverEnum.ILLEGAL;
    }
}
