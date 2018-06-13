<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${RBAC}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${RBAC}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${RBAC}/css/login.css">
    <style>

    </style>
</head>
<body>
<%--<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index.html" style="font-size:32px;">后台管理系统</a></div>
        </div>
    </div>
</nav>--%>
<div class="container">
    <form class="form-signin" role="form" method="post" id="userF" action="${ctx}/login/doLogin">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-user"></i> 用户登录</h2>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" name="userName" id="us" placeholder="请输入登录账号" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="password" class="form-control" id="pw" name="passWord" placeholder="请输入登录密码" style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <span style="color: red" id="err">${requestScope.error}</span>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住我
            </label>
            <br>
            <label>
                忘记密码
            </label>
            <label style="float:right">
                <a href="${RBAC}/jsp/login/reg.jsp">我要注册</a>
            </label>
        </div>
        <a class="btn btn-lg btn-success btn-block" onclick="dologin()" > 登录</a>
    </form>
</div>
<script src="${RBAC}/js/jquery-2.1.1.min.js"></script>
<script src="${RBAC}/bootstrap/js/bootstrap.min.js"></script>
<script>
    $(function () {
        if($("#us").val()==""){
            $("#err").hide();
        }
    })
    function dologin() {
        $("#userF").submit();
    }
</script>
</body>
</html>
