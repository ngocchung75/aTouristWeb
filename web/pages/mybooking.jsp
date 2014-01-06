<%-- 
    Document   : mybooking
    Created on : Jan 6, 2014, 11:11:46 AM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="rightpage2">
    <div id="ctl00_ctl00_MainContent_ContentMain_udpBooking">
        <p class="text_head">My Bookings</p>
        <div class="menu_myrewards">
            <a id="ctl00_ctl00_MainContent_ContentMain_lbtTotalBooking" class="rewardMenuActive" href="javascript:__doPostBack('ctl00$ctl00$MainContent$ContentMain$lbtTotalBooking','')">0 Total Bookings</a>
            <a id="ctl00_ctl00_MainContent_ContentMain_lbtUpcomingBooking" href="javascript:__doPostBack('ctl00$ctl00$MainContent$ContentMain$lbtUpcomingBooking','')">0 Upcoming</a>
            <a id="ctl00_ctl00_MainContent_ContentMain_lbtDepartBooking" href="javascript:__doPostBack('ctl00$ctl00$MainContent$ContentMain$lbtDepartBooking','')">0 Departed</a>
            <a id="ctl00_ctl00_MainContent_ContentMain_lbtCancelledBooking" href="javascript:__doPostBack('ctl00$ctl00$MainContent$ContentMain$lbtCancelledBooking','')">0 Cancelled</a>
            <div class="clear">&nbsp;</div>      
        </div>
        <div class="clear">&nbsp;</div>
        You currently have no active bookings to manage.
        <div class="clear">&nbsp;</div>

        <div id="ctl00_ctl00_MainContent_ContentMain_upg" style="display:none;" role="status" aria-hidden="true">
            <div class="rewardMask">&nbsp;</div>
            <img src="https://img.agoda.net/images/default/Rewardv2/preload.gif" width="20" height="20" alt="" class="loadingImage">
        </div>
    </div>
</div>
