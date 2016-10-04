<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>

<div class="container main-bar" style="padding: 30px 20px">
    <h2>采集规则</h2>
    <form id="ruleForm">
        <input type="hidden" name="id">
        <input type="hidden" name="name">
        <input type="hidden" name="_method">

        <div style="width: 100%; height: 400px;" class="">
            <div id="" class="list-group col-lg-3 no-padding">
                <div class="input-group" style="padding-bottom: 10px;">
                    <input id="ruleName" type="text" class="form-control">
                    <span class="input-group-btn">
                    <button onclick="addRuleList()" class="btn btn-default" type="button">添加</button>
                </span>
                </div>
                <div id="ruleList">
                </div>
            </div>
            <div class="col-lg-9 no-padding" style="height: 100%; border: 1px solid #ccc; overflow-y: scroll">
                <table id="ruleTb" class="table table-striped table-hover table-condensed scrollTable">
                    <tr>
                        <th data-field="id" class="col-lg-3">ID</th>
                        <th data-field="name" class="col-lg-9">表达式</th>
                    </tr>
                    <tbody>
                    <tr>
                        <td>主题ID</td>
                        <td><input name="topicId" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>标题</td>
                        <td><input name="postTitle" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>作者</td>
                        <td><input name="postUsername" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>作者ID</td>
                        <td><input name="postUserId" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>内容</td>
                        <td><input name="postContent" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>创建时间</td>
                        <td><input name="postCreateTime" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>最后更新时间</td>
                        <td><input name="postLastTime" type="text" class="form-control"></td>
                    </tr>
                    <%--<tr>--%>
                    <%--<td>评论数量</td>--%>
                    <%--<td><input name="postCommentsNumber" type="text" class="form-control"></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td>评论作者</td>--%>
                    <%--<td><input name="commentUsername" type="text" class="form-control"></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td>评论作者ID</td>--%>
                    <%--<td><input name="commentUserId" type="text" class="form-control"></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td>评论内容</td>--%>
                    <%--<td><input name="commentContent" type="text" class="form-control"></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td>评论时间</td>--%>
                    <%--<td><input name="commentCreateTime" type="text" class="form-control"></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td>评论楼层</td>--%>
                    <%--<td><input name="commentFloor" type="text" class="form-control"></td>--%>
                    <%--</tr>--%>
                    <tr>
                        <td></td>
                        <td>
                            <button class="btn btn-default" type="button" onclick="saveRule()">保存</button>
                            <button class="btn btn-default" type="button" onclick="showTest()">测试</button>
                        </td>
                    </tr>
                    </tbody>
                </table>

            </div>
        </div>
    </form>
</div>
<jsp:include page="../footer.jsp"/>
<!-- 模态框（Modal） -->
<div class="modal fade" id="ruleTest" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" style="width: 80%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">
                    采集规则测试
                </h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label class="col-lg-1">URL</label>
                    <div class="col-lg-8">
                        <input type="text" name="url" class="form-control">
                    </div>
                    <button class="btn btn-default" type="button" onclick="runRuleTest()">开始</button>
                </div>
                <div id="ruleTestResult">

                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    关闭
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script>
    var ruleData = undefined;
    $(function () {
        loadRuleList();
        showTest();
    });
    function addRuleList() {
        var ruleName = $("#ruleName").val();
        if (ruleName == "")
            return;
        $.post('<c:url value="/admin/collect/rule"/>',
                {_method: 'POST', name: ruleName},
                function (data) {
                    if (data == "SUCCESS") {
                        loadRuleList();
                    }
                });
    }
    function saveRule() {
        var $form = $("#ruleForm");
        $form.find("[name='_method']").val('put');
        var url = '<c:url value="/admin/collect/rule/"/>' + $form.find("[name='id']").val();
        console.log($form.serialize());
        console.log(url);
        $.post(url, $form.serialize(), function (data) {
            console.log(data);
        });
    }
    function loadRuleList() {
        $.get('<c:url value="/admin/collect/rule"/>', {}, function (data) {
            buildRuleList(data);
        });
    }
    function buildRuleList(data) {
        if (data == undefined) {
            if (ruleData == undefined) return;
            data = ruleData;
        } else {
            ruleData = data;
        }
        var $ruleList = $("#ruleList");
        $ruleList.html("");
        for (var i = 0; i < data.length; i++) {
            var $btn = $("<button type='button' class='list-group-item'></button>");
            $btn.attr("data-id", data[i].id);
            $btn.text(data[i].name);
            $btn.click(function () {
                $ruleList.find("button.active").removeClass("active");
                $(this).addClass("active");

                var $form = $("#ruleForm");
                $form.find("[name='id']").val($(this).attr("data-id"));
                $form.find("[name='name']").val($(this).text());

                buildRuleTb();
            });
            if (i == 0)
                $btn.addClass("active").trigger('click');
            $ruleList.append($btn);
        }
    }
    function buildRuleTb() {
        var id = $("#ruleForm [name='id']").val();
        var url = '<c:url value="/admin/collect/rule/"/>' + id;
        $.get(url, {}, function (data) {
            fillForm($("#ruleForm"), data);
        });
    }
    function showTest() {
        var id = $("#ruleForm [name='id']").val();
        $("#ruleTest").modal('show');
    }
    function runRuleTest() {
        var id = $("#ruleForm [name='id']").val();
        var url = '<c:url value="/admin/collect/rule/test/"/>' + id;
        var p_url = $("#ruleTest [name='url']").val();
        $.post(url, {url: p_url}, function (data) {
            fillDiv($("#ruleTestResult"), data);
        });
    }
</script>
</body>
</html>
