package com.easyloan.bean;

import java.util.Date;

public class Suggestion {
    private String id;

    private String suggestions;

    private Date suggestionTime;

    private String reply;

    private String replyTime;

    private Integer status;

    private String userId;

    private String managerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions == null ? null : suggestions.trim();
    }

    public Date getSuggestionTime() {
        return suggestionTime;
    }

    public void setSuggestionTime(Date suggestionTime) {
        this.suggestionTime = suggestionTime;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime == null ? null : replyTime.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId == null ? null : managerId.trim();
    }
}