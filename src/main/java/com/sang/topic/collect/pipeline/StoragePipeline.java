package com.sang.topic.collect.pipeline;

import com.sang.topic.common.model.Post;
import com.sang.topic.common.model.TopicUrl;
import com.sang.topic.common.service.PostService;
import com.sang.topic.common.service.TopicUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * Created by sh on 2016/8/28.
 */
@Component
public class StoragePipeline implements Pipeline {
    @Autowired
    TopicUrlService urlService;
    @Autowired
    PostService postService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void process(ResultItems resultItems, Task task) {
        TopicUrl url = resultItems.get("url");
        if (url != null) {
            logger.info("Storage Url [ " + url.getRealUrl() + " ]");
            Post post = resultItems.get("post");
            urlService.insert(url);
            postService.insert(post);
        }
    }
}
