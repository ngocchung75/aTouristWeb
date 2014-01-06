<%-- 
    Document   : index
    Created on : Jan 7, 2014, 1:03:47 AM
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
        <h1>Hello World!</h1>
        <%
            response.sendRedirect("login.jsp");
        %>
    </body>
</html>
