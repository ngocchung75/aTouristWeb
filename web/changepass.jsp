<%-- 
    Document   : changepass
    Created on : Jan 6, 2014, 11:09:38 AM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password : Asean Tourist</title>
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

                <div id="rightpage" class="inline">
                    <div class="Co_LC_Ce">
                        <h2 class="title_inside" style="width: 600px; text-align: left;">Change Password</h2>
                        <br class="clean" />
                        <s:if test="hasActionErrors()">
                            <div class="errors" style="color:red; font-size:12px; text-align:left; padding-left:0;">
                                <s:actionerror/>
                            </div>
                        </s:if>
                        <div class="account_content">
                            <form action="change-pass" method="post">           
                                <div class="account_info">
                                    <div class="row">
                                        <span class="row_L address">Current Password <font class="other_color_star">*</font></span>
                                        <input class="text_add" data-val="true" data-val-required="Please Enter Current Password." id="OldPassword" name="OldPassword" placeholder="Current Password" type="password" />
                                        <br class="clean" />
                                    </div>
                                    <div class="account_info_err"><span class="field-validation-valid" data-valmsg-for="OldPassword" data-valmsg-replace="true"></span></div>
                                    <div class="row">
                                        <span class="row_L address">New Password <font class="other_color_star">*</font></span>
                                        <input class="text_add" data-val="true" data-val-length="Password is case sensitive, must be at least 6 characters." data-val-length-max="50" data-val-length-min="6" data-val-required="Please Enter New Password." id="NewPassword" name="NewPassword" placeholder="New Password" type="password" />
                                        <br class="clean" />
                                    </div>
                                    <div class="account_info_err"><span class="field-validation-valid" data-valmsg-for="NewPassword" data-valmsg-replace="true"></span></div>
                                    <div class="row">
                                        <span class="row_L address">Confirm Password <font class="other_color_star">*</font></span>
                                        <input class="text_add" data-val="true" data-val-equalto="Password and Repeat Password must be the same." data-val-equalto-other="*.NewPassword" id="RetypePassword" name="RetypePassword" placeholder="Confirm Password" type="password" />
                                        <br class="clean" />
                                    </div>
                                    <div class="account_info_err"><span class="field-validation-valid" data-valmsg-for="RetypePassword" data-valmsg-replace="true"></span></div>
                                    <div style="text-align: left; padding-left: 146px; padding-top: 5px;">
                                        <input type="submit" value="Change Password" class="button-changepass" style="margin-left: 18px; margin-top: 15px;" />
                                    </div>
                                </div>
                            </form>        
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
