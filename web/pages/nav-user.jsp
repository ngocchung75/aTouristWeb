<%-- 
    Document   : nav-user
    Created on : Dec 21, 2013, 1:01:03 AM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<ul class="primary">
    <li><a accesskey="1" href="./">Home</a> <em>(1)</em></li>
    <li><a accesskey="2" href="hotellist.jsp">Hotel List</a> <em>(2)</em></li>
    <li><a accesskey="3" href="index-b.jsp">Hot Deal</a> <em>(3)</em></li>
    <li><a accesskey="4" href="aboutus.jsp">About us</a> <em>(4)</em></li>
    <li><a accesskey="5" href="contact.jsp">Contact</a> <em>(5)</em></li>
</ul>
<ul class="secondary">
    <li>
        <div id="google_translate_element"></div><script>
            function googleTranslateElementInit() {
                new google.translate.TranslateElement({
                    pageLanguage: 'en',
                    layout: google.translate.TranslateElement.InlineLayout.SIMPLE
                }, 'google_translate_element');
            }
        </script><script src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
    </li>
    <li>
        <p style="font-size: 1.2em;"><img src="images/account_icon.png" alt="account icon" height="20" width="20">Hi, ${sessionScope.userName}! (<a id="lbtMyAccount" href="mydashboard.jsp">My Account</a> | <a id="lbtSignOut" href="signout.jsp">Sign Out</a>)</p>
    </li>
</ul>
