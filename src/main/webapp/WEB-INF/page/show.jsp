<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" import="com.excel.common.ExcelUtils" language="java" %>
<html>
<head>
    <title>Title</title>

    <style>
        table{
            width: 55%;
            margin: 0px auto;
            margin-top: 40px;
        }
        td{
            width: 60px;
            height: 40px;
            text-align: center;
        }
    </style>
</head>
<body>
<%--<%=request.getAttribute("test")%>  这个也是可以使用  --%>
<%--<%!StringBuffer buffer = new StringBuffer(); %>
<%
    List<String[]> str = (List<String[]>)request.getAttribute("res");
        buffer.delete(0,buffer.length());
for (int i = 0; i < str.size(); i++) {
        String[] strings =str.get(i);
        for (int j = 0; j < strings.length; j++) {
            String s =strings[j];
            System.out.println(strings[j]);
            buffer.append("<table><th>");
            if (null != s){
                buffer.append("<tr><td >"+s+"</td></tr>");
            }
            buffer.append("</th></table>");
        }
    }
%>--%>
<%--<%=request.getAttribute("test")%>--%>

<%--${pageContext.request.contextPath}
<%--
<c:forEach var="tx" items="${test}">
    ${tx}
</c:forEach>--%>
${requestScope.test}
<%--${test}  这个也是可以使用--%>
</body>
</html>
