<%-- 
    Document   : Welcome
    Created on : Nov 11, 2013, 12:30:20 AM
    Author     : CHUNG TOOC
--%>
<%@page import="model.CityBean"%>
<%@page import="java.util.List"%>
<%@page import="model.HotelBean"%>
<%
    HotelBean hotelSupplier = (HotelBean) session.getValue("hotel_supplier");
    List<CityBean> cityList = (List<CityBean>) session.getValue("city_list");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <title>aTourist Service 1.0 | Manage Profile</title>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <link type="text/css" rel="stylesheet" href="css/style.css" />
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
                    <li><a href="GetAllRoomView" class="">Manage Rooms</a></li>
                    <li><a href="GetSupplierHotelView" class="focus">Manage Hotel</a></li>
                    <li><a href="GetSupplierProfileView" class="">My Profile</a></li>
                    <li><a href="./welcome.jsp" class="">Home</a></li>
                </ul>
            </div>

            <div class="page-box">
                <div class="page-top">
                    <p class="page-title">
                        <span class="title-left"></span>
                        <span class="title-text">Manage My Hotel</span>
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
                        <form action="SaveSupplierHotel" method="post">
                            <b>Manage Information My Hotel</b></br></br>
                            <input id="HotelIDUpdate" name="HotelIDUpdate" type="hidden" value="<%=hotelSupplier.getHotelID()%>">
                            <input id="UserIDUpdate" name="UserIDUpdate" type="hidden" value="<%=hotelSupplier.getUserID()%>">
                            Hotel Name:</br>
                            <input id="HotelNameUpdate" name="HotelNameUpdate" placeholder="Hotel Name" type="text" value="<%=hotelSupplier.getHotelName()%>"></br></br> 
                            Hotel Email:</br>
                            <input id="HotelEmailUpdate" name="HotelEmailUpdate" placeholder="Hotel Email" type="text" value="<%=hotelSupplier.getHotelEmail()%>"></br></br> 
                            Hotel Phone:</br>
                            <input id="HotelPhoneUpdate" name="HotelPhoneUpdate" placeholder="Hotel Phone" type="text" value="<%=hotelSupplier.getHotelPhone()%>"></br></br> 
                            Hotel Address:</br>
                            <input id="HotelAddressUpdate" name="HotelAddressUpdate" placeholder="Hotel Address" type="text" value="<%=hotelSupplier.getHotelAddress()%>"></br></br> 
                            City Name:</br>
                            <select id="CityIDUpdate" name="CityIDUpdate">
                                <%for (int i = 0; i < cityList.size(); i++) {
                                        if (cityList.get(i).getCityID() == hotelSupplier.getCityID()) {
                                %>
                                <option value="<%=cityList.get(i).getCityID()%>" selected="selected"> <%=cityList.get(i).getHotelCity()%> </option>
                                <%} else {%>
                                <option value="<%=cityList.get(i).getCityID()%>"> <%=cityList.get(i).getHotelCity()%> </option>
                                <%}
                                    }%>
                            </select></br></br> 
                            Hotel Google Map:</br>
                            <textarea id="HotelMapUpdate" name="HotelMapUpdate" rows="4"><%=hotelSupplier.getHotelMap()%></textarea></br></br> 
                            Hotel Rating:</br>
                            <input id="HotelRatingUpdate" name="HotelRatingUpdate" placeholder="Hotel Rating" type="text" value="<%=hotelSupplier.getHotelRating()%>"></br></br> 
                            Hotel Description:</br>
                            <textarea id="HotelDesUpdate" name="HotelDesUpdate" rows="4"><%=hotelSupplier.getHotelDes()%></textarea></br></br> 
                            Hotel Description Short:</br>
                            <textarea id="HotelDesShortUpdate" name="HotelDesShortUpdate" rows="4"><%=hotelSupplier.getHotelDesShort()%></textarea></br></br> 
                            Hotel Policies:</br>
                            <textarea id="HotelPolUpdate" name="HotelPolUpdate" rows="4"><%=hotelSupplier.getHotelPol()%></textarea></br></br>
                            Hotel Facilities:</br>
                            <textarea id="HotelFacUpdate" name="HotelFacUpdate" rows="4"><%=hotelSupplier.getHotelFac()%></textarea></br></br> 
                            Hotel Image:</br>
                            <input id="HotelImageUpdate" name="HotelImageUpdate" placeholder="Hotel Image" type="text" value="<%=hotelSupplier.getHotelImage()%>"></br></br> 
                            Hotel Website:</br>
                            <input id="HotelWebsiteUpdate" name="HotelWebsiteUpdate" placeholder="Hotel Website" type="text" value="<%=hotelSupplier.getHotelWebsite()%>"></br></br> 
                            Hotel Price From:</br>
                            <input id="HotelPriceFromUpdate" name="HotelPriceFromUpdate" placeholder="Hotel Price From" type="text" value="<%=hotelSupplier.getHotelPriceFrom()%>"></br></br> 
                            Time Check In:</br>
                            <input id="TimeCheckInUpdate" name="TimeCheckInUpdate" placeholder="Time Check In" type="text" value="<%=hotelSupplier.getTimeCheckIn()%>"></br></br> 
                            Time Check Out:</br>
                            <input id="TimeCheckOutUpdate" name="TimeCheckOutUpdate" placeholder="Time Check Out" type="text" value="<%=hotelSupplier.getTimeCheckOut()%>"></br></br> 

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
