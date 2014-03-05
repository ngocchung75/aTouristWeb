/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.PreparedStatement;
import common.ConnectDatabase;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
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
    private String RoomName;
    private int HotelID;
    private String HotelName;
    private String HotelEmail;
    private Date StartDate;
    private Date EndDate;
    private int RCountBook;
    private int Nights;
    private double RPrices;
    private double Total;
    private BigInteger TotalVND;
    private int StatusID;
    private String StatusName;
    private Map<String, Object> sessionMap;
    UserBean userBean;
    StatusBean statusBean;
    HotelBean hotelBean;
    RoomBean roomBean;
    int usdToVnd = 21000;

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

    public BookingBean(int BookID, int UserID, String UserName, int RoomID, String RoomName, int HotelID, String HotelName, String HotelEmail, Date StartDate, Date EndDate,
            int RCountBook, int Nights, double RPrices, double Total, BigInteger TotalVND, int StatusID, String StatusName) {
        this.BookID = BookID;
        this.UserID = UserID;
        this.UserName = UserName;
        this.RoomID = RoomID;
        this.RoomName = RoomName;
        this.HotelID = HotelID;
        this.HotelName = HotelName;
        this.HotelEmail = HotelEmail;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.RCountBook = RCountBook;
        this.Nights = Nights;
        this.RPrices = RPrices;
        this.Total = Total;
        this.TotalVND = TotalVND;
        this.StatusID = StatusID;
        this.StatusName = StatusName;
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
        cnn.close();
        st.close();
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
            cnn.close();
            st.close();
            return booking;
        } else {
            cnn.close();
            st.close();
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
            userBean = new UserBean();
            statusBean = new StatusBean();
            hotelBean = new HotelBean();
            roomBean = new RoomBean();
            UserBean userList1 = new UserBean();
            StatusBean statusList1 = new StatusBean();
            HotelBean hotelList1 = new HotelBean();
            RoomBean roomList1 = new RoomBean();

            int BookID1 = rs.getInt(1);
            int UserID1 = rs.getInt(2);
            userList1 = userBean.getUserID(UserID1);
            String UserName1 = userList1.getUserName();
            int RoomID1 = rs.getInt(3);
            roomList1 = roomBean.getRoomWithID(RoomID1);
            String RoomName1 = roomList1.getRTypeName();
            int HotelID1 = rs.getInt(4);
            hotelList1 = hotelBean.getHotel(HotelID1);
            String HotelName1 = hotelList1.getHotelName();
            String HotelEmail1 = hotelList1.getHotelEmail();
            Date StartDate1 = rs.getDate(5);
            Date EndDate1 = rs.getDate(6);
            int RCountBook1 = rs.getInt(7);
            int Nights1 = rs.getInt(8);
            double RPrices1 = rs.getDouble(9);
            double Total1 = rs.getDouble(10);
            BigInteger TotalVND;
            TotalVND = BigDecimal.valueOf(Total1).multiply(BigDecimal.valueOf(usdToVnd)).toBigInteger();
            int StatusID1 = rs.getInt(11);
            statusList1 = statusBean.getStatusWithID(StatusID1);
            String StatusName1 = statusList1.getStatusName();

            booking = new BookingBean(BookID1, UserID1, UserName1, RoomID1, RoomName1, HotelID1, HotelName1, HotelEmail1, StartDate1, EndDate1,
                    RCountBook1, Nights1, RPrices1, Total1, TotalVND, StatusID1, StatusName1);
            bookinglist.add(booking);
        }
        cnn.close();
        st.close();
        return bookinglist;
    }

    public List<BookingBean> getListBookWithHotelID(int hotelID) throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_bookings where HotelID='" + hotelID + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        List<BookingBean> bookinglist = null;
        bookinglist = new ArrayList();

        while (rs.next()) {
            BookingBean booking;
            userBean = new UserBean();
            statusBean = new StatusBean();
            hotelBean = new HotelBean();
            roomBean = new RoomBean();
            UserBean userList1 = new UserBean();
            StatusBean statusList1 = new StatusBean();
            HotelBean hotelList1 = new HotelBean();
            RoomBean roomList1 = new RoomBean();

            int BookID1 = rs.getInt(1);
            int UserID1 = rs.getInt(2);
            userList1 = userBean.getUserID(UserID1);
            String UserName1 = userList1.getUserName();
            int RoomID1 = rs.getInt(3);
            roomList1 = roomBean.getRoomWithID(RoomID1);
            String RoomName1 = roomList1.getRTypeName();
            int HotelID1 = rs.getInt(4);
            hotelList1 = hotelBean.getHotel(HotelID1);
            String HotelName1 = hotelList1.getHotelName();
            String HotelEmail1 = hotelList1.getHotelEmail();
            Date StartDate1 = rs.getDate(5);
            Date EndDate1 = rs.getDate(6);
            int RCountBook1 = rs.getInt(7);
            int Nights1 = rs.getInt(8);
            double RPrices1 = rs.getDouble(9);
            double Total1 = rs.getDouble(10);
            BigInteger TotalVND;
            TotalVND = BigDecimal.valueOf(Total1).multiply(BigDecimal.valueOf(usdToVnd)).toBigInteger();
            int StatusID1 = rs.getInt(11);
            statusList1 = statusBean.getStatusWithID(StatusID1);
            String StatusName1 = statusList1.getStatusName();

            booking = new BookingBean(BookID1, UserID1, UserName1, RoomID1, RoomName1, HotelID1, HotelName1, HotelEmail1, StartDate1, EndDate1,
                    RCountBook1, Nights1, RPrices1, Total1, TotalVND, StatusID1, StatusName1);
            bookinglist.add(booking);
        }
        cnn.close();
        st.close();
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
        String sql = "select * from atourist_bookings ORDER BY BookID ASC";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            BookID2 = rs.getInt("BookID");
        }
        cnn.close();
        st.close();
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

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String HotelName) {
        this.HotelName = HotelName;
    }

    public String getRoomName() {
        return RoomName;
    }

    public void setRoomName(String RoomName) {
        this.RoomName = RoomName;
    }

    public String getHotelEmail() {
        return HotelEmail;
    }

    public void setHotelEmail(String HotelEmail) {
        this.HotelEmail = HotelEmail;
    }

    public BigInteger getTotalVND() {
        return TotalVND;
    }

    public void setTotalVND(BigInteger TotalVND) {
        this.TotalVND = TotalVND;
    }

}
