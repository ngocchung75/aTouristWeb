<%-- 
    Document   : mydashboard
    Created on : Dec 20, 2013, 10:42:26 PM
    Author     : CHUNG TOOC
--%>

<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html" import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Dashboard : Asean Tourist</title>
        <%@include file="pages/header.jsp" %>
        <link rel="stylesheet" type="text/css" href="styles/review.css">
        <script type="text/javascript" src="javascript/agoda-http-v1.js"></script>
        <script type="text/javascript" src="javascript/agoda-stats-v1.js"></script>
        <script type="text/javascript" src="javascript/reward.js"></script>
    </head>
    <body>
        <s:if test="#session.logined != 'true' || #session.session-role != 2">
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
            <article id="content">
                <%@include file="pages/mydash.jsp" %>
                <%@include file="pages/mybooking.jsp" %>
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
        <script type="text/javascript">
            function submitForm() {
                $.ajax({type: 'POST', url: 'email-action.php', data: $('#homefrm1').serialize(), success: function(response) {
                        $('#alert').find('.message').html(response);
                    }});
                return false;
            }
        </script>
    </body>
</html>