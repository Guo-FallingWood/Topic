<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<c:url value="/resource/module/bootstrap/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resource/module/bootstrap-table/bootstrap-table.min.css"/>"/>

<link rel="stylesheet" href="<c:url value="/resource/css/admin.css"/>"/>


<script src="<c:url value="/resource/module/jquery/jquery-1.12.3/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/resource/module/jquery-cookie/jquery.cookie.js"/>"></script>
<script src="<c:url value="/resource/module/bootstrap/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resource/module/bootstrap-table/bootstrap-table.min.js"/>"></script>
<script src="<c:url value="/resource/module/vue/vue.min.js"/>"></script>

<script src="<c:url value="/resource/js/topic.js"/>"></script>

<div id="header">
    <nav class="navbar navbar-default">
        <%-- Logo --%>
        <div class="container container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                </button>
                <a class="navbar-brand" href="<c:url value="/admin/"/>">Topic Admin</a>
            </div>

            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/admin/topic/"/>">话题管理</a></li>
                <li><a href="<c:url value="/admin/user/"/>">用户管理</a></li>
                <li><a href="<c:url value="/admin/collect/"/>">采集管理</a></li>
            </ul>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="<c:url value="/" />">Topic</a></li>
                    <c:if test="${sessionUser != null}">
                        <li><a href="<c:url value="/u/${sessionUser.id}"/>">${sessionUser.username}</a></li>
                        <li><a href="<c:url value="/u/logout"/>">logout</a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
</div>
