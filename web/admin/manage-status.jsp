<%-- 
    Document   : manageusers
    Created on : Dec 17, 2013, 8:43:15 PM
    Author     : CHUNG TOOC
--%>
<%@page import="model.StatusBean"%>
<%@page import="java.util.List"%>
<%
    List<StatusBean> statusList = (List<StatusBean>) session.getValue("all_status");
    StatusBean updateStatus = (StatusBean) session.getValue("update_status");
%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>aTourist Service 1.0 | Manage Status</title>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <link type="text/css" rel="stylesheet" href="css/style.css" />
        <%@include file="pages/head.jsp" %>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <a href="" id="header-image" target="_blank"></a>
                <ul class="subnav">
                    <li><a href="./welcome.jsp" class="focus">Manage Status</a></li>
                    <li><a href="./welcome.jsp" class="">Manage City</a></li>
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
                        <span class="title-text">Manage Status</span>
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
                        <form action="AddNewStatus" method="post">
                            New Status Name: <input id="StatusNameNew" name="StatusNameNew" placeholder="Status Name" type="text" value=""> <input type="submit" value="Add New Status" class="button-changepass"/>
                        </form>
                        <div id="openUpdate" class="modalDialog">
                            <div>
                                <a href="#close" title="Close" class="close">X</a>
                                <form action="SaveUpdateStatus" method="post">
                                    <b>Update Status:</b></br></br>
                                    Status ID: <%=updateStatus.getStatusID()%> <input id="StatusIDUpdate" name="StatusIDUpdate" type="hidden" value="<%=updateStatus.getStatusID()%>"></br></br>
                                    Status Name: </br><input id="StatusNameUpdate" name="StatusNameUpdate" placeholder="Status Name" type="text" value="<%=updateStatus.getStatusName()%>"> </br></br>
                                    <input type="submit" value="Update Status"/>
                                </form>
                            </div>
                        </div>
                        </br></br>
                        <table style="width: 50%;">
                            <tr>
                                <th>Status ID</th>
                                <th>Status Name</th>
                                <th></th>
                                <th></th>
                            </tr>
                            <%for (int i = 0; i < statusList.size(); i++) {
                            %>
                            <tr>
                                <td><%=statusList.get(i).getStatusID()%></td>
                                <td><%=statusList.get(i).getStatusName()%></td>
                                <td><a href="UpdateStatus?StatusID=<%=statusList.get(i).getStatusID()%>">Edit</a></td>
                                <td><a href="DeleteStatus?StatusID=<%=statusList.get(i).getStatusID()%>">Delete</a></td>
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
