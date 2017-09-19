package com.easyloan.bean;

public class BorrowDatum {
    private String id;

    private String borrowFile;

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
}