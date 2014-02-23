<%-- 
    Document   : hoteldetails
    Created on : Jan 8, 2014, 11:44:19 AM
    Author     : CHUNG TOOC
--%>
<%@page import="model.HotelBean"%>
<%
    HotelBean detail_hotel = (HotelBean) session.getValue("detail_hotel");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en" class="a">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage : Asean Tourist</title>
        <%@include file="pages/header.jsp" %>
    </head>
    <body>
        <div id="root">
            <header id="top">
                <h1><a href="./" accesskey="h"></a></h1>
                <nav id="nav">
                    <s:if test="#session.logined == 'true' && #session.RoleID == 2">
                        <%@include file="pages/nav-user.jsp" %>
                    </s:if><s:else>
                        <%@include file="pages/nav.jsp" %>
                    </s:else>
                </nav>
                <%@include file="pages/search.jsp" %>
            </header>         

            <section id="content" class="cols-a">
                <article class="vcard">
                    <header class="module-a">
                        <h2 class="fn org"><%=detail_hotel.getHotelName()%></h2>
                        <p class="rating-a <%=detail_hotel.getHotelRating()%>">5/5</p>
                        <p class="link"><a href="GetAllHotel">Return</a></p>
                    </header>
                    <div>
                        <img src="<%=detail_hotel.getHotelImage()%>" alt="<%=detail_hotel.getHotelName()%>" width="693" height="230"> 
                    </div>
                    <div class="tabs-a">
                        <ul>
                            <li class="current">Overview</li>
                            <li>Facilities</li>
                            <li class="">Show on map</li>
                        </ul>
                        <div>
                            <div style="display: block;">
                                <p><%=detail_hotel.getHotelDes()%></p>
                                <ul class="list-b">
                                    <li><span>Check - In Time:</span> <%=detail_hotel.getTimeCheckIn()%></li>
                                    <li><span>Check - Out Time:</span> <%=detail_hotel.getTimeCheckOut()%></li>
                                </ul>
                                <p class="adr">Address: <span class="street-address"><%=detail_hotel.getHotelAddress()%>, <%=detail_hotel.getHotelCity()%></span></p>
                                <p class="tel">Phone: <%=detail_hotel.getHotelPhone()%></p>
                                <p>Website: <a rel="external" class="url" href="<%=detail_hotel.getHotelWebsite()%>"> <%=detail_hotel.getHotelWebsite()%></a></p>
                            </div>
                            <div style="display: none;">
                                <h3>Facilities</h3>
                                <p><%=detail_hotel.getHotelFac()%></p>
                                <h3>Policies</h3>
                                <p><%=detail_hotel.getHotelPol()%></p>
                            </div>

                            <div style="display: none;">
                                <%=detail_hotel.getHotelMap()%>
                            </div>
                            <div style="display: none;">

                            </div>

                        </div>
                    </div>
                </article>
                <aside>
                    <h2 class="fn org"><%=detail_hotel.getHotelName()%></h2>
                    <p class="scheme-a"><%=detail_hotel.getHotelAddress()%>, <%=detail_hotel.getHotelCity()%></p>
                    <p class="scheme-b">Price From <span>$<%=detail_hotel.getHotelPriceFrom()%> <span>/ Night</span></span></p>

                    <form action="HotelDetailBook" method="GetHotelDetailBook" class="form-a">
                        <fieldset>
                            <legend>Booking form</legend>
                            <p class="date-a">
                                <span>
                                    <label for="fcc">Check in</label>
                                    <input type="text" id="fcc" name="fcc" required>
                                </span>
                                <span>
                                    <label for="fcd">Check Out</label>
                                    <input type="text" id="fcd" name="fcd" required>
                                </span>
                            </p>
                            <s:if test="hasActionErrors()">
                                <div class="errors" style="color:red; font-size:12px; text-align:left; padding-left:0;">
                                    <s:actionerror/>
                                </div>
                            </s:if>
                            <p class="submit"><button type="submit">Book now</button></p>
                        </fieldset>
                    </form>

                </aside>
            </section>


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
