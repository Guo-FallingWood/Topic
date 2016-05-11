<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <h1>话题管理</h1>
    <table class="table">
        <tr>
            <th>topic id</th>
            <th>name</th>
            <th>url</th>
            <th>status</th>
            <th>opt</th>
        </tr>
        <c:forEach items="${topics}" var="topic">
            <tr>
                <td>${topic.id}</td>
                <td>${topic.name}</td>
                <td>${topic.url}</td>
                <td>${topic.close}</td>
                <td>
                    <button onclick="ajaxForm('/admin/topic/${topic.id}', '更新', {_method:'put', discard:1})">关闭</button>
                    <button onclick="ajaxForm('/admin/topic/${topic.id}', '更新', {_method:'put', discard:0})">开放</button>
                </td>
            </tr>
        </c:forEach>
        <form id="ajaxForm">
            <tr>
                <td></td>
                <td><input type="text" name="name"></td>
                <td><input name="url"></td>
                <td></td>
                <td><button type="button" onclick="ajaxForm('/admin/topic','创建')">new</button></td>
            </tr>
            <div id="formAlert" class="alert alert-danger hidden" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <span id="formAlertText"></span>
            </div>
        </form>
    </table>
</div>
</body>
</html>
