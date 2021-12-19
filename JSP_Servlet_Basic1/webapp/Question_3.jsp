<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Thanh
  Date: 12/15/2021
  Time: 12:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Answer 3</title>
    <style>
        body{text-align: center}
    </style>
</head>
<body>
    <h1>Display the sum of array</h1>
<%--    <form action="Question3" method="post">--%>
<%--        <button>Sum element of array</button>--%>
<%--        <input type="text" name="result" value="${result}"/>--%>
<%--    </form>--%>

    <form action="Answer3" method="post">
        <h3>Enter the array <input type="text" value="${lists}" name="lists" size="50"><br></h3>
        <p><i>Example input:3,4,5,6</i></p>
        <input type="submit" name="btn"/><br><br>
        <input type="text" name="sum" value="${sum}">
    </form>
    <a href="Question_4.jsp" ><i>Next question 4</i></a>

</body>
</html>
