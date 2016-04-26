<%--
  Created by IntelliJ IDEA.
  User: HuangTing
  Date: 2016/4/26
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ page import="TOL2.model.User" %>



<html>
<head>
    <title>卖家信息</title>
</head>
<body>
<%@include file="/WEB-INF/pages/main/header.jsp"%><br>
<table>
    <tr>
        <td>用户id:</td>
        <td><c:out value="${seller.id}" /></td>
    </tr>
    <tr>
        <td>昵&nbsp;称:</td>
        <td><c:out value="${seller.nickname}" /></td>
    </tr>
    <tr>
        <td>姓&nbsp;名:</td>
        <td><c:out value="${seller.realname}" /></td>
    </tr>
    <tr>
        <td>性&nbsp;别:</td>
        <td><c:out value="${seller.sex}" /></td>
    </tr>
    <tr>
        <td>手机号:</td>
        <td><c:out value="${seller.telephone}" /></td>
    </tr>
    <tr>
        <td>邮&nbsp;箱:</td>
        <td><c:out value="${seller.email}" /></td>
    </tr>

</table>

</body>
</html>

