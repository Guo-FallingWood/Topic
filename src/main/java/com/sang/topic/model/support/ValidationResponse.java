package com.sang.topic.model.support;

import java.util.List;

public class ValidationResponse {
    private String status;
    private List<ErrorMessage> errors;

    public ValidationResponse(){
        status = "FAIL";
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
