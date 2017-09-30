package com.easyloan.dto;

import com.easyloan.bean.UserInfo;
import com.easyloan.enums.UserStateEnum;

public class UserInfoResult extends Result<UserInfo>{


    public UserInfoResult(UserStateEnum stateEnum,UserInfo userInfo){
        this.state = stateEnum.getState();
        this.message = stateEnum.getStateInfo();
        this.data = userInfo;
    }

    public UserInfoResult(UserStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.message = stateEnum.getStateInfo();
    }

    //需要额外添加的数据
    public UserInfoResult add(String key, Object object) {
        this.extendDate.put(key, object);
        return this;
    }
}
