<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<link rel="stylesheet" href="<%=path%>/resource/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=path%>/resource/css/style.css">

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
            <a class="navbar-brand" href="/">Topic</a>
        </div>

        <%----%>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${sessionUser==null}">
                        <a href="/user/login" class="btn btn-default navbar-btn" role="button">sign in</a>
                        <a href="/user/new" class="btn btn-default navbar-btn" role="button">sign up</a>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/user/${sessionUser.id}">${sessionUser.username}</a></li>
                        <li><a href="/user/logout">logout</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
