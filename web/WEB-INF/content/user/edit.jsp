<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>

<div class="container auth-body">
    <h1>编辑个人信息 - ${user.username}</h1>
    <form action="/user/${user.id}" method="post">
        <input type="hidden" name="_method" value="put">
        <input type="hidden" name="id" value="${user.id}" readonly="readonly"><br>
        <div class="input-group">
            <span class="input-group-addon" id="basic-addon1">email</span>
            <input type="text" name="email" value="${user.email}" class="form-control" placeholder=""
                   aria-describedby="basic-addon1">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon" id="basic-addon2">手机号码</span>
            <input type="text" name="phone" value="${user.phone}" class="form-control" placeholder=""
                   aria-describedby="basic-addon2">
        </div>
        <br>
        <button type="submit">保存</button>
    </form>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
