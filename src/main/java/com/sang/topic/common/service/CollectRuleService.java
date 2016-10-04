package com.sang.topic.common.service;

import com.sang.topic.common.mapper.CollectRuleMapper;
import com.sang.topic.common.model.CollectRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sh on 2016/9/22.
 */
@Service
public class CollectRuleService {
    @Autowired
    CollectRuleMapper collectRuleMapper;

    public CollectRule get(Integer id){
        return collectRuleMapper.selectByPrimaryKey(id);
    }

    public List<CollectRule> getAll(){
        return collectRuleMapper.selectAll();
    }

    public int insert(String name){
        CollectRule collectRule = new CollectRule();
        collectRule.setName(name);
        return collectRuleMapper.insertSelective(collectRule);
    }

    public int update(CollectRule collectRule){
        return collectRuleMapper.updateByPrimaryKeySelective(collectRule);
    }

    public int delete(Integer id){
        return collectRuleMapper.deleteByPrimaryKey(id);
    }
}
