<%-- 
    Document   : prebook
    Created on : Jan 10, 2014, 12:23:26 AM
    Author     : CHUNG TOOC
--%>

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
                    <%@include file="pages/nav.jsp" %>
                    <p class="link-a"><a id="go" name="login" href="./signup.jsp">Login</a> <a id="go" name="signup" href="./signup.jsp">Register</a></p>
                </nav>
                <%@include file="pages/search.jsp" %>
            </header>         

            <section id="content" class="cols-a">
                <article class="vcard">
                    <header class="module-a">
                        <h2 class="fn org">Novotel Danang Hotel</h2>
                        <p class="rating-a f">5/5</p>
                        <p class="link"><a href="hotellist.jsp">Return</a></p>
                    </header>
                    <div class="tabs-a">
                        <ul>
                            <li class="current">Choose Your Room</li>
                        </ul>
                        <div>
                            <div>
                                <ul class="list-b">
                                    <li><span>Check in:</span> 20 - Jan - 2014</li>
                                    <li><span>Check out:</span> 22 - Jan - 2014</li>
                                    <li><span>Nights:</span> 2</li>
                                    <li><span>No. Rooms:</span> 2</li>
                                    <li><span>No. Peoples:</span> 3</li>
                                </ul>
                                <ul class="check-a">
                                    <li><label for="faca">Double Room 1<span>$360 <span>/ night</span></span>
                                            <input type="radio" id="faca" name="fac"></label></li>
                                    <p>Room info: 26 m², Air Conditioning, Flat-screen TV</p>
                                    <li><label for="facb">Double Room 2<span>$450 <span>/ night</span></span>
                                            <input type="radio" id="facb" name="fac"></label></li>
                                    <p>Room info: 32 m², Flat-screen TV, Air Conditioning, Bath, City/River view</p>
                                </ul>
                                <p class="scheme-c"><b>Total Booking </b><span><span>$</span>720</span></p>
                                <input type="submit" value=" Book now " class="button-book" style="margin-left: 560px; margin-top: -50px;">
                            </div>
                        </div>
                    </div>
                </article>
                <aside>
                    <h2 class="fn org">Novotel Danang Hotel</h2>
                    <p class="scheme-a">No.36 Bach Dang Street, Han River, Da Nang, Vietnam</p>
                    <p>Email Address</span> Novotel@gmail.com</p>
                    <p>Mobile</span> 05113.333.333</p>
                    <p class="scheme-b">Price From <span>$360 <span>/ Night</span></span></p>
                </aside>
            </section>

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
