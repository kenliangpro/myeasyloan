package com.easyloan.enums;

public enum LoanStateEnum {

    UNTREATED(-1,"未处理"),
    COMPLETED(1,"已完成"),
    REJECTED(-2,"已驳回")
    ;

    private int state;

    private String stateMsg;

    private LoanStateEnum(int state, String stateMsg) {
        this.state = state;
        this.stateMsg = stateMsg;
    }

    public int getState() {
        return state;
    }

    public String getStateMsg() {
        return stateMsg;
    }

    public static LoanStateEnum stateOf(int index) {
        for(LoanStateEnum state : values()) {
            if(state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
