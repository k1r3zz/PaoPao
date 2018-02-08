package com.user.paopao.entity;


/**
 * author：lily
 * date：2017/12/22 14:47
 * description:  公共数据请求层
 */

public class BaseBean<T> {
    private int code;
    private T data;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}
