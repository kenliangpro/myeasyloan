define([
    "text!../tpl/userPages/login.html",
    "../util/service",
    ],function(tpl,service) {
    var Backbone = require('backbone');
    var main = Backbone.View.extend({
        el: '#content',
        events:{
            "click #loginSubmit":"submit",
        },
        initialize:function () {
            // alert(123);
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
                    }else {
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
