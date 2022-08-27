<%--
  Created by IntelliJ IDEA.
  User: 79295
  Date: 2022/8/15
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
退出系统
<%session.removeAttribute("username");%>
</body>
</html>
