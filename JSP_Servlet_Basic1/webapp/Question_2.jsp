<%--
  Created by IntelliJ IDEA.
  User: Thanh
  Date: 12/14/2021
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Answer 2</title>
    <style>
        body {text-align: center}
    </style>
</head>
<body>
    <h1>Factorial of number</h1><br><br>
    <form action="Answer2" method="post">
        <table style="margin-left: auto; margin-right: auto">
            <tr>
                <td>Entering number:</td>
                <td><input type="number" name="number" value="${number}" width="30"></td>
            </tr>
            <tr>
                <td><button type="submit" style="height:20px;width:80px">Result</button></td>
                <td><input type="text" name="result" value="${result}"/></td>
            </tr>
        </table>
    </form>
    <a href="Question_3.jsp" ><i>Next question 3</i></a>
</body>
</html>
