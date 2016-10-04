package com.sang.topic.common.model;

import java.util.Date;

public class CollectUrl {
    private Integer id;

    private String realUrl;

    private String noparamUrl;

    private String type;

    private Integer postId;

    private Date createTime;

    private Date lastTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealUrl() {
        return realUrl;
    }

    public void setRealUrl(String realUrl) {
        this.realUrl = realUrl;
    }

    public String getNoparamUrl() {
        return noparamUrl;
    }

    public void setNoparamUrl(String noparamUrl) {
        this.noparamUrl = noparamUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
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