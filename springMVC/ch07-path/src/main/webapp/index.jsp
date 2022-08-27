<%--
  Created by IntelliJ IDEA.
  User: 79295
  Date: 2022/8/5
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String basePath = request.getScheme() +
            "://" +
            request.getServerName() +
            ":" +
            request.getServerPort() +
            request.getContextPath() +
            "/";
%>
<html>
<head>
    <title></title>
<%--    <base href="http://localhost:8080/ch07_path/">--%>
    <base href="<%=basePath%>">
</head>
<body>
<p>测试路径</p>
<%--<a href="${pageContext.request.contextPath}/test/some.do">发起请求test/some.do</a>--%>
<%--<a href="test/some.do">发起请求test/some.do</a>--%>
<p>有斜杠开头的</p>
<a href="/test/some.do">/test/some.do</a>
<br>
<a href="http://www.baidu.com">有协议开头的地址</a>

</body>
</html>
