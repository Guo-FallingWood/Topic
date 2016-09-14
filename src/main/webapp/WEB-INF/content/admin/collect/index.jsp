<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container main-bar">
    <h1>数据采集</h1>
    <div class="panel">
        <button class="btn btn-default" onclick="addTb()">添加爬虫</button>
        <button class="btn btn-default" onclick="loadTb()">刷新</button>
        <span id="status"></span>
    </div>
    <table id="spiderTb">

    </table>
    <jsp:include page="../../page.jsp"/>
</div>

<script>
    $(function () {
        $.get('<c:url value="/admin/collect/status"/>', {},
                function (data) {
                    $("#status").text(data.runSize + "/" + data.size);
                }, 'json');
    });
    $("#spiderTb").bootstrapTable({
        url: '<c:url value="/admin/collect/all"/>',
        columns: [
            {field: 'uuid', title: 'UUID'},
            {field: 'name', title: '名称'},
            {field: 'status', title: '状态'},
            {
                field: 'uuid', title: '操作',
                formatter: operation
            }
        ]
    });
    function operation(value, row, index) {
        var btn = $("<button class='btn btn-default'>删除</button>");
        btn.attr("onclick", "executeTb('remove','" + value + "')");
        return btn.prop('outerHTML');
    }
    function executeTb(cmd, uuid) {
        var url = "<c:url value='/admin/collect/'/>" + cmd;
        $.post(url, {uuid: uuid},
                function (data) {
                    if (data == "SUCCESS")
                        loadTb();
                });
    }
    function addTb() {
        $.post('<c:url value="/admin/collect/create"/>', {},
                function (data) {
                    if (data == "SUCCESS")
                        loadTb();
                });
    }
    function loadTb() {
        $("#spiderTb").bootstrapTable('refresh');
    }
</script>
</body>
</html>
