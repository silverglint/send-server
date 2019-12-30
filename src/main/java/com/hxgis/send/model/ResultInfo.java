package com.hxgis.send.model;

/**
 * 返回值
 *
 * @author zhouyongbo
 */
public class ResultInfo<T> {
    private String message;
    /**
     * 成功 100 失败101
     */
    private Integer code;
    /**
     * 返回数据
     */
    private T data;

    public ResultInfo() {
    }

    public ResultInfo(String message, Integer code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public static <T> ResultInfo success(T data) {
        return new ResultInfo(null, 100, data);
    }


    public static <T> ResultInfo error(String meassage) {
        return new ResultInfo(meassage, 101, null);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
