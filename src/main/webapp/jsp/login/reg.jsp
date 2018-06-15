<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html >
  <head>
	<link rel="stylesheet" href="${RBAC}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${RBAC}/css/font-awesome.min.css">
	<link rel="stylesheet" href="${RBAC}/css/login.css">
  </head>
  <body>
    <div class="container">
      <form class="form-signin" role="form" id="userF">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 用户注册</h2>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" name="userName" id="user" placeholder="请输入登录账号" autofocus>
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="password" class="form-control" name="passWord" id="pwd" placeholder="请输入登录密码" style="margin-top:10px;">
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" name="email" id="eam" placeholder="请输入邮箱地址ַ" style="margin-top:10px;">
			<span class="glyphicon glyphicon glyphicon-envelope form-control-feedback"></span>
		  </div>
        <div class="checkbox">
          <label>

          </label>
          <label style="float:right">
            <a href="${RBAC}/jsp/login/login.jsp">我已账号</a>
          </label>
        </div>
        <a class="btn btn-lg btn-success btn-block" id="sub" >注册</a>
      </form>
    </div>
    <script src="${RBAC}/js/jquery-2.1.1.min.js"></script>
    <script src="${RBAC}/bootstrap/js/bootstrap.min.js"></script>
  </body>
<script type="text/javascript">
 $("#sub").click(function () {
     var ctx="${ctx}"
   $.ajax({
       url:ctx+"/user/add",
       method:"post",
       data:$("userF").serialize(),
       success:function(res){
           alert("111")
       }
   });
 });
</script>
</html>