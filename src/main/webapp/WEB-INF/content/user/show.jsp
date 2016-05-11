<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container user-show">
    <h1>个人信息</h1>
    <p>用户名：${user.username}</p>
    <p>email：${user.email}</p>
    <p>手机号码：${user.phone}</p>
    <a href="/user/${user.id}/edit">编辑信息</a>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
