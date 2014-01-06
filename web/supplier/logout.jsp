<%-- 
    Document   : logout
    Created on : Jan 7, 2014, 1:08:17 AM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sign Out</h1>
        <p>You are successfully logged out!</p>  
        <%
            session.invalidate();
            response.sendRedirect("login.jsp");
        %>
    </body>
</html>
