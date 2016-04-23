<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <jsp:include page="../header.jsp"/>
  <h1>user-index</h1>
  <table>
    <tr>
      <th>user id</th>
      <th>username</th>
      <th>password</th>
      <th>opt</th>
    </tr>
    <c:forEach items="${models}" var="model">
      <tr>
        <td>${model.id}</td>
        <td>${model.username}</td>
        <td>${model.password}</td>
        <td>
          <a href="user/${model.id}">detail</a>
          <a href="user/${model.id}/edit">edit</a>
          <a href="user/${model.id}">delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
  <a href="user/new">new</a>

  <jsp:include page="../footer.jsp"/>
</body>
</html>
