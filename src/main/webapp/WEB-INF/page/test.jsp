<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018/4/15
  Time: 上午 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test page dump</title>
</head>
<body>
<div style="margin:0px auto;">
    <h1>successful !！</h1>
<%=request.getAttribute("user_name")%>
<%=request.getAttribute("username")%>
<%=("------------------------")%>
<%=request.getAttribute("sex")%>
</div>
</body>
</html>