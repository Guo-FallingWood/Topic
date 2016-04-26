<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>

<div class="container">
<h1>user-edit</h1>
<form action="/user/${model.id}" method="post">
  <input type="hidden" name="_method" value="put">
  <input type="text" name="id" value="${model.id}" readonly="readonly" ><br>
  <input type="text" name="username" value="${model.username}"><br>
  <input type="text" name="password" value="${model.password}"><br>
  <input type="submit" value="save">
</form>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
