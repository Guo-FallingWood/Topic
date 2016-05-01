<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="topic-nav">
    <c:forEach items="${topics}" var="topic">
        <a href="/t/${topic.id}">
        <li <c:if test="${id==topic.id}">class='active'</c:if> >
            ${topic.name}
        </li>
        </a>
    </c:forEach>
</ul>
