<%--
  Created by IntelliJ IDEA.
  User: 79295
  Date: 2022/8/15
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String basePath = request.getScheme() +
            "://" +
            request.getServerName() + ":" +
            request.getServerPort() +
            request.getContextPath() +
            "/";
%>
<html>
<head>
    <title>首页</title>
    <base href="<%=basePath%>">
    <style>
        table {
            border-collapse: collapse;
        }
    </style>
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        $(() => {
            //添加省份的 select
            getProvinceList()

            //查询按钮的单击事件
            $("#queryCity").click(() => {
                //选中的下拉列表的值
                const pid = $("#province>option:selected").val();
                $.get("city/queryCity.do", {pid: pid}, (resp) => {
                    if (resp.code === 0) {
                        alert(resp.msg)

                        $("#cityInfo").empty();
                        $.each(resp.data, (i, n) => {
                            $("#cityInfo").append("<tr><td>" + n.id + "</td><td>" + n.name + "</td></tr>")
                        })
                    } else {
                        $("#cityInfo").empty();
                        alert(resp.msg)
                    }
                }, "json")
            })

            //添加城市
            $("#addCity").on("click", () => {
                const pid = $("#province>option:selected").val()
                const name = $(":text").val()

                $.post("city/addCity.do", {name: name, provinceId: pid}, (resp) => {
                    if (resp.code === 0) {
                        alert(resp.msg)
                    } else {
                        alert(resp.msg)
                    }
                }, "json")
            })
        })

        function getProvinceList() {
            $.ajax({
                url: "queryProvince.do",
                dataType: "json",
                success: (resp) => {
                    $("#province").empty();
                    $.each(resp.data, (i, n) => {
                        $("#province").append("<option value='" + n.id + "'>" + n.name + "</option>")
                    })
                }
            })
        }
    </script>
</head>
<body>
<div align="center">
    <table>
        <tr>
            <td>省份列表：</td>
            <td>
                <select id="province">
                    <option value="0">请选择...</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>城市名称：</td>
            <td>
                <input type="text" id="cityName">
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" id="addCity" value="添加城市">
            </td>
            <td>
                <input type="button" id="queryCity" value="查询省份的城市">
            </td>
        </tr>
    </table>
    <br>
    <div id="dataDiv">
        <table border="1">
            <thead>
            <tr>
                <td>城市id</td>
                <td>城市名称</td>
            </tr>
            </thead>
            <tbody id="cityInfo">
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
