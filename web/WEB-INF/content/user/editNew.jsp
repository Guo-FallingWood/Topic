<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
  <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
  <h1>user-editNew</h1>
  <form action="/user" method="post">
    <input type="text" name="username" ><br>
    <input type="text" name="password" ><br>
    <input type="submit" value="save">
  </form>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
