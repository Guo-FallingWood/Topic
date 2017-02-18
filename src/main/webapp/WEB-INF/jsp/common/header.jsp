<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<c:url value="/resource/module/bootstrap/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resource/css/style.css"/>"/>

<script src="<c:url value="/resource/module/jquery/jquery-1.12.3/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/resource/module/bootstrap/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resource/module/jquery-cookie/jquery.cookie.js"/>"></script>
<script src="<c:url value="/resource/js/topic.js"/>"></script>

<div class="top">
    <nav class="navbar-inverse">
        <%-- Logo --%>
        <div class="container container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                </button>
                <a class="navbar-brand" href="<c:url value="/"/>">Topic</a>
            </div>

            <%----%>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <c:choose>
                        <c:when test="${sessionUser == null}">
                            <a href="<c:url value="/u/login"/>" class="btn btn-default navbar-btn" role="button">登录</a>
                            <a href="<c:url value="/u/new" />" class="btn btn-default navbar-btn" role="button">注册</a>
                        </c:when>
                        <c:otherwise>
                            <li><a href="<c:url value="/u/${sessionUser.id}"/>">${sessionUser.username}</a></li>
                            <li><a href="<c:url value="/u/logout"/>">退出登录</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>
