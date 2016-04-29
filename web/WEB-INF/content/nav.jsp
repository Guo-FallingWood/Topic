<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <ul>
        <c:forEach items="${topics}" var="topic">
            <li><a href="/t/${topic.id}">${topic.name}</a></li>
        </c:forEach>
    </ul>
</div>
