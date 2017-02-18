<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <jsp:include page="../common/user-edit-nav.jsp"/>
            <div class="user-show-main">
                <div class="user-show-top">
                    <h4>个人信息</h4>
                </div>
                <form id="ajaxForm" action="" method="post" class="form-horizontal">
                    <input type="hidden" name="_method" value="put">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="hidden" name="username" value="${user.username}">
                    <div class="form-group">
                        <label class="col-md-4 control-label">用户名</label>
                        <div class="col-md-6">
                            <input name="" type="text" class="form-control" disabled value="${user.username}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">旧密码</label>
                        <div class="col-md-6">
                            <input name="oldPassword" type="text" class="form-control" value=""/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">新密码</label>
                        <div class="col-md-6">
                            <input name="password" type="text" class="form-control" value=""/>
                        </div>
                    </div>
                    <div id="formAlert" class="alert hidden" role="alert"></div>
                    <div class="col-md-12">
                        <span class="col-md-9"></span>
                        <button class="btn btn-default" type="button" onclick="saveUserInfo()">更改密码</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>
<jsp:include page="../common/footer.jsp"/>
<script>
    function saveUserInfo() {
        myAjaxForm({
            url: '<c:url value="/u/${user.id}/password"/>',
            callback: function () {
                location.reload();
            }
        })
    }
</script>
</body>
</html>
