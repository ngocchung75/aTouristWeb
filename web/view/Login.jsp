<%-- 
    Document   : Login
    Created on : Nov 11, 2013, 12:19:33 AM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Struts 2 - Login Application</title>
    </head>
    <body>
        <h2>Struts 2 - Login Application</h2>
        <s:actionerror />
        <s:form action="login.action" method="post">
            <s:textfield name="username" key="label.username" size="20" />
            <s:password name="password" key="label.password" size="20" />
            <s:submit method="execute" key="label.login" align="center" />
        </s:form>
    </body>
</html>

