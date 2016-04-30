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
        <div class="list-group">
            <c:forEach items="${posts}" var="post">
                <a class="list-group-item" href="/p/${post.id}">
                    ${post.title}
                </a>
            </c:forEach>
        </div>
        <jsp:include page="../page.jsp"/>
    </div>
    <jsp:include page="../sidebar.jsp"/>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
