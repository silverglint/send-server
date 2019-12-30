package com.hxgis.send.model.userinfo;

/**
 * Created by sk on 2019/4/25
 */
public class FtpUserInfo extends BaseUserInfo {

    private String ftpAddress;
    private String ftpAccount;
    private String ftpPassWord;

    public FtpUserInfo() {
    }

    @Override
    public String getSendTo() {
        return this.ftpAddress;
    }

    public String getFtpAddress() {
        return ftpAddress;
    }

    public void setFtpAddress(String ftpAddress) {
        this.ftpAddress = ftpAddress;
    }

    public String getFtpAccount() {
        return ftpAccount;
    }

    public void setFtpAccount(String ftpAccount) {
        this.ftpAccount = ftpAccount;
    }

    public String getFtpPassWord() {
        return ftpPassWord;
    }

    public void setFtpPassWord(String ftpPassWord) {
        this.ftpPassWord = ftpPassWord;
    }
}
