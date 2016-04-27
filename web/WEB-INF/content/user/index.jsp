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
        <c:forEach items="${models}" varStatus="status" var="model">
            <tr>
                <td>${status.count}</td>
                <td>${model.id}</td>
                <td>${model.username}</td>
                <td>${model.password}</td>
                <td>
                    <a href="user/${model.id}">detail</a>
                    <a href="user/${model.id}/edit">edit</a>
                    <a href="" onclick="ajaxDelete('user/${model.id}')">delete</a>
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
