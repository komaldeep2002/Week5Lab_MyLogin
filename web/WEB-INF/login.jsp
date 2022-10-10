<%-- 
    Document   : login
    Created on : Oct 9, 2022, 7:10:54 PM
    Author     : Komaldeep Kaur Virk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login">
            Username: <input type="text" value="${username}" name="username"><br>
            Password: <input type="password" value="${password}" name="password"><br>
            <input type="submit"  value="Login">
            <p>${res}</p>
        </form>

    </body>
</html>
