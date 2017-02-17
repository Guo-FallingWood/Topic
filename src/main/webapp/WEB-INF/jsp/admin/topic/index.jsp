<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div id="main">
    <div class="container main-bar">
        <h1>话题管理</h1>
        <table class="table table-bordered">
            <tr>
                <th>编号</th>
                <th>名称</th>
                <th>url</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${topics}" var="topic">
                <tr <c:if test="${topic.close==1}">class="danger"</c:if></tr>
                <td>${topic.id}</td>
                <td>${topic.name}</td>
                <td>${topic.url}</td>
                <td>
                    <c:if test="${topic.close == 0}">开放</c:if>
                    <c:if test="${topic.close == 1}">关闭</c:if>
                </td>
                <td>
                        <%--<button onclick="myAjaxForm('/admin/topic/${topic.id}', '更新', {_method:'put', discard:1})">关闭</button>--%>
                        <%--<button onclick="myAjaxForm('/admin/topic/${topic.id}', '更新', {_method:'put', discard:0})">开放</button>--%>
                    <button onclick="myAjaxForm({url : '<c:url value="/admin/topic/${topic.id}"/>', params : {_method:'put', discard:1}})"
                            class="btn btn-default">关闭
                    </button>
                    <button onclick="myAjaxForm({url : '<c:url value="/admin/topic/${topic.id}"/>', params : {_method:'put', discard:0}})"
                            class="btn btn-default">开放
                    </button>
                </td>
                </tr>
            </c:forEach>
            <form id="ajaxForm">
                <tr>
                    <td></td>
                    <td><input type="text" name="name"></td>
                    <td><input name="url"></td>
                    <td></td>
                    <td>
                        <button type="button" onclick="myAjaxForm({url : '<c:url value="/admin/topic"/>'})">new</button>
                    </td>
                </tr>
                <div id="formAlert" class="alert alert-danger hidden" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <span id="formAlertText"></span>
                </div>
            </form>
        </table>
    </div>
</div>
</body>
</html>
