package com.easyloan.bean;

import java.util.Date;

public class User {
	private String id;

	private String username;
	private String password;
	private String conpassword;

	private String code;

	private Date registerTime;

	private Integer isDel;

	private Integer isShield;

	private String userinfoId;

	private String safetyQuestionId;

	private UserInfo info;

	public UserInfo getInfo() {
		return info;
	}

	public void setInfo(UserInfo info) {
		this.info = info;
	}

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

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
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

	public String getConpassword() {
		return conpassword;
	}

	public void setConpassword(String conpassword) {
		this.conpassword = conpassword;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", conpassword=" + conpassword
				+ ", code=" + code + ", registerTime=" + registerTime + ", isDel=" + isDel + ", isShield=" + isShield
				+ ", userinfoId=" + userinfoId + ", safetyQuestionId=" + safetyQuestionId + ", info=" + info + "]";
	}

}