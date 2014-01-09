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
        <div id="root">
            <header id="top">
                <h1><a href="./" accesskey="h"></a></h1>
                <nav id="nav">
                    <%@include file="pages/nav.jsp" %>
                    <p class="link-a"><a id="go" name="login" href="./signup.jsp">Login</a> <a id="go" name="signup" href="./signup.jsp">Register</a></p>
                </nav>
                <%@include file="pages/search.jsp" %>
            </header>         
            <h2 style="margin-top: 50px;"><span>Thank you</span>, your booking is complete</h2>  
            <p>Your comfirmation number is ID <span>223686</span></p>          
            <article id="content" class="cols-d">
                <div>
                    <h3>Travel Information</h3>
                    <h4 class="scheme-g">Traveller Infomation</h4>
                    <ul class="list-c">
                        <li><span>Full Name</span> Chung Tooc</li>
                        <li><span>Email Address</span> chung@gmail.com</li>
                        <li><span>Address</span> Danang, Vietnam</li>
                        <li><span>Mobile</span> 0972878218</li>
                    </ul>
                    <h4 class="scheme-g">Payment</h4>
                    <p>Lorem ipsum dolor sit saelas met, consecttur ads ipi deese cing elit. Mauris fringilla bibe endums. Lorem ipsum dolor sit saelas met, consecttur ads ipi deese cing elit. Mauris fringilla </p>
                    <h4 class="scheme-g">Special Request</h4>
                    <p>Lorem ipsum dolor sit saelas met, consecttur ads ipi deese cing elit. Mauris fringilla bibe endums. Lorem ipsum dolor sit saelas met, consecttur ads ipi deese cing elit. Mauris fringilla </p>
                    <h4 class="scheme-g">Payment Bao Kim</h4>
                    <p class="link-c"><a href="./">Bao Kim</a></p>
                </div>
                <aside>
                    <h3>Hotel Summary</h3>
                    <div class="vcard a">
                        <h4 class="fn org">Novotel Danang Hotel</h4>
                        <p class="adr">No.36 Bach Dang Street, Han River, Da Nang, Vietnam</p>
                    </div>
                    <ul class="list-c">
                        <li><span>Email Address</span> Novotel@gmail.com</li>
                        <li><span>Mobile</span> 05113.333.333</li>
                    </ul>
                    <h4 class="scheme-g">Summary</h4>
                    <ul class="list-c">
                        <li><span>Room</span> Single Room</li>
                        <li><span>No. Rooms</span> 1</li>
                        <li><span>Price per night</span> $360</li>
                        <li><span>Check in</span> 20 - Jan - 2014</li>
                        <li><span>Check out</span> 22 - Jan - 2014</li>
                        <li><span>Time</span> 02 Nights</li>
                        <li><span>Grand Total</span> $790</li>
                        <li><span>Status</span> Pending</li>
                    </ul>
                </aside>
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
