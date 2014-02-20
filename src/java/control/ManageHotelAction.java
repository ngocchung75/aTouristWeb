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
import model.HotelBean;
import model.UserBean;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author CHUNG TOOC
 */
public class ManageHotelAction extends ActionSupport implements SessionAware {
    
    private int HotelID;
    private String HotelNameNew;
    private int UserIDNew;
    private int HotelIDUpdate;
    private int UserIDUpdate;
    
    private Map<String, Object> sessionMap;
    HotelBean hotelBean;
    UserBean userBean;
    private List<HotelBean> hotelList;
    private List<HotelBean> hotelList1;
    private List<UserBean> userList;
    private int check;
    
    public String GetAllHotelView() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        HotelBean hotel123 = (HotelBean) session.get("update_hotel");
        session.remove("all_hotel");
        session.remove("all_user");
        
        hotelBean = new HotelBean();
        hotelList = new ArrayList();
        hotelList = hotelBean.getAllHotel();
        
        userBean = new UserBean();
        userList = new ArrayList();
        userList = userBean.getAllUsersRole(3);
        
        if (hotel123 == null) {
            session.remove("update_hotel");
            HotelBean hotelList12 = new HotelBean();
            hotelList12.setCityID(1);
            session.put("update_hotel", hotelList12);
        }
        
        session.put("all_hotel", hotelList);
        session.put("all_user", userList);
        return "success";
    }
    
    public String AddNewHotel() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        hotelBean = new HotelBean();
        HotelBean hotelNew = new HotelBean();
        hotelNew.setHotelID(1);
        hotelNew.setUserID(this.UserIDNew);
        hotelNew.setHotelName(this.HotelNameNew);
        hotelNew.setHotelEmail("email@domain.com");
        hotelNew.setHotelPhone("Hotel phone");
        hotelNew.setHotelAddress("Hotel Address");
        hotelNew.setCityID(1);
        hotelNew.setHotelMap("Hotel Map");
        hotelNew.setHotelRating("f");
        hotelNew.setHotelDes("Hotel description");
        hotelNew.setHotelDesShort("Hotel description short");
        hotelNew.setHotelPol("Hotel Policies");
        hotelNew.setHotelFac("Hotel Facilities");
        hotelNew.setHotelImage("img/images-default-hotel.jpg");
        hotelNew.setHotelWebsite("Hotel website");
        hotelNew.setHotelPriceFrom("100");
        hotelNew.setTimeCheckIn("12 : 00 am");
        hotelNew.setTimeCheckOut("02 : 00 pm");
        
        hotelBean.addHotel(hotelNew);
        
        return "success";
    }
    
    public String SaveUpdateHotel() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        hotelBean = new HotelBean();
        hotelBean.updateHotelAdmin(this.HotelIDUpdate, this.UserIDUpdate);
        
        return "success";
    }
    
    public String UpdateHotel() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        session.remove("update_hotel");
        hotelBean = new HotelBean();
        HotelBean hotelList15 = new HotelBean();
        hotelList15 = hotelBean.getHotel(this.HotelID);
        
        session.put("update_hotel", hotelList15);
        return "success";
    }
    
    public String DeleteHotel() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        hotelBean = new HotelBean();
        int hotelID = Integer.valueOf(this.HotelID);
        check = hotelBean.deleteHotel(hotelID);
        if (check > 0) {
            addActionError("Delete Hotel successful");
            return "success";
        }
        addActionError("System error has occurred please try again later.");
        return "error";
    }
    
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    
    public String getHotelNameNew() {
        return HotelNameNew;
    }
    
    public void setHotelNameNew(String HotelNameNew) {
        this.HotelNameNew = HotelNameNew;
    }
    
    public int getUserIDNew() {
        return UserIDNew;
    }
    
    public void setUserIDNew(int UserIDNew) {
        this.UserIDNew = UserIDNew;
    }
    
    public int getHotelID() {
        return HotelID;
    }
    
    public void setHotelID(int HotelID) {
        this.HotelID = HotelID;
    }
    
    public int getHotelIDUpdate() {
        return HotelIDUpdate;
    }
    
    public void setHotelIDUpdate(int HotelIDUpdate) {
        this.HotelIDUpdate = HotelIDUpdate;
    }
    
    public int getUserIDUpdate() {
        return UserIDUpdate;
    }
    
    public void setUserIDUpdate(int UserIDUpdate) {
        this.UserIDUpdate = UserIDUpdate;
    }
    
}
