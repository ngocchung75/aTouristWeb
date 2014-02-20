<%-- 
    Document   : booking-confirm
    Created on : Jan 10, 2014, 1:54:34 AM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en" class="a">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Confirm : Asean Tourist</title>
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
            <h2 style="margin-top: 50px;"><span>Thank you</span>, your booking is complete</h2>  
            <p>Please see the <a id="lbtMyAccount" href="my-booking">My Bookings</a> for more details.</p>          

            <center> <img src="img/complete-check-md.png" width="222" height="222"></center></br></br>

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
