package com.sang.topic.common.model;

import java.util.List;

public class ValidationResponse {
    private String status;
    private String message;
    private List<ErrorMessage> errors;

    public ValidationResponse(){
        status = "FAIL";
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public List getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorMessage> errors) {
        this.errors = errors;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
