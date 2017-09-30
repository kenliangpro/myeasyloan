package com.easyloan.dto;

import com.easyloan.bean.User;
import com.easyloan.enums.UserStateEnum;

public class UserResult extends Result<User> {


    public UserResult(UserStateEnum stateEnum) {
        this.message = stateEnum.getStateInfo();
        this.state = stateEnum.getState();
    }

    public UserResult(UserStateEnum stateEnum, User user) {
        this.message = stateEnum.getStateInfo();
        this.state = stateEnum.getState();
        this.data = user;
    }


    //需要额外添加的数据
    public UserResult add(String key, Object object) {
        this.extendDate.put(key, object);
        return this;
    }

}
