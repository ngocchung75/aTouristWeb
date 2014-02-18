<%-- 
    Document   : manageusers
    Created on : Dec 17, 2013, 8:43:15 PM
    Author     : CHUNG TOOC
--%>
<%@page import="model.RoleBean"%>
<%@page import="java.util.List"%>
<%
    List<RoleBean> roleList = (List<RoleBean>) session.getValue("all_role");
    RoleBean updateRole = (RoleBean) session.getValue("update_role");
%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>aTourist Service 1.0 | Manage Role</title>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <link type="text/css" rel="stylesheet" href="css/style.css" />
        <%@include file="pages/head.jsp" %>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <a href="" id="header-image" target="_blank"></a>
                <ul class="subnav">
                    <li><a href="GetAllStatusView" class="">Manage Status</a></li>
                    <li><a href="GetAllCityView" class="">Manage City</a></li>
                    <li><a href="GetAllRoleView" class="focus">Manage Role</a></li>
                    <li><a href="GetAllTopHotelView" class="">Manage Top Hotel</a></li>
                    <li><a href="GetAllHotelView" class="">Manage Hotel</a></li>
                    <li><a href="GetAllUserView" class="">Manage User</a></li>
                    <li><a href="./welcome.jsp" class="">Home</a></li>
                </ul>
            </div>

            <div class="page-box">
                <div class="page-top">
                    <p class="page-title">
                        <span class="title-left"></span>
                        <span class="title-text">Manage Role</span>
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
                        <form action="AddNewRole" method="post">
                            New Role Name: <input id="RoleNameNew" name="RoleNameNew" placeholder="Role Name" type="text" value=""> <input type="submit" value="Add New Role" class="button-changepass"/>
                        </form>
                        <div id="openUpdate" class="modalDialog">
                            <div>
                                <a href="#close" title="Close" class="close">X</a>
                                <form action="SaveUpdateRole" method="post">
                                    <b>Update Role:</b></br></br>
                                    Role ID: <%=updateRole.getRoleID()%> <input id="RoleIDUpdate" name="RoleIDUpdate" type="hidden" value="<%=updateRole.getRoleID()%>"></br></br>
                                    Role Name: </br><input id="RoleNameUpdate" name="RoleNameUpdate" placeholder="Role Name" type="text" value="<%=updateRole.getRoleName()%>"> </br></br>
                                    <input type="submit" value="Update Role"/>
                                </form>
                            </div>
                        </div>
                        </br></br>
                        <table style="width: 50%;">
                            <tr>
                                <th>Role ID</th>
                                <th>Role Name</th>
                                <th></th>
                                <th></th>
                            </tr>
                            <%for (int i = 0; i < roleList.size(); i++) {
                            %>
                            <tr>
                                <td><%=roleList.get(i).getRoleID()%></td>
                                <td><%=roleList.get(i).getRoleName()%></td>
                                <td><a href="UpdateRole?RoleID=<%=roleList.get(i).getRoleID()%>">Edit</a></td>
                                <td><a href="DeleteRole?RoleID=<%=roleList.get(i).getRoleID()%>">Delete</a></td>
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
