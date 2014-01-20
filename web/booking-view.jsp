<%-- 
    Document   : booking-view
    Created on : Jan 10, 2014, 1:19:43 AM
    Author     : CHUNG TOOC
--%>
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
        <s:if test="#session.logined != 'true'">
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
            <form id="content" action="./" method="post" class="form-e">
                <fieldset class="cols-d">
                    <div>
                        <h3>Travel Information</h3>
                        <h4 class="scheme-g">Traveller Infomation</h4>
                        <ul class="list-c">
                            <li><span>Full Name</span> Chung Tooc</li>
                            <li><span>Email Address</span> chung@gmail.com</li>
                            <li><span>Address</span> Danang, Vietnam</li>
                            <li><span>Mobile</span> 0972878218 ${sessionScope.getURL} ${sessionScope.userName}</li>
                        </ul>

                        <h4 class="scheme-g">Accept and confirm</h4>
                        <p class="check-a"><label for="feo"><input type="checkbox" id="feo" name="feo" checked="checked"> I agree to the booking conditions.</label></p>
                        <p class="scheme-h">Grand Total : <span><span>$</span>790</span></p>
                        <p class="link-c"><button type="submit">Submit</button></p>
                    </div>
                    <aside>
                        <h3>Hotel Summary</h3>
                        <div class="vcard a">
                            <h4 class="fn org">Novotel Danang Hotel</h4>
                            <p class="adr">No.36 Bach Dang Street, Han River, Da Nang, Vietnam</p>
                        </div>
                        <ul class="list-c">
                            <li><span>Email Address</span> Novotel@gmail.com</li>
                            <li><span>Mobile</span> 05113.333.333</li>
                        </ul>
                        <h4 class="scheme-g">Summary</h4>
                        <ul class="list-c">
                            <li><span>Room</span> Single Room</li>
                            <li><span>No. Rooms</span> 1</li>
                            <li><span>Price per night</span> $360</li>
                            <li><span>Check in</span> 20 - Jan - 2014</li>
                            <li><span>Check out</span> 22 - Jan - 2014</li>
                            <li><span>Time</span> 02 Nights</li>
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
