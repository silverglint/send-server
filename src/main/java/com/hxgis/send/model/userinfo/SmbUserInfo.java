package com.hxgis.send.model.userinfo;

/**
 * Created by sk on 2019/4/26
 */
public class SmbUserInfo extends BaseUserInfo {

    private String shareLocation;
    private String shareAccount;
    private String sharePassword;

    public SmbUserInfo() {
    }

    public String getShareLocation() {
        return shareLocation;
    }

    public void setShareLocation(String shareLocation) {
        this.shareLocation = shareLocation;
    }

    public String getShareAccount() {
        return shareAccount;
    }

    public void setShareAccount(String shareAccount) {
        this.shareAccount = shareAccount;
    }

    public String getSharePassword() {
        return sharePassword;
    }

    public void setSharePassword(String sharePassword) {
        this.sharePassword = sharePassword;
    }

    @Override
    public String getSendTo() {
        return this.shareLocation;
    }
}
