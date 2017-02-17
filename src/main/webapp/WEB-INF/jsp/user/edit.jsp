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
    <div class="container edit-bar">
        <h1>编辑个人信息 - ${user.username}</h1>
        <form id="photoForm" action="<c:url value="/photo/upload"/>" enctype="multipart/form-data" method="post">
            <div class="form-group ">
                <div class="">
                    <img src="<c:url value="/resource/upload/photo/${user.photo}"/> ">
                </div>
                <div class="">
                    <input name="photo" class="btn btn-default" type="file" style="float: left;">
                    <button type="submit" class="btn btn-default">保存头像</button>
                </div>
            </div>
        </form>
        <form:form modelAttribute="user" id="user-update" class="form-horizontal">
            <input type="hidden" name="_method" value="put">
            <div class="form-group" id="email">
                <label class="col-md-2 control-label">邮箱</label>
                <div class="col-md-4">
                    <form:input path="email" cssClass="form-control"/>
                </div>
                <span class="col-md-4 help-inline"><form:errors path="email"/></span>
            </div>
            <div class="form-group" id="phone">
                <label class="col-md-2 control-label">手机号码</label>
                <div class="col-md-4">
                    <form:input path="phone" cssClass="form-control"/>
                </div>
                <span class="col-md-4 help-inline"><form:errors path="phone"/></span>
            </div>
            <div id="formAlert" class="alert hidden" role="alert"></div>
            <button class="btn btn-default" type="submit">保存</button>
        </form:form>
    </div>
</div>
<jsp:include page="../common/footer.jsp"/>
<script>
    <spring:url value="/u/${user.username}" var="formUrl"/>
    $(document).ready(dataBind("user-update", '${formUrl}'));
</script>
</body>
</html>
