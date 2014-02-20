<%-- 
    Document   : mybooking
    Created on : Jan 6, 2014, 11:11:46 AM
    Author     : CHUNG TOOC
--%>
<%@page import="model.StatusBean"%>
<%@page import="model.BookingBean"%>
<%@page import="java.util.List"%>
<%
    List<BookingBean> bookList = (List<BookingBean>) session.getValue("all_booking");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="rightpage2">
    <div id="ctl00_ctl00_MainContent_ContentMain_udpBooking">
        <p class="text_head">My Bookings</p>
        <s:if test="hasActionErrors()">
            <div class="errors" style="color:red; font-size:12px; text-align:left; padding-left:0;">
                <s:actionerror/>
            </div>
        </s:if>
        <table cellspacing="0" cellpadding="0" border="0" style="font-size:8px">
            <tr>
                <th>Book ID</th>
                <th style="text-align:left">Hotel Name</th>
                <th style="text-align:left">Room Name</th>
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
                <td><%=bookList.get(i).getHotelName()%></td>
                <td><%=bookList.get(i).getRoomName()%></td>
                <td><%=bookList.get(i).getStartDate()%></td>
                <td><%=bookList.get(i).getEndDate()%></td>
                <td><%=bookList.get(i).getRCountBook()%></td>
                <td><%=bookList.get(i).getNights()%></td>
                <td><%=bookList.get(i).getRPrices()%></td>
                <td><%=bookList.get(i).getTotal()%></td>
                <td><%=bookList.get(i).getStatusName()%></td>
                <%if (bookList.get(i).getStatusID() == 1) {
                %>
                <td><a href="CancelBooking?BookID=<%=bookList.get(i).getBookID()%>">Cancel</a></td>
                <td><a href="https://www.baokim.vn/payment/product/version11?business=<%=bookList.get(i).getHotelEmail()%>&id=&order_description=&product_name=Hotel+Name:+<%=bookList.get(i).getHotelName()%>;+BookID:+<%=bookList.get(i).getBookID()%>;+Booking+Room:+<%=bookList.get(i).getRoomName()%>;+Room+Count:+<%=bookList.get(i).getRCountBook()%>&product_price=<%=bookList.get(i).getRPrices()%>&product_quantity=<%=bookList.get(i).getRCountBook()%>&total_amount=<%=bookList.get(i).getTotalVND()%>&url_cancel=&url_detail=&url_success=http%3A%2F%2Fdemo.atourist.net%2FaTouristWeb%2Fsuccess-payment.jsp"><img src="http://developer.baokim.vn/uploads/baokim_btn/paynow-s.png" alt="Secure payments with Bao Kim!" border="0" style="width: 95px;" title="Secure payments with Bao Kim!"/></a>
                </td>
                <%} else {%>
                <td></td>
                <td></td>
                <%}%>
            </tr>
            <%}%>
        </table>

        <div id="ctl00_ctl00_MainContent_ContentMain_upg" style="display:none;" role="status" aria-hidden="true">
            <div class="rewardMask">&nbsp;</div>
            <img src="https://img.agoda.net/images/default/Rewardv2/preload.gif" width="20" height="20" alt="" class="loadingImage">
        </div>
    </div>
</div>
