package com.sang.topic.common.service;

import com.sang.topic.common.mapper.TopicUrlMapper;
import com.sang.topic.common.model.TopicUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sh on 2016/9/11.
 */
@Service(value = "urlService")
public class TopicUrlService {
    @Autowired
    TopicUrlMapper urlMapper;

    public List<TopicUrl> getAll(){
        return urlMapper.selectAll();
    }

    @Transactional
    public void insert(TopicUrl url){
        urlMapper.insertSelective(url);
    }
}
