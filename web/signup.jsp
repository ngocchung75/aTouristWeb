<%-- 
    Document   : signup
    Created on : Dec 20, 2013, 10:57:15 AM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage : Asean Tourist</title>
        <%@include file="pages/header.jsp" %>
        <link rel="stylesheet" type="text/css" href="styles/signup.css">
        <script type="text/javascript" src="javascript/scriptgeneral.min.js"></script>
        <script type="text/javascript" src="javascript/scriptgeneral_home.min.js"></script>
    </head>
    <body>
        <s:if test="#session.logined == 'true'">
            <%
                response.sendRedirect("GetTopHotel");
            %>
        </s:if>
        <div id="root">
            <header id="top">
                <h1><a href="./" accesskey="h"></a></h1>
                <nav id="nav">
                    <%@include file="pages/nav.jsp" %>
                    <p class="link-a"><a id="go" name="login" href="./signup.jsp">Login</a> <a id="go" name="signup" href="./signup.jsp">Register</a></p>
                </nav>
                <%@include file="pages/search.jsp" %>
            </header>         
            <article id="content" class="cols-b">
                <%@include file="pages/signin-up.jsp" %>
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