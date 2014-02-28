<%-- 
    Document   : signout
    Created on : Dec 20, 2013, 10:43:04 PM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Out : Asean Tourist</title>
    </head>
    <body>
        <h1>Sign Out</h1>
        <p>You are successfully logged out!</p>  
        <%
		session.invalidate();  
		response.sendRedirect("index-a.jsp");
        %>
    </body>
</html>
