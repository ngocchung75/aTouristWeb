<%-- 
    Document   : manageusers
    Created on : Dec 17, 2013, 8:43:15 PM
    Author     : CHUNG TOOC
--%>
<%@page import="model.CityBean"%>
<%@page import="java.util.List"%>
<%
    List<CityBean> cityList = (List<CityBean>) session.getValue("all_city");
    CityBean updateCity = (CityBean) session.getValue("update_city");
%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>aTourist Service 1.0 | Manage City</title>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <link type="text/css" rel="stylesheet" href="css/style.css" />
        <%@include file="pages/head.jsp" %>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <a href="" id="header-image" target="_blank"></a>
                <ul class="subnav">
                    <li><a href="./welcome.jsp" class="">Manage Status</a></li>
                    <li><a href="./welcome.jsp" class="focus">Manage City</a></li>
                    <li><a href="./welcome.jsp" class="">Manage Role</a></li>
                    <li><a href="./welcome.jsp" class="">Manage Top Hotel</a></li>
                    <li><a href="./welcome.jsp" class="">Manage Hotel</a></li>
                    <li><a href="GetAllUserView" class="">Manage User</a></li>
                    <li><a href="./welcome.jsp" class="">Home</a></li>
                </ul>
            </div>

            <div class="page-box">
                <div class="page-top">
                    <p class="page-title">
                        <span class="title-left"></span>
                        <span class="title-text">Manage City</span>
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
                        <form action="AddNewCity" method="post">
                            New City Name: <input id="HotelCityNew" name="HotelCityNew" placeholder="City Name" type="text" value=""> <input type="submit" value="Add New City" class="button-changepass"/>
                        </form>
                        <div id="openUpdate" class="modalDialog">
                            <div>
                                <a href="#close" title="Close" class="close">X</a>
                                <form action="SaveUpdateCity" method="post">
                                    <b>Update City:</b></br></br>
                                    City ID: <%=updateCity.getCityID()%> <input id="CityIDUpdate" name="CityIDUpdate" type="hidden" value="<%=updateCity.getCityID()%>"></br></br>
                                    City Name: </br><input id="HotelCityUpdate" name="HotelCityUpdate" placeholder="City Name" type="text" value="<%=updateCity.getHotelCity()%>"> </br></br>
                                    <input type="submit" value="Update City"/>
                                </form>
                            </div>
                        </div>
                        </br></br>
                        <table style="width: 50%;">
                            <tr>
                                <th>City ID</th>
                                <th>City Name</th>
                                <th></th>
                                <th></th>
                            </tr>
                            <%for (int i = 0; i < cityList.size(); i++) {
                            %>
                            <tr>
                                <td><%=cityList.get(i).getCityID()%></td>
                                <td><%=cityList.get(i).getHotelCity()%></td>
                                <td><a href="UpdateCity?CityID=<%=cityList.get(i).getCityID()%>">Edit</a></td>
                                <td><a href="DeleteCity?CityID=<%=cityList.get(i).getCityID()%>">Delete</a></td>
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
