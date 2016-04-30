<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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
            <p>
                ${post.content}
            </p>
        </div>
    </div>
    <%--<jsp:include page="../sidebar.jsp"/>--%>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>

