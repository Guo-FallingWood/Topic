package com.sang.topic.common.model;

import java.util.HashMap;

@Deprecated
public class AjaxResultMap extends HashMap<String, Object>{
    public AjaxResultMap(boolean success, String message){
        super();
        put("success", success);
        put("message", message);
    }
}
