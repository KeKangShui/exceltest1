<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/16 0016
  Time: 下午 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!StringBuffer buffer = new StringBuffer(); %>
<%List<String[]> str = (List<String[]>)request.getAttribute("res");
        buffer.delete(0,buffer.length());
for (int i = 0; i < str.size(); i++) {
        String[] strings =str.get(i);
        for (int j = 0; j < strings.length; j++) {
            String s =strings[j];
            System.out.println(strings[j]);
            buffer.append("<table><th>");
            if (null != s){
                buffer.append("<tr><td>"+strings[j]+"</td></tr>");
            }
            buffer.append("</table></th>");
        }
    }
%>
${buffer}
<%=buffer.toString()%>


</body>
</html>
