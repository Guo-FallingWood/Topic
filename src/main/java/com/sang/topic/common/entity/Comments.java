package com.sang.topic.common.entity;

import com.sang.topic.common.format.annotation.TopicDateFormat;

import javax.validation.constraints.Size;
import java.util.Date;

public class Comments {
    private Integer id;

    @Size(min = 5, max = 100, message = "内容长度应该为{min}-{max}")
    private String content;

    private Integer userId;

    private Integer postId;

    private Integer discard;

    private String userUsername;

    //    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @TopicDateFormat
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}