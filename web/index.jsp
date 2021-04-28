<%--
  Created by IntelliJ IDEA.
  User: danjh
  Date: 2021/4/24
  Time: 8:42 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    String name = "";
    String password = "";
    String value = "";
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("name".equals(cookie.getName())) {
                name = cookie.getValue();
                System.out.println(name);
            }
            if ("pass".equals(cookie.getName())) {
                password = cookie.getValue();
                System.out.println(password);
            }
            if ("remeber".equals(cookie.getName())) {
                value = cookie.getValue();
                pageContext.setAttribute("ch",value);
            }
        }
    }%>

<%if (name != "" && password != "" && value != "") {%>
<form action=${pageContext.request.contextPath}/Ucontroller method="post">
    <label for="uname">用户名</label>
    <input id="uname" type="text" name="name" value=<%=name%>   ><br>
    <label for="upassword">密 码</label>
    <input id="upassword" type="password" name="password" value=<%=password%>><br>
    <input type="checkbox" name="remeber" ${pageContext.getAttribute("ch")}  >记住用户名和密码<br>
    <button type="submit">登录</button>
</form>

<%} else { %>


<form action=${pageContext.request.contextPath}/Ucontroller method="post">
    <label for="name">用户名</label>
    <input id="name" type="text" name="name"><br>
    <label for="password">密 码</label>
    <input id="password" type="password" name="password"><br>
    <input type="checkbox" name="remeber" value="remeber">记住用户名和密码<br>
    <button type="submit">登录</button>
</form>
<%}%>
</body>
</html>
