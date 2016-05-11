function ajaxForm(url, text, params){
    if(params == undefined) {
        params = $("#ajaxForm").serialize();
    }
    $("#formAlert").removeClass("hidden");
    console.log(url);
    console.log(params);
    $.ajax({
        type: "post",
        url: url,
        data: params,
        success: function (data) {
            console.log(data);
            if(data == "success") {
                $("#formAlertText").text(text+"成功");
                $("#formAlert").removeClass("alert-danger");
                $("#formAlert").addClass("alert-success");
            }else{
                $("#formAlertText").text(text+"失败");
            }
        },
        error: function () {
            $("#formAlertText").text(text+"异常");
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