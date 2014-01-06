<%-- 
    Document   : signin-up
    Created on : Dec 20, 2013, 2:26:11 PM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<div class="content">
    <div class="col_CC">
        <p class="title_pages L">Sign In or Create My Account</p>
        <br class="clean">
        <s:if test="hasActionErrors()">
            <div class="errors" style="color:red; font-size:12px; text-align:left; padding-left:0;">
                <s:actionerror/>
            </div>
        </s:if>
        <div class="login_new_form">
            <dl class="login_new_form_item">
                <dt>Sign In</dt>
                <dd class="login_col1">
                    <form action="login-user" method="post">
                        <input id="ReturnUrl" name="ReturnUrl" type="hidden" value="~/" />            
                        <div class="login_form">
                            <span class="field-validation-valid" data-valmsg-for="IsValidUser" data-valmsg-replace="true"></span>
                            <div class="row">
                                <span class="row_L">Username<font class="other_color_star">*</font></span>
                                <input class="text" data-val="true" data-val-required="Please Enter Username." id="username" name="username" placeholder="Username" type="text" value="" />
                                <br class="clean">
                            </div>
                            <div class="err_re">
                                <span class="field-validation-valid" data-valmsg-for="username" data-valmsg-replace="true"></span>
                            </div>
                            <div class="row">
                                <span class="row_L">Password<font class="other_color_star">*</font></span>
                                <input class="text" data-val="true" data-val-required="Please Enter Password." id="password" name="password" placeholder="Password" type="password" />
                                <br class="clean">
                            </div>
                            <div class="err_re">
                                <span class="field-validation-valid" data-valmsg-for="password" data-valmsg-replace="true"></span>
                            </div>
                            <div class="row">
                                <button type="submit" class="button-signup">Sign In &raquo;</button>
                            </div>
                            <div class="row" style="margin-top: 0px;">
                                <a href='contact.jsp'>Forgot your password.</a>
                                <p>(Please send us a message!)</p>
                            </div>
                        </div>
                    </form>    </dd>
            </dl>

            <script language="javascript">
                $(function() {
                    $("#Email").focus();
                });
            </script>


            <dl class="login_new_form_item changew">
                <dt>Create My Account</dt>
                <dd>
                    <form action="signup-user" method="post">
                        <input id="ReturnUrl" name="ReturnUrl" type="hidden" value="~/" />            
                        <div class="re_form">
                            <div>
                                <span class="field-validation-valid" data-valmsg-for="ErrorMessage" data-valmsg-replace="true"></span>
                            </div>
                            <div class="row">
                                <span class="row_L">Username<font class="other_color_star">*</font></span>
                                <input class="text" data-val="true" data-val-required="Please Enter Username." id="RegisterUsername" name="RegisterUsername" placeholder="Username" type="text" value="" />
                                <br class="clean">
                            </div>
                            <div class="err_re">
                                <span class="field-validation-valid" data-valmsg-for="RegisterUsername" data-valmsg-replace="true"></span>
                            </div>
                            <div class="row">
                                <span class="row_L">Password<font class="other_color_star">*</font></span>
                                <input class="text" data-val="true" data-val-length="Password is case sensitive, must be at least 6 characters." data-val-length-max="50" data-val-length-min="6" data-val-required="Please Enter Password." id="RegisterPassword" name="RegisterPassword" placeholder="Password" type="password" />
                                <br class="clean" />
                            </div>
                            <div class="err_re">
                                <span class="field-validation-valid" data-valmsg-for="RegisterPassword" data-valmsg-replace="true"></span>
                            </div>
                            <div class="row">
                                <span class="row_L">Confirm Password<font class="other_color_star">*</font></span>
                                <input class="text" data-val="true" data-val-equalto="Password and Repeat Password must be the same." data-val-equalto-other="*.RegisterPassword" id="RetypePassword" name="RetypePassword" placeholder="Retype Password" type="password" /><br class="clean" />
                            </div>
                            <div class="err_re">
                                <span class="field-validation-valid" data-valmsg-for="RetypePassword" data-valmsg-replace="true"></span>
                            </div>
                        </div>
                        <div class="re_form1">
                            <div class="row">
                                <span class="row_L1">Full Name<font class="other_color_star">*</font></span>
                                <input class="text" data-val="true" data-val-required="Please Enter Full Name." id="FullName" name="FullName" placeholder="Full Name" type="text" value="" /><br class="clean" />
                            </div>
                            <div class="err_re1">
                                <span class="field-validation-valid" data-valmsg-for="FullName" data-valmsg-replace="true"></span>
                            </div>
                            <div class="row">
                                <span class="row_L1">Email<font class="other_color_star">*</font></span>
                                <input class="text" data-val="true" data-val-regex="Email Address is not valid." data-val-regex-pattern="^[-!#$%&amp;&#39;*+/0-9=?A-Z^_a-z{|}~](\.?[-!#$%&amp;&#39;*+/0-9=?A-Z^_a-z{|}~])*@[a-zA-Z](-?[a-zA-Z0-9])*(\.[a-zA-Z](-?[a-zA-Z0-9])*)+$" data-val-required="Please Enter Email Address." id="RegisterEmail" name="RegisterEmail" placeholder="Email Address" type="text" value="" />
                                <br class="clean" />
                            </div>
                            <div class="err_re1">
                                <span class="field-validation-valid" data-valmsg-for="RegisterEmail" data-valmsg-replace="true" id="emailValidationMessage"></span>
                            </div>
                            <div class="row">
                                <span class="row_L1">Mobile<font class="other_color_star">*</font></span>
                                <input class="text" data-val="true" data-val-regex="Mobile Number is not valid." data-val-regex-pattern="09\d{8}|01\d{9}" data-val-required="Please Enter Mobile Number." id="Mobile" name="Mobile" placeholder="Mobile Number" type="text" value="" /><br class="clean" />
                            </div>
                            <div class="err_re1">
                                <span class="field-validation-valid" data-valmsg-for="Mobile" data-valmsg-replace="true"></span>
                            </div>

                        </div>
                        <div class="re_form_B">
                            <p>
                                <input checked="checked" data-val="true" data-val-requireacceptterms=" " data-val-requireacceptterms-param="title_item_note" data-val-regex="The AcceptTerms field is required." data-val-required="The AcceptTerms field is required." id="AcceptTerms" name="AcceptTerms" type="checkbox" value="true" /><input name="AcceptTerms" type="hidden" value="false" />
                                <span class="title_item_note2">&nbsp;&nbsp;Yes, I have read and accept the aTourist Terms of Use.</span>
                                <span class="field-validation-valid" data-valmsg-for="AcceptTerms" data-valmsg-replace="true"></span>
                            </p>
                        </div>
                        <div>
                            <p style="padding-top: 15px; text-align: left;">
                                <button type="submit" class="button-signup">Create My Account &raquo;</button>
                            </p>
                        </div>
                    </form>    </dd>
            </dl>
        </div>
    </div>
</div>
