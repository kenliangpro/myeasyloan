package com.easyloan.dto;

import org.springframework.beans.factory.annotation.Value;

public class AverageCapital {

    //每月利息
    private double perMonthInvest;
    //每月本金
    private double perMonthPrincipal;
    //总利息
    private double totalInvest;
    //年利率
//    public final static double yearRate = 0.144;

    private int detailsMonth;

    public double getPerMonthInvest() {
        return perMonthInvest;
    }

    public void setPerMonthInvest(double perMonthInvest) {
        this.perMonthInvest = perMonthInvest;
    }

    public double getPerMonthPrincipal() {
        return perMonthPrincipal;
    }

    public void setPerMonthPrincipal(double perMonthPrincipal) {
        this.perMonthPrincipal = perMonthPrincipal;
    }

    public double getTotalInvest() {
        return totalInvest;
    }

    public void setTotalInvest(double totalInvest) {
        this.totalInvest = totalInvest;
    }

//    public static double getYearRate() {
//        return yearRate;
//    }



    public int getDetailsMonth() {
        return detailsMonth;
    }

    public void setDetailsMonth(int detailsMonth) {
        this.detailsMonth = detailsMonth;
    }

    public AverageCapital(double perMonthInvest, double perMonthPrincipal, double totalInvest, int detailsMonth) {
        this.perMonthInvest = perMonthInvest;
        this.perMonthPrincipal = perMonthPrincipal;
        this.totalInvest = totalInvest;
        this.detailsMonth = detailsMonth;
    }

    @Override
    public String toString() {
        return "AverageCapital{" +
                "perMonthInvest=" + perMonthInvest +
                ", perMonthPrincipal=" + perMonthPrincipal +
                ", totalInvest=" + totalInvest +
                ", detailsMonth='" + detailsMonth + '\'' +
                '}';
    }
}
