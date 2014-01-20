<%-- 
    Document   : hotellist
    Created on : Jan 8, 2014, 10:11:06 AM
    Author     : CHUNG TOOC
--%>
<%@page import="model.HotelBean"%>
<%@page import="java.util.List"%>
<%
    List<HotelBean> hotellist = (List<HotelBean>) session.getValue("all_hotel");
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
                    <form action="./" method="post" class="module-b">
                        <fieldset>
                            <nav class="pagination-a" style="z-index: 19;">
                                <p>Page 01 of 06</p>
                                <ol>
                                    <li class="prev"><a href="./">Previous</a></li>
                                    <li class="active"><a href="./" style="cursor: default; text-decoration: none;">01</a></li>
                                    <li><a href="./">02</a></li>
                                    <li><a href="./">03</a></li>
                                    <li><a href="./">04</a></li>
                                    <li class="next"><a href="./">Next</a></li>
                                </ol>
                            </nav>
                        </fieldset>
                    </form>
                    <div class="news-a">

                        <%for (int i = 0; i < hotellist.size(); i++) {
                        %>
                        <article>
                            <header>
                                <h2><a href="GetDetailHotel?HotelID=<%=hotellist.get(i).getHotelID()%>"><%=hotellist.get(i).getHotelName()%></a></h2> <p class="rating-a <%=hotellist.get(i).getHotelRating()%>">5/5</p>
                                <figure><img src="<%=hotellist.get(i).getHotelImage()%>" alt="Placeholder" width="128" height="102"></figure>
                                <p><%=hotellist.get(i).getHotelAddress()%><%=hotellist.get(i).getHotelCity()%></p><div class="fit-a"></div>
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
                    <s:form action="booknow.action" method="post">
                        <%@include file="pages/booknow.jsp" %>
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
