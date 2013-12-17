<%-- 
    Document   : contact
    Created on : Dec 17, 2013, 10:32:37 PM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
                    <ul class="primary">
                        <li><a accesskey="1" href="./">Home</a> <em>(1)</em></li>
                        <li><a accesskey="2" href="#">Hotel List</a> <em>(2)</em></li>
                        <li><a accesskey="3" href="aboutus.jsp">About us</a> <em>(3)</em></li>
                        <li class="active"><a accesskey="4" href="contact.jsp">Contact</a> <em>(4)</em></li>
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
                <%@include file="pages/search.jsp" %>
            </header>         
            <nav id="breadcrumbs">
                <ul>
                    <li><a href="./">Home</a></li>
                    <li>Contact</li>
                </ul>
            </nav>                
            <article id="content" class="cols-b">
                <form  onSubmit="return submitForm();" action="" method="post" class="form-b" name="homefrm1" id="homefrm1">
                    <input type="hidden"  name="event" value="start" />
                    <fieldset>
                        <div id="alert">
                            <div class="message"></div>
                        </div>
                        <legend>Send Us a Message</legend>
                        <p>
                            <label for="fba">Your name</label>
                            <input type="text" id="fba" name="name" required>
                        </p>
                        <p>
                            <label for="fbb">Your email</label>
                            <input type="email" id="fbb" name="email" required>
                        </p>
                        <p>
                            <label for="fbc">Your message</label>
                            <textarea id="fbc" name="msg" required></textarea>
                        </p>
                        <p><button type="submit">Submit</button></p>
                    </fieldset>
                </form>
                <aside>
                    <h3>Location Map</h3>
                    <figure class="map-a"><img src="temp/622x318.gif"  alt="Placeholder" width="622" height="318"></figure>
                </aside>
            </article>
            <footer id="footer">
                <nav>
                    <div class="vcard">
                        <h3>Contact us <span class="fn org">Asean Tourist</span></h3>
                        <ul class="list-a">
                            <li><span>Tell</span> <span class="tel">(84) - 972 878 218</span></li>
                            <li><span>Email</span> <a class="email">contact//atourist/net</a></li>
                            <li class="adr"><span>Add</span> <span class="street-address">182 - Nguyen Van Linh Street</span>, <span class="locality">Danang</span> City, <span class="country-name">Vietnam</span></li>
                        </ul>
                    </div>
                    <div>
                        <h3>Support &amp; Help</h3>
                        <ul>
                            <li><a href="./">Payment options</a></li>
                            <li><a href="./">FAQ</a></li>
                            <li><a href="./">Privacy &amp; Policy</a></li>
                        </ul>
                    </div>
                    <div>
                        <h3>Information</h3>
                        <ul>
                            <li><a href="./">My account</a></li>
                            <li><a href="./">Sit map</a></li>
                            <li><a href="./">Order history</a></li>
                        </ul>
                    </div>
                    <form action="./" method="post">
                        <fieldset>
                            <legend>Newsletter</legend>
                            <p>Lorem emphasised est dolor sit ams...</p>
                            <p>
                                <label for="na">Enter your email</label>
                                <input type="email" id="na" name="na" required>
                                <button type="submit">Submit</button>
                            </p>
                        </fieldset>
                    </form>
                </nav>
                <%@include file="pages/footer.jsp" %>
            </footer>
        </div>
        <script src="http://maps.google.com/maps/api/js?sensor=false&amp;libraries=geometry&amp;language=en"></script>
        <script type="text/javascript">
                                head.js('javascript/jquery.min.js', 'javascript/jquery-ui.min.js', 'javascript/scripts.js', 'javascript/mobile.js')
        </script>
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
