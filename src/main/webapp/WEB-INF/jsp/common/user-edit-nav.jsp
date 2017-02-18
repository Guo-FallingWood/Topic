<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="user-show-list">
    <ul class="list-group">
        <a class="list-group-item" href="<c:url value="/u/edit"/>">修改个人信息</a>
        <a class="list-group-item" href="<c:url value="/u/edit/photo"/>">修改头像</a>
        <a class="list-group-item" href="<c:url value="/u/edit/password"/>">修改密码</a>
    </ul>
</div>
