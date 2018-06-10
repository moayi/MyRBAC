<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>欢迎</title>
    <link rel="stylesheet" href="${RBAC}/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${RBAC}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${RBAC}/css/main.css">
    <style>
        .tree li {
            list-style-type: none;
            cursor:pointer;
        }
        .tree-closed {
            height : 40px;
        }
        .tree-expanded {
            height : auto;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <div><a class="navbar-brand" style="font-size:32px;" href="#">MOAYI</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li style="padding-top:8px;">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">
                            <i class="glyphicon glyphicon-user"></i> 张三 <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
                            <li class="divider"></li>
                            <li><a href="index.html"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                        </ul>
                    </div>
                </li>
                <li style="margin-left:10px;padding-top:8px;">
                    <button type="button" class="btn btn-default btn-danger">
                        <span class="glyphicon glyphicon-question-sign"></span> 帮助
                    </button>
                </li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="查询">
            </form>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <div class="tree">
                <ul style="padding-left:0px;" class="list-group">
                    <c:forEach items="${sessionScope.menu}" var="permission">
                        <c:if test="${empty permission.children}">
                            <li class="list-group-item tree-closed" >
                                <a href="#" onclick="menuClick ('${permission.url}')"><i class="${permission.icon}"></i> ${permission.name}</a>
                            </li>
                        </c:if>
                        <c:if test="${not empty permission.children}">
                            <li class="list-group-item tree-closed">
                                <span><i class="${permission.icon}"></i> ${permission.name} <span class="badge" style="float:right">${permission.children.size()}</span></span>
                                <ul style="margin-top:10px;display:none;">
                                    <c:forEach items="${permission.children}" var="child">
                                        <li style="height:30px;">
                                            <a href="#" onclick="menuClick ('${child.url}')"><i class="${child.icon}"></i> ${child.name}</a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="row placeholders">
                <iframe id="main" src="${RBAC}/index.jsp" width="100%"  frameborder="no" border="0" marginwidth="0"
                        marginheight=" 0" scrolling="no" allowtransparency="yes"></iframe>
            </div>
        </div>
    </div>
</div>
</body>
<script src="${RBAC}/js/jquery-2.1.1.min.js"></script>
<script src="${RBAC}/bootstrap/js/bootstrap.min.js"></script>
<script src="${RBAC}/js/docs.min.js"></script>
<script type="text/javascript">
    $(function () {
        $(".list-group-item").click(function(){
            if ( $(this).find("ul") ) { // 3 li
                $(this).toggleClass("tree-closed");
                if ( $(this).hasClass("tree-closed") ) {
                    $("ul", this).hide("fast");
                } else {
                    $("ul", this).show("fast");
                }
            }
        });
    });
    function menuClick (menuUrl) {
         var ctx="${ctx}";
        $("#main").attr('src',ctx+menuUrl);
    };
</script>
</html>
