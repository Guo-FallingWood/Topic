package com.sang.topic.common.service;

import com.sang.topic.common.mapper.CollectUrlMapper;
import com.sang.topic.common.model.CollectUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sh on 2016/9/11.
 */
@Service(value = "urlService")
public class CollectUrlService {
    @Autowired
    CollectUrlMapper urlMapper;

    public List<CollectUrl> getAll(){
        return urlMapper.selectAll();
    }

    @Transactional
    public void insert(CollectUrl url){
        urlMapper.insertSelective(url);
    }
    
}
