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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CHUNG TOOC
 */
public class RoomBean {

    private int RoomID;
    private int HotelID;
    private String RTypeName;
    private int RNumPeople;
    private int RCount;
    private String RoomDes;
    private String RImage;
    private double RoomPrice;
    private List<RoomBean> roomlist;
    private RoomBean roomBean;

    public RoomBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public RoomBean(int RoomID, int HotelID, String RTypeName, int RNumPeople,
            int RCount, String RoomDes, String RImage, double RoomPrice) {
        this.RoomID = RoomID;
        this.HotelID = HotelID;
        this.RTypeName = RTypeName;
        this.RNumPeople = RNumPeople;
        this.RCount = RCount;
        this.RoomDes = RoomDes;
        this.RImage = RImage;
        this.RoomPrice = RoomPrice;
    }

    public int roomIDLast() throws ClassNotFoundException, SQLException {
        int roomID = 0;
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_rooms";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            roomID = rs.getInt("RoomID");
        }
        return roomID;
    }

    public void addRoom(RoomBean roomBean) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String insert_room = "insert into atourist_rooms values(?,?,?,?,?,?,?,?)";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(insert_room);

        int roomID = roomIDLast();
        roomID++;
        // Parameters start with 1
        pre.setInt(1, roomID);
        pre.setInt(2, roomBean.getHotelID());
        pre.setString(3, roomBean.getRTypeName());
        pre.setInt(4, roomBean.getRNumPeople());
        pre.setInt(5, roomBean.getRCount());
        pre.setString(6, roomBean.getRoomDes());
        pre.setString(7, roomBean.getRImage());
        pre.setDouble(8, roomBean.getRoomPrice());

        pre.executeUpdate();
        cnn.close();
        pre.close();
    }

    public int deleteRoom(int roomID) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String delete_room = "delete from atourist_rooms where RoomID=?";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(delete_room);
        pre.setInt(1, roomID);

        int check = pre.executeUpdate();
        cnn.close();
        pre.close();
        return check;
    }

    public void updateRoom(RoomBean roomBean) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String update_room = "Update atourist_rooms set HotelID=?, RTypeName=?, RNumPeople=?,\n"
                + "RCount=?, RoomDes=?, RImage=?, RoomPrice=? where RoomID=?";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(update_room);

        // Parameters start with 1
        pre.setInt(1, roomBean.getHotelID());
        pre.setString(2, roomBean.getRTypeName());
        pre.setInt(3, roomBean.getRNumPeople());
        pre.setInt(4, roomBean.getRCount());
        pre.setString(5, roomBean.getRoomDes());
        pre.setString(6, roomBean.getRImage());
        pre.setDouble(7, roomBean.getRoomPrice());
        pre.setInt(8, roomBean.getRoomID());

        pre.executeUpdate();
        cnn.close();
        pre.close();
    }

    public List<RoomBean> getAllRoom() throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_rooms";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        List<RoomBean> roomlist = null;
        roomlist = new ArrayList();

        while (rs.next()) {
            int RoomID1 = rs.getInt(1);
            int HotelID1 = rs.getInt(2);
            String RTypeName1 = rs.getString(3);
            int RNumPeople1 = rs.getInt(4);
            int RCount1 = rs.getInt(5);
            String RoomDes1 = rs.getString(6);
            String RImage1 = rs.getString(7);
            double RoomPrice1 = rs.getDouble(8);

            roomBean = new RoomBean(RoomID1, HotelID1, RTypeName1, RNumPeople1, RCount1, RoomDes1, RImage1, RoomPrice1);
            roomlist.add(roomBean);
        }
        return roomlist;
    }

    public List<RoomBean> getAllRoomWithHotelID(int hotelID) throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_rooms where HotelID='" + hotelID + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        List<RoomBean> roomlist = null;
        roomlist = new ArrayList();
                
        while (rs.next()) {
            int RoomID1 = rs.getInt(1);
            int HotelID1 = rs.getInt(2);
            String RTypeName1 = rs.getString(3);
            int RNumPeople1 = rs.getInt(4);
            int RCount1 = rs.getInt(5);
            String RoomDes1 = rs.getString(6);
            String RImage1 = rs.getString(7);
            double RoomPrice1 = rs.getDouble(8);

            roomBean = new RoomBean(RoomID1, HotelID1, RTypeName1, RNumPeople1, RCount1, RoomDes1, RImage1, RoomPrice1);
            roomlist.add(roomBean);
        }
        return roomlist;
    }

    public RoomBean getRoomWithID(int roomID) throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_rooms where RoomID='" + roomID + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        if (rs.next()) {
            RoomBean room1;
            int RoomID1 = rs.getInt(1);
            int HotelID1 = rs.getInt(2);
            String RTypeName1 = rs.getString(3);
            int RNumPeople1 = rs.getInt(4);
            int RCount1 = rs.getInt(5);
            String RoomDes1 = rs.getString(6);
            String RImage1 = rs.getString(7);
            double RoomPrice1 = rs.getDouble(8);

            room1 = new RoomBean(RoomID1, HotelID1, RTypeName1, RNumPeople1, RCount1, RoomDes1, RImage1, RoomPrice1);
            return room1;
        } else {
            return null;
        }
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

    public String getRTypeName() {
        return RTypeName;
    }

    public void setRTypeName(String RTypeName) {
        this.RTypeName = RTypeName;
    }

    public int getRNumPeople() {
        return RNumPeople;
    }

    public void setRNumPeople(int RNumPeople) {
        this.RNumPeople = RNumPeople;
    }

    public int getRCount() {
        return RCount;
    }

    public void setRCount(int RCount) {
        this.RCount = RCount;
    }

    public String getRoomDes() {
        return RoomDes;
    }

    public void setRoomDes(String RoomDes) {
        this.RoomDes = RoomDes;
    }

    public double getRoomPrice() {
        return RoomPrice;
    }

    public void setRoomPrice(double RoomPrice) {
        this.RoomPrice = RoomPrice;
    }

    public String getRImage() {
        return RImage;
    }

    public void setRImage(String RImage) {
        this.RImage = RImage;
    }

}
