<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
<h1>user-show</h1>
<table>
  <tr>
    <td>id:</td>
    <td>${model.id}</td>
  </tr>
  <tr>
    <td>username:</td>
    <td>${model.username}</td>
  </tr>
  <tr>
    <td>password:</td>
    <td>${model.password}</td>
  </tr>
</table>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
