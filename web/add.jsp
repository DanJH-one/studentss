<%--
  Created by IntelliJ IDEA.
  User: danjh
  Date: 2021/4/24
  Time: 1:15 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <form action=${pageContext.request.contextPath}/StuController?value=tjsj  method="post">
      <label for="name">学生姓名: </label>
      <input id="name" type="text" name="name"><br>

      <label for="age">学生年龄: </label>
      <input id="age" type="text" name="age"><br>

      <label for="source">学生成绩: </label>
      <input id="source" type="text" name="source"><br><br>

      <button type="submit">保存</button>&nbsp&nbsp&nbsp
      <button type="submit">重置</button>

  </form>
  </body>
</html>
