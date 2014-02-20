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
import model.TopHotelBean;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author CHUNG TOOC
 */
public class ManageTopHotelAction extends ActionSupport implements SessionAware {
    
    private int TopHotelID;
    private int HotelIDNew;
    private int TopHotelIDUpdate;
    private int HotelIDUpdate;
    private Map<String, Object> sessionMap;
    TopHotelBean topHotelBean;
    private List<TopHotelBean> topHotelList;
    private List<TopHotelBean> topHotelList1;
    private int check;
    
    public String GetAllTopHotelView() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        TopHotelBean topHotel123 = (TopHotelBean) session.get("update_topHotel");
        session.remove("all_topHotel");
        session.remove("all_hotel");
        
        topHotelBean = new TopHotelBean();
        topHotelList = new ArrayList();
        topHotelList = topHotelBean.getAllTopHotel();
        
        topHotelList1 = new ArrayList();
        topHotelList1 = topHotelBean.getAllHotel();
        
        if (topHotel123 == null) {
            session.remove("update_topHotel");
            TopHotelBean topHotelList12 = new TopHotelBean();
            topHotelList12.setHotelID(1);
            session.put("update_topHotel", topHotelList12);
        }
        
        session.put("all_topHotel", topHotelList);
        session.put("all_hotel", topHotelList1);
        return "success";
    }
    
    public String AddNewTopHotel() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        topHotelBean = new TopHotelBean();
        topHotelBean.addtopHotel(this.HotelIDNew);
        
        return "success";
    }
    
    public String SaveUpdateTopHotel() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        topHotelBean = new TopHotelBean();
        topHotelBean.updatetopHotel(this.TopHotelIDUpdate, this.HotelIDUpdate);
        
        return "success";
    }
    
    public String UpdateTopHotel() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        session.remove("update_topHotel");
        topHotelBean = new TopHotelBean();
        TopHotelBean topHotelList1 = new TopHotelBean();
        topHotelList1 = topHotelBean.getTopHotelWithID(this.TopHotelID);
        
        session.put("update_topHotel", topHotelList1);
        return "success";
    }
    
    public String DeleteTopHotel() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        
        topHotelBean = new TopHotelBean();
        int topHotelID = Integer.valueOf(this.TopHotelID);
        check = topHotelBean.deletetopHotel(topHotelID);
        if (check > 0) {
            addActionError("Delete TopHotel successful");
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
    
    public int getTopHotelID() {
        return TopHotelID;
    }
    
    public void setTopHotelID(int TopHotelID) {
        this.TopHotelID = TopHotelID;
    }
    
    public int getHotelIDNew() {
        return HotelIDNew;
    }
    
    public void setHotelIDNew(int HotelIDNew) {
        this.HotelIDNew = HotelIDNew;
    }
    
    public int getTopHotelIDUpdate() {
        return TopHotelIDUpdate;
    }
    
    public void setTopHotelIDUpdate(int TopHotelIDUpdate) {
        this.TopHotelIDUpdate = TopHotelIDUpdate;
    }
    
    public int getHotelIDUpdate() {
        return HotelIDUpdate;
    }
    
    public void setHotelIDUpdate(int HotelIDUpdate) {
        this.HotelIDUpdate = HotelIDUpdate;
    }
    
}
