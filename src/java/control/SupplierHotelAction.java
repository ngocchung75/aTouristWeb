/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.CityBean;
import model.HotelBean;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author CHUNG TOOC
 */
public class SupplierHotelAction extends ActionSupport implements SessionAware {

    private int HotelIDUpdate;
    private int UserIDUpdate;
    private String HotelNameUpdate;
    private String HotelEmailUpdate;
    private String HotelPhoneUpdate;
    private String HotelAddressUpdate;
    private int CityIDUpdate;
    private String HotelMapUpdate;
    private String HotelRatingUpdate;
    private String HotelDesUpdate;
    private String HotelDesShortUpdate;
    private String HotelPolUpdate;
    private String HotelFacUpdate;
    private String HotelImageUpdate;
    private String HotelWebsiteUpdate;
    private String HotelPriceFromUpdate;
    private String TimeCheckInUpdate;
    private String TimeCheckOutUpdate;

    private Map<String, Object> sessionMap;
    HotelBean hotelBean;

    public String GetSupplierHotelView() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        String checklogin = (String) session.get("logined");
        if (!"true".equals(checklogin)) {
            return "error";
        } else {
            int userID123 = (Integer) session.get("session-userid");
            session.remove("hotel_supplier");
            session.remove("city_list");
            hotelBean = new HotelBean();
            HotelBean hotelList1 = new HotelBean();
            CityBean cityBean = new CityBean();
            List<CityBean> cityList;
            cityList = new ArrayList();
            cityList = cityBean.getAllCity();

            hotelList1 = hotelBean.getHotelWithUserID(userID123);

            session.put("hotel_supplier", hotelList1);
            session.put("city_list", cityList);
            return "success";
        }
    }

    public String SaveSupplierHotel() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        hotelBean = new HotelBean();
        HotelBean hotelList12 = new HotelBean();
        hotelList12.setHotelID(this.HotelIDUpdate);
        hotelList12.setUserID(this.UserIDUpdate);
        hotelList12.setHotelName(this.HotelNameUpdate);
        hotelList12.setHotelEmail(this.HotelEmailUpdate);
        hotelList12.setHotelPhone(this.HotelPhoneUpdate);
        hotelList12.setHotelAddress(this.HotelAddressUpdate);
        hotelList12.setCityID(this.CityIDUpdate);
        hotelList12.setHotelMap(this.HotelMapUpdate);
        hotelList12.setHotelRating(this.HotelRatingUpdate);
        hotelList12.setHotelDes(this.HotelDesUpdate);
        hotelList12.setHotelDesShort(this.HotelDesShortUpdate);
        hotelList12.setHotelPol(this.HotelPolUpdate);
        hotelList12.setHotelFac(this.HotelFacUpdate);
        hotelList12.setHotelImage(this.HotelImageUpdate);
        hotelList12.setHotelWebsite(this.HotelWebsiteUpdate);
        hotelList12.setHotelPriceFrom(this.HotelPriceFromUpdate);
        hotelList12.setTimeCheckIn(this.TimeCheckInUpdate);
        hotelList12.setTimeCheckOut(this.TimeCheckOutUpdate);

        hotelBean.updateHotel(hotelList12);

        return "success";
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public int getHotelIDUpdate() {
        return HotelIDUpdate;
    }

    public void setHotelIDUpdate(int HotelIDUpdate) {
        this.HotelIDUpdate = HotelIDUpdate;
    }

    public String getHotelNameUpdate() {
        return HotelNameUpdate;
    }

    public void setHotelNameUpdate(String HotelNameUpdate) {
        this.HotelNameUpdate = HotelNameUpdate;
    }

    public String getHotelEmailUpdate() {
        return HotelEmailUpdate;
    }

    public void setHotelEmailUpdate(String HotelEmailUpdate) {
        this.HotelEmailUpdate = HotelEmailUpdate;
    }

    public String getHotelPhoneUpdate() {
        return HotelPhoneUpdate;
    }

    public void setHotelPhoneUpdate(String HotelPhoneUpdate) {
        this.HotelPhoneUpdate = HotelPhoneUpdate;
    }

    public String getHotelAddressUpdate() {
        return HotelAddressUpdate;
    }

    public void setHotelAddressUpdate(String HotelAddressUpdate) {
        this.HotelAddressUpdate = HotelAddressUpdate;
    }

    public int getCityIDUpdate() {
        return CityIDUpdate;
    }

    public void setCityIDUpdate(int CityIDUpdate) {
        this.CityIDUpdate = CityIDUpdate;
    }

    public String getHotelMapUpdate() {
        return HotelMapUpdate;
    }

    public void setHotelMapUpdate(String HotelMapUpdate) {
        this.HotelMapUpdate = HotelMapUpdate;
    }

    public String getHotelRatingUpdate() {
        return HotelRatingUpdate;
    }

    public void setHotelRatingUpdate(String HotelRatingUpdate) {
        this.HotelRatingUpdate = HotelRatingUpdate;
    }

    public String getHotelDesUpdate() {
        return HotelDesUpdate;
    }

    public void setHotelDesUpdate(String HotelDesUpdate) {
        this.HotelDesUpdate = HotelDesUpdate;
    }

    public String getHotelDesShortUpdate() {
        return HotelDesShortUpdate;
    }

    public void setHotelDesShortUpdate(String HotelDesShortUpdate) {
        this.HotelDesShortUpdate = HotelDesShortUpdate;
    }

    public String getHotelPolUpdate() {
        return HotelPolUpdate;
    }

    public void setHotelPolUpdate(String HotelPolUpdate) {
        this.HotelPolUpdate = HotelPolUpdate;
    }

    public String getHotelFacUpdate() {
        return HotelFacUpdate;
    }

    public void setHotelFacUpdate(String HotelFacUpdate) {
        this.HotelFacUpdate = HotelFacUpdate;
    }

    public String getHotelImageUpdate() {
        return HotelImageUpdate;
    }

    public void setHotelImageUpdate(String HotelImageUpdate) {
        this.HotelImageUpdate = HotelImageUpdate;
    }

    public String getHotelWebsiteUpdate() {
        return HotelWebsiteUpdate;
    }

    public void setHotelWebsiteUpdate(String HotelWebsiteUpdate) {
        this.HotelWebsiteUpdate = HotelWebsiteUpdate;
    }

    public String getHotelPriceFromUpdate() {
        return HotelPriceFromUpdate;
    }

    public void setHotelPriceFromUpdate(String HotelPriceFromUpdate) {
        this.HotelPriceFromUpdate = HotelPriceFromUpdate;
    }

    public String getTimeCheckInUpdate() {
        return TimeCheckInUpdate;
    }

    public void setTimeCheckInUpdate(String TimeCheckInUpdate) {
        this.TimeCheckInUpdate = TimeCheckInUpdate;
    }

    public String getTimeCheckOutUpdate() {
        return TimeCheckOutUpdate;
    }

    public void setTimeCheckOutUpdate(String TimeCheckOutUpdate) {
        this.TimeCheckOutUpdate = TimeCheckOutUpdate;
    }

    public int getUserIDUpdate() {
        return UserIDUpdate;
    }

    public void setUserIDUpdate(int UserIDUpdate) {
        this.UserIDUpdate = UserIDUpdate;
    }

}
