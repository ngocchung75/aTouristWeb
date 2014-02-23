<%-- 
    Document   : Welcome
    Created on : Nov 11, 2013, 12:30:20 AM
    Author     : CHUNG TOOC
--%>
<%@page import="model.RoomBean"%>
<%@page import="java.util.List"%>
<%
    List<RoomBean> roomList = (List<RoomBean>) session.getValue("all_room");
    RoomBean updateRoom = (RoomBean) session.getValue("update_room");
    int hotelID = (Integer) session.getValue("hotelID");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <title>aTourist Service 1.0 | Manage Rooms</title>
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
                    <li><a href="GetAllBookingView" class="">Manage Booking</a></li>
                    <li><a href="GetAllRoomView" class="focus">Manage Rooms</a></li>
                    <li><a href="GetSupplierHotelView" class="">Manage Hotel</a></li>
                    <li><a href="GetSupplierProfileView" class="">My Profile</a></li>
                    <li><a href="./welcome.jsp" class="">Home</a></li>
                </ul>
            </div>

            <div class="page-box">
                <div class="page-top">
                    <p class="page-title">
                        <span class="title-left"></span>
                        <span class="title-text">Manage Rooms</span>
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
                        <form action="AddNewRoom" method="post">
                            <b>Add New Room</b></br></br>
                            <input id="HotelIDNew" name="HotelIDNew" type="hidden" value="<%=hotelID%>">
                            Room Type Name:</br>
                            <input id="RTypeNameNew" name="RTypeNameNew" placeholder="Room Type Name" type="text" value=""> </br></br>
                            Room Number People:</br>
                            <input id="RNumPeopleNew" name="RNumPeopleNew" placeholder="Room Number People" type="text" value=""> </br></br>
                            Room Count:</br>
                            <input id="RCountNew" name="RCountNew" placeholder="Room Count" type="text" value=""> </br></br>
                            Room Description:</br>
                            <textarea id="RoomDesNew" name="RoomDesNew" placeholder="Room Description" rows="4"></textarea></br></br>
                            Room Link Image:</br>
                            <input id="RImageNew" name="RImageNew" placeholder="Room Link Image" type="text" value="temp/single-room.jpg"> </br></br>
                            Room Price:</br>
                            <input id="RoomPriceNew" name="RoomPriceNew" placeholder="Room Price" type="text" value=""> </br></br>

                            <input type="submit" value="Add New Room" class="button-changepass"/>
                        </form>
                        <div id="openUpdate" class="modalDialog">
                            <div>
                                <a href="#close" title="Close" class="close">X</a>
                                <form action="SaveUpdateRoom" method="post">
                                    <b>Update Information Room:</b></br></br>
                                    Room ID: <%=updateRoom.getRoomID()%> 
                                    <input id="RoomIDUpdate" name="RoomIDUpdate" type="hidden" value="<%=updateRoom.getRoomID()%>">
                                    <input id="HotelIDUpdate" name="HotelIDUpdate" type="hidden" value="<%=updateRoom.getHotelID()%>"></br></br>
                                    Room Type Name:</br>
                                    <input id="RTypeNameUpdate" name="RTypeNameUpdate" placeholder="Room Type Name" type="text" value="<%=updateRoom.getRTypeName()%>"> </br></br>
                                    Room Number People:</br>
                                    <input id="RNumPeopleUpdate" name="RNumPeopleUpdate" placeholder="Room Number People" type="text" value="<%=updateRoom.getRNumPeople()%>"> </br></br>
                                    Room Count:</br>
                                    <input id="RCountUpdate" name="RCountUpdate" placeholder="Room Count" type="text" value="<%=updateRoom.getRCount()%>"> </br></br>
                                    Room Description:</br>
                                    <input id="RoomDesUpdate" name="RoomDesUpdate" placeholder="Room Description" type="text" value="<%=updateRoom.getRoomDes()%>"> </br></br>
                                    Room Link Image:</br>
                                    <input id="RImageUpdate" name="RImageUpdate" placeholder="Room Link Image" type="text" value="<%=updateRoom.getRImage()%>"> </br></br>
                                    Room Price:</br>
                                    <input id="RoomPriceUpdate" name="RoomPriceUpdate" placeholder="Room Price" type="text" value="<%=updateRoom.getRoomPrice()%>"> </br></br>

                                    <input type="submit" value="Update Room"/>
                                </form>
                            </div>
                        </div>
                        </br></br>

                        <table>
                            <tr>
                                <th>Room ID</th>
                                <th>Room Type Name</th>
                                <th>Room Number People</th>
                                <th>Room Count</th>
                                <th>Room Description</th>
                                <th>Room Link Image</th>
                                <th>Room Price</th>
                                <th></th>
                                <th></th>
                            </tr>
                            <%for (int i = 0; i < roomList.size(); i++) {
                            %>
                            <tr>
                                <td><%=roomList.get(i).getRoomID()%></td>
                                <td><%=roomList.get(i).getRTypeName()%></td>
                                <td><%=roomList.get(i).getRNumPeople()%></td>
                                <td><%=roomList.get(i).getRCount()%></td>
                                <td><%=roomList.get(i).getRoomDes()%></td>
                                <td><%=roomList.get(i).getRImage()%></td>
                                <td><%=roomList.get(i).getRoomPrice()%></td>
                                <td><a href="UpdateRoom?RoomID=<%=roomList.get(i).getRoomID()%>">Edit</a></td>
                                <td><a href="DeleteRoom?RoomID=<%=roomList.get(i).getRoomID()%>">Delete</a></td>
                            </tr>
                            <%}%>
                        </table>

                        </br></br>
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
