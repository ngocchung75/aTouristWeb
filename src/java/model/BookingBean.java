/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.PreparedStatement;
import common.ConnectDatabase;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author CHUNG TOOC
 */
public class BookingBean {

    private int BookID;
    private int UserID;
    private String UserName;
    private int RoomID;
    private int HotelID;
    private Date StartDate;
    private Date EndDate;
    private int RCountBook;
    private int Nights;
    private double RPrices;
    private double Total;
    private int StatusID;
    private String StatusName;
    private Map<String, Object> sessionMap;
    UserBean userBean;
    StatusBean statusBean;

    public BookingBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public BookingBean(int BookID, int UserID, String UserName, int RoomID, int HotelID, Date StartDate, Date EndDate,
            int RCountBook, int Nights, double RPrices, double Total, int StatusID, String StatusName) {
        this.BookID = BookID;
        this.UserID = UserID;
        this.UserName = UserName;
        this.RoomID = RoomID;
        this.HotelID = HotelID;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.RCountBook = RCountBook;
        this.Nights = Nights;
        this.RPrices = RPrices;
        this.Total = Total;
        this.StatusID = StatusID;
        this.StatusName = StatusName;
    }

    public BookingBean(int BookID, int UserID, int RoomID, int HotelID, Date StartDate, Date EndDate,
            int RCountBook, int Nights, double RPrices, double Total, int StatusID) {
        this.BookID = BookID;
        this.UserID = UserID;
        this.RoomID = RoomID;
        this.HotelID = HotelID;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.RCountBook = RCountBook;
        this.Nights = Nights;
        this.RPrices = RPrices;
        this.Total = Total;
        this.StatusID = StatusID;
    }

    public List<BookingBean> getListAllBook() throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_bookings";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        List<BookingBean> bookinglist = null;
        bookinglist = new ArrayList();

        while (rs.next()) {
            BookingBean booking;
            userBean = new UserBean();
            statusBean = new StatusBean();
            UserBean userList1 = new UserBean();
            StatusBean statusList1 = new StatusBean();

            int BookID1 = rs.getInt(1);
            int UserID1 = rs.getInt(2);
            userList1 = userBean.getUserID(UserID1);
            String UserName1 = userList1.getUserName();
            int RoomID1 = rs.getInt(3);
            int HotelID1 = rs.getInt(4);
            Date StartDate1 = rs.getDate(5);
            Date EndDate1 = rs.getDate(6);
            int RCountBook1 = rs.getInt(7);
            int Nights1 = rs.getInt(8);
            double RPrices1 = rs.getDouble(9);
            double Total1 = rs.getDouble(10);
            int StatusID1 = rs.getInt(11);
            statusList1 = statusBean.getStatusWithID(StatusID1);
            String StatusName1 = statusList1.getStatusName();

            booking = new BookingBean(BookID1, UserID1, UserName1, RoomID1, HotelID1, StartDate1, EndDate1,
                    RCountBook1, Nights1, RPrices1, Total1, StatusID1, StatusName1);
            bookinglist.add(booking);
        }
        return bookinglist;
    }

    public BookingBean getBookingID(int BookID) throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_bookings where BookID='" + BookID + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);

        if (rs.next()) {
            BookingBean booking;
            userBean = new UserBean();
            statusBean = new StatusBean();
            UserBean userList1 = new UserBean();
            StatusBean statusList1 = new StatusBean();

            int BookID1 = rs.getInt(1);
            int UserID1 = rs.getInt(2);
            userList1 = userBean.getUserID(UserID1);
            String UserName1 = userList1.getUserName();
            int RoomID1 = rs.getInt(3);
            int HotelID1 = rs.getInt(4);
            Date StartDate1 = rs.getDate(5);
            Date EndDate1 = rs.getDate(6);
            int RCountBook1 = rs.getInt(7);
            int Nights1 = rs.getInt(8);
            double RPrices1 = rs.getDouble(9);
            double Total1 = rs.getDouble(10);
            int StatusID1 = rs.getInt(11);
            statusList1 = statusBean.getStatusWithID(StatusID1);
            String StatusName1 = statusList1.getStatusName();

            booking = new BookingBean(BookID1, UserID1, UserName1, RoomID1, HotelID1, StartDate1, EndDate1,
                    RCountBook1, Nights1, RPrices1, Total1, StatusID1, StatusName1);
            return booking;
        } else {
            return null;
        }
    }

    public List<BookingBean> getListBookUser(int UserID) throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_bookings where UserID='" + UserID + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        List<BookingBean> bookinglist = null;
        bookinglist = new ArrayList();

        while (rs.next()) {
            BookingBean booking;
            int BookID1 = rs.getInt(1);
            int UserID1 = rs.getInt(2);
            int RoomID1 = rs.getInt(3);
            int HotelID1 = rs.getInt(4);
            Date StartDate1 = rs.getDate(5);
            Date EndDate1 = rs.getDate(6);
            int RCountBook1 = rs.getInt(7);
            int Nights1 = rs.getInt(8);
            double RPrices1 = rs.getDouble(9);
            double Total1 = rs.getDouble(10);
            int StatusID1 = rs.getInt(11);

            booking = new BookingBean(BookID1, UserID1, RoomID1, HotelID1, StartDate1, EndDate1,
                    RCountBook1, Nights1, RPrices1, Total1, StatusID1);
            bookinglist.add(booking);
        }
        return bookinglist;
    }

    public int addBooking(int BookID, int UserID, int RoomID, int HotelID, Date StartDate, Date EndDate,
            int RCountBook, int Nights, double RPrices, double Total, int StatusID)
            throws ClassNotFoundException, SQLException {

        int bookID = bookIDLast();
        bookID++;
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String insert_booking = "insert into atourist_bookings values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(insert_booking);
        pre.setInt(1, bookID);
        pre.setInt(2, UserID);
        pre.setInt(3, RoomID);
        pre.setInt(4, HotelID);
        pre.setDate(5, StartDate);
        pre.setDate(6, EndDate);
        pre.setInt(7, RCountBook);
        pre.setInt(8, Nights);
        pre.setDouble(9, RPrices);
        pre.setDouble(10, Total);
        pre.setInt(11, StatusID);

        int check = pre.executeUpdate();
        cnn.close();
        pre.close();
        return check;
    }

    public int bookIDLast() throws ClassNotFoundException, SQLException {
        int BookID2 = 0;
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_bookings";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            BookID2 = rs.getInt("BookID");
        }
        return BookID2;
    }

    public int deleteBooking(int bookID) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String delete_booking = "delete from atourist_bookings where BookID=?";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(delete_booking);
        pre.setInt(1, bookID);

        int check = pre.executeUpdate();
        cnn.close();
        pre.close();
        return check;
    }

    public void updateStatusBooking(int bookID, int statusID) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String update_booking = "Update atourist_bookings set StatusID=? where BookID=?";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(update_booking);

        // Parameters start with 1
        pre.setInt(1, statusID);
        pre.setInt(2, bookID);

        pre.executeUpdate();
        cnn.close();
        pre.close();
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int BookID) {
        this.BookID = BookID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int RoomID) {
        this.RoomID = RoomID;
    }

    public int getHotelID() {
        return HotelID;
    }

    public void setHotelID(int HotelID) {
        this.HotelID = HotelID;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public int getRCountBook() {
        return RCountBook;
    }

    public void setRCountBook(int RCountBook) {
        this.RCountBook = RCountBook;
    }

    public double getRPrices() {
        return RPrices;
    }

    public void setRPrices(double RPrices) {
        this.RPrices = RPrices;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public int getStatusID() {
        return StatusID;
    }

    public void setStatusID(int StatusID) {
        this.StatusID = StatusID;
    }

    public int getNights() {
        return Nights;
    }

    public void setNights(int Nights) {
        this.Nights = Nights;
    }

    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getStatusName() {
        return StatusName;
    }

    public void setStatusName(String StatusName) {
        this.StatusName = StatusName;
    }

}
