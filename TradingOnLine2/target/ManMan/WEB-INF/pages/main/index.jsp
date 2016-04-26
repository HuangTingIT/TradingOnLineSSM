<%--
  Created by IntelliJ IDEA.
  User: HuangTing
  Date: 2016/4/23
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

</head>
<body>
<h1>你来我往二手交易网站</h1>


<%@include file="header.jsp"%>
<table width="100%" border=1>
    <tr>
        <td>商品名称</td>
        <td>商品种类</td>
        <td>商品数量</td>
        <td>商品价格</td>
        <td>商品描述</td>
        <td>收藏数</td>
    </tr>
    <c:forEach items="${goodsList }" var="goods">
        <tr>
            <td><a href="${pageContext.request.contextPath }/goods/queryAGoodsByGoodsID?id=${goods.id}"/>${goods.name }</td>
            <td>${goods.category }</td>
            <td>${goods.num }</td>
            <td>${goods.price }</td>
            <td>${goods.description }</td>
            <td>${goods.likenum }</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>