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
            <th>id</th>
            <th>user id</th>
            <th>username</th>
            <th>password</th>
            <th>email</th>
            <th>phone</th>
        </tr>
        <c:forEach items="${users}" varStatus="status" var="user">
            <tr>
                <td>${status.count}</td>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
            </tr>
        </c:forEach>
    </table>
    <jsp:include page="../page.jsp"/>
</div>
</body>
</html>
