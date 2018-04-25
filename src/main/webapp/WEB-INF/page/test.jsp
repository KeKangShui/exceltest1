<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test page dump</title>
    <link rel="stylesheet" type="text/css" href="/css/show.css">
</head>
<body>
<div style="margin:0px auto;">
    <h1>successful !！</h1>
<%=request.getAttribute("table")%>
<c:forEach var="tb" items="${table}">
    ${tb}
</c:forEach>



<%=request.getAttribute("username")%>
<%=("------------------------")%>
<%=request.getAttribute("sex")%>
</div>
</body>
</html>