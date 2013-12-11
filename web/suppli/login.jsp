<%-- 
    Document   : login
    Created on : Dec 11, 2013, 8:38:35 PM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <h3>Supplier Login</h3>
                <form action="http://localhost/HotelBooking/index.php?controller=Admin&amp;action=login" method="post" id="frmLoginAdmin" class="login-form">
                    <input type="hidden" name="login_user" value="1" />
                    <table class="login-table" cellpadding="0" cellspacing="0">
                        <tr>
                            <th>Username:</th>
                            <th colspan="2">Password:</th>
                        </tr>
                        <tr>
                            <td><input name="login_username" type="text" class="text-login w250" id="login_username" /></td>
                            <td><input name="login_password" type="password" class="text-login w250" id="login_password" /></td>
                            <td><input type="submit" value="" class="button button_login" /></td>
                        </tr>
                    </table>
                    <ul id="login-errors">
                        <li><label for="login_username" class="error">Username is required</label></li>
                        <li><label for="login_password" class="error">Password is required</label></li>
                    </ul>
                </form>			</div>

            <div class="footer">
                <a href="http://www.phpjabbers.com/" target="_blank">PHP Scripts</a> Copyright &copy; 2013 <a href="http://www.stivasoft.com/" target="_blank">StivaSoft Ltd</a>
            </div>
        </div>
    </body>
</html>
