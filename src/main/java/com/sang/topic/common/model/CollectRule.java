package com.sang.topic.common.model;

public class CollectRule {
    private Integer id;

    private String name;

    private Integer topicId;

    private String postTitle;

    private String postContent;

    private Integer postUserId;

    private String postUsername;

    private String postCommentsNumber;

    private String postCreateTime;

    private String postLastTime;

    private String commentContent;

    private String commentUserId;

    private String commentUsername;

    private String commentCreateTime;

    private String commentFloor;

    private boolean isTest;

    public boolean isTest() {
        return isTest;
    }

    public void setTest(boolean test) {
        isTest = test;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Integer getPostUserId() {
        return postUserId;
    }

    public void setPostUserId(Integer postUserId) {
        this.postUserId = postUserId;
    }

    public String getPostUsername() {
        return postUsername;
    }

    public void setPostUsername(String postUsername) {
        this.postUsername = postUsername;
    }

    public String getPostCommentsNumber() {
        return postCommentsNumber;
    }

    public void setPostCommentsNumber(String postCommentsNumber) {
        this.postCommentsNumber = postCommentsNumber;
    }

    public String getPostCreateTime() {
        return postCreateTime;
    }

    public void setPostCreateTime(String postCreateTime) {
        this.postCreateTime = postCreateTime;
    }

    public String getPostLastTime() {
        return postLastTime;
    }

    public void setPostLastTime(String postLastTime) {
        this.postLastTime = postLastTime;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(String commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentUsername() {
        return commentUsername;
    }

    public void setCommentUsername(String commentUsername) {
        this.commentUsername = commentUsername;
    }

    public String getCommentCreateTime() {
        return commentCreateTime;
    }

    public void setCommentCreateTime(String commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
    }

    public String getCommentFloor() {
        return commentFloor;
    }

    public void setCommentFloor(String commentFloor) {
        this.commentFloor = commentFloor;
    }
}