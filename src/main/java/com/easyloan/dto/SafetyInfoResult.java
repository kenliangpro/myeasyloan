package com.easyloan.dto;

import com.easyloan.bean.SafetyQuestion;
import com.easyloan.enums.UserStateEnum;

public class SafetyInfoResult extends Result<SafetyQuestion> {


    public SafetyInfoResult(UserStateEnum stateEnum, SafetyQuestion safetyQuestion){
        this.state = stateEnum.getState();
        this.message = stateEnum.getStateInfo();
        this.data = safetyQuestion;
    }

    public SafetyInfoResult(UserStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.message = stateEnum.getStateInfo();
    }

    //需要额外添加的数据
    public SafetyInfoResult add(String key, Object object) {
        this.extendDate.put(key, object);
        return this;
    }
}
