<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="user-show">
        <div class="user-show-top">
            <h1>个人信息</h1>
        </div>
        <div class="user-show-left">
            <img src="/resource/upload/photo/${user.photo}" alt=""/><br>
            <%--<a href="#">修改头像</a>--%>
        </div>
        <div class="user-show-right">
            <p>用户名：${user.username}</p>
            <p>email：${user.email}</p>
            <p>手机号码：${user.phone}</p>
            <c:if test="${sessionUser != null && sessionUser.id==user.id}">
                <a href="/u/${user.username}/edit">编辑信息</a>
                <a href="#">修改密码</a>
            </c:if>
        </div>
        <%--<div class="user-show-bottom">--%>
            <%--<ul class="nav nav-tabs">--%>
                <%--<li role="presentation" class="active"><a href="#">最近回复</a></li>--%>
                <%--<li role="presentation" class=""><a href="#">最近发帖</a></li>--%>
            <%--</ul>--%>
            <%--<div class="panel panel-body">--%>
                <%--没有内容--%>
            <%--</div>--%>
        <%--</div>--%>
    </div>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
