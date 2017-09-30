package com.easyloan.bean;

public class User {
    private String id;

    private String username;

    private String password;

    private String registerTime;

    private Integer isDel;

    private Integer isShield;

    private String userinfoId;

    private String safetyQuestionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime == null ? null : registerTime.trim();
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getIsShield() {
        return isShield;
    }

    public void setIsShield(Integer isShield) {
        this.isShield = isShield;
    }

    public String getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(String userinfoId) {
        this.userinfoId = userinfoId == null ? null : userinfoId.trim();
    }

    public String getSafetyQuestionId() {
        return safetyQuestionId;
    }

    public void setSafetyQuestionId(String safetyQuestionId) {
        this.safetyQuestionId = safetyQuestionId == null ? null : safetyQuestionId.trim();
    }
}