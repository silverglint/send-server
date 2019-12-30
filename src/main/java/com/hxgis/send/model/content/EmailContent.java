package com.hxgis.send.model.content;

/**
 * Created by sk on 2019/4/24
 */
public class EmailContent extends BaseContent {
    //主题
    private String subject;
    //内容
    private String text;
    private byte[] attachment;
    private String attachmentName;

    public EmailContent() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }
}
