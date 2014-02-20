<%-- 
    Document   : Welcome
    Created on : Nov 11, 2013, 12:30:20 AM
    Author     : CHUNG TOOC
--%>

<%@page import="model.StatusBean"%>
<%@page import="model.BookingBean"%>
<%@page import="java.util.List"%>
<%
    List<BookingBean> bookList = (List<BookingBean>) session.getValue("all_booking");
    List<StatusBean> statusList = (List<StatusBean>) session.getValue("all_status");
    BookingBean updateBook = (BookingBean) session.getValue("update_booking");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <title>aTourist Service 1.0 | Manage Booking</title>
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
                    <li><a href="GetAllBookingView" class="focus">Manage Booking</a></li>
                    <li><a href="GetAllRoomView" class="">Manage Rooms</a></li>
                    <li><a href="GetSupplierHotelView" class="">Manage Hotel</a></li>
                    <li><a href="GetSupplierProfileView" class="">My Profile</a></li>
                    <li><a href="./welcome.jsp" class="">Home</a></li>
                </ul>
            </div>

            <div class="page-box">
                <div class="page-top">
                    <p class="page-title">
                        <span class="title-left"></span>
                        <span class="title-text">Manage Booking</span>
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

                        <div id="openUpdate" class="modalDialog">
                            <div>
                                <a href="#close" title="Close" class="close">X</a>
                                <form action="SaveUpdateBooking" method="post">
                                    <b>Update Status Booking:</b></br></br>
                                    Book ID: <%=updateBook.getBookID()%> 
                                    <input id="BookIDUpdate" name="BookIDUpdate" type="hidden" value="<%=updateBook.getBookID()%>"></br></br>
                                    Status Name:</br>
                                    <select id="StatusIDUpdate" name="StatusIDUpdate">
                                        <%for (int i = 0; i < statusList.size(); i++) {
                                                if (statusList.get(i).getStatusID() == updateBook.getStatusID()) {
                                        %>
                                        <option value="<%=statusList.get(i).getStatusID()%>" selected="selected"> <%=statusList.get(i).getStatusName()%> </option>
                                        <%} else {%>
                                        <option value="<%=statusList.get(i).getStatusID()%>"> <%=statusList.get(i).getStatusName()%> </option>
                                        <%}
                                            }%>
                                    </select></br></br> 
                                    <input type="submit" value="Update Booking"/>
                                </form>
                            </div>
                        </div>
                        </br></br>

                        <table>
                            <tr>
                                <th>Book ID</th>
                                <th>User Name</th>
                                <th>Room ID</th>
                                <th>Check in</th>
                                <th>Check Out</th>
                                <th>Room Count</th>
                                <th>Nights</th>
                                <th>Room Price</th>
                                <th>Total</th>
                                <th>Status Name</th>
                                <th></th>
                                <th></th>
                            </tr>
                            <%for (int i = 0; i < bookList.size(); i++) {
                            %>
                            <tr>
                                <td><%=bookList.get(i).getBookID()%></td>
                                <td><%=bookList.get(i).getUserName()%></td>
                                <td><%=bookList.get(i).getRoomID()%></td>
                                <td><%=bookList.get(i).getStartDate()%></td>
                                <td><%=bookList.get(i).getEndDate()%></td>
                                <td><%=bookList.get(i).getRCountBook()%></td>
                                <td><%=bookList.get(i).getNights()%></td>
                                <td><%=bookList.get(i).getRPrices()%></td>
                                <td><%=bookList.get(i).getTotal()%></td>
                                <td><%=bookList.get(i).getStatusName()%></td>
                                <td><a href="UpdateBooking?BookID=<%=bookList.get(i).getBookID()%>">Edit</a></td>
                                <td><a href="DeleteBooking?BookID=<%=bookList.get(i).getBookID()%>">Delete</a></td>
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
