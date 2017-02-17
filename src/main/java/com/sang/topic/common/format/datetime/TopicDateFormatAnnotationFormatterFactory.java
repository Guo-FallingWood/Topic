package com.sang.topic.common.format.datetime;

import com.sang.topic.common.format.annotation.TopicDateFormat;
import org.apache.log4j.Logger;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by arch on 2016/6/11.
 */
public class TopicDateFormatAnnotationFormatterFactory implements AnnotationFormatterFactory<TopicDateFormat> {
    Logger logger = Logger.getLogger(TopicDateFormatAnnotationFormatterFactory.class);

    @Override
    public Set<Class<?>> getFieldTypes() {
        Set<Class<?>> fieldTypes = new HashSet<>();
        fieldTypes.add(Date.class);
        return fieldTypes;
    }

    @Override
    public Printer<?> getPrinter(TopicDateFormat topicDateFormat, Class<?> aClass) {
        return new TopicDateFormatter();
    }

    @Override
    public Parser<?> getParser(TopicDateFormat topicDateFormat, Class<?> aClass) {
        return new TopicDateFormatter();
    }
}
