<%--
  Created by IntelliJ IDEA.
  User: 79295
  Date: 2022/8/13
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>浏览学生</title>
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        $(() => {
            //在页面加载后执行AJAX，获取数据
            getStudentInfo()
            $("#doAJAX").click(() => {
                getStudentInfo()
            })
        })

        function getStudentInfo() {
            $.ajax({
                url: "student/queryStudent.do",
                dataType: "json",
                success: (resp) => {
                    $("#stuInfo").empty()
                    $.each(resp, (i, n) => {
                        $("#stuInfo").append(
                            "<tr><td>" + n.id +
                            "</td><td>" + n.name +
                            "</td><td>" + n.age +
                            "</td></tr>")
                    })
                }
            })
        }
    </script>
</head>
<body>
<div align="center">
    <p>浏览学生
        <button id="doAJAX">获取学生的信息</button>
    </p>
    <table>
        <thead>
        <tr>
            <td>id</td>
            <td>姓名</td>
            <td>年龄</td>
        </tr>
        </thead>
        <tbody id="stuInfo">
        </tbody>
    </table>
</div>
</body>
</html>
