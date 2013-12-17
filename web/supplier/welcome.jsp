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
        <title>aTourist Service 1.0 | Home</title>
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
        <div id="container">
            <div id="header">
                <a href="" id="header-image" target="_blank"></a>
                <ul class="nav">
                    <li><a href="./welcome.jsp" class="nav-home focus"></a></li>
                    <li><a href="./welcome.jsp" class="nav-bookings"></a></li>
                    <li><a href="./welcome.jsp" class="nav-rooms"></a></li>					
                    <li><a href="./welcome.jsp" class="nav-reports"></a></li>
                    <li><a href="./welcome.jsp" class="nav-invoices"></a></li>
                    <li><a href="./welcome.jsp" class="nav-install"></a></li>
                    <li><a href="./welcome.jsp" class="nav-options"></a></li>
                    <li><a href="./welcome.jsp" class="nav-preview" target="_blank"></a></li>
                    <li><a href="./welcome.jsp" class="nav-logout"></a></li>
                </ul>
                <ul class="subnav">
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
                        <a class="home" href="./welcome.jsp"><span class="home-bookings"></span>View and manage users</a>
                        <a class="home" href="./welcome.jsp"><span class="home-rooms"></span>Room, Extras and Prices</a>
                        <a class="home" href="./welcome.jsp"><span class="home-reports"></span>Reports</a>
                        <a class="home" href="./welcome.jsp"><span class="home-invoices"></span>Invoices</a>
                        <a class="home" href="./welcome.jsp"><span class="home-options"></span>Options and Account Details</a>
                        <a class="home" href="./welcome.jsp"><span class="home-install"></span>Installation instructions</a>
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