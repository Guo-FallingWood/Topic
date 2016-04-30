function login(){
    $("#formAlert").removeClass("hidden");
    $.ajax({
        type: "post",
        url: "/user/valid",
        data: $("#loginForm").serialize(),
        success: function(data){
            console.log(data);
            if(data == "success") {
                $("#formAlert").removeClass("alert-danger");
                $("#formAlert").addClass("alert-success");
                $("#formAlertText").text("登陆成功");
            }else {
                $("#formAlertText").text("用户名或密码错误");
            }
        },
        error: function(){
            //console.log("error function");
            $("#formAlertText").text("登陆异常");
        }
    });
}

function reg(){
    $.ajax({
        type: "post",
        url: "/user",
        data: $("#regForm").serialize(),
        success: function(data){
            console.log(data);
            if(data == "success") {
                $("#formAlert").removeClass("hidden");
                $("#formAlert").removeClass("alert-danger");
                $("#formAlert").addClass("alert-success");
                $("#formAlertText").text("注册成功");
            }else {
                $("#formAlert").removeClass("hidden");
                $("#formAlertText").text("注册失败");
            }
        },
        error: function(){
            $("#formAlert").removeClass("hidden");
            $("#formAlertText").text("注册异常");
        }
    });
}

function ajaxPostNew(url) {
    $("#formAlert").removeClass("hidden");
    console.log(url);
    $.ajax({
        type: "post",
        url: url,
        data: $("#postForm").serialize(),
        success: function (data) {
            console.log(data);
            if(data == "success") {
                $("#formAlertText").text("发表成功");
                $("#formAlert").removeClass("alert-danger");
                $("#formAlert").addClass("alert-success");
            }else{
                $("#formAlertText").text("发表失败");
            }
        },
        error: function () {
            $("#formAlertText").text("发表异常");
        }
    });
}

function ajaxDelete(url){
    console.log(url);
    $.ajax({
        type: "delete",
        url: url,
        success: function(){
            location.reload();
        }
    });
}