package com.easyloan.bean;

public class BorrowDatum {
    private String id;

    private String borrowFile;

    private String borrowDetails;

    private Double totalInvest;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBorrowFile() {
        return borrowFile;
    }

    public void setBorrowFile(String borrowFile) {
        this.borrowFile = borrowFile == null ? null : borrowFile.trim();
    }

    public String getBorrowDetails() {
        return borrowDetails;
    }

    public void setBorrowDetails(String borrowDetails) {
        this.borrowDetails = borrowDetails == null ? null : borrowDetails.trim();
    }

    public Double getTotalInvest() {
        return totalInvest;
    }

    public void setTotalInvest(Double totalInvest) {
        this.totalInvest = totalInvest;
    }
}