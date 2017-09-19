package com.easyloan.bean;

import java.util.Date;

public class PersonalLoan {
    private String id;

    private Integer loanAmount;

    private Integer loanTern;

    private Date loanDeadline;

    private Date createTime;

    private String addr;

    private Integer status;

    private String datumId;

    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Integer loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getLoanTern() {
        return loanTern;
    }

    public void setLoanTern(Integer loanTern) {
        this.loanTern = loanTern;
    }

    public Date getLoanDeadline() {
        return loanDeadline;
    }

    public void setLoanDeadline(Date loanDeadline) {
        this.loanDeadline = loanDeadline;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDatumId() {
        return datumId;
    }

    public void setDatumId(String datumId) {
        this.datumId = datumId == null ? null : datumId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}