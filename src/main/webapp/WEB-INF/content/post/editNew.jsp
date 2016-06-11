<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="main-bar">
        <%--<jsp:include page="../nav.jsp"/>--%>
        <h2>添加新文章到 [${topic.name}] </h2>
        <form action="" id="ajaxForm">
            <input type="hidden" name="topicId" value="${topic.id}" >
            <label class="control-label">文章标题</label>
            <input type="text" class="form-control" name="title">
            <label class="control-label">文章内容</label>
            <textarea name="content" id="" cols="" rows="10" class="form-control"></textarea>
            <br>
            <div id="formAlert" class="alert alert-danger hidden" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <span id="formAlertText"></span>
            </div>
            <button type="button" class="btn btn-default" onclick="ajaxForm('/p','发表')">发表</button>
        </form>
    </div>
    <%--<jsp:include page="../sidebar.jsp"/>--%>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
