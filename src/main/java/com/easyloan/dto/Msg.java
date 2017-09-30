package com.easyloan.dto;

import com.easyloan.enums.UserStateEnum;

import java.util.HashMap;
import java.util.Map;

public class Msg {

    private int state;
    // 提示信息
    private String msg;

    private UserStateEnum stateEnum;

    public UserStateEnum getStateEnum() {
        return stateEnum;
    }

    public void setStateEnum(UserStateEnum stateEnum) {
        this.stateEnum = stateEnum;
    }

    private Map<String,Object> extraData = new HashMap<>();

    public Map<String, Object> getExtraData() {
        return extraData;
    }

    public void setExtraData(Map<String, Object> extraData) {
        this.extraData = extraData;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Msg(int state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public Msg() {
    }

    public Msg(UserStateEnum stateEnum){
        this.stateEnum = stateEnum;
        this.state = stateEnum.getState();
        this.msg = stateEnum.getStateInfo();
    }

    public static Msg success() {
        Msg msg = new Msg();
        msg.setState(1);
        msg.setMsg("操作成功");
        return msg;
    }

    public static Msg fail() {
        Msg msg = new Msg();
        msg.setState(-1);
        msg.setMsg("操作失败");
        return msg;
    }

    public Msg addExtraData(String key,Object value){
        extraData.put(key, value);
        return this;
    }


}
