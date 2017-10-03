define([
    "text!../tpl/userPages/login.html",
    "../util/service",
    ],function(tpl,service) {
    var Backbone = require('backbone');
    var main = Backbone.View.extend({
        el: '#content',
        events:{
            "click #loginSubmit":"submit",
            "click #send":"sendcode",
            "click #updatePass":"updatePass",
        },
        initialize:function () {
            // alert(123);
        },

        updatePass:function () {
            var password = $('#newPass').val();
            var conpass = $('#connewPass').val();
            var code = $('#verification_code').val();

            if(password==''||conpass==''||code==''){
                bootbox.confirm({
                    size: "small",
                    message: "请输入完整数据",
                    callback: function(result){}
                })
            }else if(password!=conpass){
                bootbox.confirm({
                    size: "small",
                    message: "密码和确认密码不一致",
                    callback: function(result){}
                })
            }else {
                var data = {
                    password : password,
                    code : code,
                };
                service.forgetPass(data);
                window.location.href = '#/';
            }

        },


        sendcode: function(){
            var username = $('#forUsername').val();
            if (username=='') {
                bootbox.confirm({
                    size: "small",
                    message: "请输入手机号码",
                    callback: function(result){}
                })


            }else{
                var data={
                    username : username,
                };
                service.sendcodeForget(data).then(function(res){
                    var countdown=20;
                    var obj = $("#send");

                    if(res.state==0){

                        bootbox.confirm({
                            size: "small",
                            message: "该号码是无效密码请重新输入",
                            callback: function(result){}
                        })
                    }else {
                        settime(obj);
                        $("#newPassModal").modal("show");

                    }

                    function settime(obj) { //发送验证码倒计时
                        if (countdown == 0) {
                            obj.attr('disabled',false);
                            //obj.removeattr("disabled");
                            obj.val("免费获取验证码");
                            countdown = 20;
                            return;
                        } else {
                            obj.attr('disabled',true);
                            obj.val("重新发送(" + countdown + ")");
                            countdown--;
                        }
                        setTimeout(function() {
                                settime(obj) }
                            ,1000)
                    }

                });


            }
        },


        submit:function(){
            var username = $('#username').val();
            var password = $('#password').val();
            var verification_code = $('#code').val();
            if (username==''||password==''||verification_code=='') {
                // alert("请输出完整信息");
                bootbox.confirm({ 
                  size: "small",
                  message: "请输入完整信息", 
                  callback: function(result){}
                })
                
                return false;
            }else{
                var data = {
                    username : username,
                    password : password,
                    verification_code:verification_code,
                };
                service.userLogin(data).then(function(res){
                    var state = res.state;
                    if(state == -1){
                        bootbox.confirm({
                            size: "small",
                            message: "该账号未注册",
                            callback: function(result){}
                        })
                    }else if(state == 0){
                        bootbox.confirm({
                            size: "small",
                            message: "账号或密码错误",
                            callback: function(result){}
                        })
                    }else if(state==-2){
                        bootbox.confirm({
                            size: "small",
                            message: "验证码错误",
                            callback: function(result){}
                        })
                    } else {
                        window.location.href="#/";
                    }
                });



            }

        },

        render: function(param) {
            $('#content').html(tpl);
        }
    });
    return main;
});
