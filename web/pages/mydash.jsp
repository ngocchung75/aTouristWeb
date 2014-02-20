<%-- 
    Document   : mydash
    Created on : Dec 21, 2013, 1:36:13 AM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="leftpage" style="z-index: 0;">

    <div class="menu1">
        <div id="sub_menu">
            <p class="text_account">My Account</p>
            <div class="account_email">
            </div>
        </div>
        <div id="ctl00_ctl00_MainContent_leftMenu1_udpMenu">

            <ul class="menu">
                <li>
                    <p class="menuline"></p>
                    <a id="ctl00_ctl00_MainContent_leftMenu1_lbtMyBooking" class="aspNetDisabled sprite_menu pic_menu1 rewardMenu" href="my-booking">My Bookings</a>
                </li>
                <li>
                    <p class="menuline"></p>
                    <a id="ctl00_ctl00_MainContent_leftMenu1_lbtMyProfile" class="aspNetDisabled sprite_menu pic_menu4" href="myprofile.jsp">My Profile</a>
                </li>
                <li>
                    <p class="menuline"></p>
                    <a id="ctl00_ctl00_MainContent_leftMenu1_lbtChangePassword" class="aspNetDisabled sprite_menu pic_menu5" href="changepass.jsp">Change Password</a>
                </li>
                <li class="lastmenu">
                    <p class="menuline"></p>
                    <a id="ctl00_ctl00_MainContent_leftMenu1_lbtSignOut" class="aspNetDisabled sprite_menu pic_menu7" href="signout.jsp">Sign Out</a>
                </li>
            </ul>

        </div>
    </div>
    
    <div class="rewards_menu2">
        <p class="text_submenu">aTourist Rewards</p>
        <p class="line_dashed"></p>
        <ul class="submenu">
            <li><span class="bullet">•</span> <a href="#">Earn Points Worth 4-7%</a></li>
            <li><span class="bullet">•</span> <a href="#">About aTourist Rewards</a></li>
            <li><span class="bullet">•</span> <a href="#">Rewards FAQ</a></li>
            <li><span class="bullet">•</span> <a href="#">Terms and Conditions</a></li>
        </ul>
    </div>



    <script type="text/javascript">
        $(document).ready(function() {
            rewardSession = new agodaRewardSession();
        });
    </script>
    <div id="rewardRefreshMask" class="hide"></div>
    <div class="refreshSessionImage hide">
        <img src="../images/mydash/Rewardv2/preload.gif" width="20" height="20" alt="" class="loadingImage">
        <br><br>
        Refreshing Session...
    </div>

</div>
