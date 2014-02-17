<%-- 
    Document   : Welcome
    Created on : Nov 11, 2013, 12:30:20 AM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <title>aTourist Service 1.0 | Admin Home</title>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <link type="text/css" rel="stylesheet" href="libs/jquery/ui/css/flick/jquery.ui.core.css" />
        <link type="text/css" rel="stylesheet" href="libs/jquery/ui/css/flick/jquery.ui.theme.css" />
        <link type="text/css" rel="stylesheet" href="libs/jquery/ui/css/flick/jquery.ui.tabs.css" />
        <link type="text/css" rel="stylesheet" href="css/admin.css" />
        <script type="text/javascript" src="libs/jquery/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="js/admin-core.js"></script>
        <script type="text/javascript" src="js/jquery.ui.core.min.js"></script>
        <script type="text/javascript" src="js/jquery.ui.widget.min.js"></script>
        <script type="text/javascript" src="js/jquery.ui.tabs.min.js"></script>	
    </head>
    <body>
        <s:if test="#session.logined != 'true' || #session.RoleID != 1">
            <%
                response.sendRedirect("login.jsp");
            %>
        </s:if>
        <div id="container">
            <div id="header">
                <a href="" id="header-image" target="_blank"></a>
                <ul class="subnav">
                    <li><a href="./welcome.jsp" class="">Manage Status</a></li>
                    <li><a href="./welcome.jsp" class="">Manage City</a></li>
                    <li><a href="./welcome.jsp" class="">Manage Role</a></li>
                    <li><a href="./welcome.jsp" class="">Manage Top Hotel</a></li>
                    <li><a href="./welcome.jsp" class="">Manage Hotel</a></li>
                    <li><a href="GetAllUserView" class="">Manage User</a></li>
                    <li><a href="./welcome.jsp" class="focus">Home</a></li>
                </ul>
            </div>

            <div class="page-box">
                <div class="page-top">
                    <p class="page-title">
                        <span class="title-left"></span>
                        <span class="title-text">Home</span>
                        <span class="title-right"></span>						
                    </p>
                </div>
                <div class="page-middle">

                    <div id="content">
                        <a class="home" href="./welcome.jsp"><span class="home-options"></span>Manage User</a>
                        <a class="home" href="./welcome.jsp"><span class="home-bookings"></span>Manage Hotel</a>
                        <a class="home" href="./welcome.jsp"><span class="home-bookings"></span>Manage Top Hotel</a>
                        <a class="home" href="./welcome.jsp"><span class="home-invoices"></span>Manage Role</a>
                        <a class="home" href="./welcome.jsp"><span class="home-bookings"></span>Manage City</a>
                        <a class="home" href="./welcome.jsp"><span class="home-invoices"></span>Manage Status</a>
                    </div> <!-- content -->

                </div> <!-- page-middle -->
                <div class="page-bottom"></div>
            </div> <!-- page-box -->

            <div class="footer">
                Copyright &copy; 2013 - 2014 by <a href="http://atourist.net/" target="_blank">Bamboo Co., Ltd</a>
            </div>

        </div>
    </body>
</html>
