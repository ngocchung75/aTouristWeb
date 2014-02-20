<%-- 
    Document   : search-result
    Created on : Jan 10, 2014, 2:54:57 AM
    Author     : CHUNG TOOC
--%>
<%@page import="model.HotelBean"%>
<%@page import="java.util.List"%>
<%@page import="control.SearchResultAction"%>
<%
    SearchResultAction listbooknow = (SearchResultAction) session.getValue("list-booknow");
    List<HotelBean> hotellist = (List<HotelBean>) session.getValue("all_hotel");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en" class="a">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Result : Asean Tourist</title>
        <%@include file="pages/header.jsp" %>
    </head>
    <body>
        <div id="root">
            <header id="top">
                <h1><a href="./" accesskey="h"></a></h1>
                <nav id="nav">
                    <s:if test="#session.logined != 'true'">
                        <%@include file="pages/nav.jsp" %>
                    </s:if><s:else>
                        <%@include file="pages/nav-user.jsp" %>
                    </s:else>
                </nav>
                <%@include file="pages/search.jsp" %>
            </header>         
            <article id="content" class="cols-c">
                <div>
                    <div>
                        <img src="temp/danang-rong.jpg" alt="Placeholder" width="693" height="200"> 
                    </div>

                    <s:if test="hasActionErrors()">
                        <div class="errors" style="color:red; font-size:12px; text-align:left; padding-left:0;">
                            <s:actionerror/>
                        </div>
                    </s:if>
                    <div class="news-a">
                        <%for (int i = 0; i < hotellist.size(); i++) {
                        %>
                        <article>
                            <header>
                                <h2><a href="GetSearchDetail?HotelID=<%=hotellist.get(i).getHotelID()%>"><%=hotellist.get(i).getHotelName()%></a></h2> <p class="rating-a <%=hotellist.get(i).getHotelRating()%>">5/5</p>
                                <figure><img src="<%=hotellist.get(i).getHotelImage()%>" alt="Placeholder" width="128" height="102"></figure>
                                <p><%=hotellist.get(i).getHotelAddress()%>, <%=hotellist.get(i).getHotelCity()%></p><div class="fit-a"></div>
                            </header>
                            <p><%=hotellist.get(i).getHotelDesShort()%></p>
                            <footer>
                                <p class="link-b"><a href="GetSearchDetail?HotelID=<%=hotellist.get(i).getHotelID()%>">View Details</a></p>
                            </footer>
                        </article>
                        <%}%>
                    </div>
                </div>
                <aside>

                    <div class="form-c">
                        <fieldset>
                            <legend>Your Search Details</legend>
                            <h3><span>01.</span> <b>What?</b></h3>
                            <p>Hotel</p>
                            <p><%=listbooknow.getFca()%></p>

                            <h3><span>02.</span> <b>Where?</b></h3>
                            <p><%=listbooknow.getFcb()%></p>

                            <h3><span>03.</span> <b>When?</b></h3>
                            <p>Check in: <%=listbooknow.getFcc()%></p>
                            <p>Check out: <%=listbooknow.getFcd()%></p>
                            <p>Nights: <%=listbooknow.getToNight()%></p>

                            <h3><span>04.</span> <b>Choose the hotel</b></h3>
                            <p>Please choose the hotel in search result</p>
                            <img src="img/right-here.png" alt="Choose the hotel" width="170" height="40"> 
                        </fieldset></div>

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
