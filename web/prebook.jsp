<%-- 
    Document   : prebook
    Created on : Jan 10, 2014, 12:23:26 AM
    Author     : CHUNG TOOC
--%>
<%@page import="model.RoomBean"%>
<%@page import="java.util.List"%>
<%@page import="model.HotelBean"%>
<%@page import="control.SearchResultAction"%>
<%
    SearchResultAction listbooknow = (SearchResultAction) session.getValue("list-booknow");
    HotelBean detail_hotel = (HotelBean) session.getValue("detail_hotel");
    List<RoomBean> listroom = (List<RoomBean>) session.getValue("list-room");
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
        <s:if test="#session.logined != 'true'">
            <%
                response.sendRedirect("signup.jsp");
            %>
        </s:if>
        <s:if test="#session.searched != 'true'">
            <%
                response.sendRedirect("GetTopHotel");
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
            <s:form action="GetBookingView" method="GetBookingView">
                <section id="content" class="cols-a">
                    <article class="vcard">
                        <header class="module-a">
                            <h2 class="fn org"><%=detail_hotel.getHotelName()%></h2>
                            <p class="rating-a <%=detail_hotel.getHotelRating()%>">5/5</p>
                            <p class="link"><a href="GetAllHotel">Return</a></p>
                        </header>
                        <div class="tabs-a">
                            <ul>
                                <li class="current">Choose Your Room</li>
                            </ul>
                            <div>
                                <div>
                                    <ul class="list-b">
                                        <li><span>Check in:</span> <%=listbooknow.getFcc()%></li>
                                        <li><span>Check out:</span> <%=listbooknow.getFcd()%></li>
                                        <li><span>Nights:</span> <%=listbooknow.getToNight()%></li>
                                    </ul>

                                    <div class="news-a">
                                        <%for (int i = 0; i < listroom.size(); i++) {
                                        %>
                                        <article>
                                            <header>
                                                <h2><a href="#"><%=listroom.get(i).getRTypeName()%></a></h2> 
                                                <figure><img src="<%=listroom.get(i).getRImage()%>" alt="<%=listroom.get(i).getRTypeName()%>" width="128" height="102"></figure>
                                                <div class="fit-a"></div>
                                            </header>
                                            <p style="color: #ff5f46; font-weight: 700; font-size: 1.23em;">$360 / night</p>
                                            <p>People max: <%=listroom.get(i).getRNumPeople()%></p>
                                            <p>Room info: <%=listroom.get(i).getRoomDes()%></p>
                                            <p>No. Rooms: <select id="roomsel<%=listroom.get(i).getRoomID()%>" name="roomsel<%=listroom.get(i).getRoomID()%>">
                                                    <%for (int j = 0; j <= listroom.get(i).getRCount(); j++) {
                                                    %>
                                                    <option value="<%=j%>"><%=j%></option>
                                                    <%}%>
                                                </select>
                                            </p>
                                        </article>
                                        <%}%>
                                    </div>

                                    <s:if test="hasActionErrors()">
                                        <div class="errors" style="color:red; font-size:12px; text-align:left; padding-left:0;">
                                            <s:actionerror/>
                                        </div>
                                    </s:if>
                                    <s:else>
                                        <div style="border-top: 1px dashed #e5e5e5; border-top-style: solid;"></div>
                                        <input type="submit" value=" Book now " class="button-book" style="margin-left: 560px; margin-top: 10px;">
                                    </s:else>

                                </div>
                            </div>
                        </div>
                    </article>
                    <aside>
                        <h2 class="fn org"><%=detail_hotel.getHotelName()%></h2>
                        <p class="scheme-a"><%=detail_hotel.getHotelAddress()%><%=detail_hotel.getHotelCity()%></p>
                        <p class="scheme-b">Price From <span>$ <%=detail_hotel.getHotelPriceFrom()%> <span>/ Night</span></span></p>
                    </aside>
                </section>
            </s:form>
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
