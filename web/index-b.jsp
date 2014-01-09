<%-- 
    Document   : index-b
    Created on : Jan 10, 2014, 3:15:01 AM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en" class="a">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel List : Asean Tourist</title>
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

            <article id="content" class="cols-c">
                <div>
                    <div class="slider-a">
                        <figure class="image-b"><img src="temp/693x276.gif"  alt="Placeholder" width="693" height="276"> <figcaption>Paris Eurostar Breaks</figcaption></figure>
                        <figure class="image-a"><img src="temp/693x276(2).gif" alt="Placeholder" width="693" height="276"> <figcaption>Paris Eurostar Breaks <span>Curabitur fringilla mauris interdum nec magna</span> <span>From $350</span></figcaption></figure>
                        <figure><img src="temp/693x276(1).gif" alt="Placeholder" width="693" height="276"></figure>
                    </div>

                    <h2 class="header-a">Hot deal</h2>

                    <div class="news-b">
                        <article>
                            <header>
                                <figure><img src="temp/217x131.gif"  alt="Placeholder" width="217" height="131"> <span class="a">Hot</span></figure>
                                <h2><a href="#">Sheraton hanoi Hotel</a></h2>
                            </header>
                            <p>Lorem ipsum dolor sit saelas met lo nsecttur ads ipi deese cing...</p>
                            <p class="scheme-e"><span>$</span>900 <a href="hoteldetails.jsp">Book</a></p>
                            <p class="link-b"><a href="hoteldetails.jsp">View Details</a></p>
                        </article>
                        <article>
                            <header>
                                <figure><img src="temp/217x131(1).gif"  alt="Placeholder" width="217" height="131"> <span class="a">Hot</span></figure>
                                <h2><a href="#">Taj hanoi Hotel</a></h2>
                            </header>
                            <p>Lorem ipsum dolor sit saelas met lo nsecttur ads ipi deese cing...</p>
                            <p class="scheme-e"><span>$</span>450 <a href="hoteldetails.jsp">Book</a></p>
                            <p class="link-b"><a href="hoteldetails.jsp">View Details</a></p>
                        </article>
                        <article>
                            <header>
                                <figure><img src="temp/217x131(2).gif"  alt="Placeholder" width="217" height="131"> <span class="a">Hot</span></figure>
                                <h2><a href="#">Hanoi Sheraton Hotel</a></h2>
                            </header>
                            <p>Lorem ipsum dolor sit saelas met lo nsecttur ads ipi deese cing...</p>
                            <p class="scheme-e"><span>$</span>355 <a href="hoteldetails.jsp">Book</a></p>
                            <p class="link-b"><a href="hoteldetails.jsp">View Details</a></p>
                        </article>
                        <article>
                            <header>
                                <figure><img src="temp/217x131(3).gif"  alt="Placeholder" width="217" height="131"> <span class="a">Hot</span></figure>
                                <h2><a href="#">Lorem Impsum Hotel</a></h2>
                            </header>
                            <p>Lorem ipsum dolor sit saelas met lo nsecttur ads ipi deese cing...</p>
                            <p class="scheme-e"><span>$</span>600 <a href="hoteldetails.jsp">Book</a></p>
                            <p class="link-b"><a href="hoteldetails.jsp">View Details</a></p>
                        </article>
                        <article>
                            <header>
                                <figure><img src="temp/217x131(4).gif"  alt="Placeholder" width="217" height="131"> <span class="a">Hot</span></figure>
                                <h2><a href="#">Just Another Hotel</a></h2>
                            </header>
                            <p>Lorem ipsum dolor sit saelas met lo nsecttur ads ipi deese cing...</p>
                            <p class="scheme-e"><span>$</span>250 <a href="hoteldetails.jsp">Book</a></p>
                            <p class="link-b"><a href="hoteldetails.jsp">View Details</a></p>
                        </article>
                        <article>
                            <header>
                                <figure><img src="temp/217x131(5).gif"  alt="Placeholder" width="217" height="131"> <span class="a">Hot</span></figure>
                                <h2><a href="#">Sheraton hanoi Hotel</a></h2>
                            </header>
                            <p>Lorem ipsum dolor sit saelas met lo nsecttur ads ipi deese cing...</p>
                            <p class="scheme-e"><span>$</span>500 <a href="hoteldetails.jsp">Book</a></p>
                            <p class="link-b"><a href="hoteldetails.jsp">View Details</a></p>
                        </article>

                    </div>
                </div>
                <aside>
                    <s:form action="booknow.action" method="post">
                        <%@include file="pages/booknow.jsp" %>
                    </s:form>
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
