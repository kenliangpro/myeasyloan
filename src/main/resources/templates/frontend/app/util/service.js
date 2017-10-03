define([], function () {
    var service = {};
    var isSuccess = function (res) {
        if (res.status != 0) {
            // alert(res.msg)
            return false;
        }
        return true;
    }
    service.sendcodeForget = function (data) {
        var dtd = $.Deferred();
        var username = data.username;
        console.log(username);
        $.ajax({
            url: "user/forgetPassword",
            type: "post",
            data: "username=" + username,
            success: function (result) {
                console.log(result);
                dtd.resolve(result);
            }
        });
        return dtd.promise();

    }

    service.sendcode = function (data) {
        var dtd = $.Deferred();
        var username = data.username;
        console.log(username);

        $.ajax({
            url: "user/sendcode/" + username,
            type: "post",
            success: function (result) {
                console.log(result);
                dtd.resolve(result);
            }
        });
        return dtd.promise();

    }
    // 	var dtd=$.Deferred();
    // 	$.post('/user/sendcode/:username',data,function(res){
    // 		console.log("done sendcode")
    // 		if(isSuccess(res)){
    // 			//执行成功会将res返回给then
    // 			dtd.resolve(res);
    // 			console.log(data);
    // 			console.log(res.message);
    // 		}else{
    // 			dtd.reject();
    // 		}
    //
    // 	})
    // 	return dtd.promise();
    // }


    service.userRegister = function (data) {
        var dtd = $.Deferred();
        $.ajax({
            url: "/user/register",
            type: "post",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (result) {
                console.log(result.message);
                console.log(data);
                dtd.resolve(result);

            }
        });
        return dtd.promise();
    }

    service.userLogin = function (data) {
        var dtd = $.Deferred();
        $.ajax({
            url: "/user/login",
            type: "post",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (result) {
                console.log(result);
                dtd.resolve(result);

            }
        });
        return dtd.promise();
    }


    service.mock = function () {
        var dtd = $.Deferred();
        $.get('/mock', function (res) {
            console.log("done mock")
            if (isSuccess(res)) {
                //执行成功会将res返回给then
                console.log(res.msg);
                dtd.resolve(res);
            } else {
                dtd.reject();
            }
        })
        return dtd.promise();
    }


    service.info = function () {
        var dtd = $.Deferred();
        $.ajax({
            url: "/user/checkUserInfo",
            type: "get",
            success: function (res) {
                console.log("done Checkinfo");

                dtd.resolve(res);
                console.log(res);
                // if (isSuccess(res)) {
                //     //执行成功会将res返回给then
                //     console.log(res.data);
                //     console.log(res.message);
                //     dtd.resolve(res);
                // } else {
                //     dtd.reject();
                // }
            }
        });
        return dtd.promise();
    }


    service.perfectInfo = function (data) {
        var dtd = $.Deferred();
        $.post('/user/perfectInfo', data, function (res) {
            console.log("done perfectInfo");
            dtd.resolve(res);
        })
        return dtd.promise();
    }


    service.safetyInfo = function () {
        var dtd = $.Deferred();
        $.ajax({
            url: "/user/checkSafetyInfo",
            type: "get",
            success: function (res) {
                console.log("done checkSafetyInfo");
                dtd.resolve(res);
                console.log(res);
                // if (isSuccess(res)) {
                //     dtd.resolve(res);
                //     console.log(res.data);
                // } else {
                //     dtd.reject();
                // }
            }
        });
        return dtd.promise();
    }

    service.perfectSafetyInfo = function (data) {
        var dtd = $.Deferred();
        $.ajax({
            url: "/user/perfectSafetyInfo",
            type: "post",
            data: data,
            success: function (res) {
                console.log("done perfectSafetyInfo");
                dtd.resolve(res);
                console.log(res);
            }
        });
        return dtd.promise();
    }

    service.checkLoanPlan = function (data) {
        var dtd = $.Deferred();
        console.log(data);
        $.ajax({
            url: "/personalLoan/checkPlan",
            type: "post",
            data: data,
            success: function (res) {
                dtd.resolve(res);
                console.log(res);
            }

        });
        return dtd.promise();
    }

    service.forgetPass = function (data) {
        console.log(data);
        var dtd = $.Deferred();
        $.ajax({
            url: "/user/findpassword",
            type: "post",
            data: data,
            success: function (result) {
                console.log(result);
                dtd.resolve(result);
            }
        });
        return dtd.promise();
    }


    return service;
})