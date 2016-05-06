package com.sang.topic.util;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by arch on 2016/5/5.
 */
public class DateConverter implements WebBindingInitializer {

    public static String convert(Date date, Date now){
        StringBuffer time = new StringBuffer();

        long t = now.getTime()-date.getTime();
        long second = t/1000;
        long min = second/60;

        if(min < 60 ){
            time.append(min);
            time.append("分钟前");
        }else if(min < 60 * 24){
            long hours = min/60;
            min = min%60;
            time.append(hours);
            time.append("小时");
            time.append(min);
            time.append("分钟前");
        }else if(min < 60 * 24 * 7 ) {
            long day = min/ (60 * 24);
            time.append(day);
            time.append("天前");
        } else{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            time.append(simpleDateFormat.format(date));
        }
        return time.toString();
    }

    public static String convert(Date date){
        return convert(date, new Date());
    }

    @Override
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {

    }
}
