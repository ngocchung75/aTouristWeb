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
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author CHUNG TOOC
 */
public class ManageCityAction extends ActionSupport implements SessionAware {
    
    private int CityID;
    private String HotelCityNew;
    private int CityIDUpdate;
    private String HotelCityUpdate;
    private Map<String, Object> sessionMap;
    CityBean cityBean;
    private List<CityBean> cityList;
    private int check;
    
    public String GetAllCityView() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        CityBean city123 = (CityBean) session.get("update_city");
        session.remove("all_city");
        
        cityBean = new CityBean();
        cityList = new ArrayList();
        cityList = cityBean.getAllCity();
        
        if (city123 == null) {
            session.remove("update_city");
            CityBean cityList1 = new CityBean();
            cityList1.setCityID(1);
            session.put("update_city", cityList1);
        }
        
        session.put("all_city", cityList);
        return "success";
    }
    
    public String AddNewCity() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        cityBean = new CityBean();
        cityBean.addCity(this.HotelCityNew);
        
        return "success";
    }
    
    public String SaveUpdateCity() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        cityBean = new CityBean();
        cityBean.updateCity(this.CityIDUpdate, this.HotelCityUpdate);
        
        return "success";
    }
    
    public String UpdateCity() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        session.remove("update_city");
        cityBean = new CityBean();
        CityBean cityList1 = new CityBean();
        cityList1 = cityBean.getCityWithID(this.CityID);
        
        session.put("update_city", cityList1);
        return "success";
    }
    
    public String DeleteCity() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        cityBean = new CityBean();
        int cityID = Integer.valueOf(this.CityID);
        check = cityBean.deleteCity(cityID);
        if (check > 0) {
            addActionError("Delete City successful");
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
    
    public int getCityID() {
        return CityID;
    }
    
    public void setCityID(int CityID) {
        this.CityID = CityID;
    }
    
    public String getHotelCityNew() {
        return HotelCityNew;
    }
    
    public void setHotelCityNew(String HotelCityNew) {
        this.HotelCityNew = HotelCityNew;
    }
    
    public int getCityIDUpdate() {
        return CityIDUpdate;
    }
    
    public void setCityIDUpdate(int CityIDUpdate) {
        this.CityIDUpdate = CityIDUpdate;
    }
    
    public String getHotelCityUpdate() {
        return HotelCityUpdate;
    }
    
    public void setHotelCityUpdate(String HotelCityUpdate) {
        this.HotelCityUpdate = HotelCityUpdate;
    }
    
}
