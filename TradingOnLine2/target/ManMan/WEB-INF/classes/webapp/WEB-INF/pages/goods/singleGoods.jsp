<%--
  Created by IntelliJ IDEA.
  User: HuangTing
  Date: 2016/4/25
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>单个商品列表</title>
</head>
<body>
<%@include file="/WEB-INF/pages/main/header.jsp"%><br>

<form action="/goods/editGoodsInfo.action" method="post">
    <table>

        <%--type=hidden 隐式传值---%>
            <input type="hidden" name="id" value="${goods.id}"/>
            <input type="hidden" name="likeNum" value="${goods.likenum}"/>
            <input type="hidden" name="isSold" value="${goods.issold}"/>
            <input type="hidden" name="pictures" value="${goods.pictures}"/>
            <tr>
            <td>标题</td>
            <td><c:out value="${goods.name}" /></td>
        </tr>
            <tr>
                <td><a href="/user/querySellerInfo?sellerId=${goods.userid}" >卖家：</a></td>
                <td><c:out value="${goods.userid}" /></td>
            </tr>
        <tr>
            <td>种类:</td>
            <td><c:out value="${goods.category}" /></td>
        </tr>
        <tr>
            <td>数量:</td>
            <td><c:out value="${goods.num}" /></td>
        </tr>
        <tr>
            <td>价格:</td>
            <td><c:out value="${goods.price}" /></td>
        </tr>
        <tr>
            <td>收藏:</td>
            <td><c:out value="${goods.likenum}" /></td>
        </tr>
        <tr>
            <td>宝贝描述:</td>
            <td><c:out value="${goods.description}" /></td>
        </tr>
        <tr>
            <td>照片：</td>
            <td>
                <c:if test="${picsList!=null}">
                    <c:forEach items="${picsList}" var="pic">
                        <img src="/pics/${goods.userid}/${pic}" height="100"/>
                    </c:forEach>
                    <br/>
                </c:if>
                <c:if test="${picsList==null}">
                    <h4>您还未上传图片！</h4>
                </c:if>
            </td>
        </tr>
    </table>
    <input type="submit" value="修改商品信息"/>

</form>
</body>
</html>
