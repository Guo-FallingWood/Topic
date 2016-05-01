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
    <div class="main-bar">
        <jsp:include page="../nav.jsp"/>
        <div class="panel panel-default">
            <div class="panel-heading">
                <span>${post.title}</span>
                <span class="navbar-right">
                    来自: <a href="/user/${user.id}">${user.username}</a>
                </span>
            </div>
            <div class="panel-body">
                <pre>${post.content}</pre>
            </div>
        </div>
        <ul class="list-group">
            <c:forEach items="${comments}" var="comment">
                <li class="list-group-item">${comment.content}</li>
            </c:forEach>
        </ul>
        <div class="panel panel-default">
            <div class="panel-heading">
                回复
            </div>
            <div class="panel-body">
                <form id="postForm">
                    <textarea name="content" class="form-control" rows="5"></textarea>
                    <div id="formAlert" class="alert alert-danger hidden" role="alert">
                        <input type="hidden" name="userId" value="${sessionUser.id}">
                        <input type="hidden" name="postId" value="${post.id}">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <span id="formAlertText"></span>
                    </div>
                    <button type="button" onclick="ajaxPostNew('/c')">回复</button>
                </form>
            </div>
        </div>
    </div>
    <%--<jsp:include page="../sidebar.jsp"/>--%>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>

