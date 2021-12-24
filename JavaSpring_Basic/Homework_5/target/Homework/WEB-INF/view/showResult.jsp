<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Thanh
  Date: 12/23/2021
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
    <style>
        body {
            text-align: center;
        }
        h1 {
            color: orangered;
        }
        div {
            display:block;
            border: 1px solid black;
            padding:5px;
            margin-top:5px;
            width:80%;
            height:100px;
            overflow:scroll;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body>
    <% String result = String.valueOf(request.getAttribute("result"));
        System.out.println("this is show result page");
        System.out.println(result);
        ArrayList<String> listData = (ArrayList<String>) request.getAttribute("listData");
    %>
    <%
        if (result.equals("0")){
    %>
    <br><br><h1>Your email or phone number has available</h1>
    <%
        } else if (result.equals("1")){
    %>
    <h1>Success. Thanks for registration</h1><%}%><br><br>

    <div>
    <%
        try{
            for (int i = 0; i < listData.size(); i++){

    %>
    <%=listData.get(i)%><br>
    <%
            }
        }catch(Exception ex){
        System.out.println(ex.getMessage());
    }%>
    </div><br><br>
    <a href="<%= request.getContextPath()%>/">Go to first page</a><br><br>
    <footer><a href="<%= request.getContextPath()%>/form">Add new customer</a></footer>

</body>
</html>
