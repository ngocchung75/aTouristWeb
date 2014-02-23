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
                        <h2 class="title_inside L" style="width: 600px; text-align: left;">My Profile</h2>
                        <br class="clean">
                        <s:if test="hasActionErrors()">
                            <div class="errors" style="color:red; font-size:12px; text-align:left; padding-left:0;">
                                <s:actionerror/>
                            </div>
                        </s:if>
                        <div class="account_content">
                            <form action="my-profile" method="post">
                                <div class="account_info">
                                    <div class="row">
                                        <span class="row_L address">Full Name</span>
                                        <input class="text_add valid" data-val="true" data-val-required="Please Enter Full Name" id="FullName" name="FullName" placeholder="Full Name" type="text" value="${sessionScope.FullName}">
                                    </div>
                                    <div class="account_info_err">
                                        <span class="field-validation-valid" data-valmsg-for="FullName" data-valmsg-replace="true"></span>
                                    </div>

                                    <div class="row re_form2" style="width:100%;">
                                        <span class="row_L address">Gender</span>
                                        <s:if test="#session.Gender == 'Male'">
                                            <span><select data-val="true" data-val-range-max="2" data-val-range-min="1" data-val-requiredifferent="" data-val-requiredifferent-param="0" id="Gender" name="Gender">
                                                    <option selected="selected" value="1">Male</option>
                                                    <option value="2">Female</option>
                                                </select></span>
                                            </s:if>
                                            <s:if test="#session.Gender == 'Female'">
                                            <span><select data-val="true" data-val-range-max="2" data-val-range-min="1" data-val-requiredifferent="" data-val-requiredifferent-param="0" id="Gender" name="Gender">
                                                    <option value="1">Male</option>
                                                    <option selected="selected" value="2">Female</option>
                                                </select></span>
                                            </s:if>

                                        <br class="clean">
                                    </div>
                                    <div class="account_info_err">
                                        <span class="field-validation-valid" data-valmsg-for="Gender" data-valmsg-replace="true"></span>
                                    </div>

                                    <div class="row">
                                        <span class="row_L address">Year Of Birth</span>
                                        <input class="text_add valid" data-val="true" data-val-length="Year Of Birth must be at least 4 characters." data-val-length-max="4" data-val-length-min="4" data-val-required="Please Enter Year Of Birth" id="YearOfBirth" name="YearOfBirth" placeholder="Year Of Birth" type="text" value="${sessionScope.YearOfBirth}">
                                    </div>
                                    <div class="account_info_err">
                                        <span class="field-validation-valid" data-valmsg-for="YearOfBirth" data-valmsg-replace="true"></span>
                                    </div>

                                    <div class="row">
                                        <span class="row_L address">Email</span>
                                        <input class="text_add valid" data-val="true" data-val-regex="Email Address is not valid." data-val-regex-pattern="^[-!#$%&amp;&#39;*+/0-9=?A-Z^_a-z{|}~](\.?[-!#$%&amp;&#39;*+/0-9=?A-Z^_a-z{|}~])*@[a-zA-Z](-?[a-zA-Z0-9])*(\.[a-zA-Z](-?[a-zA-Z0-9])*)+$" data-val-required="Please Enter Email Address." id="Email" name="Email" placeholder="Email Address" type="text" value="${sessionScope.Email}" />
                                        <br class="clean" />
                                    </div>
                                    <div class="account_info_err">
                                        <span class="field-validation-valid" data-valmsg-for="Email" data-valmsg-replace="true" id="emailValidationMessage"></span>
                                    </div>

                                    <div class="row">
                                        <span class="row_L address">Mobile</span>
                                        <input class="text_add valid" data-val="true" data-val-regex="Mobile Number is not valid." data-val-regex-pattern="09\d{8}|01\d{9}" data-val-required="Please Enter Mobile Number." id="Mobile" name="Mobile" placeholder="Mobile Number" type="text" value="${sessionScope.Phone}" /><br class="clean" />
                                    </div>
                                    <div class="account_info_err">
                                        <span class="field-validation-valid" data-valmsg-for="Mobile" data-valmsg-replace="true"></span>
                                    </div>

                                    <div class="row">
                                        <span class="row_L address">Address</span>
                                        <input class="text_add valid" data-val="true" data-val-required="Please Enter Address" id="Address" name="Address" placeholder="Address" type="text" value="${sessionScope.UserAddress}">
                                    </div>
                                    <div class="account_info_err">
                                        <span class="field-validation-valid" data-valmsg-for="Address" data-valmsg-replace="true"></span>
                                    </div>

                                    <div style="text-align: left; padding-left: 146px; padding-top: 5px;">
                                        <input type="submit" value="Save" class="button-changepass" style="margin-left: 18px; margin-top: 15px;" />
                                    </div>
                                </div>
                            </form>      
                        </div>
                    </div>
                    <br class=" clean">
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
