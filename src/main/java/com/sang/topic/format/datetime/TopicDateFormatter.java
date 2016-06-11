package com.sang.topic.format.datetime;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by arch on 2016/6/11.
 */
public class TopicDateFormatter implements Formatter<Date> {
    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        return new Date();
    }

    @Override
    public String print(Date date, Locale locale) {
        Date now = new Date();
        return DateToString(now, date);
    }

    public String DateToString(Date now, Date target){
        String r;
        long interval = now.getTime() - target.getTime();
        long second = interval/1000;
        long minute = second/60;
        if(minute >= 60){
            long hour = minute/60;
            if(hour >= 24){
                long day = hour/24;
                if(day >= 30){
                    r = new SimpleDateFormat("yyyy-MM-dd").format(target);
                }else{
                    r = day+"天前";
                }
            }else{
                r = hour+"小时前";
            }
        }else{
            r = minute+"分钟前";
        }
        return r;
    }
}
