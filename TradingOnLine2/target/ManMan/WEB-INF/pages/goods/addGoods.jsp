<%--
  Created by IntelliJ IDEA.
  User: HuangTing
  Date: 2016/4/25
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>发布商品</title>
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
    </script>
</head>
<body>
<%@include file="/WEB-INF/pages/main/header.jsp"%><br>

<form action="/goods/saveAddedGoodsInfo" method="post" enctype="multipart/form-data">

    <strong>标题</strong> <input type="text" name="name" value=""/><br/>
    <strong>种类</strong> <input type="text" name="category" value=""/><br/>
    <strong>数量</strong> <input type="text" name="num" value="" /><br/>
    <strong>价格</strong> <input type="text" name="price" value=""/><br/>
    <strong>地址</strong> <input type="text" name="address" value=""/><br/>
    <strong>宝贝描述</strong><textarea name="description" value=""></textarea><br/>
    <strong>选择图片</strong><br>

    文件：<div id="files"><input type="file"  name="goods_pics"/><br></div>
    <input type="button" value="添加图片" onclick="addFile()" ><br>
    <input type="button" value="删除图片" onclick="deleteFile()" ><br>

    <input type="submit" value="提交"/>

</form>
</body>
</html>
