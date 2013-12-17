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
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <link type="text/css" rel="stylesheet" href="libs/jquery/ui/css/flick/jquery.ui.core.css" />
        <link type="text/css" rel="stylesheet" href="libs/jquery/ui/css/flick/jquery.ui.theme.css" />
        <link type="text/css" rel="stylesheet" href="libs/jquery/ui/css/flick/jquery.ui.tabs.css" />
        <link type="text/css" rel="stylesheet" href="css/admin.css" />
        <script type="text/javascript" src="libs/jquery/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="js/admin-core.js"></script>
        <script type="text/javascript" src="libs/jquery/ui/js/jquery.ui.core.min.js"></script>
        <script type="text/javascript" src="libs/jquery/ui/js/jquery.ui.widget.min.js"></script>
        <script type="text/javascript" src="libs/jquery/ui/js/jquery.ui.tabs.min.js"></script>
        <script type="text/javascript" src="libs/jquery/plugins/validate/js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="js/admin.js"></script>	
    </head>
    <body>
        <div id="container">
            <div id="login-content">
                <a href="" id="login-image" target="_blank"></a>
                <h3>Admin Login</h3>
                <form action="login-admin" method="post" id="frmLoginAdmin" class="login-form">
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
