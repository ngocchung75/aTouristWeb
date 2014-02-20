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
import model.RoomBean;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author CHUNG TOOC
 */
public class SupplierRoomAction extends ActionSupport implements SessionAware {

    private int RoomID;
    private int HotelIDNew;
    private String RTypeNameNew;
    private int RNumPeopleNew;
    private int RCountNew;
    private String RoomDesNew;
    private String RImageNew;
    private double RoomPriceNew;

    private int RoomIDUpdate;
    private int HotelIDUpdate;
    private String RTypeNameUpdate;
    private int RNumPeopleUpdate;
    private int RCountUpdate;
    private String RoomDesUpdate;
    private String RImageUpdate;
    private double RoomPriceUpdate;

    private Map<String, Object> sessionMap;
    RoomBean roomBean;
    private List<RoomBean> roomList;
    private int check;

    public String GetAllRoomView() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        String checklogin = (String) session.get("logined");
        if (!"true".equals(checklogin)) {
            return "error";
        } else {
            RoomBean room123 = (RoomBean) session.get("update_room");
            session.remove("all_room");

            int userID123 = (Integer) session.get("session-userid");
            HotelBean hotelBean = new HotelBean();
            HotelBean hotelList1 = new HotelBean();
            hotelList1 = hotelBean.getHotelWithUserID(userID123);
            int hotelID = hotelList1.getHotelID();

            roomBean = new RoomBean();
            roomList = new ArrayList();
            roomList = roomBean.getAllRoomWithHotelID(hotelID);

            if (room123 == null) {
                session.remove("update_room");
                RoomBean roomList1 = new RoomBean();
                roomList1.setRoomID(1);
                session.put("update_room", roomList1);
            }

            session.put("hotelID", hotelID);
            session.put("all_room", roomList);
            return "success";
        }
    }

    public String AddNewRoom() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        roomBean = new RoomBean();
        RoomBean roomList = new RoomBean();
        roomList.setHotelID(this.HotelIDNew);
        roomList.setRTypeName(this.RTypeNameNew);
        roomList.setRNumPeople(this.RNumPeopleNew);
        roomList.setRCount(this.RCountNew);
        roomList.setRoomDes(this.RoomDesNew);
        roomList.setRImage(this.RImageNew);
        roomList.setRoomPrice(this.RoomPriceNew);

        roomBean.addRoom(roomList);

        return "success";
    }

    public String DeleteRoom() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        roomBean = new RoomBean();
        int roomID = Integer.valueOf(this.RoomID);
        check = roomBean.deleteRoom(roomID);
        if (check > 0) {
            addActionError("Delete City successful");
            return "success";
        }
        addActionError("System error has occurred please try again later.");
        return "error";
    }

    public String SaveUpdateRoom() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        roomBean = new RoomBean();
        RoomBean roomList = new RoomBean();
        roomList.setRoomID(this.RoomIDUpdate);
        roomList.setHotelID(this.HotelIDUpdate);
        roomList.setRTypeName(this.RTypeNameUpdate);
        roomList.setRNumPeople(this.RNumPeopleUpdate);
        roomList.setRCount(this.RCountUpdate);
        roomList.setRoomDes(this.RoomDesUpdate);
        roomList.setRImage(this.RImageUpdate);
        roomList.setRoomPrice(this.RoomPriceUpdate);

        roomBean.updateRoom(roomList);

        return "success";
    }

    public String UpdateRoom() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        session.remove("update_room");
        roomBean = new RoomBean();
        RoomBean roomList = new RoomBean();
        roomList = roomBean.getRoomWithID(this.RoomID);

        session.put("update_room", roomList);
        return "success";
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int RoomID) {
        this.RoomID = RoomID;
    }

    public int getHotelIDNew() {
        return HotelIDNew;
    }

    public void setHotelIDNew(int HotelIDNew) {
        this.HotelIDNew = HotelIDNew;
    }

    public String getRTypeNameNew() {
        return RTypeNameNew;
    }

    public void setRTypeNameNew(String RTypeNameNew) {
        this.RTypeNameNew = RTypeNameNew;
    }

    public int getRNumPeopleNew() {
        return RNumPeopleNew;
    }

    public void setRNumPeopleNew(int RNumPeopleNew) {
        this.RNumPeopleNew = RNumPeopleNew;
    }

    public int getRCountNew() {
        return RCountNew;
    }

    public void setRCountNew(int RCountNew) {
        this.RCountNew = RCountNew;
    }

    public String getRoomDesNew() {
        return RoomDesNew;
    }

    public void setRoomDesNew(String RoomDesNew) {
        this.RoomDesNew = RoomDesNew;
    }

    public String getRImageNew() {
        return RImageNew;
    }

    public void setRImageNew(String RImageNew) {
        this.RImageNew = RImageNew;
    }

    public double getRoomPriceNew() {
        return RoomPriceNew;
    }

    public void setRoomPriceNew(double RoomPriceNew) {
        this.RoomPriceNew = RoomPriceNew;
    }

    public int getRoomIDUpdate() {
        return RoomIDUpdate;
    }

    public void setRoomIDUpdate(int RoomIDUpdate) {
        this.RoomIDUpdate = RoomIDUpdate;
    }

    public int getHotelIDUpdate() {
        return HotelIDUpdate;
    }

    public void setHotelIDUpdate(int HotelIDUpdate) {
        this.HotelIDUpdate = HotelIDUpdate;
    }

    public String getRTypeNameUpdate() {
        return RTypeNameUpdate;
    }

    public void setRTypeNameUpdate(String RTypeNameUpdate) {
        this.RTypeNameUpdate = RTypeNameUpdate;
    }

    public int getRNumPeopleUpdate() {
        return RNumPeopleUpdate;
    }

    public void setRNumPeopleUpdate(int RNumPeopleUpdate) {
        this.RNumPeopleUpdate = RNumPeopleUpdate;
    }

    public int getRCountUpdate() {
        return RCountUpdate;
    }

    public void setRCountUpdate(int RCountUpdate) {
        this.RCountUpdate = RCountUpdate;
    }

    public String getRoomDesUpdate() {
        return RoomDesUpdate;
    }

    public void setRoomDesUpdate(String RoomDesUpdate) {
        this.RoomDesUpdate = RoomDesUpdate;
    }

    public String getRImageUpdate() {
        return RImageUpdate;
    }

    public void setRImageUpdate(String RImageUpdate) {
        this.RImageUpdate = RImageUpdate;
    }

    public double getRoomPriceUpdate() {
        return RoomPriceUpdate;
    }

    public void setRoomPriceUpdate(double RoomPriceUpdate) {
        this.RoomPriceUpdate = RoomPriceUpdate;
    }

}
