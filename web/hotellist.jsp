<%-- 
    Document   : hotellist
    Created on : Jan 8, 2014, 10:11:06 AM
    Author     : CHUNG TOOC
--%>
<%@page import="model.CityBean"%>
<%@page import="model.HotelBean"%>
<%@page import="java.util.List"%>
<%
    List<HotelBean> hotellist = (List<HotelBean>) session.getValue("all_hotel");
    List<CityBean> citylist = (List<CityBean>) session.getValue("city_list");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en" class="a">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel List : Asean Tourist</title>
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
            <article id="content" class="cols-c">
                <div>
                    <div>
                        <img src="temp/danang-rong.jpg" alt="Placeholder" width="693" height="200"> 
                    </div>

                    <div class="news-a">

                        <%for (int i = 0; i < hotellist.size(); i++) {
                        %>
                        <article>
                            <header>
                                <h2><a href="GetDetailHotel?HotelID=<%=hotellist.get(i).getHotelID()%>"><%=hotellist.get(i).getHotelName()%></a></h2> <p class="rating-a <%=hotellist.get(i).getHotelRating()%>">5/5</p>
                                <figure><img src="<%=hotellist.get(i).getHotelImage()%>" alt="Placeholder" width="128" height="102"></figure>
                                <p><%=hotellist.get(i).getHotelAddress()%>, <%=hotellist.get(i).getHotelCity()%></p><div class="fit-a"></div>
                            </header>
                            <p><%=hotellist.get(i).getHotelDesShort()%></p>
                            <footer>
                                <p class="link-b"><a href="GetDetailHotel?HotelID=<%=hotellist.get(i).getHotelID()%>">View Details</a></p>
                            </footer>
                        </article>
                        <%}%>
                    </div>
                </div>
                <aside>
                    <s:form action="GetSearchResult" method="GetSearchResult">
                        <div class="form-c">
                            <fieldset>
                                <legend>Book now</legend>
                                <h3><span>01.</span> What?</h3>
                                <ul class="check-c">
                                    <li><label for="fcaa"><input type="radio" id="fcaa" name="fca" value="Hotels"> Hotels</label></li>
                                    <li><label for="fcab"><input type="radio" id="fcab" name="fca" value="Flights"> Flights</label></li>
                                    <li><label for="fcac"><input type="radio" id="fcac" name="fca" value="Cars"> Cars</label></li>
                                </ul>
                                <h3><span>02.</span> Where?</h3>
                                <p class="select-c">
                                    <label for="fcb">Location</label>
                                    <select id="fcb" name="fcb">
                                        <%for (int i = 0; i < citylist.size(); i++) {
                                        %>
                                        <option value="<%=citylist.get(i).getCityID()%>"><%=citylist.get(i).getHotelCity()%></option>
                                        <%}%>
                                    </select>
                                </p>
                                <h3><span>03.</span> When?</h3>
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
                                <p class="submit"><button type="submit">Search</button></p>
                            </fieldset>
                        </s:form>

                </aside>
            </article>
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
