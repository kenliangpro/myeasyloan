package com.easyloan.dto;

import com.easyloan.enums.UserStateEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * 操作业务返回类
 */
public class VocationalResult extends Result {

    private List<AverageCapital> list = new ArrayList<>();

    public VocationalResult(UserStateEnum stateEnum, List<AverageCapital> list){
        this.state = stateEnum.getState();
        this.message = stateEnum.getStateInfo();
        this.list = list;
    }

    public VocationalResult(UserStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.message = stateEnum.getStateInfo();
    }

    public List<AverageCapital> getList() {
        return list;
    }

    public void setList(List<AverageCapital> list) {
        this.list = list;
    }
}
