package com.sang.topic.util;

import java.util.HashMap;

public class AjaxResultMap extends HashMap<String, Object>{
    public AjaxResultMap(boolean success, String message){
        put("success", success);
        put("message", message);
    }
}
