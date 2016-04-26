<%--
  Created by IntelliJ IDEA.
  User: HuangTing
  Date: 2015/12/13
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<html>
<head>
    <title>注册</title>

</head>

<body>
<%@include file="/WEB-INF/pages/main/header.jsp"%><br>
<a href="${pageContext.request.contextPath}/login">
    <input type="button" value="登陆"></a>
<form action="${pageContext.request.contextPath}/user/saveRegisterInfo.action" method="post">
    <label>
        <span>真实姓名：</span>
        <input type="text"  name="realName" value="${user.realname}"/>
    </label>
    <br>
    <label>
        <span>手机号：</span>
        <input type="text"  name="telephone"  value="${user.telephone}"/>
    </label><br>
    <label>
        <span>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</span>
        <input type="text" class="text" name="email" value="${user.email}"/>
    </label><br>
    <label>
        <span>登录密码：</span>
        <input type="password" class="text"  name="password"  value="${user.password}"/>
    </label><br>

    <input type="submit" value="注册" />

</form>

</body>
</html>