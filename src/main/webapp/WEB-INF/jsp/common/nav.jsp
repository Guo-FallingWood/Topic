<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="topic-nav">
    <a href="<c:url value="/"/>" >
        <li <c:if test="${id == null}">class="active"</c:if>>全部</li>
    </a>
    <c:forEach items="${topics}" var="topic">
        <a href="<c:url value="/t/${topic.id}"/>" >
            <li <c:if test="${id==topic.id}">class='active'</c:if> >
                ${topic.name}
            </li>
        </a>
    </c:forEach>
</ul>
