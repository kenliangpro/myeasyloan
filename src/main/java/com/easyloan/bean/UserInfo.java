package com.easyloan.bean;

public class UserInfo {
	private String id;

	private Integer gender;

	private String realName;

	private String headerImg;

	private String email;

	private String addr;

	private String phone;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName == null ? null : realName.trim();
	}

	public String getHeaderImg() {
		return headerImg;
	}

	public void setHeaderImg(String headerImg) {
		this.headerImg = headerImg == null ? null : headerImg.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr == null ? null : addr.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", gender=" + gender + ", realName=" + realName + ", headerImg=" + headerImg
				+ ", email=" + email + ", addr=" + addr + ", phone=" + phone + "]";
	}

}