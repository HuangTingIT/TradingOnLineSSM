<%--
  Created by IntelliJ IDEA.
  User: HuangTing
  Date: 2016/4/25
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>查询商品列表</title>
    <script type="text/javascript">
        function deleteItems(){
            //提交form
            document.goodsForm.action="${pageContext.request.contextPath }/goods/deleteGoodsList.action";
            document.goodsForm.submit();
        }
        function queryMyGoodsByConditions(){
            //提交form
            document.goodsForm.action="${pageContext.request.contextPath }/goods/queryMyGoodsByConditions";
            document.goodsForm.submit();
        }
        function queryMyGoods(){
            //提交form
            document.goodsForm.action="${pageContext.request.contextPath }/goods/queryMyGoods";
            document.goodsForm.submit();
        }
    </script>
</head>
<body>
<%@include file="/WEB-INF/pages/main/header.jsp"%><br>

当前用户：${user.nickname}，
<c:if test="${user.nickname!=null }">
    <a href="${pageContext.request.contextPath }/logout.action">退出</a>
</c:if>
<form name="goodsForm" action="${pageContext.request.contextPath }/goods/queryMyGoods" method="post">
    查询条件：
    <table width="100%" border=1>
        <tr>
            <td>
                商品名称：<input name="goodsExtended.name" />
                商品类型：
                <select name="itemType">
                    <c:forEach items="${itemTypes}" var="itemType">
                        <option value="${itemType.key}">${itemType.value }</option>
                    </c:forEach>
                </select>

            </td>
            <td><input type="button" value="查询" onclick="queryMyGoodsByConditions()"/>
                <input type="button" value="查询我的全部商品" onclick="queryMyGoods()"/>
                <input type="button" value="批量删除" onclick="deleteItems()"/>
            </td>
        </tr>
    </table>

</form>
商品列表：
<table width="100%" border=1>
    <tr>
        <td>选择</td>
        <td>商品名称</td>
        <td>商品种类</td>
        <td>商品数量</td>
        <td>商品价格</td>
        <td>商品描述</td>
        <td>收藏数</td>
    </tr>
    <c:forEach items="${goodsList}" var="goods">
        <tr>
            <td><input type="checkbox" name="goods_id" value="${goods.id}"/></td>
            <td><a href="${pageContext.request.contextPath }/goods/queryAGoodsByGoodsID?id=${goods.id}"/>${goods.name }</td>
            <td>${goods.category }</td>
            <td>${goods.num }</td>
            <td>${goods.price }</td>
            <td>${goods.description }</td>
            <td>${goods.likenum }</td>
            <td><a href="${pageContext.request.contextPath }/goods/editGoodsInfo.action?id=${goods.id}">修改</a></td>
        </tr>
    </c:forEach>

</table>
<div align="center">

    <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
    ${page.pageNow} 页</font> <a href="/concretePageWithConditions?pageNow=1">首页</a>
    <c:choose>
        <c:when test="${page.pageNow - 1 > 0}">
            <a href="/concretePageWithConditions?pageNow=${page.pageNow - 1}">上一页</a>
        </c:when>
        <c:when test="${page.pageNow - 1 <= 0}">
            <a href="/concretePageWithConditions?pageNow=1">上一页</a>
        </c:when>
    </c:choose>
    <c:if test="${page.totalPageCount!=0}">
        <c:forEach var="index" begin="1" end="${page.totalPageCount}">
            <c:choose>
                <c:when test="${index==page.pageNow}">
                    &nbsp;<a href="/concretePageWithConditions?pageNow=${index}"><strong><i>${index}</i></strong></a>&nbsp;
                </c:when>
                <c:otherwise>
                    &nbsp;<a href="/concretePageWithConditions?pageNow=${index}">${index}</a>&nbsp;
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </c:if>
    <c:choose>
        <c:when test="${page.totalPageCount==0}">
            <a href="/concretePageWithConditions?pageNow=${page.pageNow}">下一页</a>
        </c:when>
        <c:when test="${page.pageNow + 1 < page.totalPageCount}">
            <a href="/concretePageWithConditions?pageNow=${page.pageNow + 1}">下一页</a>
        </c:when>
        <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
            <a href="/concretePageWithConditions?pageNow=${page.totalPageCount}">下一页</a>
        </c:when>
    </c:choose>
    <c:choose>
        <c:when test="${page.totalPageCount==0}">
            <a href="/concretePage?pageNow=${page.pageNow}">尾页</a>
        </c:when>
        <c:otherwise>
            <a href="/concretePage?pageNow=${page.totalPageCount}">尾页</a>
        </c:otherwise>
    </c:choose>
</div>
<!-- 分页功能 End -->
</body>

</html>
