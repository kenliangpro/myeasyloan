package com.easyloan.utils;

import com.easyloan.bean.PersonalLoan;
import com.easyloan.dto.AverageCapital;
import com.easyloan.dto.VocationalResult;
import com.easyloan.enums.UserStateEnum;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author kenliang
 * 个人贷款，公司贷款，个人借钱
 * 业务工具类
 */
@Component
public class VocationalUtils {

    //个人贷款年利率
    public static final double PERSONAL_LOAN_YEAR_RATE = 0.144;
    //企业贷款年利率
    public static final double COMPANY_LOAN_YEAR_RATE = 0.1;
    //个人借钱年利率
    public static final double PERSONAL_BORROW_MONEY = 0.18;
    //月份上限
    public static final Map<Integer, Integer> MONTHS = new HashMap<>();

    //按照规定还款日期前3天
    private final static int NEAR_REPAYMENT_DAY = 3;

    static {
        MONTHS.put(6, 6);
        MONTHS.put(12, 12);
        MONTHS.put(18, 18);
        MONTHS.put(24, 24);
        MONTHS.put(36, 36);
        MONTHS.put(48, 48);
    }

    /**
     * 每个30分钟执行一次
     */
    @Scheduled(cron = "0 0/30 * * * ?")
    public void checkIsOverDeadline() {
//        String systemTime = FormatDate.formatDate(new Date());
//        List<PersonalLoan> list = personalLoanMapper.selectByExample(null);
//        if (list.size() > 0) {
//            for (PersonalLoan p : list) {
//                if (FormatDate.daysBetween(new Date().toString(), p.getLoanDeadline()) <= 3) {
//                    System.out.println("执行发送信息操作");
//                }
//            }
//        }
        System.out.println("执行推送");

    }

    /**
     * 生成业务计划(list)
     *
     * @param principal
     * @param totalMonth
     * @return
     */
    public static VocationalResult generateLoanPlan(Double principal, double yearRate, int totalMonth) {
        //根据借款钱数和月份生成贷款计划
        List<AverageCapital> loan_plan_list = new ArrayList<>();
        if (principal > 0 && totalMonth > 0) {
            loan_plan_list = (List) getVocationDetails(principal, yearRate, totalMonth).get("plan_list");
        }
        return new VocationalResult(UserStateEnum.LOANPLAN, loan_plan_list);
    }


    /**
     * 等额本金是指一种贷款的还款方式，是在还款期内把贷款数总额等分，
     * 每月偿还同等数额的本金和剩余贷款在该月所产生的利息，这样由于每月的还款本金额固定，
     * 而利息越来越少，借款人起初还款压力较大，但是随时间的推移每月还款数也越来越少。
     */

    /**
     * 等额本金计算获取还款方式为等额本金的每月偿还本金和利息
     * <p>
     * 公式：每月偿还本金=(贷款本金÷还款月数)+(贷款本金-已归还本金累计额)×月利率
     *
     * @param invest     总借款额（贷款本金）
     * @param yearRate   年利率
     * @param totalMonth 还款总月数
     * @return 每月偿还本金和利息, 不四舍五入，直接截取小数点最后两位
     */
    public static Map<Integer, Double> getPerMonthPrincipalInterest(double invest, double yearRate, int totalMonth) {
        Map<Integer, Double> map = new HashMap<Integer, Double>();
        // 每月本金
        double monthPri = getPerMonthPrincipal(invest, totalMonth);
        // 获取月利率
        double monthRate = yearRate / 12;
        monthRate = new BigDecimal(monthRate).setScale(6, BigDecimal.ROUND_DOWN).doubleValue();
        for (int i = 1; i <= totalMonth; i++) {
            double monthRes = monthPri + (invest - monthPri * (i - 1)) * monthRate;
            monthRes = new BigDecimal(monthRes).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
            map.put(i, monthRes);
        }
        return map;
    }

    /**
     * 等额本金计算获取还款方式为等额本金的每月偿还利息
     * <p>
     * 公式：每月应还利息=剩余本金×月利率=(贷款本金-已归还本金累计额)×月利率
     *
     * @param invest     总借款额（贷款本金）
     * @param yearRate   年利率
     * @param totalMonth 还款总月数
     * @return 每月偿还利息
     */
    public static Map<Integer, Double> getPerMonthInterest(double invest, double yearRate, int totalMonth) {
        Map<Integer, Double> inMap = new HashMap<Integer, Double>();
        double principal = getPerMonthPrincipal(invest, totalMonth);
        Map<Integer, Double> map = getPerMonthPrincipalInterest(invest, yearRate, totalMonth);
        for (Map.Entry<Integer, Double> entry : map.entrySet()) {
            BigDecimal principalBigDecimal = new BigDecimal(principal);
            BigDecimal principalInterestBigDecimal = new BigDecimal(entry.getValue());
            BigDecimal interestBigDecimal = principalInterestBigDecimal.subtract(principalBigDecimal);
            interestBigDecimal = interestBigDecimal.setScale(2, BigDecimal.ROUND_DOWN);
            inMap.put(entry.getKey(), interestBigDecimal.doubleValue());
        }
        return inMap;
    }

    /**
     * 等额本金计算获取还款方式为等额本金的每月偿还本金
     * <p>
     * 公式：每月应还本金=贷款本金÷还款月数
     *
     * @param invest     总借款额（贷款本金）
     * @param totalMonth 还款总月数
     * @return 每月偿还本金
     */
    public static double getPerMonthPrincipal(double invest, int totalMonth) {
        BigDecimal monthIncome = new BigDecimal(invest).divide(new BigDecimal(totalMonth), 2, BigDecimal.ROUND_DOWN);
        return monthIncome.doubleValue();
    }

    /**
     * 等额本金计算获取还款方式为等额本金的总利息
     *
     * @param invest     总借款额（贷款本金）
     * @param yearRate   年利率
     * @param totalMonth 还款总月数
     * @return 总利息
     */
    public static double getInterestCount(double invest, double yearRate, int totalMonth) {
        BigDecimal count = new BigDecimal(0);
        Map<Integer, Double> mapInterest = getPerMonthInterest(invest, yearRate, totalMonth);

        for (Map.Entry<Integer, Double> entry : mapInterest.entrySet()) {
            count = count.add(new BigDecimal(entry.getValue()));
        }
        return count.doubleValue();
    }

    /*
     * 根据本金，年利率，总月数，生成业务计划
     * @param invest
     * @param yearRate
     * @param totalMonth
     * @return 
     */
    public static Map<String, Object> getVocationDetails(double invest, double yearRate, int totalMonth) {
        //返回的map
        Map<String, Object> details_map = new HashMap<>();
        //返回的list 用于前端显示
        List<AverageCapital> loan_plan_list = new ArrayList<>();
        //返回String 用户存储在数据库
        String loan_datails = new String();

        //每月本金
        double perMonthPrincipal = getPerMonthPrincipal(invest, totalMonth);
        //总利息
        double totalInvest = getInterestCount(invest, yearRate, totalMonth);
        //每月利息
        Map<Integer, Double> mapInterest = getPerMonthInterest(invest, yearRate, totalMonth);

        for (Map.Entry<Integer, Double> entry : mapInterest.entrySet()) {
            AverageCapital averageCapital = new AverageCapital(entry.getValue(), perMonthPrincipal, totalInvest, entry.getKey());
            loan_datails += averageCapital.getDetailsMonth() + "-" + averageCapital.getPerMonthInvest() + "-" + averageCapital.getPerMonthPrincipal() + ",";
            loan_plan_list.add(averageCapital);
        }

        //总利息
        details_map.put("total_invest", totalInvest);
        //计划列表
        details_map.put("plan_list", loan_plan_list);
        //计划细节
        details_map.put("vocational_details", loan_datails.substring(0, loan_datails.length() - 1));
        return details_map;
    }
}
