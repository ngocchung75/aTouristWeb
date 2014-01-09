<%-- 
    Document   : hoteldetails
    Created on : Jan 8, 2014, 11:44:19 AM
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
                    <div>
                        <img src="temp/novotel-lag.jpg" alt="Placeholder" width="693" height="230"> 
                    </div>
                    <div class="tabs-a">
                        <ul>
                            <li class="current">Overview</li>
                            <li>Facilities</li>
                            <li class="">Show on map</li>
                        </ul>
                        <div>
                            <div style="display: block;">
                                <p>Conveniently located in Da Nang, Novotel Danang Premier Han River is a great base from which to explore this vibrant city. From here, guests can enjoy easy access to all that the lively city has to offer. Danang has been title by the government to be the essential city of the key economic zone in central Vietnam, the entrance to the UNESCO World Heritages sites, and the East-West Corridor connecting with Laos, Thailand and Myanmar. For sightseeing options and local attractions, one need not look far as the hotel enjoys close proximity to Han River Swing Bridge, and Indochina Riverside Towers. Uniquely situated in Danang inner city on the beautiful West Bank of the Han River, Novotel Danang Premier Han River is the ideal place for both business and leisure travelers. It is one of the first upscale internationally-managed hotels and serviced apartments in Danang.</p>
                                <ul class="list-b">
                                    <li><span>Check - In Time:</span> 12 : 00 am</li>
                                    <li><span>Check - Out Time:</span> 02 : 00 pm</li>
                                </ul>
                                <p class="adr"><span class="street-address">No.36 Bach Dang Street, Han River, Da Nang, Vietnam</span></p>
                                <p class="tel">(+84) 93 668 2236</p>
                                <p><a rel="external" class="url" href="http://novotel-danang-premier.com/">http://www.novotel-danang-premier.com/</a></p>
                            </div>
                            <div style="display: none;">
                                <h3>Facilities</h3>
                                <div class="triple-a">
                                    <ul>
                                        <li>Wifi</li>
                                        <li>Beachfront</li>
                                        <li>Hospital</li>
                                        <li>Flight</li>
                                    </ul>
                                    <ul>
                                        <li>Wifi</li>
                                        <li>Taxi &amp; car hire</li>
                                        <li>Ironing boad</li>
                                        <li>Coffee bars</li>
                                    </ul>
                                    <ul>
                                        <li>Karaoke</li>
                                        <li>Foot Massage</li>
                                        <li>Bars</li>
                                        <li>Airport Shuttle</li>
                                    </ul>
                                </div>
                                <h3>Policies</h3>
                                <p>Please be informed that Superior room type only accept maximum occupacy of 2 person including children.</p>
                            </div>

                            <div style="display: none;">
                                <iframe width="640" height="480" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Hotel+Novotel+Danang+Premier+Han+River&amp;aq=&amp;sll=37.0625,-95.677068&amp;sspn=47.704107,99.931641&amp;ie=UTF8&amp;hq=Hotel+Novotel+Premier+Han+River&amp;hnear=Da+Nang,+Thanh+Kh%C3%AA,+Da+Nang,+Vietnam&amp;t=m&amp;cid=15854477060324217521&amp;ll=16.087011,108.224087&amp;spn=0.019793,0.027466&amp;z=15&amp;iwloc=A&amp;output=embed"></iframe><br /><small><a href="https://maps.google.com/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Hotel+Novotel+Danang+Premier+Han+River&amp;aq=&amp;sll=37.0625,-95.677068&amp;sspn=47.704107,99.931641&amp;ie=UTF8&amp;hq=Hotel+Novotel+Premier+Han+River&amp;hnear=Da+Nang,+Thanh+Kh%C3%AA,+Da+Nang,+Vietnam&amp;t=m&amp;cid=15854477060324217521&amp;ll=16.087011,108.224087&amp;spn=0.019793,0.027466&amp;z=15&amp;iwloc=A" style="color:#0000FF;text-align:left">View Larger Map</a></small>
                            </div>
                            <div style="display: none;">

                            </div>

                        </div>
                    </div>
                </article>
                <aside>
                    <h2 class="fn org">Novotel Danang Hotel</h2>
                    <p class="scheme-a">No.36 Bach Dang Street, Han River, Da Nang, Vietnam 
                    </p>
                    <p class="scheme-b">Price From <span>$360 <span>/ Night</span></span></p>

                    <form action="./" method="post" class="form-a">
                        <fieldset>
                            <legend>Booking form</legend>
                            <p class="date-a">
                                <span>
                                    <label for="faa">Check in</label>
                                    <input type="text" id="faa" name="faa" required>
                                </span>
                                <span>
                                    <label for="fab">Check Out</label>
                                    <input type="text" id="fab" name="fab" required>
                                </span>
                            </p>
                            <p class="select-a">
                                <span>
                                    <label for="fce">No. Rooms</label>
                                    <select id="fce" name="fce">
                                        <option>01</option>
                                        <option>02</option>
                                        <option>03</option>
                                        <option>04</option>
                                        <option>05</option>
                                    </select>
                                </span>
                                <span>
                                    <label for="fcf">No. Peoples</label>
                                    <select id="fcf" name="fcf">
                                        <option>01</option>
                                        <option>02</option>
                                        <option>03</option>
                                        <option>04</option>
                                        <option>05</option>
                                    </select>
                                </span>
                            </p>
                            <p class="submit"><button type="submit">Book now</button></p>
                        </fieldset>
                    </form>

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
