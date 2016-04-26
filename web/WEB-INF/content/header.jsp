<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path=request.getContextPath(); %>
<link rel="stylesheet" href="<%=path%>/resource/css/bootstrap.min.css">
<script src="<%=path%>/resource/js/jquery-1.12.3.min.js"></script>
<script src="<%=path%>/resource/js/bootstrap.min.js"></script>

<div class="container">
  <p>header</p>
  <c:choose>
    <c:when test="${sessionUser==null}">
    <div>
      <p>sign in</p>
      <p>sign up</p>
    </div>
    </c:when>
    <c:otherwise>
      <div>
        <p>${sessionUser.username}</p>
      </div>
    </c:otherwise>
  </c:choose>
</div>
