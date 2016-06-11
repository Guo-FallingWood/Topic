package com.sang.topic.model;

import com.sang.topic.format.annotation.TopicDateFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Post {
    private Integer id;

    private String title;

    private String content;

    private Integer userId;

    private Integer topicId;

    private Integer discard;

    private String userUsername;

    private Integer commentsNumber;

//    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @TopicDateFormat
    private Date createTime;

    @TopicDateFormat
    private Date lastTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getDiscard() {
        return discard;
    }

    public void setDiscard(Integer discard) {
        this.discard = discard;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public Integer getCommentsNumber() {
        return commentsNumber;
    }

    public void setCommentsNumber(Integer commentsNumber) {
        this.commentsNumber = commentsNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}