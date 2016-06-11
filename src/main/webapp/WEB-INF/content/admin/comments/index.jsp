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
    <h1>评论管理</h1>
    <table class="table table-bordered">
        <tr>
            <th>comment id</th>
            <th>content</th>
            <th>user</th>
            <th>create time</th>
            <th>opt</th>
        </tr>
        <c:forEach items="${comments}" var="comment">
            <tr>
                <td>${comment.id}</td>
                <td>${comment.content}</td>
                <th><a href="/u/${comment.userId}">${comment.userUsername}</a></th>
                <td>${comment.discard}</td>
                <td>
                    <a href="">折叠</a>
                    <a href="">显示</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <jsp:include page="../../page.jsp"/>
</div>
</body>
</html>
