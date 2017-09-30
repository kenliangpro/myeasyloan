package com.easyloan.dto;


import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

public class PersonLoanDto {

    private String address;
    private String phone;
    private double loan_amount;
    private int loan_tern;
    private MultipartFile[] loanDatums;
    private String creditCard;

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(double loan_amount) {
        this.loan_amount = loan_amount;
    }

    public int getLoan_tern() {
        return loan_tern;
    }

    public void setLoan_tern(int loan_tern) {
        this.loan_tern = loan_tern;
    }

    public MultipartFile[] getLoanDatums() {
        return loanDatums;
    }

    public void setLoanDatums(MultipartFile[] loanDatums) {
        this.loanDatums = loanDatums;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PersonLoanDto() {
    }

    @Override
    public String toString() {
        return "PersonLoanDto{" +
                "address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", loan_amount=" + loan_amount +
                ", loan_tern=" + loan_tern +
                ", loanDatums=" + Arrays.toString(loanDatums) +
                ", creditCard='" + creditCard + '\'' +
                '}';
    }
}
