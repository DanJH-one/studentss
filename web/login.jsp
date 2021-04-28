<%--
  Created by IntelliJ IDEA.
  User: danjh
  Date: 2021/4/24
  Time: 10:34 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            width: 50%;
            text-align: center;
            margin-top: 2%;
        }

        .one {
            text-align: center;
            margin-top: 5%;
        }

        #wd {
            width: 300px;
        }

        .two {
            text-align: center;
        }

        a {
            text-decoration: none;
        }

    </style>
</head>

<%--<div class="top">
    <form action=${pageContext.request.contextPath}/StuController method="post" class="topone">
        <button type="submit" name="cshsj" value="cshsj">初始化数据</button>
&nbsp;
        <button type="submit" name="xzsj" value="xzsj">下载数据</button>
    </form>
</div>

<div>

    <form action=${pageContext.request.contextPath}/add.jsp method="post" class="toptw">
        <button type="submit" name="tjsj" >添加数据</button>
    </form>

</div>--%>
<div class="one">
    <a href=${pageContext.request.contextPath}/StuController?name=cshsj>
        <button>初始化数据</button>
    </a>
    &nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/StuController?name=xzsj">
        <button>下载数据</button>
    </a>
    &nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/add.jsp?name=tjsj">
        <button>添加数据</button>
    </a>
</div>
<br>

<%-- <form action=${pageContext.request.contextPath}/StuController?value=sscz method="post">
     <input type="text" name="ss" width="600px">&nbsp&nbsp
     <button type="submit">搜索</button>
 </form>--%>

<div class="two">
    <form action=${pageContext.request.contextPath}/StuController?value=sscz method="post">
        <input id="wd" type="text" name="ss" required>&nbsp&nbsp
        <button type="submit">搜索</button>
    </form>
</div>


<body>
<table border="1px" align="center">
    <tr>
        <td>用户名</td>
        <td>年龄</td>
        <td>成绩</td>
        <td colspan="2">操作</td>

    </tr>
    <c:forEach items="${list.data}" var="st">
        <tr>
            <td>${st.name}</td>
            <td>${st.age}</td>
            <td>${st.source}</td>
            <form action=${pageContext.request.contextPath}/updae.jsp?sid=${st.sid} method="post">
                <input type="hidden" name="na" value="${st.name}">
                <input type="hidden" name="pageNum" value="${st.age}">
                <input type="hidden" name="page" value="${st.source}">
                <td>
                    <button type="submit" name="upde" value="${st.sid}">更新</button>
                </td>
            </form>

            <form action=${pageContext.request.contextPath}/StuController?method=me&pageNum=${list.pageNum}   method="post">
                <td>
                    <button type="submit" name="dele" value="${st.sid}">删除</button>
                </td>
            </form>
        </tr>
    </c:forEach>


    <tr>
        <td>
            <c:if test="${list.isStartpage}">
                <button type="submit" disabled>首页</button>
            </c:if>
            <c:if test="${!list.isStartpage}">
                <a href="${pageContext.request.contextPath}/StuController?method=findAll&pageNum=1">
                    <button type="submit">首页</button>
                </a>
            </c:if>
        </td>
        <td>
            <c:if test="${list.isStartpage}">
                <button type="submit" disabled>上一页</button>
            </c:if>
            <c:if test="${!list.isStartpage}">
                <a href="${pageContext.request.contextPath}/StuController?method=findAll&pageNum=${sessionScope.list.pageNum-1}">
                    <button type="submit">上一页</button>
                </a>
            </c:if>

        </td>
        <td>
            当前页码：${list.pageNum}
        </td>
        <td>
            <c:if test="${list.islendpage}">
                <button type="submit" disabled>下一页</button>
            </c:if>
            <c:if test="${!list.islendpage}">
                <a href="${pageContext.request.contextPath}/StuController?method=findAll&pageNum=${sessionScope.list.pageNum+1}">
                    <button type="submit">下一页</button>
                </a>
            </c:if>
        </td>
        <td>
            <c:if test="${list.islendpage}">
                <button type="submit" disabled>尾页</button>
            </c:if>
            <c:if test="${!list.islendpage}">
                <a href="${pageContext.request.contextPath}/StuController?method=findAll&pageNum=${sessionScope.list.pageCount}">
                    <button type="submit">尾页</button>
                </a>
            </c:if>
        </td>
    </tr>




<%--
    <tr>
        <td>
            <c:if test="${list.isStartpage}">
               <a href="${pageContext.request.contextPath}/StuController">
                   <button disabled>首页</button>
               </a>
            </c:if>
        </td>
        <td>上一页</td>
        <td>当前页码</td>
        <td>下一页</td>
        <td>尾页</td>
    </tr>--%>

</table>
</body>
</html>
