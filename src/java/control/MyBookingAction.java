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
import model.StatusBean;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author CHUNG TOOC
 */
public class MyBookingAction extends ActionSupport implements SessionAware {

    private int BookID;
    private Map<String, Object> sessionMap;
    BookingBean bookingBean;
    private List<BookingBean> bookingList;
    private List<StatusBean> statusList;
    private int check;

    public String GetMyBookingView() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        String checklogin = (String) session.get("logined");
        if (!"true".equals(checklogin)) {
            return "error";
        } else {
            session.remove("all_booking");
            int userID123 = (Integer) session.get("session-userid");
            bookingBean = new BookingBean();
            bookingList = new ArrayList();
            bookingList = bookingBean.getListBookUser(userID123);

            session.put("all_booking", bookingList);
            if (bookingList.isEmpty()) {
                addActionError("You currently have no active bookings to manage.");
                return "error";
            }
            return "success";
        }
    }

    public String CancelBooking() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        bookingBean = new BookingBean();
        bookingBean.updateStatusBooking(this.BookID, 4);

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

}
