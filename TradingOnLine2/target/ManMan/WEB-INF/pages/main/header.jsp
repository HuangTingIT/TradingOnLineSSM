<%@ page import="TOL2.model.User" %><%--
  Created by IntelliJ IDEA.
  User: HuangTing
  Date: 2016/4/25
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!--原来是包含页面与被包含页面的@page指令里面的contentType不一致，仔细检查两个文件第一行的 @page，
包含页面的是： contentType="text/html; charset=utf-8"
被包含页面：contentType="text/html;charset=utf-8"
果然contentType="text/html;和charset=utf-8"之间多了一个空格，把两个文件第一行的@page内容改为一致，再执行程序，运行通过。-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<c:choose>
    <%--test="${sessionScope.user!=null}" 这样是错误的 气死我了 找了好久的bug啊--%>
    <c:when test="${empty user}">
        <a href="${pageContext.request.contextPath}/main/login">登录</a>
        <a href="${pageContext.request.contextPath}/user/register">注册</a>
        <!--之前这里把c:when丢了，里面的内容都解析不出来-->
    </c:when>
    <c:otherwise>
        <h4>用户<c:out value="${user.id}"/>,您已登录成功。</h4><br>
        <a href="${pageContext.request.contextPath}/goods/queryMyGoods">查看我的商品</a>
        <a href="${pageContext.request.contextPath}/goods/addGoods">发布我的商品</a>
        <a href="${pageContext.request.contextPath}/user/queryPersonalInfo">查看我的个人信息</a>
        <a href="${pageContext.request.contextPath}/user/editPersonalInfo.action">完善我的个人信息</a>
        <a href="${pageContext.request.contextPath}/logout.action">退出</a>
    </c:otherwise>
</c:choose>
<%--
    jsp里面 用el表达式时 el表达式查找的顺序为page request session application 如果没找到 则返回null 但是用c:out输出不出来
    el表达式判断对象是否非空，用的是empty 而不是直接！=null判断啊
--%>
<a href="${pageContext.request.contextPath}/index">主页</a>

