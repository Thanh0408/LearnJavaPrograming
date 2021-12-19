<%@ page import="java.util.function.Function" %>
<%@ page import="java.awt.*" %><%--
  Created by IntelliJ IDEA.
  User: Thanh
  Date: 12/16/2021
  Time: 12:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Answer 4</title>
    <STYLE>
        body{text-align: center;}
    </STYLE>
</head>
<body>
    <h1>Login</h1>
    <form name="form" action="Answer4" method="post" >
        <fieldset style="width: fit-content; margin-right: auto; margin-left: auto">
            Username:<input type="text" name="username"><br><br>
            Password:<input type="password" name="password"><br><br>
            <input type="submit" onclick="alertName()" value="login">
        </fieldset>
    </form>

    <br><br><p><i>Username:thanh && Password:1234</i></p>

    <script type="text/javascript">
        function alertName(){
            if (document.form.username.value == null &&document.form.password.value == null){
                alert ( "You did not input your account!" );
                return true;
            }
            else if (document.form.username.value == "thanh" &&document.form.password.value == "1234"){
                alert ( "Login successful" );
                return true;
            }
            else {alert ( "Invalidate!" );}
        }
    </script>
    <a href="Question_5.jsp" ><i>Next question 5</i></a>
</body>
</html>
