<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<link rel="stylesheet" href="<%=path%>/resource/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=path%>/resource/admin/css/admin.css">

<script src="<%=path%>/resource/js/jquery-1.12.3.min.js"></script>
<script src="<%=path%>/resource/js/bootstrap.min.js"></script>
<script src="<%=path%>/resource/js/topic.js"></script>
<nav class="navbar navbar-default">
    <%-- Logo --%>
    <div class="container container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            </button>
            <a class="navbar-brand" href="/admin">Topic Admin</a>
        </div>

        <ul class="nav navbar-nav">
            <li><a href="/admin/topic">话题管理</a></li>
            <li><a href="/admin/user">用户管理</a></li>
            <li><a href="/admin/post">帖子管理</a></li>
        </ul>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/">Topic</a></li>
                <c:if test="${sessionUser != null}">
                    <li><a href="/u/${sessionUser.id}">${sessionUser.username}</a></li>
                    <li><a href="/u/logout">logout</a></li>
                </c:if>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
