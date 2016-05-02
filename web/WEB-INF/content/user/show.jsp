<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <h1>个人信息</h1>
    <ul>
        <li>用户名：${user.username}</li>
        <li>email：${user.email}</li>
        <li>手机号码：${user.phone}</li>
    </ul>
    <a href="/user/${user.id}/edit">编辑信息</a>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
