<%-- 
    Document   : aboutus
    Created on : Dec 17, 2013, 10:32:50 PM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
                    <s:if test="#session.logined == 'true' && #session.session-role == 2">
                        <%@include file="pages/nav-user.jsp" %>
                    </s:if><s:else>
                        <%@include file="pages/nav.jsp" %>
                    </s:else>
                </nav>
                <%@include file="pages/search.jsp" %>
            </header>         
            <nav id="breadcrumbs">
                <ul>
                    <li><a href="./">Home</a></li>
                    <li>About us</li>
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
                    <h3>About us</h3>
                    <li><span>Bamboo Company Limited</span></li>
                    <li><span>Chung, Ha Ngoc – CIO, Bamboo Co., Ltd</span></li>
                    <li><span>Mobile: (84) - 972 878 218</span></li>
                    <li><span>Email: chunghn@atourist.net</span></li>
                    <li><span>Address: No.182 - Nguyen Van Linh Street, Danang City, Vietnam</span></li>
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
