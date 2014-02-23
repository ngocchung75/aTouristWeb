<%-- 
    Document   : manageusers
    Created on : Dec 17, 2013, 8:43:15 PM
    Author     : CHUNG TOOC
--%>
<%@page import="model.UserBean"%>
<%@page import="model.HotelBean"%>
<%@page import="java.util.List"%>
<%
    List<HotelBean> hotelList = (List<HotelBean>) session.getValue("all_hotel");
    List<UserBean> userList = (List<UserBean>) session.getValue("all_user");
    HotelBean updateHotel = (HotelBean) session.getValue("update_hotel");
%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>aTourist Service 1.0 | Manage Hotel</title>
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
                    <li><a href="GetAllTopHotelView" class="">Top Hotel</a></li>
                    <li><a href="GetAllHotelView" class="focus">Hotel</a></li>
                    <li><a href="GetAllUserView" class="">Manage User</a></li>
                    <li><a href="./welcome.jsp" class="">Home</a></li>
                </ul>
            </div>

            <div class="page-box">
                <div class="page-top">
                    <p class="page-title">
                        <span class="title-left"></span>
                        <span class="title-text">Manage Hotel</span>
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
                        <form action="AddNewHotel" method="post">
                            <b>Add New Hotel</b></br></br>
                            New Hotel Name:</br>
                            <input id="HotelNameNew" name="HotelNameNew" placeholder="Hotel Name" type="text" value=""></br></br>
                            User Manage:</br>
                            <select id="UserIDNew" name="UserIDNew">
                                <%for (int i = 0; i < userList.size(); i++) {
                                %>
                                <option value="<%=userList.get(i).getUserID()%>"> <%=userList.get(i).getUserName()%> </option>
                                <%}%>
                            </select></br></br>
                            <input type="submit" value="Add New Hotel" class="button-changepass"/>
                        </form>
                        <div id="openUpdate" class="modalDialog">
                            <div>
                                <a href="#close" title="Close" class="close">X</a>
                                <form action="SaveUpdateHotel" method="post">
                                    <b>Update User Manage Hotel:</b></br></br>
                                    Hotel ID: <%=updateHotel.getHotelID()%> <input id="HotelIDUpdate" name="HotelIDUpdate" type="hidden" value="<%=updateHotel.getHotelID()%>"></br></br>
                                    Hotel Name: <%=updateHotel.getHotelName()%> </br>
                                    User Manage: </br>
                                    <select id="UserIDUpdate" name="UserIDUpdate">
                                        <%for (int i = 0; i < userList.size(); i++) {
                                        %>
                                        <option value="<%=userList.get(i).getUserID()%>"> <%=userList.get(i).getUserName()%> </option>
                                        <%}%>
                                    </select>
                                    </br></br>
                                    <input type="submit" value="Update"/>
                                </form>
                            </div>
                        </div>
                        </br></br>
                        <table style="width: 50%;">
                            <tr>
                                <th>Hotel ID</th>
                                <th>Hotel Name</th>
                                <th>User Name</th>
                                <th></th>
                                <th></th>
                            </tr>
                            <%for (int i = 0; i < hotelList.size(); i++) {
                            %>
                            <tr>
                                <td><%=hotelList.get(i).getHotelID()%></td>
                                <td><%=hotelList.get(i).getHotelName()%></td>
                                <td><%=hotelList.get(i).getUserName()%></td>
                                <td><a href="UpdateHotel?HotelID=<%=hotelList.get(i).getHotelID()%>">Edit</a></td>
                                <td><a onclick="delete_confirm('Are you sure you want to delete hotel?', 'DeleteHotel?HotelID=<%=hotelList.get(i).getHotelID()%>')" href="#">Delete</a></td>
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
