<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
  <h1>修改页面</h1>
  <form action="${pageContext.request.contextPath}/studentController/update" method="post">
     <input type="hidden" value="${student.id}" name="id">
    学生姓名：<input type="text" name="name" value="${student.name}" ><br/>
    学生性别：<input type="text" name="sex" value="${student.sex}" ><br/>
    学生年龄：<input type="text" name="age" value="${student.age}" ><br/>
    学生地址：<input type="text" name="address" value="${student.address}" ><br/>
    <button type="submit">修改</button>
  </form>
</body>
</html>
