<%@ page import="java.time.LocalDate" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Thanh
  Date: 12/21/2021
  Time: 11:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>view</title>
    <style>
        body{
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Registration customer form</h1>
<form action="<%=request.getContextPath()%>/showResult" method="post">
    <table style="margin-right: auto; margin-left: auto" >
        <tr>
            <td>Full name</td>
            <td><input type="text" name="fullName" required placeholder="Input your full name"></td>
        </tr>
        <tr>
            <td>Day of birth</td>
            <td><input type="date" name="dob" value="<%=LocalDate.now()%>"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="email" required placeholder="demo@gmail.com"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td>Mobile phone</td>
            <td><input type="text" name="phoneNumber"></td>
        </tr>
        <tr>
            <td>Sex</td>
            <td>
                <input type="radio" name="gender" value="Male">Male
                <input type="radio" name="gender" value="Female">Female
            </td>
        </tr>
        <tr><td colspan="2" align="center"><button type="submit" value="submit">submit</button></td></tr>
    </table>
</form><br><br>

<p>New account will be created, when have <b style="color: red">new phone number</b> and <b style="color: red">new email</b></p>

</body>
</html>
