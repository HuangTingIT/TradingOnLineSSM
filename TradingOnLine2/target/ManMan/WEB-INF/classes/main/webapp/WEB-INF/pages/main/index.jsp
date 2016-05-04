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
<script type="text/javascript">
    function loadXMLDoc(){
        var xmlhttp;
        if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        }
        else
        {// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    function showHint(str)
    {
        var xmlhttp;
        if (str.length==0)
        {
            document.getElementById("txtHint").innerHTML="";
            return;
        }
        if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        }
        else
        {// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
            }
        }
        xmlhttp.open("GET","/ajax/gethint.asp?q="+str,true);
        xmlhttp.send();
    }

</script>
</head>
<body>
<h1>你来我往二手交易网站</h1>


<%@include file="header.jsp"%>

<form name="${pageContext.request.contextPath }/searchFromAllWithConditions" action="${pageContext.request.contextPath }/searchFromAllWithConditions" method="post">
    查询条件：
    <table width="100%" border=1>
        <tr>
            <td>
                商品名称：<input name="name" />
                商品类型：
                <select name="category">
                    <c:forEach items="${categorys}" var="category">
                        <option name="category" value="${category.value}">${category.value }</option>
                    </c:forEach>
                </select>

            </td>
        </tr>
        <tr>
            <td>
                价格：<input type="text" name="minPrice" value="${goodsExtended.minPrice}" />&nbsp;
                      <input type="text" name="maxPrice" value="" />
            </td>
            <td>
                <select name="order" >
                    <option   value="orderByDefault" selected="selected">综合排序</option>
                    <option   value="orderByPriceASC">价格从低到高</option>
                    <option   value="orderByPriceDESC">价格从高到低</option>
                    <option   value="orderByLikeNumASC">收藏数从低到高</option>
                    <option   value="orderByLikeNumDESC">收藏数从高到低</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="查询"/>
            </td>
        </tr>
    </table>
</form>



    <table width="100%" border=1>
    <tr>
        <td>商品名称</td>
        <td>商品种类</td>
        <td>商品数量</td>
        <td>商品价格</td>
        <td>商品描述</td>
        <td>收藏数</td>
    </tr>
    <c:forEach items="${goodsList}" var="goods">
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
<!-- 分页功能 start -->
<div align="center">

    <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
    ${page.pageNow} 页</font> <a href="/concretePage?pageNow=1">首页</a>
    <c:choose>
        <c:when test="${page.pageNow - 1 > 0}">
            <a href="/concretePage?pageNow=${page.pageNow - 1}">上一页</a>
        </c:when>
        <c:when test="${page.pageNow - 1 <= 0}">
            <a href="/concretePage?pageNow=1">上一页</a>
        </c:when>
    </c:choose>
    <c:if test="${page.totalPageCount!=0}">
        <c:forEach var="index" begin="1" end="${page.totalPageCount}">
            <c:choose>
                <c:when test="${index==page.pageNow}">
                    &nbsp;<a href="/concretePage?pageNow=${index}"><strong><i>${index}</i></strong></a>&nbsp;
                </c:when>
                <c:otherwise>
                    &nbsp;<a href="/concretePage?pageNow=${index}">${index}</a>&nbsp;
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </c:if>
    <c:choose>
        <c:when test="${page.totalPageCount==0}">
            <a href="/concretePage?pageNow=${page.pageNow}">下一页</a>
        </c:when>
        <c:when test="${page.pageNow + 1 < page.totalPageCount}">
            <a href="/concretePage?pageNow=${page.pageNow + 1}">下一页</a>
        </c:when>
        <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
            <a href="/concretePage?pageNow=${page.totalPageCount}">下一页</a>
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