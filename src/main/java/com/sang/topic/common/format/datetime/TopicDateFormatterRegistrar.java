package com.sang.topic.common.format.datetime;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

/**
 * Created by arch on 2016/6/11.
 */
public class TopicDateFormatterRegistrar implements FormatterRegistrar{
    @Override
    public void registerFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldAnnotation(new TopicDateFormatAnnotationFormatterFactory());
    }
}
