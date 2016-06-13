function ajaxForm(url, params, formAlertId) {
    var $formAlert;
    if (params == undefined)
        params = $("#ajaxForm").serialize();
    if (formAlertId == undefined)
        $formAlert = $("#formAlert");
    else
        $formAlert = $("#"+formAlertId);
    $formAlert.removeClass("hidden");
    console.log("params:"+params);
    $.ajax({
        type: "post",
        url: url,
        data: params,
        //dataType: "json",
        success: function (data) {
            console.log(data);
            if (data.success) {
                $formAlert.addClass("alert-success");
                $formAlert.text("成功");
            } else {
                $formAlert.addClass("alert-danger");
                //$("#formAlertText").text("失败");
                $formAlert.text(data.message);
            }
        },
        error: function () {
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

            if (response.status == "SUCCESS") {
                console.log("success");
                var $formAlert = $("#formAlert");
                $formAlert.removeClass("hidden");
                $formAlert.addClass("alert-success");
                $formAlert.text("成功");

                $form.unbind('submit');
            } else {
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
