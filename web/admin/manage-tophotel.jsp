<%-- 
    Document   : manageusers
    Created on : Dec 17, 2013, 8:43:15 PM
    Author     : CHUNG TOOC
--%>
<%@page import="model.TopHotelBean"%>
<%@page import="java.util.List"%>
<%
    List<TopHotelBean> topHotelList = (List<TopHotelBean>) session.getValue("all_topHotel");
    List<TopHotelBean> hotelList = (List<TopHotelBean>) session.getValue("all_hotel");
    TopHotelBean updateTopHotel = (TopHotelBean) session.getValue("update_topHotel");
%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>aTourist Service 1.0 | Manage TopHotel</title>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <link type="text/css" rel="stylesheet" href="css/style.css" />
        <%@include file="pages/head.jsp" %>
        <script type="text/javascript">
            function delete_confirm(msg, url)
            {
                if (confirm(msg))
                {
                    window.location.href = url;
                }
                else
                {
                    false;
                }
            }
        </script>
    </head>
    <body>
        <s:if test="#session.logined != 'true' || #session.RoleID != 1">
            <%
                response.sendRedirect("login.jsp");
            %>
        </s:if>
        <div id="container">
            <div id="header">
                <a href="" id="header-image" target="_blank"></a>
                <ul class="subnav">
                    <li><a href="./logout.jsp" class="">Logout</a></li>
                    <li><a href="GetAllStatusView" class="">Manage Status</a></li>
                    <li><a href="GetAllCityView" class="">Manage City</a></li>
                    <li><a href="GetAllRoleView" class="">Manage Role</a></li>
                    <li><a href="GetAllTopHotelView" class="focus">Top Hotel</a></li>
                    <li><a href="GetAllHotelView" class="">Hotel</a></li>
                    <li><a href="GetAllUserView" class="">Manage User</a></li>
                    <li><a href="./welcome.jsp" class="">Home</a></li>
                </ul>
            </div>

            <div class="page-box">
                <div class="page-top">
                    <p class="page-title">
                        <span class="title-left"></span>
                        <span class="title-text">Manage TopHotel</span>
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
                        <form action="AddNewTopHotel" method="post">
                            New Hotel Name: 
                            <select id="HotelIDNew" name="HotelIDNew">
                                <%for (int i = 0; i < hotelList.size(); i++) {
                                %>
                                <option value="<%=hotelList.get(i).getHotelID()%>"> <%=hotelList.get(i).getHotelName()%> </option>
                                <%}%>
                            </select>
                            <input type="submit" value="Add New TopHotel" class="button-changepass"/>
                        </form>
                        <div id="openUpdate" class="modalDialog">
                            <div>
                                <a href="#close" title="Close" class="close">X</a>
                                <form action="SaveUpdateTopHotel" method="post">
                                    <b>Update Top Hotel:</b></br></br>
                                    Top Hotel ID: <%=updateTopHotel.getTopHotelID()%> <input id="TopHotelIDUpdate" name="TopHotelIDUpdate" type="hidden" value="<%=updateTopHotel.getTopHotelID()%>"></br></br>
                                    Hotel Name: </br>
                                    <select id="HotelIDUpdate" name="HotelIDUpdate">
                                        <%for (int i = 0; i < hotelList.size(); i++) {
                                        %>
                                        <option value="<%=hotelList.get(i).getHotelID()%>"> <%=hotelList.get(i).getHotelName()%> </option>
                                        <%}%>
                                    </select>
                                    </br></br>
                                    <input type="submit" value="Update TopHotel"/>
                                </form>
                            </div>
                        </div>
                        </br></br>
                        <table style="width: 50%;">
                            <tr>
                                <th>Top Hotel ID</th>
                                <th>Hotel Name</th>
                                <th></th>
                                <th></th>
                            </tr>
                            <%for (int i = 0; i < topHotelList.size(); i++) {
                            %>
                            <tr>
                                <td><%=topHotelList.get(i).getTopHotelID()%></td>
                                <td><%=topHotelList.get(i).getHotelName()%></td>
                                <td><a href="UpdateTopHotel?TopHotelID=<%=topHotelList.get(i).getTopHotelID()%>">Edit</a></td>
                                <td><a onclick="delete_confirm('Are you sure you want to delete top hotel?', 'DeleteTopHotel?TopHotelID=<%=topHotelList.get(i).getTopHotelID()%>')" href="#">Delete</a></td>
                            </tr>
                            <%}%>
                        </table>
                        </br></br>
                    </div> <!-- content -->

                </div> <!-- page-middle -->
                <div class="page-bottom"></div>
            </div> <!-- page-box -->

            <div class="footer">
                <%@include file="pages/footer.jsp" %>
            </div>

        </div>
    </body>
</html>
