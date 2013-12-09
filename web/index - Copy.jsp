<%-- 
    Document   : index
    Created on : Nov 10, 2013, 2:08:18 AM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="a">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage : Asean Tourist</title>
        <meta name="description" content="">
        <meta name="keywords" content="">
        <meta name="HandheldFriendly" content="True">
        <meta name="MobileOptimized" content="320">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="javascript/head.js"></script>
        <link rel="stylesheet" type="text/css" href="styles/screen.css" media="screen">
        <link rel="stylesheet" type="text/css" href="styles/print.css" media="print">
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    </head>
    <body>
        <div id="root">
            <header id="top">
                <h1><a href="./" accesskey="h"></a></h1>
                <nav id="skip">
                    <ul>
                        <li><a href="#nav" accesskey="n">Skip to navigation (n)</a></li>
                        <li><a href="#content" accesskey="c">Skip to content (c)</a></li>
                        <li><a href="#footer" accesskey="f">Skip to footer (f)</a></li>
                    </ul>
                </nav>
                <nav id="nav">
                    <ul class="primary">
                        <li class="active"><a accesskey="1" href="index.html">Home</a> <em>(1)</em></li>
                        <li><a accesskey="2" href="index-b.html">Alt Home</a> <em>(2)</em></li>
                        <li><a accesskey="3" href="#">All Pages</a> <em>(3)</em>
                            <ul>
                                <li class="active"><a href="index.html">Home</a></li>
                                <li><a href="index-b.html">Alt Home</a></li>
                                <li><a href="hotel-list.html">Hotel List</a></li>
                                <li><a href="hotel-details.html">Hotel Details</a></li>
                                <li><a href="hotel-grid.html">Hotel Grid</a></li>
                                <li><a href="booking-view.html">Booking View</a></li>
                                <li><a href="booking-confirm.html">Booking Confirm</a></li>
                                <li><a href="blog.html">Blog Listings</a></li>
                                <li><a href="blog-article.html">Blog Single</a></li>
                                <li><a href="contact.html">Contact</a></li>
                            </ul>
                        </li>

                        <li><a accesskey="4" href="#">Hotel Pages</a> <em>(4)</em>
                            <ul>
                                <li><a href="hotel-list.html">Hotel List</a></li>
                                <li><a href="hotel-details.html">Hotel Details</a></li>
                                <li><a href="hotel-grid.html">Hotel Grid</a></li>
                            </ul>
                        </li>

                        <li><a accesskey="5" href="#">Booking Pages</a> <em>(5)</em>
                            <ul>
                                <li><a href="booking-view.html">Booking View</a></li>
                                <li><a href="booking-confirm.html">Booking Confirm</a></li>
                            </ul>
                        </li>

                        <li><a accesskey="6" href="#">Blog</a> <em>(6)</em>
                            <ul>
                                <li><a href="blog.html">Blog Listings</a></li>
                                <li><a href="blog-article.html">Blog Single</a></li>
                            </ul>
                        </li>

                        <li><a accesskey="7" href="contact.html">Contact</a> <em>(7)</em></li>
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
                    </ul>
                    <p class="link-a"><a href="./">Login</a> <a href="./">Register</a></p>
                </nav>
                <form action="./" method="post" id="search">
                    <fieldset>
                        <legend>Search</legend>
                        <p>
                            <label for="sa">Search</label>
                            <input type="text" id="sa" name="sa" required>
                            <button type="submit">Submit</button>
                        </p>
                    </fieldset>
                </form>
                <p class="tel">Call us today <span>(84) - 972 878 218</span></p>
            </header>         
            <article id="home">
                <figure class="image-c"><a href="./"><img src="temp/danang2.jpg" alt="Featured" width="1260" height="754"></a> <figcaption>Need a luxury room for your holiday <span>Muong Thanh hotel</span> <span>$450  /  night</span></figcaption></figure>
                <form action="./" method="post" class="form-c">
                    <fieldset>
                        <legend>Book now</legend>
                        <h3><span>01.</span> What?</h3>
                        <ul class="check-c">
                            <li><label for="fcaa"><input type="radio" id="fcaa" name="fca" checked='checked'> Hotels</label></li>
                            <li><label for="fcab"><input type="radio" id="fcab" name="fca" disabled='disabled'> Flights</label></li>
                            <li><label for="fcac"><input type="radio" id="fcac" name="fca" > Cars</label></li>
                            <li><label for="fcad"><input type="radio" id="fcad" name="fca" > Rent car</label></li>
                            <li><label for="fcae"><input type="radio" id="fcae" name="fca" > Cruise</label></li>
                            <li><label for="fcaf"><input type="radio" id="fcaf" name="fca" > All</label></li>
                        </ul>
                        <h3><span>02.</span> Where?</h3>
                        <p class="select-c">
                            <label for="fcb">Location</label>
                            <select id="fcb" name="fcb">
                                <option>Danang, Vietnam</option>
                            </select>
                        </p>
                        <h3><span>03.</span> When?</h3>
                        <p class="date-a">
                            <span>
                                <label for="fcc">Check in</label>
                                <input type="text" id="fcc" name="fcc" required>
                            </span>
                            <span>
                                <label for="fcd">Check Out</label>
                                <input type="text" id="fcd" name="fcd" required>
                            </span>
                        </p>
                        <h3><span>04.</span> Who?</h3>
                        <p class="select-a">
                            <span>
                                <label for="fce">Rooms</label>
                                <select id="fce" name="fce">
                                    <option>01</option>
                                    <option>02</option>
                                    <option>03</option>
                                    <option>04</option>
                                    <option>05</option>
                                </select>
                            </span>
                            <span>
                                <label for="fcf">Adults</label>
                                <select id="fcf" name="fcf">
                                    <option>01</option>
                                    <option>02</option>
                                    <option>03</option>
                                    <option>04</option>
                                    <option>05</option>
                                </select>
                            </span>
                            <span>
                                <label for="fcg">Child</label>
                                <select id="fcg" name="fcg">
                                    <option>01</option>
                                    <option>02</option>
                                    <option>03</option>
                                    <option>04</option>
                                    <option>05</option>
                                </select>
                            </span>
                        </p>
                        <p class="submit"><button type="submit">Proceed</button></p>
                    </fieldset>
                </form>
            </article>
            <footer id="footer">
                <p>Copyright &copy; <span class="date">2013</span>. All rights reseved <a href="./">Asean Tourist</a></p>
                <ul id="social">
                    <li class="rs"><a rel="external" href="./">RSS</a></li>
                    <li class="tw"><a rel="external" href="./">Twitter</a></li>
                    <li class="fl"><a rel="external" href="./">Flickr</a></li>
                    <li class="fb"><a rel="external" href="./">Facebook</a></li>
                </ul>
            </footer>
        </div>
        <script src="http://maps.google.com/maps/api/js?sensor=false&amp;libraries=geometry&amp;language=en"></script>
        <script type="text/javascript">
                                head.js('javascript/jquery.min.js', 'javascript/jquery-ui.min.js', 'javascript/scripts.js', 'javascript/mobile.js')
        </script>
        <script type="text/javascript">

        </script>
    </body>
</html>
