<%@ page import="model.ProductLine" %>
<%@ page import="control.ProductLineDA" %><%--
  Created by IntelliJ IDEA.
  User: Thanh
  Date: 12/19/2021
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit ProductLine</title>
    <style>
        body {text-align: center}
    </style>
</head>
<body>
<%
    String pline = request.getParameter("pline");
    ProductLineDA productLineDA = new ProductLineDA();
    ProductLine p = productLineDA.selectProductLine(pline);
    System.out.println("went to edit product line");
%>
<h2>Information detail of: <%=pline%></h2>
<form action="../ServletProductLine_edit" method="get">
    <table border = 1 style="margin-left: auto; margin-right: auto">
        <tr>
            <td>ProductLine</td>
            <td><input type="text" name="namePl" value="<%=p.getProductLine()%>" readonly></td>
        </tr>
        <tr>
            <td>Text Description</td>
            <td><input type="text" name="textPl" value="<%=p.getTextDescription()%>"></td>
        </tr>
        <tr>
            <td>Html Description</td>
            <td><input type="text" name="htmlPl" value="<%=p.getHtmlDescription()%>"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Update">
                <input type="reset" value="Reset">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
