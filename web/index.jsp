<%-- 
    Document   : index
    Created on : Nov 10, 2013, 2:08:18 AM
    Author     : CHUNG TOOC
--%>
<%
    response.sendRedirect("GetTopHotel");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en" class="a">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage : Asean Tourist</title>
        <%@include file="pages/header.jsp" %>
    </head>
    <body>
        <div id="root">
            <header id="top">
                <h1><a href="./" accesskey="h"></a></h1>
                <nav id="nav">
                    <s:if test="#session.logined == 'true' && #session.RoleID == 2">
                        <%@include file="pages/nav-user.jsp" %>
                    </s:if><s:else>
                        <%@include file="pages/nav.jsp" %>
                    </s:else>
                </nav>
                <%@include file="pages/search.jsp" %>
            </header>         
            <article id="home">
                <%@include file="pages/bg.jsp" %>
                <s:form action="booknow.action" method="post">
                    <%@include file="pages/booknow.jsp" %>
                </s:form>
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
    </body>
</html>
