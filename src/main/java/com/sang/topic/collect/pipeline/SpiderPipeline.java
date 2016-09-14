package com.sang.topic.collect.pipeline;

import com.sang.topic.collect.TopicSpider;
import com.sang.topic.common.model.Post;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * Created by sh on 2016/9/4.
 */
public class SpiderPipeline implements Pipeline {
    private TopicSpider spider;

    public SpiderPipeline(TopicSpider spider) {
        this.spider = spider;
    }

    @Override
    public synchronized void process(ResultItems resultItems, Task task) {
        Post post = resultItems.get("post");
        spider.setPost(post);
    }
}
