<%--
  Created by IntelliJ IDEA.
  User: HuangTing
  Date: 2015/12/13
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ page import="java.util.*" %>

<html>
<head><title>TradingOnLine</title></head>
<body>
<%@include file="header.jsp"%>
</body>
</html>


<html>
<head>
    <title>登录</title>

</head>
<body>
<a href="/user/register">
    <input type="button" value="注册"></a>
<form action="${pageContext.request.contextPath}/loginByTel.action" method="post">
    <div class="infield">
        <div>
            <input  type="text" placeholder="手机号" name="telephone"></div>
        <div>
            <input  type="password" placeholder="密码"  name="password"></div>
    </div>
        <input type="submit" value="登录">
</form>
</div>
</body>
</html>