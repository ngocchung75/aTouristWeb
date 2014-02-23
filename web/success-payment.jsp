<%-- 
    Document   : myprofile
    Created on : Jan 6, 2014, 9:05:44 PM
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
        <title>My Profile : Asean Tourist</title>
        <%@include file="pages/header.jsp" %>
        <link rel="stylesheet" type="text/css" href="styles/review.css">
        <script type="text/javascript" src="javascript/agoda-http-v1.js"></script>
        <script type="text/javascript" src="javascript/agoda-stats-v1.js"></script>
        <script type="text/javascript" src="javascript/reward.js"></script>

        <link rel="stylesheet" type="text/css" href="styles/signup.css">
        <script type="text/javascript" src="javascript/scriptgeneral.min.js"></script>
        <script type="text/javascript" src="javascript/scriptgeneral_home.min.js"></script>
    </head>
    <body>
        <s:if test="#session.logined != 'true' || #session.RoleID != 2">
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


                <div id="rightpage" class="inline">
                    <div class="Co_LC_Ce">
                        <h2 class="title_inside" style="width: 600px; text-align: left;">Bao Kim payment successful</h2>
                        <br class="clean" />

                        <div class="account_content">
                            <div class="errors" style="color:red; font-size:12px; text-align:left; padding-left:0;">
                                <span>Bao Kim payment successful. Please send an email to the hotel inform payment. We will confirm the order immediately after receiving the money.
                                    </br>
                                    Thank you very much!
                                </span>
                            </div>
                        </div>
                    </div>
                    <br class="clean" />
                </div>

            </article>
            <footer id="footer">
                <%@include file="pages/footer1.jsp" %>
                <%@include file="pages/footer.jsp" %>
            </footer>
        </div>
        <script src="http://maps.google.com/maps/api/js?sensor=false&amp;libraries=geometry&amp;language=en"></script>
        <script type="text/javascript">
            head.js('javascript/jquery.min.js', 'javascript/jquery-ui.min.js', 'javascript/scripts.js', 'javascript/mobile.js');</script>
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
