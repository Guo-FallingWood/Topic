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
    <h1>用户管理</h1>
    <table class="table">
        <tr>
            <th>user id</th>
            <th>username</th>
            <th>password</th>
            <th>email</th>
            <th>role</th>
            <th>phone</th>
            <th>opt</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td><a href="/user/${user.id}">${user.username}</a></td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.roleId}</td>
                <td>${user.phone}</td>
                <td>
                    <a href="">禁用</a>
                    <a href="">解禁</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <jsp:include page="../page.jsp"/>
</div>
</body>
</html>
