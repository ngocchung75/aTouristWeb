<%-- 
    Document   : manageusers
    Created on : Dec 17, 2013, 8:43:15 PM
    Author     : CHUNG TOOC
--%>
<%@page import="java.util.List"%>
<%@page import="model.UserBean"%>
<%
    List<UserBean> userlist = (List<UserBean>) session.getValue("all_user");
%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>aTourist Service 1.0 | Manage Users</title>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <link type="text/css" rel="stylesheet" href="css/style.css" />
        <%@include file="pages/head.jsp" %>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <a href="" id="header-image" target="_blank"></a>
                <ul class="subnav">
                    <li><a href="./welcome.jsp" class="">All Bookings</a></li>
                    <li><a href="./welcome.jsp" class="">Calendar</a></li>
                    <li><a href="GetAllUserView" class="focus">Manage User</a></li>
                    <li><a href="./welcome.jsp" class="">Home</a></li>
                </ul>
            </div>

            <div class="page-box">
                <div class="page-top">
                    <p class="page-title">
                        <span class="title-left"></span>
                        <span class="title-text">Manage User</span>
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
                        <a href="AddNewUser">Add New User</a>
                        </br></br>
                        <table>
                            <tr>
                                <th>User ID</th>
                                <th>UserName</th>
                                <th>Full Name</th>
                                <th>Gender</th>
                                <th>Year Of Birth</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Address</th>
                                <th>Created</th>
                                <th></th>
                                <th></th>
                            </tr>
                            <%for (int i = 0; i < userlist.size(); i++) {
                            %>
                            <tr>
                                <td><%=userlist.get(i).getUserID()%></td>
                                <td><%=userlist.get(i).getUserName()%></td>
                                <td><%=userlist.get(i).getFullName()%></td>
                                <td><%=userlist.get(i).getGender()%></td>
                                <td><%=userlist.get(i).getYearOfBirth()%></td>
                                <td><%=userlist.get(i).getEmail()%></td>
                                <td><%=userlist.get(i).getPhone()%></td>
                                <td><%=userlist.get(i).getUserAddress()%></td>
                                <td><%=userlist.get(i).getCreated()%></td>
                                <td><a href="UpdateUser?UserID=<%=userlist.get(i).getUserID()%>">Edit</a></td>
                                <td><a href="DeleteUser?UserID=<%=userlist.get(i).getUserID()%>">Delete</a></td>
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
