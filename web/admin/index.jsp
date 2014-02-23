<%-- 
    Document   : index
    Created on : Jan 7, 2014, 12:57:21 AM
    Author     : CHUNG TOOC
--%>

<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html" import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <s:if test="#session.logined == 'true' && #session.RoleID == 1">
            <%
                response.sendRedirect("welcome.jsp");
            %>
        </s:if>
        <s:if test="#session.logined != 'true' || #session.RoleID != 1">
            <%
                response.sendRedirect("login.jsp");
            %>
        </s:if>
    </body>
</html>
