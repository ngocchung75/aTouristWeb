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
        <title>aTourist Service 1.0 | Supplier Home</title>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <%@include file="pages/head.jsp" %>
    </head>
    <body>
        <s:if test="#session.logined != 'true' || #session.RoleID != 3">
            <%
                response.sendRedirect("login.jsp");
            %>
        </s:if>
        <div id="container">
            <div id="header">
                <a href="" id="header-image" target="_blank"></a>
                <ul class="subnav">
                    <li><a href="./logout.jsp" class="">Logout</a></li>
                    <li><a href="GetAllBookingView" class="">Manage Booking</a></li>
                    <li><a href="GetAllRoomView" class="">Manage Rooms</a></li>
                    <li><a href="GetSupplierHotelView" class="">Manage Hotel</a></li>
                    <li><a href="GetSupplierProfileView" class="">My Profile</a></li>
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
                        <a class="home" href="GetSupplierProfileView"><span class="home-options"></span>My Profile</a>
                        <a class="home" href="GetSupplierHotelView"><span class="home-bookings"></span>Manage Hotel</a>
                        <a class="home" href="GetAllRoomView"><span class="home-bookings"></span>Manage Rooms</a>
                        <a class="home" href="GetAllBookingView"><span class="home-rooms"></span>Manage Booking</a>

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
