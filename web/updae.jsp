<%--
  Created by IntelliJ IDEA.
  User: danjh
  Date: 2021/4/24
  Time: 4:14 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action=${pageContext.request.contextPath}/StuController?sid=${pageContext.request.getParameter("sid")}&met=upde method="post">
    <label for="name">学生姓名: </label>
    <input id="name" type="text" name="name" value="${pageContext.request.getParameter("na")}" required><br>

    <label for="age">学生年龄: </label>
    <input id="age" type="text" name="age" value="${pageContext.request.getParameter("pageNum")}" required><br>

    <label for="source">学生成绩: </label>
    <input id="source" type="text" name="source" value="${pageContext.request.getParameter("page")}" required><br><br>

    <button type="submit">保存</button>&nbsp&nbsp&nbsp
    <button type="submit">重置</button>

</form>
</body>
</html>
