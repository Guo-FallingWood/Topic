package com.sang.topic.collect.processor;

import com.sang.topic.common.model.CollectRule;
import com.sang.topic.common.model.CollectUrl;
import com.sang.topic.common.model.Post;
import com.sang.topic.common.service.CollectUrlService;
import com.sang.topic.common.util.ApplicationContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by arch on 2016/8/27.
 */
@Component(value = "topicPageProcessor")
public class TopicPageProcessor implements PageProcessor {
    private Site site;
    private Map<String, CollectUrl> urlMap;
    private CollectRule rule;

    private static int topicId = 4;
    static int userId = 2;

    @Autowired
    CollectUrlService urlService;

    private TopicPageProcessor() {
    }

    public static TopicPageProcessor newInstance(CollectRule rule) {
        TopicPageProcessor processor = (TopicPageProcessor) ApplicationContextHelper.getBean("topicPageProcessor");
        processor.rule = rule;
        processor.init();
        return processor;
    }

    private void init() {
        site = new Site();
        site.setSleepTime(5000);
        site.setRetryTimes(2);
        List<CollectUrl> list = urlService.getAll();
        urlMap = list.stream()
                .collect(Collectors.toMap(CollectUrl::getNoparamUrl, item -> item));
    }

    @Override
    public void process(Page page) {
        String url = page.getUrl().get();
        if (checkProcess(url)) {
            extract(page, url);
        }
    }

    private void extract(Page page, String url) {
        Html html = page.getHtml();
        String id = page.getUrl().regex("^https://(?:www\\.)?v2ex\\.com/t/(\\d+)(?:#reply\\d+)?.*$").toString();
        if (id != null) {
            String title = html.xpath("//div[@class='header']/h1/text()").get();
            String content = html.xpath("//div[@class='topic_content']/div/html()").get();
            String userName = html.xpath("//small[@class='gray']/a/text()").get();

            Post post = new Post();
            post.setTitle(title);
            post.setContent(content);
            post.setUserUsername(userName);
            post.setUserId(userId);
            post.setTopicId(topicId);
            page.putField("post", post);

            String noParamUrl = removeParameter(url);
            CollectUrl collectUrl = new CollectUrl();
            collectUrl.setCreateTime(new Date());
            collectUrl.setRealUrl(url);
            collectUrl.setNoparamUrl(noParamUrl);
            page.putField("url", collectUrl);

            urlMap.put(noParamUrl, collectUrl);
        }
        Selectable links = html.links();
        List<String> l = links.regex("(https://(?:www\\.)?v2ex\\.com/t/(\\d+)(?:#reply\\d+)?.*)").all();
        page.addTargetRequests(l);
    }

    public String removeParameter(String url) {
        return url.replaceAll("^(.*)(\\?|#).*$", "$1");
    }

    private boolean checkProcess(String url) {
        if (urlMap.containsKey(removeParameter(url)))
            return false;
        return true;
    }

    @Override
    public Site getSite() {
        return site;
    }
}
