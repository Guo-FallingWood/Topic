package com.sang.topic.model;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.sang.topic.format.annotation.TopicDateFormat;
=======
>>>>>>> 315a87405659f35f4521fbd4db8650f79cc56120
=======
>>>>>>> 315a87405659f35f4521fbd4db8650f79cc56120
=======
>>>>>>> 315a87405659f35f4521fbd4db8650f79cc56120
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Comments {
    private Integer id;

    private String content;

    private Integer userId;

    private Integer postId;

    private Integer discard;

    private String userUsername;


<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
//    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @TopicDateFormat
=======
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
>>>>>>> 315a87405659f35f4521fbd4db8650f79cc56120
=======
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
>>>>>>> 315a87405659f35f4521fbd4db8650f79cc56120
=======
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
>>>>>>> 315a87405659f35f4521fbd4db8650f79cc56120
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