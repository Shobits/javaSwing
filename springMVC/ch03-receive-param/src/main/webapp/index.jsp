<%--
  Created by IntelliJ IDEA.
  User: 79295
  Date: 2022/8/5
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>逐个接受请求参数</title>
</head>
<body>
<p>逐个接受请求参数</p>
<form action="receive-property.do" method="post">
    姓名：<input type="text" name="name"> <br>
    年龄：<input type="text" name="age"> <br>
    <input type="submit" value="post提交"/>
</form>

<br>
<br>
<p>逐个接受请求参数：请求中参数名和形参名不一样</p>
<form action="receive-param.do" method="post">
    姓名：<input type="text" name="rname"> <br>
    年龄：<input type="text" name="rage"> <br>
    <input type="submit" value="post提交"/>
</form>

<br>
<br>
<p>对象接收请求参数，请求中参数名和对象的属性名一样</p>
<form action="receive-object.do" method="post">
    姓名：<input type="text" name="name"> <br>
    年龄：<input type="text" name="age"> <br>
    <input type="submit" value="对象接收参数"/>
</form>

</body>
</html>
