<%-- 
    Document   : check-book
    Created on : Jan 14, 2014, 12:08:57 AM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <s:if test="#session.searched == 'true'">
        <%
            response.sendRedirect("prebook.jsp");
        %>
    </s:if>
    <s:else>
        <%
            response.sendRedirect("GetTopHotel");
        %>
    </s:else>
    <h1>Hello World!</h1>
</body>
</html>
