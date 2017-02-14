package com.sang.topic.common.model.support;

import java.util.Map;

/**
 * Created by sh on 2017/1/21.
 */
public class ResultResponse {
    private Integer status;
    private String message;
    private Map<String, Object> data;

    public ResultResponse(){
        this("处理成功");
    }

    public ResultResponse(String message) {
        this(0, message);
    }

    public ResultResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
