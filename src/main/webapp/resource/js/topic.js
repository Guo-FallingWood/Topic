function ajaxForm(url, params, formAlertId) {
    var $formAlert;
    if (params == undefined)
        params = $("#ajaxForm").serialize();
    if (formAlertId == undefined)
        $formAlert = $("#formAlert");
    else
        $formAlert = $("#" + formAlertId);
    console.log("params:" + params);
    $.ajax({
        type: "post",
        url: url,
        data: params,
        //dataType: "json",
        success: function (data) {
            console.log(data);
            $formAlert.removeClass("hidden");
            if (data.success) {
                $formAlert.removeClass("alert-danger");
                $formAlert.addClass("alert-success");
                $formAlert.text("成功");
            } else {
                $formAlert.addClass("alert-danger");
                //$("#formAlertText").text("失败");
                $formAlert.text(data.message);
            }
        },
        error: function () {
            $formAlert.removeClass("hidden");
            $formAlert.addClass("alert-danger");
            $formAlert.text("异常");
        }
    });
}
function ajaxDelete(url) {
    console.log(url);
    $.ajax({
        type: "delete",
        url: url,
        success: function () {
            location.reload();
        }
    });
}
function collectFormData(fields) {
    var data = {};
    for (var i = 0; i < fields.length; i++) {
        var $item = $(fields[i]);
        data[$item.attr('name')] = $item.val();
    }
    return data;
}

function dataBind(formId, jsonUrl) {
    var $form = $('#' + formId);
    $form.bind('submit', function (e) {
        // Ajax validation
        var $inputs = $form.find('input');
        var data = collectFormData($inputs);

        $.post(jsonUrl, data, function (response) {
            $form.find('.form-group').removeClass('error');
            $form.find('.help-inline').empty();

            console.log(response);

            var $formAlert = $("#formAlert");
            if (response.status == "SUCCESS") {
                $formAlert.removeClass("hidden");
                $formAlert.removeClass("alert-danger");
                $formAlert.addClass("alert-success");
                $formAlert.text("成功");

                $form.unbind('submit');
                return false;
            } else {
                if (response.message != null) {
                    $formAlert.removeClass("hidden");
                    $formAlert.addClass("alert-danger");
                    $formAlert.text(response.message);
                }
                for (var i = 0; response.errors != null && i < response.errors.length; i++) {
                    var item = response.errors[i];
                    var $controlGroup = $('#' + item.fieldName);
                    $controlGroup.addClass('error');
                    $controlGroup.find('.help-inline').html(item.message);
                }
            }
        }, 'json');
        e.preventDefault();
        return false;
    });
};

function fillDiv($div, json){
    var $table = $("<table class='table'></table>")
    for (var key in json){
        var $tr = $("<tr></tr>");
        var $td1 = $("<td></td>").text(key);
        var $td2 = $("<td></td>").text(json[key]);
        $table.append($tr.append($td1).append($td2));
    }
    $div.text("");
    $div.append($table);
}

function fillForm($form, json) {
    var jsonObj = json;
    if (typeof json === 'string') {
        jsonObj = $.parseJSON(json);
    }
    for (var key in jsonObj) {  //遍历json字符串
        var v = jsonObj[key];
        if (v == null) v = '';
        $("[name=" + key + "]", $form).val(v);
    }
}
