/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.CityBean;
import model.HotelBean;
import model.RoomBean;
import model.SearchRoom;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author CHUNG TOOC
 */
public class SearchResultAction extends ActionSupport implements SessionAware {

    private String fca;
    private String fcb;
    private String fcc;
    private String fcd;
    private String toNight;
    private Boolean error;
    private Map<String, Object> sessionMap;

    public SearchResultAction() {
    }

    public SearchResultAction(String fca, String fcb, String fcc, String fcd, String toNight) {
        this.fca = fca;
        this.fcb = fcb;
        this.fcc = fcc;
        this.fcd = fcd;
        this.toNight = toNight;
    }

    public String GetSearchResult() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        //session.remove("list-booknow");

        CityBean city = new CityBean();
        SearchResultAction listbooknow = new SearchResultAction();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date date = new java.util.Date();
        String dateNow = dateFormat.format(date).toString();
        java.util.Date date1 = formatter.parse(dateNow);

        int intWhere = Integer.parseInt(this.fcb.toString());
        String strWhere = city.getNameCity(intWhere);
        String strDateStart = this.fcc.toString();
        String strDateEnd = this.fcd.toString();
        java.util.Date dateStart = formatter.parse(strDateStart);
        java.util.Date dateEnd = formatter.parse(strDateEnd);
        int days = (int) ((dateEnd.getTime() - dateStart.getTime()) / (1000 * 60 * 60 * 24));
        int dayscheck = (int) ((dateStart.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));

        listbooknow.setFca(this.fca);
        listbooknow.setFcb(strWhere);
        listbooknow.setFcc(this.fcc);
        listbooknow.setFcd(this.fcd);
        listbooknow.setToNight(String.valueOf(days));

        HotelBean hotel = new HotelBean();
        List<HotelBean> hotellist = null;
        hotellist = new ArrayList();
        hotellist = hotel.getAllHotelCity(intWhere);

        session.put("all_hotel", hotellist);
        session.put("list-booknow", listbooknow);

        if (!"Hotels".equals(listbooknow.getFca())) {
            addActionError("Please choose radio Hotels. Please go back and refine your search.");
            return "error";
        }
        if (dayscheck < 0) {
            addActionError("Please choose date Check in is greater than Date Now. Please go back and refine your search.");
            return "error";
        }
        if (days <= 0) {
            addActionError("Please choose date Check out is greater than Date Check in. Please go back and refine your search.");
            return "error";
        }

        if (hotellist.isEmpty()) {
            addActionError("No search found for " + strWhere + " city. Please go back and refine your search.");
            return "success";
        }

        return "success";
    }

    public String GetSearchDetailBook() throws ParseException, ClassNotFoundException, SQLException {
        Map session = ActionContext.getContext().getSession();
        session.remove("searched");

        SearchResultAction listbooknow = (SearchResultAction) session.get("list-booknow");
        HotelBean detail_hotel = (HotelBean) session.get("detail_hotel");
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        int hotelID = detail_hotel.getHotelID();
        int night;
        night = Integer.parseInt(listbooknow.getToNight());

        String strDateStart = listbooknow.getFcc();
        String strDateEnd = listbooknow.getFcd();

        java.util.Date dateStart = formatter.parse(strDateStart);
        java.sql.Date dateStart1 = new java.sql.Date(dateStart.getTime());

        java.util.Date dateEnd = formatter.parse(strDateEnd);
        java.sql.Date dateEnd1 = new java.sql.Date(dateEnd.getTime());

        SearchRoom searchRoom = new SearchRoom();
        List<RoomBean> roomlist = null;
        roomlist = new ArrayList();
        roomlist = searchRoom.getRoomHotel(hotelID, dateStart1, dateEnd1);

        session.put("list-room", roomlist);
        session.put("searched", "true");
        if (roomlist.isEmpty()) {
            addActionError("No Empty Rooms for " + detail_hotel.getHotelName() + ". Please go back and refine your search.");
            return "success";
        }
        return "success";
    }

    public String GetHotelDetailBook() throws ParseException, ClassNotFoundException, SQLException {
        Map session = ActionContext.getContext().getSession();
        session.remove("searched");
        session.remove("list-booknow");

        CityBean city = new CityBean();
        HotelBean detail_hotel = (HotelBean) session.get("detail_hotel");
        SearchResultAction listbooknow = new SearchResultAction();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date date = new java.util.Date();
        String dateNow = dateFormat.format(date).toString();
        java.util.Date date1 = formatter.parse(dateNow);

        int intWhere1;
        intWhere1 = detail_hotel.getCityID();
        String strWhere = city.getNameCity(intWhere1);
        String strDateStart = this.fcc.toString();
        String strDateEnd = this.fcd.toString();
        java.util.Date dateStart = formatter.parse(strDateStart);
        java.util.Date dateEnd = formatter.parse(strDateEnd);
        int days = (int) ((dateEnd.getTime() - dateStart.getTime()) / (1000 * 60 * 60 * 24));
        int dayscheck = (int) ((dateStart.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));

        listbooknow.setFca(this.fca);
        listbooknow.setFcb(strWhere);
        listbooknow.setFcc(this.fcc);
        listbooknow.setFcd(this.fcd);
        listbooknow.setToNight(String.valueOf(days));

        String strDateStart1 = this.fcc;
        String strDateEnd1 = this.fcd;

        java.util.Date dateStart1 = formatter.parse(strDateStart1);
        java.sql.Date dateStart2 = new java.sql.Date(dateStart1.getTime());

        java.util.Date dateEnd1 = formatter.parse(strDateEnd1);
        java.sql.Date dateEnd2 = new java.sql.Date(dateEnd1.getTime());

        SearchRoom searchRoom = new SearchRoom();
        List<RoomBean> roomlist = null;
        roomlist = new ArrayList();
        roomlist = searchRoom.getRoomHotel(detail_hotel.getHotelID(), dateStart2, dateEnd2);

        session.put("list-booknow", listbooknow);
        session.put("list-room", roomlist);
        session.put("searched", "true");
        if (dayscheck < 0) {
            addActionError("Please choose date Check in is greater than Date Now.");
            return "error";
        }
        if (days <= 0) {
            addActionError("Please choose date Check out is greater than Date Check in.");
            return "error";
        }
        if (roomlist.isEmpty()) {
            addActionError("No Empty Rooms for " + detail_hotel.getHotelName() + ". Please go back and refine your search.");
            return "success";
        }
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

    public String getFcb() {
        return fcb;
    }

    public void setFcb(String fcb) {
        this.fcb = fcb;
    }

    public String getFcc() {
        return fcc;
    }

    public void setFcc(String fcc) {
        this.fcc = fcc;
    }

    public String getFcd() {
        return fcd;
    }

    public void setFcd(String fcd) {
        this.fcd = fcd;
    }

    public String getToNight() {
        return toNight;
    }

    public void setToNight(String toNight) {
        this.toNight = toNight;
    }

    public String getFca() {
        return fca;
    }

    public void setFca(String fca) {
        this.fca = fca;
    }

}
