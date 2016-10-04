package com.sang.topic.collect;

import com.sang.topic.collect.pipeline.SpiderPipeline;
import com.sang.topic.collect.pipeline.StoragePipeline;
import com.sang.topic.common.model.CollectRule;
import com.sang.topic.common.model.Post;
import com.sang.topic.common.util.ApplicationContextHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.*;

/**
 * Created by sh on 2016/8/28.
 */
@Component
public class SpiderExecutor {
    private static SpiderExecutor SpiderExecutor = new SpiderExecutor();
    private Map<String, TopicSpider> spiders = new LinkedHashMap<>();
    private Logger logger = LoggerFactory.getLogger(getClass());

    private SpiderExecutor() {
    }

    public static SpiderExecutor getInstance() {
        return SpiderExecutor;
    }

    public Post run(CollectRule rule, String url){
        TopicSpider spider = new TopicSpider(rule);
        spider.addUrl(url);
        spider.addPipeline(new SpiderPipeline(spider));
        spider.run();
        return spider.getPost();
    }

    public List<Map<String, Object>> mapSpider() {
        Map<String, TopicSpider> list = getSpiders();
        List<Map<String, Object>> result = new ArrayList<>();
        list.values().forEach(s -> {
            Map<String, Object> m = new HashMap<>();
            m.put("name", s.getName());
            m.put("post", s.getPost());
            m.put("uuid", s.getUUID());
            m.put("status", s.getStatus());
            result.add(m);
        });
        return result;
    }

    public Map<String, Object> mapStatus() {
        long runSize = spiders.values().stream()
                .filter(s -> s.getStatus() == Spider.Status.Running)
                .count();
        Map<String, Object> result = new HashMap<>();
        result.put("size", spiders.size());
        result.put("runSize", runSize);
        return result;
    }

    private void close(TopicSpider spider) {
        spider.close();
        spiders.remove(spider);
    }

    public synchronized void resume(String uuid) {
    }

    public synchronized Post getPost(String uuid) {
        return spiders.get(uuid).getPost();
    }

    public synchronized Map<String, TopicSpider> getSpiders() {
        return spiders;
    }

    public synchronized void destroy() {
        spiders.values().forEach(s -> s.close());
    }
}
