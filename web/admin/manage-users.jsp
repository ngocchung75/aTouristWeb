<%-- 
    Document   : manageusers
    Created on : Dec 17, 2013, 8:43:15 PM
    Author     : CHUNG TOOC
--%>
<%@page import="model.RoleBean"%>
<%@page import="java.util.List"%>
<%@page import="model.UserBean"%>
<%
    List<UserBean> userlist = (List<UserBean>) session.getValue("all_user");
    List<RoleBean> rolelist = (List<RoleBean>) session.getValue("all_role");
    UserBean updateUser = (UserBean) session.getValue("update_user");
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
                    <li><a href="GetAllHotelView" class="">Hotel</a></li>
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
                        <form action="AddNewUser" method="post">
                            <b>Add New User</b></br></br>
                            <table>
                                <tr>
                                    <td> 
                                        UserName:</br>
                                        <input id="UserNameNew" name="UserNameNew" placeholder="User Name" type="text" value=""></br></br>
                                        Password:</br>
                                        <input id="PasswordNew" name="PasswordNew" placeholder="Password" type="password" value=""></br></br>
                                        Role Name:</br>
                                        <select id="RoleIDNew" name="RoleIDNew">
                                            <%for (int i = 0; i < rolelist.size(); i++) {
                                            %>
                                            <option value="<%=rolelist.get(i).getRoleID()%>"> <%=rolelist.get(i).getRoleName()%> </option>
                                            <%}%>
                                        </select></br>
                                    </td>
                                    <td> 
                                        Full Name:</br>
                                        <input id="FullNameNew" name="FullNameNew" placeholder="Full Name" type="text" value=""></br></br>
                                        Gender:</br>
                                        <input id="GenderNew" name="GenderNew" placeholder="Gender (Male/Female)" type="text" value=""></br></br>
                                        Year Of Birth:</br>
                                        <input id="YearOfBirthNew" name="YearOfBirthNew" placeholder="Year Of Birth" type="text" value=""></br></br>
                                    </td>
                                    <td> 
                                        Email:</br>
                                        <input id="EmailNew" name="EmailNew" placeholder="Email" type="text" value=""></br></br>
                                        Phone:</br>
                                        <input id="PhoneNew" name="PhoneNew" placeholder="Phone" type="text" value=""></br></br>
                                        Address:</br>
                                        <input id="AddressNew" name="AddressNew" placeholder="Address" type="text" value=""></br></br>
                                    </td>
                                </tr>
                            </table>
                            </br><input type="submit" value="Add New User" class="button-changepass"/>
                        </form>
                        <div id="openUpdate" class="modalDialog">
                            <div>
                                <a href="#close" title="Close" class="close">X</a>
                                <form action="SaveUpdateUser" method="post">
                                    <b>Update Top Hotel:</b></br></br>
                                    UserID: <%=updateUser.getUserID()%> <input id="UserIDUpdate" name="UserIDUpdate" type="hidden" value="<%=updateUser.getUserID()%>"></br>
                                    UserName: <%=updateUser.getUserName()%> <input id="UserNameUpdate" name="UserNameUpdate" placeholder="User Name" type="hidden" value="<%=updateUser.getUserName()%>"></br>
                                    Role Name: <%=updateUser.getRoleName()%> <input id="RoleIDUpdate" name="RoleIDUpdate" type="hidden" value="<%=updateUser.getRoleID()%>"></br></br>
                                    <input id="PasswordUpdate" name="PasswordUpdate" placeholder="Password" type="hidden" value="<%=updateUser.getUserPass()%>">
                                    Full Name:</br>
                                    <input id="FullNameUpdate" name="FullNameUpdate" placeholder="Full Name" type="text" value="<%=updateUser.getFullName()%>"></br></br>
                                    Gender:</br>
                                    <input id="GenderUpdate" name="GenderUpdate" placeholder="Gender (Male/Female)" type="text" value="<%=updateUser.getGender()%>"></br></br>
                                    Year Of Birth:</br>
                                    <input id="YearOfBirthUpdate" name="YearOfBirthUpdate" placeholder="Year Of Birth" type="text" value="<%=updateUser.getYearOfBirth()%>"></br></br>
                                    Email:</br>
                                    <input id="EmailUpdate" name="EmailUpdate" placeholder="Email" type="text" value="<%=updateUser.getEmail()%>"></br></br>
                                    Phone:</br>
                                    <input id="PhoneUpdate" name="PhoneUpdate" placeholder="Phone" type="text" value="<%=updateUser.getPhone()%>"></br></br>
                                    Address:</br>
                                    <input id="AddressUpdate" name="AddressUpdate" placeholder="Address" type="text" value="<%=updateUser.getUserAddress()%>"></br></br>
                                    </br>
                                    <input type="submit" value="Update User"/>
                                </form>
                            </div>
                        </div>
                        <div id="openChangeRole" class="modalDialog">
                            <div>
                                <a href="#close" title="Close" class="close">X</a>
                                <form action="SaveChangeRoleUser" method="SaveChangeRoleUser">
                                    <b>Change Role:</b></br></br>
                                    UserID: <%=updateUser.getUserID()%> <input id="UserIDChangeRole" name="UserIDChangeRole" type="hidden" value="<%=updateUser.getUserID()%>"></br></br>
                                    UserName: <%=updateUser.getUserName()%> </br></br>
                                    Role Name:</br>
                                    <select id="RoleIDChangeRole" name="RoleIDChangeRole">
                                        <%for (int i = 0; i < rolelist.size(); i++) {
                                        %>
                                        <option value="<%=rolelist.get(i).getRoleID()%>"> <%=rolelist.get(i).getRoleName()%> </option>
                                        <%}%>
                                    </select></br></br>
                                    <input type="submit" value="Change Role"/>
                                </form>
                            </div>
                        </div>
                        <div id="openChangePassword" class="modalDialog">
                            <div>
                                <a href="#close" title="Close" class="close">X</a>
                                <form action="SaveChangePasswordUser" method="SaveChangePasswordUser">
                                    <b>Change Role:</b></br></br>
                                    UserID: <%=updateUser.getUserID()%> <input id="UserIDChangePassword" name="UserIDChangePassword" type="hidden" value="<%=updateUser.getUserID()%>"></br></br>
                                    UserName: <%=updateUser.getUserName()%> </br></br>
                                    Password:</br> <input id="UserPassChangePassword" name="UserPassChangePassword" type="password" value="">
                                    </br></br>
                                    <input type="submit" value="Change Role"/>
                                </form>
                            </div>
                        </div>
                        </br></br>
                        <table>
                            <tr>
                                <th>User ID</th>
                                <th>UserName</th>
                                <th>RoleName</th>
                                <th>Full Name</th>
                                <th>Gender</th>
                                <th>Year Of Birth</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Address</th>
                                <th>Created</th>
                                <th></th>
                                <th></th>
                                <th></th>
                                <th></th>
                            </tr>
                            <%for (int i = 0; i < userlist.size(); i++) {
                            %>
                            <tr>
                                <td><%=userlist.get(i).getUserID()%></td>
                                <td><%=userlist.get(i).getUserName()%></td>
                                <td><%=userlist.get(i).getRoleName()%></td>
                                <td><%=userlist.get(i).getFullName()%></td>
                                <td><%=userlist.get(i).getGender()%></td>
                                <td><%=userlist.get(i).getYearOfBirth()%></td>
                                <td><%=userlist.get(i).getEmail()%></td>
                                <td><%=userlist.get(i).getPhone()%></td>
                                <td><%=userlist.get(i).getUserAddress()%></td>
                                <td><%=userlist.get(i).getCreated()%></td>
                                <td><a href="UpdateUser?UserID=<%=userlist.get(i).getUserID()%>">Edit</a></td>
                                <td><a href="DeleteUser?UserID=<%=userlist.get(i).getUserID()%>">Delete</a></td>
                                <td><a href="ChangeRoleUser?UserID=<%=userlist.get(i).getUserID()%>">Change Role</a></td>
                                <td><a href="ChangePassUser?UserID=<%=userlist.get(i).getUserID()%>">Change Password</a></td>
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
