<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <script src="${ctx}/js/jquery-2.1.1.min.js"></script>
    <script src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${ctx}/js/docs.min.js"></script>
    <script type="text/javascript">
        var ctx = "<%=request.getContextPath()%>";
    </script>
</head>
<body>
</body>
</html>
