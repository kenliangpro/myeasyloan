package com.easyloan.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * 所有json的返回类型，封装json
 *
 * @param <T>
 */
public class Result<T> {

    public int state;

    public String message;

    public T data;

    public Map<String, Object> extendDate = new HashMap<String, Object>();

    public Map<String, Object> getExtendDate() {
        return extendDate;
    }

    public void setExtendDate(Map<String, Object> extendDate) {
        this.extendDate = extendDate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }


}
