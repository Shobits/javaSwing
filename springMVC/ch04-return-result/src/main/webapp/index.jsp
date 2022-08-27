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
    <title>请求方式</title>
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        $(function () {
            //绑定事件
            $("#btnAjax").on("click", function () {
                $.ajax({
                    url: "doStringData.do",
                    data: {
                        name: "里斯",
                        age: 20
                    },
                    //dataType: "json",
                    dataType:'text',
                    success: function (resp) {
                        //resp = XMLHttpRequest.responseText
                        //alert("resp == " + resp.name + " === " + resp.age)
                        // $.each(resp, function (i, n) {
                        //     alert("n name = " + n.name + ", age = " + n.age)
                        // })
                        alert("resp == "+resp);
                    }
                })
            })
        })
    </script>
</head>
<body>
<p>控制器返回String-逻辑视图名称</p>
<form action="return-string-view1.do" method="post">
    姓名：<input type="text" name="name"> <br>
    年龄：<input type="text" name="age"> <br>
    <input type="submit" value="post提交"/>
</form>
<br>
<br>
<p>控制器返回String-完整视图路径</p>
<form action="return-string-view2.do" method="post">
    姓名：<input type="text" name="name"> <br>
    年龄：<input type="text" name="age"> <br>
    <input type="submit" value="post提交"/>
</form>

<br>
<br>
<button id="btnAjax">发起ajax请求</button>

</body>
</html>
