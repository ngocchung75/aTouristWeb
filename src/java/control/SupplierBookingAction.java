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
import model.BookingBean;
import model.HotelBean;
import model.StatusBean;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author CHUNG TOOC
 */
public class SupplierBookingAction extends ActionSupport implements SessionAware {

    private int BookIDUpdate;
    private int StatusIDUpdate;
    private int BookID;
    private Map<String, Object> sessionMap;
    BookingBean bookingBean;
    private List<BookingBean> bookingList;
    private List<StatusBean> statusList;
    private int check;

    public String GetAllBookingView() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        String checklogin = (String) session.get("logined");
        if (!"true".equals(checklogin)) {
            return "error";
        } else {
            BookingBean booking123 = (BookingBean) session.get("update_booking");
            session.remove("all_booking");
            session.remove("all_status");

            int userID123 = (Integer) session.get("session-userid");
            HotelBean hotelBean = new HotelBean();
            HotelBean hotelList1 = new HotelBean();
            hotelList1 = hotelBean.getHotelWithUserID(userID123);
            int hotelID123 = hotelList1.getHotelID();

            bookingBean = new BookingBean();
            bookingList = new ArrayList();
            bookingList = bookingBean.getListBookWithHotelID(hotelID123);

            StatusBean status = new StatusBean();
            statusList = new ArrayList();
            statusList = status.getAllStatus();

            if (booking123 == null) {
                session.remove("update_booking");
                BookingBean bookingList1 = new BookingBean();
                bookingList1.setBookID(1);
                session.put("update_booking", bookingList1);
            }

            session.put("all_booking", bookingList);
            session.put("all_status", statusList);
            return "success";
        }
    }

    public String DeleteBooking() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        bookingBean = new BookingBean();
        int bookID = Integer.valueOf(this.BookID);
        check = bookingBean.deleteBooking(bookID);
        if (check > 0) {
            addActionError("Delete Booking successful");
            return "success";
        }
        addActionError("System error has occurred please try again later.");
        return "error";
    }

    public String UpdateBooking() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        session.remove("update_booking");
        bookingBean = new BookingBean();
        BookingBean bookList = new BookingBean();
        bookList = bookingBean.getBookingID(this.BookID);

        session.put("update_booking", bookList);
        return "success";
    }

    public String SaveUpdateBooking() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        bookingBean = new BookingBean();
        bookingBean.updateStatusBooking(this.BookIDUpdate, this.StatusIDUpdate);

        return "success";
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int BookID) {
        this.BookID = BookID;
    }

    public int getBookIDUpdate() {
        return BookIDUpdate;
    }

    public void setBookIDUpdate(int BookIDUpdate) {
        this.BookIDUpdate = BookIDUpdate;
    }

    public int getStatusIDUpdate() {
        return StatusIDUpdate;
    }

    public void setStatusIDUpdate(int StatusIDUpdate) {
        this.StatusIDUpdate = StatusIDUpdate;
    }

}
