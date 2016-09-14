package com.sang.topic.collect;

import com.sang.topic.collect.pipeline.SpiderPipeline;
import com.sang.topic.collect.pipeline.StoragePipeline;
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
public class SpiderMap {
    private static SpiderMap SpiderMap = new SpiderMap();
    private Map<String, TopicSpider> spiders = new LinkedHashMap<>();
    private Logger logger = LoggerFactory.getLogger(getClass());

    private SpiderMap() {
    }

    public static SpiderMap getInstance() {
        return SpiderMap;
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

    public synchronized TopicSpider add(TopicSpider spider) {
        spiders.put(spider.getUUID(), spider);
        spider.start();
        return spider;
    }

    public synchronized TopicSpider add(PageProcessor pageProcessor) {
        TopicSpider spider = new TopicSpider(pageProcessor);
        spider.thread(1);

        StoragePipeline storagePipeline = (StoragePipeline) ApplicationContextHelper.getBean("storagePipeline");
        spider.addPipeline(storagePipeline);
        spider.addPipeline(new SpiderPipeline(spider));
        return add(spider);
    }

    private void close(TopicSpider spider) {
        spider.close();
        spiders.remove(spider);
    }

    public synchronized void remove(String uuid) {
        Iterator<TopicSpider> it = spiders.values().stream()
                .filter(s -> s.getUUID().equals(uuid) && s.getStatus() == Spider.Status.Stopped)
                .iterator();
        while (it.hasNext()) {
            close(it.next());
        }
    }

    public synchronized void pause(String uuid) {
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
