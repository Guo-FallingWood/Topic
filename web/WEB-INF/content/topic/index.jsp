<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
<div class="container">
    <h1>topic-index</h1>
    <table>
        <tr>
            <th>title</th>
            <th>userId</th>
        </tr>
        <c:forEach items="${posts}" var="post">
            <tr>
                <td>${post.title}</td>
                <td>${post.userId}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="../page.jsp"/>
<jsp:include page="../footer.jsp"/>
</body>
</html>
