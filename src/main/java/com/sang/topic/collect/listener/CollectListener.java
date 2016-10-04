package com.sang.topic.collect.listener;

import com.sang.topic.collect.SpiderExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by arch on 2016/8/27.
 */
public class CollectListener implements ServletContextListener{
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("CollectListener init");
        SpiderExecutor.getInstance();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("CollectListener destroy");
        SpiderExecutor.getInstance().destroy();
    }
}
