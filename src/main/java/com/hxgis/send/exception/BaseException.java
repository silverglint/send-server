package com.hxgis.send.exception;


/**
 * 异常基类
 */
public abstract class BaseException extends RuntimeException {

    private Object data;

    private String message;

    private Object[] results;

    public BaseException(String message) {
        this.message = message;
    }

    public BaseException(Object data) {
        this.data = data;
    }

    public BaseException(Object data, Object... results) {
        this.data = data;
        this.results = results;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object[] getResults() {
        return results;
    }

    public void setResults(Object[] results) {
        this.results = results;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResultInfo() {
        return this.getResultInfoDo();
    }

    public abstract Object getResultInfoDo();
}
