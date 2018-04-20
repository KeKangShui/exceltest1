<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${A}
${filename}
<%=request%>
<%=request.getAttribute("filename")%>
<c:forEach items="${map}" var="maps">
${maps}
</c:forEach>
</body>
</html>
