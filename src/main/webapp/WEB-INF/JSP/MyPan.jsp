<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: zjwen
  Date: 2019/4/5
  Time: 2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user =(User) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>主页</title>
    <link href="/static/css/basic.css" rel="stylesheet" type="text/css">
    <link href="/static/css/style.css" rel="stylesheet" type="text/css">
    <link href="/static/css/Pan.css" rel="stylesheet" type="text/css">

</head>

<body>
<div class="d1">
</div>
<div class="d2">
    <div class="user-account">
        <p>下午好，欢迎~ ${user.getUserName()}</p>
        <p>帐户名：欢迎~ ${user.getUserID()}</p>
    </div>
</div>
<div class="d3">
    <ul>
        <li><a href="personal.html" target="target-a">用户信息</a></li>
        <li><a href="file.html" target="target-a">我的文件</a></li>
        <li><a href="create.html" target="target-a">新建文件夹</a></li>
        <li><a href="check.html" target="target-a">查看下载</a></li>
    </ul>
</div>
<div class="d5">
    <div class="toolBox">
        <div class="Upload">
            <form action="">
                <div class="Button">点击上传</div>
                <input type="file"  id="File" class="file_input">
            </form>
        </div>
        <button class="NewDIr">创建文件夹</button>

        <div>
            <form action="">
                <input type="text" class="So">
                <input type="submit" class="SO_Button" value="搜索" >
            </form>

        </div>
    </div>
</div>
<div class="d4">
    <div id="H">
        <c:forEach var="item" items="${dirs.data}"   >
            <div class="FileBox_1" id="${item.getID()}">
                <div class="FileBox_2">
                    <img src="/static/img/Folde.png" />
                </div>
                <div class="FileBox_1_text">${item.getDirectoriesName()}</div>
            </div>

        </c:forEach>
        <c:forEach var="item" items="${files.data}">
            <div class="FileBox_1" onclick="window.open('${item.getDow_link()}')" id="${item.getID()}">
                <div class="FileBox_2">
                    <img src="${item.getFileImg()}" />
                </div>
                <div class="FileBox_1_text">${item.getFileName()}</div>
            </div>
        </c:forEach>
    </div>

</div>
</body>
</html>


<script src="/static/js/jquery.min.js"></script>
<script src="/static/js/index.js"></script>
<script src="/static/js/Pan.js"></script>

<script>

    var thisDIr="${user.getID()}";
    console.log("当前目录ID是:"+thisDIr);

    $(function(){
        var $input =  $("#File");
        // ①为input设定change事件
        $input.change(function () {
            //    ②如果value不为空，调用文件加载方法
            if($(this).val() != ""){
                var form = new FormData();
                form.append("multipartFile", $("#File")[0].files[0]);
                form.append("DirID", thisDIr);

                PostFIle(form);
            }
        })
    })



</script>
