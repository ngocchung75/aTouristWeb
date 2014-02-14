/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import common.ConnectDatabase;
import control.AddAccountAction;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CHUNG TOOC
 */
public class SearchRoom {

    public List<RoomBean> getRoomHotel(int HotelID, Date StartDate, Date EndDate) throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_rooms where HotelID='" + HotelID + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        List<RoomBean> roomlist = null;
        roomlist = new ArrayList();

        while (rs.next()) {
            RoomBean room;
            int RoomID1 = rs.getInt(1);
            int HotelID1 = rs.getInt(2);
            String RTypeName1 = rs.getString(3);
            int RNumPeople1 = rs.getInt(4);
            int RCount1 = rs.getInt(5);
            String RoomDes1 = rs.getString(6);
            String RImage1 = rs.getString(7);
            double RoomPrice1 = rs.getDouble(8);

            int RCountEmpty = getRCountEmpty(RoomID1, RCount1, StartDate);

            room = new RoomBean(RoomID1, HotelID1, RTypeName1, RNumPeople1, RCountEmpty, RoomDes1, RImage1, RoomPrice1);
            roomlist.add(room);
        }
        return roomlist;
    }

    public List<BookingBean> getListBook(int RoomID) throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_bookings where RoomID='" + RoomID + "';";
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

    public int getRCountEmpty(int RoomID, int RCount, Date StartDate) throws ClassNotFoundException, SQLException {
        List<BookingBean> bookinglist = null;
        bookinglist = new ArrayList();
        bookinglist = getListBook(RoomID);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        int roomBusy = 0;
        for (int i = 0; i < bookinglist.size(); i++) {
            Date endDateBoook = bookinglist.get(i).getEndDate();
            if (StartDate.before(endDateBoook)) {
                roomBusy = roomBusy + bookinglist.get(i).getRCountBook();
            }
        }
        return RCount - roomBusy;
    }

    public RoomBean getRoomDetail(int RoomID) throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_rooms where RoomID='" + RoomID + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);

        if (rs.next()) {
            RoomBean room;
            int RoomID1 = rs.getInt(1);
            int HotelID1 = rs.getInt(2);
            String RTypeName1 = rs.getString(3);
            int RNumPeople1 = rs.getInt(4);
            int RCount1 = rs.getInt(5);
            String RoomDes1 = rs.getString(6);
            String RImage1 = rs.getString(7);
            double RoomPrice1 = rs.getDouble(8);

            room = new RoomBean(RoomID1, HotelID1, RTypeName1, RNumPeople1, RCount1, RoomDes1, RImage1, RoomPrice1);
            return room;
        } else {
            return null;
        }
    }

}
