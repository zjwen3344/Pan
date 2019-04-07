<%--
  Created by IntelliJ IDEA.
  User: zjwen
  Date: 2019/4/5
  Time: 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录界面</title>
    <link rel="stylesheet" href="/static/css/reset.css" />
    <link rel="stylesheet" href="/static/css/common.css" />
    <link rel="stylesheet" href="/static/css/font-awesome.min.css" />
</head>
<body>
<div class="wrap login_wrap">
    <div class="content">
        <div class="logo"></div>
        <div class="login_box">

            <div class="login_form">
                <div class="login_title">
                    登录
                </div>
                <form action="/User/toLogin" method="post">

                    <div class="form_text_ipt">
                        <input name="UserID" type="text" placeholder="用户名" value="">
                    </div>
                    <div class="ececk_warning"><span>用户名不能为空</span></div>
                    <div class="form_text_ipt">
                        <input name="Password" type="password" placeholder="密码">
                    </div>
                    <div class="ececk_warning"><span>密码不能为空</span></div>

                    <div class="form_btn">
                      <input type="submit" value="登录">
                    </div>
                    <div class="form_reg_btn">
                        <span>还没有帐号？</span><a href="/User/Regist">马上注册</a>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/static/js/jquery.min.js" ></script>
<script type="text/javascript" src="/static/js/common.js" ></script>
<div style="text-align:center;">
</div>
</body>
</html>



