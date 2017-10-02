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
            $("#loanplan").empty();
            $("#showtotalInvest").empty();

            var principal = $('#loan_amount').val();
            var totalMonth = $('#loan_tern').val();
            var data={
                principal : principal,
                totalMonth: totalMonth
            };
            if (principal==''||totalMonth=='') {
                bootbox.confirm({ 
                  size: "small",
                  message: "请输入完整数据", 
                  callback: function(result){}
                })
                return false;
            }else{

                service.checkLoanPlan(data).then(function(res){

                    var list = res.list;
                    console.log(list);
                    $('#showPlan').show();

                    $.each(list, function (index, item) {
                        $("#loanplan").append("<tr><td>第"+item.detailsMonth+"个月</td>" + "<td>" + item.perMonthInvest +"元</td>"+
                            "<td>" + item.perMonthPrincipal +"元</td>"+
                            "<td>" + (item.perMonthInvest + item.perMonthPrincipal) +"元</td></tr>>");
                         totalInvest = item.totalInvest;
                    })
                    $("#showtotalInvest").append("总利息:"+totalInvest+"元");
                });
            }
        },
        render: function(param) {
            $('#content').html(tpl);
        }
    });
    return main;
});
