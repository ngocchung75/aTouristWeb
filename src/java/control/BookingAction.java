/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.BookingBean;
import model.HotelBean;
import model.NoRoomBean;
import model.RoomBean;
import model.RoomBookBean;
import model.SearchRoom;
import org.apache.struts2.ServletActionContext;
import static org.apache.struts2.StrutsStatics.HTTP_REQUEST;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author CHUNG TOOC
 */
public class BookingAction extends ActionSupport implements SessionAware {

    private String roomsel1;
    private String roomsel2;
    private String roomsel3;
    private String roomsel4;
    private String roomsel5;
    private String roomsel6;
    private String roomsel7;
    private String roomsel8;
    private String roomsel9;
    private String roomsel10;
    private String feo;

    private Map<String, Object> sessionMap;
    RoomBean roombean;
    BookingBean bookingbean;

    public BookingAction() {
    }

    public BookingAction(String roomsel1, String roomsel2, String roomsel3, String roomsel4, String roomsel5,
            String roomsel6, String roomsel7, String roomsel8, String roomsel9, String roomsel10) {
        this.roomsel1 = roomsel1;
        this.roomsel2 = roomsel2;
        this.roomsel3 = roomsel3;
        this.roomsel4 = roomsel4;
        this.roomsel5 = roomsel5;
        this.roomsel6 = roomsel6;
        this.roomsel7 = roomsel7;
        this.roomsel8 = roomsel8;
        this.roomsel9 = roomsel9;
        this.roomsel10 = roomsel10;
    }

    public String getPath(ActionInvocation invocation) throws Exception {
        ActionContext context = invocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
        return request.getPathInfo();
    }

    public String GetBookingView() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        SearchResultAction listbooknow = (SearchResultAction) session.get("list-booknow");
        HotelBean detail_hotel = (HotelBean) session.get("detail_hotel");
        List<RoomBean> listroom;
        listroom = (List<RoomBean>) session.get("list-room");
        List<NoRoomBean> noroomlist = null;
        noroomlist = new ArrayList();
        NoRoomBean noroom;
        int nights = Integer.parseInt(listbooknow.getToNight());
        double grandTotal = 0;

        HttpServletRequest request;
        request = ServletActionContext.getRequest();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : requestParams.entrySet()) {
            String key = entry.getKey();         // parameter name
            String idRoom = key.substring(7);
            String[] value = entry.getValue();   // parameter values as array of String
            String valueString = "";

            // in case of checkbox input, value may be array of length greater than one
            if (value.length > 1) {
                for (String value1 : value) {
                    valueString += value1 + " ";
                }
            } else {
                valueString = value[0];
            }
            noroom = new NoRoomBean(idRoom, valueString);
            noroomlist.add(noroom);
        }

        List<RoomBookBean> roombooklist = null;
        roombooklist = new ArrayList();
        RoomBookBean roombook;

        for (int i = 0; i < noroomlist.size(); i++) {
            int noroombook;
            noroombook = Integer.parseInt(noroomlist.get(i).getNoRoomCount());
            if (noroombook > 0) {
                int noIDRoom = Integer.parseInt(noroomlist.get(i).getNoRoomID());
                roombean = new RoomBean();
                SearchRoom searchRoom = new SearchRoom();
                roombean = searchRoom.getRoomDetail(noIDRoom);
                double roomPrice = roombean.getRoomPrice();
                double totalPrice = noroombook * nights * roomPrice;
                grandTotal = grandTotal + totalPrice;

                String NoRoomCount1 = noroomlist.get(i).getNoRoomCount();

                roombook = new RoomBookBean(noIDRoom, roombean.getHotelID(), roombean.getRTypeName(),
                        roombean.getRNumPeople(), roombean.getRCount(), roombean.getRoomDes(),
                        roombean.getRImage(), roombean.getRoomPrice(), NoRoomCount1, totalPrice);
                roombooklist.add(roombook);
            }
        }

        if(roombooklist.isEmpty()){
            addActionError("Please choose No. Rooms.");
            session.put("error_check", "true");
            return "error";
        }
        sessionMap.put("grandTotal", grandTotal);
        session.put("grand-Total", grandTotal);
        session.put("noroom-list", noroomlist);
        session.put("roombook-list", roombooklist);
        return "success";
    }

    public String BookingSubmit() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        SearchResultAction listbooknow = (SearchResultAction) session.get("list-booknow");
        HotelBean detail_hotel = (HotelBean) session.get("detail_hotel");
        List<RoomBean> listroom;
        listroom = (List<RoomBean>) session.get("list-room");
        List<NoRoomBean> noroomlist;
        noroomlist = (List<NoRoomBean>) session.get("noroom-list");
        List<RoomBookBean> roombooklist;
        roombooklist = (List<RoomBookBean>) session.get("roombook-list");
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        int userID = (Integer) sessionMap.get("UserID");
        int night = Integer.valueOf(listbooknow.getToNight());
        String strDateStart = listbooknow.getFcc();
        String strDateEnd = listbooknow.getFcd();

        java.util.Date dateStart = formatter.parse(strDateStart);
        java.sql.Date dateStart1 = new java.sql.Date(dateStart.getTime());

        java.util.Date dateEnd = formatter.parse(strDateEnd);
        java.sql.Date dateEnd1 = new java.sql.Date(dateEnd.getTime());
        
        if (!"check".equals(this.getFeo())) {
            addActionError("Please choose radio Accept and confirm.");
            return "error";
        }

        for (int i = 0; i < roombooklist.size(); i++) {
            bookingbean = new BookingBean();

            int BookID1 = 1;
            int UserID1 = userID;
            int RoomID1 = roombooklist.get(i).getRoomID();
            int HotelID1 = roombooklist.get(i).getHotelID();
            Date StartDate1 = dateStart1;
            Date EndDate1 = dateEnd1;
            int RCountBook1 = Integer.parseInt(roombooklist.get(i).getNoRoomCount());
            int Nights1 = night;
            double RPrices1 = roombooklist.get(i).getRoomPrice();
            double Total1 = roombooklist.get(i).getPriceTotal();
            int StatusID1 = 1;

            int check = bookingbean.addBooking(BookID1, UserID1, RoomID1, HotelID1, StartDate1, EndDate1,
                    RCountBook1, Nights1, RPrices1, Total1, StatusID1);
        }

        return "success";
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public String getRoomsel1() {
        return roomsel1;
    }

    public void setRoomsel1(String roomsel1) {
        this.roomsel1 = roomsel1;
    }

    public String getRoomsel2() {
        return roomsel2;
    }

    public void setRoomsel2(String roomsel2) {
        this.roomsel2 = roomsel2;
    }

    public String getRoomsel3() {
        return roomsel3;
    }

    public void setRoomsel3(String roomsel3) {
        this.roomsel3 = roomsel3;
    }

    public String getRoomsel4() {
        return roomsel4;
    }

    public void setRoomsel4(String roomsel4) {
        this.roomsel4 = roomsel4;
    }

    public String getRoomsel5() {
        return roomsel5;
    }

    public void setRoomsel5(String roomsel5) {
        this.roomsel5 = roomsel5;
    }

    public String getRoomsel6() {
        return roomsel6;
    }

    public void setRoomsel6(String roomsel6) {
        this.roomsel6 = roomsel6;
    }

    public String getRoomsel7() {
        return roomsel7;
    }

    public void setRoomsel7(String roomsel7) {
        this.roomsel7 = roomsel7;
    }

    public String getRoomsel8() {
        return roomsel8;
    }

    public void setRoomsel8(String roomsel8) {
        this.roomsel8 = roomsel8;
    }

    public String getRoomsel9() {
        return roomsel9;
    }

    public void setRoomsel9(String roomsel9) {
        this.roomsel9 = roomsel9;
    }

    public String getRoomsel10() {
        return roomsel10;
    }

    public void setRoomsel10(String roomsel10) {
        this.roomsel10 = roomsel10;
    }

    public String getFeo() {
        return feo;
    }

    public void setFeo(String feo) {
        this.feo = feo;
    }

}
