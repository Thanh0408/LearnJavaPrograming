<%@ page import="control.PaymentDA" %>
<%@ page import="model.Payment" %><%--
  Created by IntelliJ IDEA.
  User: Thanh
  Date: 12/19/2021
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit payment</title>
</head>
<body>
<%
    String cusNumb = request.getParameter("cusNumb");
    String checkNumb = request.getParameter("checkNumb");
    PaymentDA paymentDA = new PaymentDA();
    Payment p = paymentDA.selectPayment(cusNumb,checkNumb);
%>
<h2> Edit checkNumber payment of: <%=p.getCheckNumber()%></h2>
<form action="../ServletPayment_edit" method="get">
    <table>
        <tr>
            <td>Customer number</td>
            <td><input type="text" value="<%=p.getCustomerNumber()%>" name="cusNumb" readonly></td>
        </tr>
        <tr>
            <td>Check number</td>
            <td><input type="text" value="<%=p.getCheckNumber()%>" name="checkNumb" readonly></td>
        </tr>
        <tr>
            <td>Payment date</td>
            <td><input type="text" value="<%=p.getPaymentDate()%>" name="pDate"></td>
        </tr>
        <tr>
            <td>Amount</td>
            <td><input type="text" value="<%=p.getAmount()%>" name="amount"></td>
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
