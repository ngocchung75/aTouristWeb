/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
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
public class HotelListAction extends ActionSupport implements SessionAware {

    private int HotelID;
    private int UserID;
    private String HotelName;
    private String HotelEmail;
    private String HotelPhone;
    private String HotelAddress;
    private String HotelCity;
    private String HotelMap;
    private String HotelRating;
    private String HotelDes;
    private String HotelDesShort;
    private String HotelPol;
    private String HotelFac;
    private String HotelImage;
    private String HotelWebsite;
    private String HotelPriceFrom;
    private String TimeCheckIn;
    private String TimeCheckOut;

    private Boolean error;
    private Map<String, Object> sessionMap;
    HotelBean hotel;
    CityBean city;
    private List<HotelBean> hotellist;
    private List<CityBean> citylist;

    public HotelListAction() {
    }

    public String GetAllHotel() {

        Map session = ActionContext.getContext().getSession();
        session.remove("all_hotel");
        session.remove("searched");
        try {
            hotel = new HotelBean();
            hotellist = new ArrayList();
            hotellist = hotel.getAllHotel();

        } catch (ClassNotFoundException e) {
            addActionError("Error in retrieving: " + e.getMessage());
            return "error";
        } catch (SQLException e) {
            addActionError("Error in retrieving: " + e.getMessage());
            return "error";
        }

        session.put("all_hotel", hotellist);
        return "success";
    }

    public String GetDetailHotel() {

        Map session = ActionContext.getContext().getSession();
        session.remove("detail_hotel");
        session.remove("searched");
        try {
            hotel = new HotelBean();
            hotel = hotel.getHotel(this.HotelID);

        } catch (ClassNotFoundException e) {
            addActionError("Error in retrieving: " + e.getMessage());
            return "error";
        } catch (SQLException e) {
            addActionError("Error in retrieving: " + e.getMessage());
            return "error";
        }

        session.put("detail_hotel", hotel);
        return "success";
    }

    public String GetTopHotel() {

        Map session = ActionContext.getContext().getSession();
        session.remove("top_hotel");
        session.remove("city_list");
        try {
            hotel = new HotelBean();
            hotellist = new ArrayList();
            hotellist = hotel.getTopHotel();

            city = new CityBean();
            citylist = new ArrayList();
            citylist = city.getAllCity();

        } catch (ClassNotFoundException e) {
            addActionError("Error in retrieving: " + e.getMessage());
            return "error";
        } catch (SQLException e) {
            addActionError("Error in retrieving: " + e.getMessage());
            return "error";
        }

        session.put("top_hotel", hotellist);
        session.put("city_list", citylist);
        return "success";
    }

    @Override
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public int getHotelID() {
        return HotelID;
    }

    public void setHotelID(int HotelID) {
        this.HotelID = HotelID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String HotelName) {
        this.HotelName = HotelName;
    }

    public String getHotelEmail() {
        return HotelEmail;
    }

    public void setHotelEmail(String HotelEmail) {
        this.HotelEmail = HotelEmail;
    }

    public String getHotelPhone() {
        return HotelPhone;
    }

    public void setHotelPhone(String HotelPhone) {
        this.HotelPhone = HotelPhone;
    }

    public String getHotelAddress() {
        return HotelAddress;
    }

    public void setHotelAddress(String HotelAddress) {
        this.HotelAddress = HotelAddress;
    }

    public String getHotelCity() {
        return HotelCity;
    }

    public void setHotelCity(String HotelCity) {
        this.HotelCity = HotelCity;
    }

    public String getHotelMap() {
        return HotelMap;
    }

    public void setHotelMap(String HotelMap) {
        this.HotelMap = HotelMap;
    }

    public String getHotelDes() {
        return HotelDes;
    }

    public void setHotelDes(String HotelDes) {
        this.HotelDes = HotelDes;
    }

    public String getHotelPol() {
        return HotelPol;
    }

    public void setHotelPol(String HotelPol) {
        this.HotelPol = HotelPol;
    }

    public String getHotelFac() {
        return HotelFac;
    }

    public void setHotelFac(String HotelFac) {
        this.HotelFac = HotelFac;
    }

    public String getHotelImage() {
        return HotelImage;
    }

    public void setHotelImage(String HotelImage) {
        this.HotelImage = HotelImage;
    }

    public String getHotelPriceFrom() {
        return HotelPriceFrom;
    }

    public void setHotelPriceFrom(String HotelPriceFrom) {
        this.HotelPriceFrom = HotelPriceFrom;
    }

    public String getTimeCheckIn() {
        return TimeCheckIn;
    }

    public void setTimeCheckIn(String TimeCheckIn) {
        this.TimeCheckIn = TimeCheckIn;
    }

    public String getTimeCheckOut() {
        return TimeCheckOut;
    }

    public void setTimeCheckOut(String TimeCheckOut) {
        this.TimeCheckOut = TimeCheckOut;
    }

    public String getHotelRating() {
        return HotelRating;
    }

    public void setHotelRating(String HotelRating) {
        this.HotelRating = HotelRating;
    }

    public String getHotelDesShort() {
        return HotelDesShort;
    }

    public void setHotelDesShort(String HotelDesShort) {
        this.HotelDesShort = HotelDesShort;
    }

    public String getHotelWebsite() {
        return HotelWebsite;
    }

    public void setHotelWebsite(String HotelWebsite) {
        this.HotelWebsite = HotelWebsite;
    }

    public List<CityBean> getCitylist() {
        return citylist;
    }

    public void setCitylist(List<CityBean> citylist) {
        this.citylist = citylist;
    }

}
