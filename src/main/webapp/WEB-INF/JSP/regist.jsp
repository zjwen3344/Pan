<%--
  Created by IntelliJ IDEA.
  User: zjwen
  Date: 2019/4/6
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>注册界面</title>
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
                    注册
                </div>
                <form action="/User/toRegist" method="post">

                    <div class="form_text_ipt">
                        <input name="UserID" type="text" placeholder="用户名">
                    </div>
                    <div class="ececk_warning"><span>用户名不能为空</span></div>



                    <div class="form_text_ipt">
                        <input name="Password" type="password" placeholder="密码">
                    </div>
                    <div class="ececk_warning"><span>密码不能为空</span></div>



                    <div class="form_text_ipt">
                        <input name="SEX" type="int" placeholder="性别">
                    </div>
                    <div class="ececk_warning"><span>性别不能为空</span></div>



                    <div class="form_text_ipt">
                        <input name="UserName" type="varchar" placeholder="昵称">
                    </div>
                    <div class="ececk_warning"><span>昵称不能为空</span></div>



                    <div class="form_text_ipt">
                        <input name="Email" type="varchar" placeholder="邮箱">
                    </div>
                    <div class="ececk_warning"><span>邮箱不能为空</span></div>

                    <div class="form_btn">
                        <input type="submit"  value="注册"/>
                    </div>
                    <div class="form_reg_btn">
                        <span>已有帐号？</span><a href="/User/Login">马上登录</a>
                    </div>
                </form>
                <div class="other_login">
                    <div class="left other_left">

                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/static/js/jquery.min.js" ></script>
<script type="text/javascript" src="/static/js/common.js" ></script>
<script>
    var code ="${msg.getCode()}";
    var msg="${msg.getMsg()}";

    if(code!=""){
        if(code=="400"){
            alert(msg);
        }else {
            alert(msg);
        }
    }

</script>

</body>
</html>
