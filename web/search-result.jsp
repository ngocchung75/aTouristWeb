<%-- 
    Document   : search-result
    Created on : Jan 10, 2014, 2:54:57 AM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en" class="a">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Result : Asean Tourist</title>
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
                    <div>
                        <img src="temp/danang-rong.jpg" alt="Placeholder" width="693" height="200"> 
                    </div>
                    <form action="./" method="post" class="module-b">
                        <fieldset>
                            <nav class="pagination-a" style="z-index: 19;">
                                <p>Page 01 of 06</p>
                                <ol>
                                    <li class="prev"><a href="./">Previous</a></li>
                                    <li class="active"><a href="./" style="cursor: default; text-decoration: none;">01</a></li>
                                    <li><a href="./">02</a></li>
                                    <li><a href="./">03</a></li>
                                    <li><a href="./">04</a></li>
                                    <li class="next"><a href="./">Next</a></li>
                                </ol>
                            </nav>
                        </fieldset>
                    </form>
                    <div class="news-a">
                        <article>
                            <header>
                                <h2><a href="#">Novotel Danang Hotel</a></h2>
                                <figure><img src="temp/novotel.jpg" alt="Placeholder" width="128" height="102"></figure>
                                <p>36 Bach Dang Street, Han River, Da Nang, Vietnam</p><div class="fit-a"></div>
                            </header>
                            <p>Conveniently located in Da Nang, Novotel Danang Premier Han River is a great base from which to explore this vibrant city...</p>
                            <footer>
                                <p class="link-b"><a href="search-details.jsp">View Details</a></p>
                            </footer>
                        </article>
                        <article>
                            <header>
                                <h2><a href="#">Muong Thanh Hotel</a></h2>
                                <figure><img src="temp/muongthanh.jpg" alt="Placeholder" width="128" height="102"></figure>
                                <p>962 Ngo Quyen, Son Tra District, Han River, Da Nang, Vietnam</p><div class="fit-a"></div>
                            </header>
                            <p>If what you're looking for is a conveniently located hotel in Da Nang, look no further than Muong Thanh Da Nang Hotel...</p>
                            <footer>
                                <p class="link-b"><a href="search-details.jsp">View Details</a></p>
                            </footer>
                        </article>

                        <footer>
                            <nav class="pagination-a">
                                <p>Page 01 of 06</p>
                                <ol>
                                    <li class="prev"><a href="./">Previous</a></li>
                                    <li class="active"><a href="./" style="cursor: default; text-decoration: none;">01</a></li>
                                    <li><a href="./">02</a></li>
                                    <li><a href="./">03</a></li>
                                    <li><a href="./">04</a></li>
                                    <li class="next"><a href="./">Next</a></li>
                                </ol>
                            </nav>
                        </footer>
                    </div>
                </div>
                <aside>

                    <div class="form-c">
                        <fieldset>
                            <legend>Book now</legend>
                            <h3><span>01.</span> What?</h3>
                            <p>Hotel</p>

                            <h3><span>02.</span> Where?</h3>
                            <p>Danang, Vietnam</p>

                            <h3><span>03.</span> When?</h3>
                            <p>Check in: 20 - Jan - 2014</p>
                            <p>Check out: 22 - Jan - 2014</p>
                            <p>Nights: 2</p>

                            <h3><span>04.</span> Who?</h3>
                            <p>No. Rooms: 2</p>
                            <p>No. Peoples: 3</p>
                        </fieldset></div>

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
