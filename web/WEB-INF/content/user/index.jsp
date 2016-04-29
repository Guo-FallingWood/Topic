<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <h1>user-index</h1>
    <table>
        <tr>
            <th>id</th>
            <th>user id</th>
            <th>username</th>
            <th>password</th>
            <th>opt</th>
        </tr>
        <c:forEach items="${users}" varStatus="status" var="user">
            <tr>
                <td>${status.count}</td>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>
                    <a href="user/${user.id}">detail</a>
                    <a href="user/${user.id}/edit">edit</a>
                    <a href="" onclick="ajaxDelete('user/${user.id}')">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="user/new">new</a>
</div>
<jsp:include page="../page.jsp"/>
<jsp:include page="../footer.jsp"/>
</body>
</html>
