<%--
  Created by IntelliJ IDEA.
  User: HuangTing
  Date: 2016/4/25
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <script type="text/javascript">
        function addFile(){
            var upFile = '<input type="file" name="goods_pics"><br>';
            document .getElementById ("files").insertAdjacentHTML("beforeEnd",upFile);
        }

        function deleteFile(){
            var file = document .getElementById ("files").lastChild;
            if(file == null)
                return;
            document .getElementById ("files").removeChild(file);
            file = document .getElementById ("files").lastChild; //移除换行符<br>所以要移两次
            document .getElementById ("files").removeChild(file); //如果在表格里面不加<br>就自动换行的，可以去掉，自己把握
        }
        function deleteSelected(){
            //提交form
            document.goodsForm.action="${pageContext.request.contextPath }/goods/deleteSelectedPics.action";
            document.goodsForm.submit();
        }
    </script>
    <title>修改商品信息</title>
</head>
<body>
<%@include file="/WEB-INF/pages/main/header.jsp"%><br>

<form id="goodsEditForm" action="${pageContext.request.contextPath }/goods/saveAlteredGoodsInfo.action" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>标题</td>
            <td><input type="text" name="name" value="<c:out value="${goods.name}"/>"/></td>
        </tr>
        <tr>
            <td>种类:</td>
            <td><input type="text" name="category" value="<c:out value="${goods.category}" />"/></td>
        </tr>
        <tr>
            <td>数量:</td>
            <td><input type="text" name="num" value="<c:out value="${goods.num}" />"/></td>
        </tr>
        <tr>
            <td>价格:</td>
            <td><input type="text" name="price" value="<c:out value="${goods.price}" />"/></td>
        </tr>
        <tr>
            <td>宝贝描述:</td>
            <td><input type="text" name="description" value="<c:out value="${goods.description}" />"/></td>
        </tr>
        <input type="hidden"  name="id" value="<c:out value="${goods.id}"/>"/>
    </table>
    <table>
        <tr>
            <td>图片</td>
            <td>
                <c:if test="${picsList!=null}">
                    <c:forEach items="${picsList}" var="pic">
                        <input type="checkbox" name="picsSelected" value="${pic}"/>
                            <img src="/pics/${goods.userid}/${pic}" height="100"/>
                        <br>
                    </c:forEach>
                </c:if>
                <c:if test="${picsList==null}">
                    <h4>您还未上传图片！</h4>
                </c:if>
            </td>
        </tr>

        <tr>
            <td>选择文件：<div id="files"><input type="file" name="goods_pics"><br></div></td>
        </tr>
        <tr>
            <td><input type="button" value="添加图片" onclick="addFile()" ><br></td>
            <td><input type="button" value="删除图片" onclick="deleteFile()" ></td>
        </tr>
    </table>
<input type="submit"  value="提交">
</form>
</body>
</html>
