define([
    "text!../tpl/userPages/register.html",
    "../util/service",
    ],function(tpl,service) {
    var Backbone = require('backbone');
    var main = Backbone.View.extend({
        el: '#content',
        events:{
            "click #submit":"submit",
            "click #send":"sendcode",
        },
        initialize:function () {
            // alert(123);
        },



        sendcode: function(){
            username = $('#username').val();
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
                // service.sendcode(data);

                service.sendcode(data).then(function(){
                        var countdown=20;
                        var obj = $("#send");
                        settime(obj);
                        
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


        submit: function(){
            username = $('#username').val();
            pass = $('#pass').val();
            conpass = $('#conpass').val();
            verification_code = $('#verification_code').val();
             if(username=='' || pass=='' || conpass=='' || verification_code==''){
                    bootbox.confirm({ 
                      size: "small",
                      message: "请输入完整信息", 
                      callback: function(result){}
                    })
                    return false;
                }else if (pass!=conpass) {
                    bootbox.confirm({ 
                      size: "small",
                      message: "密码前后不一致，请重新输入", 
                      callback: function(result){}
                    })

                    return false;
                }else{ 
                    var data = {
                                username : username,
                                password : pass,
                                verification_code : verification_code,
                            };
                         service.userRegister(data).then(function (result) {
                             if(result.message=='用户已存在'){
                                 bootbox.confirm({
                                     size: "small",
                                     message: "用户已存在请重新注册",
                                     callback: function(result){}
                                 })
                             }else if(result.message=='验证码不正确'){
                                 bootbox.confirm({
                                     size: "small",
                                     message: "验证码不正确",
                                     callback: function(result){}
                                 })
                             }else {

                                 window.location.href='#/';
                             }
                         });
                         }
        },

        render: function(param) {
            $('#content').html(tpl);
        },
    });
    return main;
});