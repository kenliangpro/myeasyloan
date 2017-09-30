package com.easyloan.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormatDate {

    public static void main(String[] args) throws Exception {
        System.out.println(calculateDeadLine(new Date(), 6));
        System.out.println(stringToDate(calculateDeadLine(new Date(), 6)));
    }


    public static String formatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date stringToDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws Exception
     */
    public static int daysBetween(String smdate, String bdate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date sdate = sdf.parse(smdate);
            Date bate = sdf.parse(bdate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bate);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            return Integer.parseInt(String.valueOf(between_days));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public static String calculateDeadLine(Date create_time, int loan_tern) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar deadLine = Calendar.getInstance();
        try {
            deadLine.setTime(create_time);
            deadLine.add(Calendar.MONTH, loan_tern);
            return sdf.format(deadLine.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


}
