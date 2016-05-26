<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>

<div class="edit-bar container">
    <form id="ajaxForm" action="" method="post">
        <h2>登录</h2>
        <br>
        <div class="input-group">
            <span class="input-group-addon" id="basic-addon1">Username</span>
            <input type="text" name="username" class="form-control" placeholder="Username"
                   aria-describedby="basic-addon1">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon" id="basic-addon2">Password</span>
            <input type="password" name="password" class="form-control" placeholder="Password"
                   aria-describedby="basic-addon2">
        </div>
        <br>
        <div id="formAlert" class="alert alert-danger hidden" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <span id="formAlertText"></span>
        </div>
        <br>
        <button class="btn btn-default navbar-right" type="button" onclick="ajaxForm('/u/valid','登录')">
            登录
        </button>
    </form>
</div>

<jsp:include page="../footer.jsp"/>
</body>
</html>
