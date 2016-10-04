package com.sang.topic.collect;

import com.sang.topic.collect.processor.TopicPageProcessor;
import com.sang.topic.common.model.CollectRule;
import com.sang.topic.common.model.Post;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.UUID;

/**
 * Created by sh on 2016/8/30.
 */
public class TopicSpider extends Spider{
    protected Post post = null;
    private String name = "";

    public TopicSpider(CollectRule rule){
        super(TopicPageProcessor.newInstance(rule));
        uuid = UUID.randomUUID().toString();
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
