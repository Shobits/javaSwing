<%--
  Created by IntelliJ IDEA.
  User: 79295
  Date: 2022/8/5
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>other</title>
</head>
<body>
/other.jsp<br>
<h3>name = ${param.myname}</h3>
<h3>age = ${param.myage}</h3>
<h3>获取 get 请求中的参数，<%=request.getParameter("myname")%></h3>
</body>
</html>
