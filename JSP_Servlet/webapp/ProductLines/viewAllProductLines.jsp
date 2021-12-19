<%@ page import="java.util.ArrayList" %>
<%@ page import="model.ProductLine" %><%--
  Created by IntelliJ IDEA.
  User: Thanh
  Date: 12/19/2021
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All productLines</title>
</head>
<body>
    <%
        ArrayList<ProductLine> lists = (ArrayList<ProductLine>) request.getAttribute("lists");
    %>

<table border="1">
    <tr>
        <th>ProductLine</th>
        <th>TextDescription</th>
        <th>HtmlDescription</th>
    </tr>
<%
    for (ProductLine p: lists){
%>
    <tr>
        <td><%=p.getProductLine()%></td>
        <td><%=p.getTextDescription()%></td>
        <td><%=p.getHtmlDescription()%></td>
        <td>
            <a href="ProductLines/editProductLine.jsp?pline=<%=p.getProductLine()%>"><button>Edit</button></a>
            <a href="ServletProductLine_delete?pline=<%=p.getProductLine()%>"><button onclick="return confirm('Are u sure?')">Delete</button></a>
        </td>
    </tr>
<%}%>

</table>

</body>
</html>
