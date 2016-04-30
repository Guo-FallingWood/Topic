<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ol class="breadcrumb">
    <c:forEach items="${topics}" var="topic">
        <li><a href="/t/${topic.id}">${topic.name}</a></li>
    </c:forEach>
</ol>
