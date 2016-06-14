package com.sang.topic.model.support;

import java.util.HashMap;

public class AjaxResultMap extends HashMap<String, Object>{
    public AjaxResultMap(boolean success, String message){
        super();
        put("success", success);
        put("message", message);
    }
}
