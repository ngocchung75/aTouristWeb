<%-- 
    Document   : Welcome
    Created on : Nov 11, 2013, 12:30:20 AM
    Author     : CHUNG TOOC
--%>
<%@page import="model.UserBean"%>
<%
    UserBean userSupplier = (UserBean) session.getValue("user_supplier");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <title>aTourist Service 1.0 | Manage Profile</title>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <link type="text/css" rel="stylesheet" href="../admin/css/style.css" />
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
                    <li><a href="./welcome.jsp" class="">Manage Booking</a></li>
                    <li><a href="./welcome.jsp" class="">Manage Rooms</a></li>
                    <li><a href="GetSupplierHotelView" class="">Manage Hotel</a></li>
                    <li><a href="GetSupplierProfileView" class="focus">My Profile</a></li>
                    <li><a href="./welcome.jsp" class="">Home</a></li>
                </ul>
            </div>

            <div class="page-box">
                <div class="page-top">
                    <p class="page-title">
                        <span class="title-left"></span>
                        <span class="title-text">Manage Profile</span>
                        <span class="title-right"></span>						
                    </p>
                </div>
                <div class="page-middle">

                    <div id="content">
                        </br>
                        <s:if test="hasActionErrors()">
                            <div class="errors" style="color:red; font-size:12px; text-align:left; padding-left:0;">
                                <s:actionerror/>
                            </div>
                        </s:if>
                        <form action="SaveSupplierProfile" method="post">
                            <b>My Profile</b></br></br>
                            <input id="UserNameUpdate" name="UserNameUpdate" type="hidden" value="<%=userSupplier.getUserName()%>"></br>
                            Full Name:</br>
                            <input id="FullNameUpdate" name="FullNameUpdate" placeholder="Full Name" type="text" value="<%=userSupplier.getFullName()%>"></br></br> 
                            Gender:</br>
                            <input id="GenderUpdate" name="GenderUpdate" placeholder="Gender (Male/Female)" type="text" value="<%=userSupplier.getGender()%>"></br></br> 
                            Year Of Birth:</br>
                            <input id="YearOfBirthUpdate" name="YearOfBirthUpdate" placeholder="Year Of Birth" type="text" value="<%=userSupplier.getYearOfBirth()%>"></br></br> 
                            Email:</br>
                            <input id="EmailUpdate" name="EmailUpdate" placeholder="Email" type="text" value="<%=userSupplier.getEmail()%>"></br></br> 
                            Mobile:</br>
                            <input id="PhoneUpdate" name="PhoneUpdate" placeholder="Phone" type="text" value="<%=userSupplier.getPhone()%>"></br></br> 
                            Address:</br>
                            <input id="AddressUpdate" name="AddressUpdate" placeholder="Address" type="text" value="<%=userSupplier.getUserAddress()%>"></br></br> 
                            
                            <input type="submit" value="Save" class="button-changepass"/></br></br>
                        </form>

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
