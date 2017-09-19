package com.easyloan.bean;

public class PersonalLoanDatum {
    private String id;

    private String identityFile;

    private String mortgageFile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getIdentityFile() {
        return identityFile;
    }

    public void setIdentityFile(String identityFile) {
        this.identityFile = identityFile == null ? null : identityFile.trim();
    }

    public String getMortgageFile() {
        return mortgageFile;
    }

    public void setMortgageFile(String mortgageFile) {
        this.mortgageFile = mortgageFile == null ? null : mortgageFile.trim();
    }
}