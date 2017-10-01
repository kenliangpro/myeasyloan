define([
    "text!../tpl/userPages/personalLaon.html",
    "../util/service",
    ],function(tpl,service) {
    var Backbone = require('backbone');
    var main = Backbone.View.extend({
        el: '#content',
        events:{
            "click #plan":"plan",
        },
        initialize:function () {
            // alert(123);
        },

        plan:function(){
            var loan_amount = $('#loan_amount').val();
            var loan_tern = $('#loan_tern').val();
            if (loan_amount==''||loan_tern=='') {
                bootbox.confirm({ 
                  size: "small",
                  message: "请输入完整数据", 
                  callback: function(result){}
                })
                return false;
            }else{
                var data = {
                    loan_amount:loan_amount,
                    loan_tern:loan_tern,
                };
                service.checkLoanPlan(data).then(function(res){
                    var list = res.list;
                    console.log(list);
                    $('#showPlan').show();
                    $.each(list, function (index, item) {
                        $("#loanplan").append("第"+item.detailsMonth+"个月" + " 利息：" + item.perMonthInvest +"元"+
                            " 每月本金:" + item.perMonthPrincipal +"元"+
                            " 总额:" + (item.perMonthInvest + item.perMonthPrincipal) +"元"+ "<br/>");
                         })
                    var totalInvest = item.totalInvest;

                });

            }

            

        },

        render: function(param) {
            $('#content').html(tpl);
        }
    });
    return main;
});
