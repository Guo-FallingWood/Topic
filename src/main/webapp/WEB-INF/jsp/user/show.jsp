<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="content">
    <div class="container">
        <div class="user-show">
            <div class="user-show-top">
                <h4>个人信息</h4>
                <img class="user-show-img" src="<c:url value="/resource/upload/photo/${user.photo}"/>" alt=""/>
                <p>${user.username}</p>
            </div>
            <br>
            <ul class="user-show-detail">
                <li>
                    <div>邮箱:</div>
                    <div>${user.email}</div>
                </li>
                <li>
                    <div>手机号码:</div>
                    <div>${user.phone}</div>
                </li>
            </ul>
            <c:if test="${sessionUser != null && sessionUser.id==user.id}">
            <div class="user-show-bottom">
                <a href="<c:url value="/u/edit"/>">编辑信息</a>
            </div>
            </c:if>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>
