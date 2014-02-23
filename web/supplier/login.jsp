<%-- 
    Document   : login
    Created on : Dec 11, 2013, 8:38:35 PM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>aTourist Service 1.0 | Login</title>
        <%@include file="pages/head.jsp" %>
    </head>
    <body>
        <s:if test="#session.logined == 'true' && #session.RoleID == 3">
            <%
                response.sendRedirect("welcome.jsp");
            %>
        </s:if>
        <div id="container">
            <div id="login-content">
                <a href="" id="login-image" target="_blank"></a>
                <h3>Supplier Login</h3>
                <form action="login-supplier" method="post" id="frmLoginAdmin" class="login-form">
                    <table class="login-table" cellpadding="0" cellspacing="0">
                        <tr>
                            <th>Username:</th>
                            <th colspan="2">Password:</th>
                        </tr>
                        <tr>
                            <td><input name="username" type="text" class="text-login w250" id="username" /></td>
                            <td><input name="password" type="password" class="text-login w250" id="password" /></td>
                            <td><input type="submit" method="execute" value="" class="button button_login" /></td>
                        </tr>
                    </table>

                    <s:if test="hasActionErrors()">
                        <div class="errors">
                            <s:actionerror/>
                        </div>
                    </s:if>
                </form>			
            </div>

            <div class="footer">
                Copyright &copy; 2013 - 2014 by <a href="http://atourist.net/" target="_blank">Bamboo Co., Ltd</a>
            </div>
        </div>
    </body>
</html>
