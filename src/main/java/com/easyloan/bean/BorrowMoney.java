package com.easyloan.bean;

public class BorrowMoney {

    private String id;
    //借钱金额
    private Double borrowAmount;
    //借钱期限
    private Integer borrowTern;
    //单位信息
    private String unitInfo;
    //财务信息
    private String financialInfo;
    //公司名称
    private String companyName;
    //公司法人
    private String companyLegalPerson;
    //公司注册资金
    private Integer companyRegisteredCapital;
    //公司地址
    private String companyAddr;
    //公司编号
    private String companyNum;
    //融资资金
    private Integer companyFinancing;

    private Integer status;

    private String borrowDatumId;

    private String userId;

    private String createTime;
    //银行卡信息
    private String creditCard;

    private String borrowDeadline;
    //电话
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Double getBorrowAmount() {
        return borrowAmount;
    }

    public void setBorrowAmount(Double borrowAmount) {
        this.borrowAmount = borrowAmount;
    }

    public Integer getBorrowTern() {
        return borrowTern;
    }

    public void setBorrowTern(Integer borrowTern) {
        this.borrowTern = borrowTern;
    }

    public String getUnitInfo() {
        return unitInfo;
    }

    public void setUnitInfo(String unitInfo) {
        this.unitInfo = unitInfo == null ? null : unitInfo.trim();
    }

    public String getFinancialInfo() {
        return financialInfo;
    }

    public void setFinancialInfo(String financialInfo) {
        this.financialInfo = financialInfo == null ? null : financialInfo.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyLegalPerson() {
        return companyLegalPerson;
    }

    public void setCompanyLegalPerson(String companyLegalPerson) {
        this.companyLegalPerson = companyLegalPerson == null ? null : companyLegalPerson.trim();
    }

    public Integer getCompanyRegisteredCapital() {
        return companyRegisteredCapital;
    }

    public void setCompanyRegisteredCapital(Integer companyRegisteredCapital) {
        this.companyRegisteredCapital = companyRegisteredCapital;
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr == null ? null : companyAddr.trim();
    }

    public String getCompanyNum() {
        return companyNum;
    }

    public void setCompanyNum(String companyNum) {
        this.companyNum = companyNum == null ? null : companyNum.trim();
    }

    public Integer getCompanyFinancing() {
        return companyFinancing;
    }

    public void setCompanyFinancing(Integer companyFinancing) {
        this.companyFinancing = companyFinancing;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBorrowDatumId() {
        return borrowDatumId;
    }

    public void setBorrowDatumId(String borrowDatumId) {
        this.borrowDatumId = borrowDatumId == null ? null : borrowDatumId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard == null ? null : creditCard.trim();
    }

    public String getBorrowDeadline() {
        return borrowDeadline;
    }

    public void setBorrowDeadline(String borrowDeadline) {
        this.borrowDeadline = borrowDeadline == null ? null : borrowDeadline.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    @Override
    public String toString() {
        return "BorrowMoney{" +
                "id='" + id + '\'' +
                ", borrowAmount=" + borrowAmount +
                ", borrowTern=" + borrowTern +
                ", unitInfo='" + unitInfo + '\'' +
                ", financialInfo='" + financialInfo + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyLegalPerson='" + companyLegalPerson + '\'' +
                ", companyRegisteredCapital=" + companyRegisteredCapital +
                ", companyAddr='" + companyAddr + '\'' +
                ", companyNum='" + companyNum + '\'' +
                ", companyFinancing=" + companyFinancing +
                ", status=" + status +
                ", borrowDatumId='" + borrowDatumId + '\'' +
                ", userId='" + userId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", creditCard='" + creditCard + '\'' +
                ", borrowDeadline='" + borrowDeadline + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}