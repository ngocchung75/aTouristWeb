<%-- 
    Document   : booknow
    Created on : Dec 3, 2013, 10:54:26 AM
    Author     : CHUNG TOOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fieldset>
    <legend>Book now</legend>
    <h3><span>01.</span> What?</h3>
    <ul class="check-c">
        <li><label for="fcaa"><input type="radio" id="fcaa" name="fca" checked="checked" /> Hotels</label></li>
        <li><label for="fcab"><input type="radio" id="fcab" name="fca" disabled="disabled"> Flights</label></li>
        <li><label for="fcac"><input type="radio" id="fcac" name="fca" disabled="disabled"> Cars</label></li>
        <li><label for="fcad"><input type="radio" id="fcad" name="fca" disabled="disabled"> Rent car</label></li>
        <li><label for="fcae"><input type="radio" id="fcae" name="fca" disabled="disabled"> Cruise</label></li>
        <li><label for="fcaf"><input type="radio" id="fcaf" name="fca" disabled="disabled"> All</label></li>
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