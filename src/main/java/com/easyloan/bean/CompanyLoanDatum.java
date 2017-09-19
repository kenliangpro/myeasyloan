package com.easyloan.bean;

public class CompanyLoanDatum {
    private String id;

    private String companyFile;

    private String mortgageFile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCompanyFile() {
        return companyFile;
    }

    public void setCompanyFile(String companyFile) {
        this.companyFile = companyFile == null ? null : companyFile.trim();
    }

    public String getMortgageFile() {
        return mortgageFile;
    }

    public void setMortgageFile(String mortgageFile) {
        this.mortgageFile = mortgageFile == null ? null : mortgageFile.trim();
    }
}