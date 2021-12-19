<%--
  Created by IntelliJ IDEA.
  User: Thanh
  Date: 12/17/2021
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question 1</title>
    <style>
        body {text-align: center}
    </style>
</head>
<body>
    <h1>Evaluate grade</h1>
    <form action="Answer1" method="post">
        <table style="margin-left: auto; margin-right: auto">
            <tr>
                <td>Your grade</td>
                <td><input type="number" name="grade" value="${grade}" style="text-align: center"></td>
            </tr><br>
            <tr>
                <td  colspan="2" align="center"><input type="submit" align="center"></td>
            </tr>
            <tr>
                <td>Evaluation</td>
                <td><input type="text" name="evaluate" value="${evaluate}" style="text-align: center"></td>
            </tr>
        </table>
    </form>
    <a href="Question_2.jsp" ><i>Next question 2</i></a>
</body>
</html>
