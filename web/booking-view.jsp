<%-- 
    Document   : booking-view
    Created on : Jan 10, 2014, 1:19:43 AM
    Author     : CHUNG TOOC
--%>
<%@page import="model.RoomBookBean"%>
<%@page import="model.NoRoomBean"%>
<%@page import="model.RoomBean"%>
<%@page import="java.util.List"%>
<%@page import="model.HotelBean"%>
<%@page import="control.SearchResultAction"%>
<%
    SearchResultAction listbooknow = (SearchResultAction) session.getValue("list-booknow");
    HotelBean detail_hotel = (HotelBean) session.getValue("detail_hotel");
    List<RoomBean> listroom = (List<RoomBean>) session.getValue("list-room");
    List<NoRoomBean> noroomlist = (List<NoRoomBean>) session.getValue("noroom-list");
    List<RoomBookBean> roombooklist = (List<RoomBookBean>) session.getValue("roombook-list");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en" class="a">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book view : Asean Tourist</title>
        <%@include file="pages/header.jsp" %>
    </head>
    <body>
        <s:if test="#session.logined != 'true' || #session.RoleID != 2">
            <%
                response.sendRedirect("signup.jsp");
            %>
        </s:if>
        <div id="root">
            <header id="top">
                <h1><a href="./" accesskey="h"></a></h1>
                <nav id="nav">
                    <%@include file="pages/nav-user.jsp" %>
                </nav>
                <%@include file="pages/search.jsp" %>
            </header>         
            <form id="content" action="BookingSubmit" method="post" class="form-e">
                <fieldset class="cols-d">
                    <div>
                        <h3>Travel Information</h3>
                        <h4 class="scheme-g">Traveller Infomation</h4>
                        <ul class="list-c">
                            <li><span>Full Name</span> ${sessionScope.FullName}</li>
                            <li><span>Email Address</span> ${sessionScope.Email}</li>
                            <li><span>Address</span> ${sessionScope.UserAddress}</li>
                            <li><span>Mobile</span> ${sessionScope.Phone}</li>
                        </ul>

                        <h4 class="scheme-g">Rooms Infomation</h4>
                        <div class="news-a">
                            <%for (int i = 0; i < roombooklist.size(); i++) {
                            %>
                            <article>
                                <header>
                                    <h2><a href="#"><%=roombooklist.get(i).getRTypeName()%></a></h2> 
                                    <figure><img src="<%=roombooklist.get(i).getRImage()%>" alt="<%=roombooklist.get(i).getRTypeName()%>" width="128" height="102"></figure>
                                    <div class="fit-a"></div>
                                </header>
                                <ul class="list-c">
                                    <li><span>No. Rooms:</span> <%=roombooklist.get(i).getNoRoomCount()%></li>
                                    <li><span>Time:</span> <%=listbooknow.getToNight()%> Nights</li>
                                    <li><span>Price per night:</span> <%=roombooklist.get(i).getRoomPrice()%></li>
                                    <li><span>Total:</span> <%=roombooklist.get(i).getPriceTotal()%></li>
                                </ul>
                            </article>
                            <%}%>
                        </div>

                        <div style="border-top: 1px dashed #e5e5e5;border-top-style: solid;"></div>
                        <h4 class="scheme-g">Accept and confirm</h4>
                        <p class="check-a"><label for="feo"><input type="checkbox" id="feo" name="feo" value="check"> I agree to the booking conditions.</label></p>
                                <s:if test="hasActionErrors()">
                            <div class="errors" style="color:red; font-size:12px; text-align:left; padding-left:0;">
                                <s:actionerror/>
                            </div>
                        </s:if>
                        <p class="scheme-h">Grand Total : <span><span>$</span>${sessionScope.grandTotal}</span></p>
                        <p class="link-c"><button type="submit">Submit</button></p>
                    </div>
                    <aside>
                        <h3>Hotel Summary</h3>
                        <div class="vcard a">
                            <h4 class="fn org"><%=detail_hotel.getHotelName()%></h4>
                            <p class="adr"><%=detail_hotel.getHotelAddress()%>, <%=detail_hotel.getHotelCity()%></p>
                        </div>
                        <ul class="list-c">
                            <li><span>Email Address</span> <%=detail_hotel.getHotelEmail()%></li>
                            <li><span>Mobile</span> <%=detail_hotel.getHotelPhone()%></li>
                            <li><span>Check in</span> <%=listbooknow.getFcc()%></li>
                            <li><span>Check out</span> <%=listbooknow.getFcd()%></li>
                            <li><span>Time</span> <%=listbooknow.getToNight()%> Nights</li>
                        </ul>

                    </aside>
                </fieldset>
            </form>

            <footer id="footer">
                <%@include file="pages/footer1.jsp" %>
                <%@include file="pages/footer.jsp" %>
            </footer>
        </div>
        <script src="http://maps.google.com/maps/api/js?sensor=false&amp;libraries=geometry&amp;language=en"></script>
        <script type="text/javascript">
            head.js('javascript/jquery.min.js', 'javascript/jquery-ui.min.js', 'javascript/scripts.js', 'javascript/mobile.js');
        </script>
    </body>
</html>
