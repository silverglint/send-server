package com.hxgis.send.model.content;

/**
 * Created by sk on 2019/4/26
 */
public class SmbContent extends BaseContent {
    private byte[] file;
    private String fileName;

    public SmbContent() {
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
