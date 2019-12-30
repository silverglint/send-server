package com.hxgis.send.model.baseway;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by sk on 2019/4/24
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "driverId",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "0100", value = EmailSendModel.class),
        @JsonSubTypes.Type(name = "0300", value = FtpSendModel.class),
        @JsonSubTypes.Type(name = "1200", value = SmbSendModel.class),
})
public abstract class BaseSendModel {

    private String driverId;

    public BaseSendModel() {
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

}
