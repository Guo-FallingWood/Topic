<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
  <nav>
    <ul class="pagination">
      <li>
        <a href="<c:url value="${page.url}${page.currentPage-1}"/>" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
        </a>
      </li>
      <c:forEach var="index" begin="1" end="${page.pageNumber>10 ? 10 : page.pageNumber}" step="1">
        <li><a href="<c:url value="${page.url}${index}"/>">${index}</a></li>
      </c:forEach>
      <li>
        <a href="<c:url value="${page.url}${page.currentPage+1}"/>" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
        </a>
      </li>
    </ul>
  </nav>
</div>
