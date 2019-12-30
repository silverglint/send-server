package com.hxgis.send.model.content;

/**
 * Created by sk on 2019/4/25
 */
public class FtpContent extends BaseContent {

    private byte[] file;
    private String fileName;

    public FtpContent() {
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
