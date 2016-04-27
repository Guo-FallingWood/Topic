function login(){
    $.ajax({
        type: "post",
        url: "/user/valid",
        data: $("#loginForm").serialize(),
        success: function(data){
            //console.log("success");
            if(data == "") {
                $("#formAlert").removeClass("hidden");
                $("#formAlertText").text("用户名或密码错误");
            }else {
                //console.log(data);
                $("#formAlert").removeClass("hidden");
                $("#formAlert").removeClass("alert-danger");
                $("#formAlert").addClass("alert-success");
                $("#formAlertText").text("登陆成功");
            }
        },
        error: function(){
            //console.log("error function");
            $("#formAlert").removeClass("hidden");
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
            //console.log("success");
            if(data == "") {
                $("#formAlert").removeClass("hidden");
                $("#formAlertText").text("注册失败");
            }else {
                //console.log(data);
                $("#formAlert").removeClass("hidden");
                $("#formAlert").removeClass("alert-danger");
                $("#formAlert").addClass("alert-success");
                $("#formAlertText").text("注册成功");
            }
        },
        error: function(){
            //console.log("error function");
            $("#formAlert").removeClass("hidden");
            $("#formAlertText").text("注册异常");
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