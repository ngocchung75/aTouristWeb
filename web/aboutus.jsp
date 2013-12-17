<%-- 
    Document   : aboutus
    Created on : Dec 17, 2013, 10:32:50 PM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                    <%@include file="pages/nav.jsp" %>
                    <p class="link-a"><a href="./">Login</a> <a href="./">Register</a></p>
                </nav>
                <%@include file="pages/search.jsp" %>
            </header>         
            <article id="home">
                <%@include file="pages/bg.jsp" %>
                <form action="./" method="post" class="form-c">
                    <%@include file="pages/booknow.jsp" %>
                </form>
            </article>
            <footer id="footer">
                <%@include file="pages/footer.jsp" %>
            </footer>
        </div>
        <script src="http://maps.google.com/maps/api/js?sensor=false&amp;libraries=geometry&amp;language=en"></script>
        <script type="text/javascript">
            head.js('javascript/jquery.min.js', 'javascript/jquery-ui.min.js', 'javascript/scripts.js', 'javascript/mobile.js')
        </script>

    </body>
</html>
