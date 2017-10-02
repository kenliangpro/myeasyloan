package com.easyloan.enums;

/**
 * 用户数据字典
 */
public enum UserStateEnum {

    NEXTSTEP(1,"进入下一步"),
    LOGIN(1,"成功登陆"),
    SIGNUP(1,"成功注册"),
    LOANPLAN(1,"生成贷款计划成功"),
    COMMONSUCCESS(1,"操作成功,等待审核"),
    CERTIFICATION(1,"已实名认证，进入下一步"),
    MISPASSWORDORUSERNAME(0,"用户名或密码错误"),
    MISPASSWORDEQUAL(0,"两次输入密码不一致"),
    EXSTIENS(0,"用户已存在"),
    NONEXISTENSE(0,"用户不存在"),
    ILLEGAL(-1,"无效的账号"),
    NONVALIDATE(-2,"验证码不正确"),
    UNKNOWNERROR(-3,"发生未知错误"),
    UNLOGIN(0,"用户未登录"),
    UPDATEUSERINFOERROR(-1,"更新用户出错"),
    FILENULL(-1,"文件为空"),
    FAILUPLOAD(-1,"文件上传失败"),
    SUCCESSCHECK(1,"查询用户信息成功"),
    FAILCHECK(-1,"查询用户信息失败"),
    SUCCESSUPDATEPASSWORD(1,"成功更新密码"),
    FAILUPDATEPASSWORD(0,"更新密码密码"),
    ERROREMAIL(-1,"邮箱格式错误"),
    ERRORIDNUMBER(-1,"身份证格式错误"),
    ERRORPHONENUMBER(-1,"电话号码格式错误"),
    ERRORREALNAME(-1,"姓名必须为中文"),
    UNCERTIFICATION(-1,"未进行实名认证"),
    UNUPLOADLOANDATUM(-1,"未上传贷款资料")
    ;

    private int state;
    private String stateInfo;

    private UserStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static UserStateEnum stateOf(int index){
        for(UserStateEnum state:values()){
            if(state.getState()==index){
                return state;
            }
        }
        return null;
    }

}
