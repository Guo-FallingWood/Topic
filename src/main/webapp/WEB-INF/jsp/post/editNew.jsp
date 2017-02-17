<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="content">
    <div class="container">
        <div class="main-bar">
            <%--<jsp:include page="../nav.jsp"/>--%>
            <h2>添加新文章到 [${topic.name}] </h2>
            <form action="" id="ajaxForm">
                <input type="hidden" name="topicId" value="${topic.id}">
                <label class="control-label">文章标题</label>
                <input type="text" class="form-control" name="title">
                <label class="control-label">文章内容</label>
                <textarea name="content" id="" cols="" rows="10" class="form-control"></textarea>
                <br>
                <div id="formAlert" class="alert hidden" role="alert"></div>
                <button type="button" class="btn btn-default" onclick="postNew()">发表</button>
            </form>
        </div>
        <%--<jsp:include page="../sidebar.jsp"/>--%>
    </div>
</div>
<jsp:include page="../common/footer.jsp"/>

<script>
    function postNew() {
        myAjaxForm({
            url: '<c:url value="/p"/>', callback: function (data) {
                var id = data.data.id;
                var url = '<c:url value="/p/"/>' + id;
                window.location.href = url;
            }
        });
    }
</script>
</body>
</html>
