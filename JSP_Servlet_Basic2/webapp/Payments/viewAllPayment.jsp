<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Payment" %><%--
  Created by IntelliJ IDEA.
  User: Thanh
  Date: 12/19/2021
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show payments</title>
</head>
<body>
<%
    ArrayList<Payment> lists = (ArrayList<Payment>) request.getAttribute("lists");
%>
<table border="1" style="margin-left: auto; margin-right: auto">
    <tr>
        <th>Customer number</th>
        <th>Check number</th>
        <th>Payment date</th>
        <th>Amount</th>
    </tr>
<%
    for(Payment p:lists){
%>
    <tr>
        <td><%=p.getCustomerNumber()%></td>
        <td><%=p.getCheckNumber()%></td>
        <td><%=p.getPaymentDate()%></td>
        <td><%=p.getAmount()%></td>
        <td>
            <a href="Payments/editPayment.jsp?checkNumb=<%=p.getCheckNumber()%>&cusNumb=<%=p.getCustomerNumber()%>"><button>Edit</button></a>
            <a href="ServletPayment_delete?cusNumb=<%=p.getCustomerNumber()%>&checkNumb=<%=p.getCheckNumber()%>"><button>Delete</button></a>
        </td>
    </tr>
    <%}%>
</table>

</body>
</html>
