<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>

<div class="container edit-bar">
    <h1>编辑个人信息 - ${user.username}</h1>
    <form id="photoForm" action="/photo/upload" enctype="multipart/form-data" method="post">
        <div class="form-group">
            <div class="">
                <img src="/resource/upload/photo/${user.photo}"><br>
                原头像
            </div>
            <input name="photo" type="file" style="float: left;">
            <button type="submit">保存头像</button>
        </div>
    </form>
    <form id="ajaxForm">
        <input type="hidden" name="_method" value="put">
        <div class="form-group">
            <label for="email">email</label>
            <input type="text" id="email" name="email" value="${user.email}" class="form-control" placeholder="email"/>
        </div>
        <div class="form-group">
            <label for="phone">手机号码</label>
            <input type="text" id="phone" name="phone" value="${user.phone}" class="form-control" placeholder="phone"/>
        </div>
        <button class="btn btn-default" type="button" onclick="ajaxForm('/u/${user.username}','保存')">保存</button>
    </form>
    <div id="formAlert" class="alert alert-danger hidden" role="alert">
        <span id="formAlertText"></span>
    </div>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
