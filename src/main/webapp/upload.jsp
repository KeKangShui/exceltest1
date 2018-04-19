<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/16 0016
  Time: 下午 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<form action="/mytest.do" method="post" enctype="multipart/form-data">
    <h1>请上传文件</h1>
    <input type="file" name="file"><br><br>
    <input type="submit" value="提交">
</form>
</center>
</body>
</html>
