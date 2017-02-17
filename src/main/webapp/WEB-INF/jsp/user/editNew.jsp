<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="content">
    <div class="edit-bar container">
        <h2 style="text-align: center">用户注册</h2>
        <br>
        <spring:url value="/u" var="formUrl"/>
        <form:form modelAttribute="user" id="user-add" class="form-horizontal">
            <div class="form-group" id="username">
                <label class="col-md-4 control-label">用户名</label>
                <div class="col-md-4">
                    <form:input path="username" cssClass="form-control"/>
                </div>
                <span class="col-md-4 help-inline"><form:errors path="username"/></span>
            </div>
            <div class="form-group" id="password">
                <label class="col-md-4 control-label">密码</label>
                <div class="col-md-4">
                    <form:password path="password" cssClass="form-control"/>
                </div>
                <span class="col-md-4 help-inline"><form:errors path="password"/></span>
            </div>
            <div id="formAlert" class="alert hidden" role="alert"></div>
            <div class="col-md-12">
                <span class="col-md-7"></span>
                <input class="btn btn-default" type="submit" value="注册"/>
            </div>
        </form:form>
    </div>
</div>
<jsp:include page="../common/footer.jsp"/>
<script>
    $(document).ready(dataBind("user-add", '${formUrl}', function () {
        window.location.href = '<c:url value="/"/>';
    }));
</script>
</body>
</html>
