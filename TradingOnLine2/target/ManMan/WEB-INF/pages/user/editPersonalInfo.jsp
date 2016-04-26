<%--
  Created by IntelliJ IDEA.
  User: HuangTing
  Date: 2016/4/24
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="TOL2.model.User" %>


<html>
<head>

</head>
<body>
<%@include file="/WEB-INF/pages/main/header.jsp"%>
<form action="/user/UpdateUserInfo.action" method="post">


    <label>
        <span class="item">用户id:</span>
        <c:out value="${user.id}"/>
    </label>
    <br>
    <label>
        <span class="item">昵&nbsp;称:</span>
        <input type="text" name="nickname" value="<c:out value="${user.nickname}"/>"/>
    </label>
    <br>
    <label>
        <span class="item">姓&nbsp;名:</span>
        <input type="text" name="realname" value="<c:out value="${user.realname}"/>"/>
    </label>
    <br>
    <span class="item">
        <c:if test="${user.sex==' '}">
            性&nbsp;别:</span><input type="radio" value="男" name="Sex" checked="">男 &nbsp;
    <input type="radio" value="女" name="Sex">女
    </c:if>

    <c:if test="${user.sex=='男'}">
        性&nbsp;别:</span><input type="radio" value="女" name="Sex" checked >男 &nbsp;
        <input type="radio" value="女" name="Sex">女
    </c:if>


    <c:if test="${user.sex=='女'}">
        性&nbsp;别:</span><input type="radio" value="男" name="Sex" >男 &nbsp;
        <input type="radio" value="女" name="Sex" checked>女
    </c:if>
    <br>
    <label>
        <span class="item">手机号:</span>
        <input type="text" name="telephone" value="<c:out value="${user.telephone}"/>"/></label>
    <br>

    <label>
        <span class="item">邮&nbsp;箱:</span>
        <input type="text" name="email" value="<c:out value="${user.email}"/>"/>
    </label>
    <label>
        <span class="item">地&nbsp;址:</span>
        <input type="text" name="address" value="<c:out value="${user.address}"/>"/>
    </label>
    <br>
    <input type="submit" value="提交"/>

</form>

</body>
</html>

