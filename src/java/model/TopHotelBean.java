/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import common.ConnectDatabase;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CHUNG TOOC
 */
public class TopHotelBean {

    private int TopHotelID;
    private int HotelID;
    private String HotelName;
    HotelBean hotel;

    public TopHotelBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public TopHotelBean(int TopHotelID, int HotelID) {
        this.TopHotelID = TopHotelID;
        this.HotelID = HotelID;
    }

    public TopHotelBean(int TopHotelID, int HotelID, String HotelName) {
        this.TopHotelID = TopHotelID;
        this.HotelID = HotelID;
        this.HotelName = HotelName;
    }

    public TopHotelBean(int HotelID, String HotelName) {
        this.HotelID = HotelID;
        this.HotelName = HotelName;
    }

    public int topHotelIDLast() throws ClassNotFoundException, SQLException {
        int topHotelID = 0;
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_tophotels";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            topHotelID = rs.getInt("TopHotelID");
        }
        return topHotelID;
    }

    public void addtopHotel(int hotelID) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String insert_topHotel = "insert into atourist_tophotels values(?,?)";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(insert_topHotel);

        int topHotelID = topHotelIDLast();
        topHotelID++;
        // Parameters start with 1
        pre.setInt(1, topHotelID);
        pre.setInt(2, hotelID);

        pre.executeUpdate();
        cnn.close();
        pre.close();
    }

    public int deletetopHotel(int topHotelID) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String delete_topHotel = "delete from atourist_tophotels where TopHotelID=?";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(delete_topHotel);
        pre.setInt(1, topHotelID);

        int check = pre.executeUpdate();
        cnn.close();
        pre.close();
        return check;
    }

    public void updatetopHotel(int topHotelID, int hotelID) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String update_account = "Update atourist_tophotels set HotelID=? where TopHotelID=?";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(update_account);

        // Parameters start with 1
        pre.setInt(1, hotelID);
        pre.setInt(2, topHotelID);

        pre.executeUpdate();
        cnn.close();
        pre.close();
    }

    public List<TopHotelBean> getAllTopHotel() throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_tophotels";
        java.sql.Statement st = cnn.createStatement();
        List<TopHotelBean> topHotelLiss = new ArrayList<TopHotelBean>();
        ResultSet rs;
        rs = st.executeQuery(sql);
        while (rs.next()) {
            TopHotelBean topHotel;
            hotel = new HotelBean();
            int TopHotelID1 = rs.getInt(1);
            int HotelID1 = rs.getInt(2);
            String HotelName1 = hotel.getHotel(HotelID1).getHotelName();
            topHotel = new TopHotelBean(TopHotelID1, HotelID1, HotelName1);
            topHotelLiss.add(topHotel);
        }
        cnn.close();
        return topHotelLiss;
    }

    public TopHotelBean getTopHotelWithID(int topHotelID) throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_tophotels where TopHotelID='" + topHotelID + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        if (rs.next()) {
            TopHotelBean topHotel;
            hotel = new HotelBean();
            int TopHotelID1 = rs.getInt(1);
            int HotelID1 = rs.getInt(2);
            String HotelName1 = hotel.getHotel(HotelID1).getHotelName();
            topHotel = new TopHotelBean(TopHotelID1, HotelID1, HotelName1);
            cnn.close();
            return topHotel;
        } else {
            cnn.close();
            return null;
        }
    }

    public List<TopHotelBean> getTopHotel() throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_tophotels";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        List<TopHotelBean> tophotellist = null;
        tophotellist = new ArrayList();

        while (rs.next()) {
            TopHotelBean tophotel;
            int TopHotelID1 = rs.getInt(1);
            int HotelID1 = rs.getInt(2);

            tophotel = new TopHotelBean(TopHotelID1, HotelID1);
            tophotellist.add(tophotel);
        }
        cnn.close();
        return tophotellist;
    }

    public List<TopHotelBean> getAllHotel() throws ClassNotFoundException, SQLException {
        List<TopHotelBean> topHotelLiss = new ArrayList<TopHotelBean>();
        List<HotelBean> hotellist = null;
        hotellist = new ArrayList();
        hotel = new HotelBean();
        hotellist = hotel.getAllHotel();

        for (int i = 0; i < hotellist.size(); i++) {
            TopHotelBean tophotel;
            int HotelID1 = hotellist.get(i).getHotelID();
            String HotelName1 = hotellist.get(i).getHotelName();

            tophotel = new TopHotelBean(HotelID1, HotelName1);
            topHotelLiss.add(tophotel);
        }

        return topHotelLiss;
    }

    public int getTopHotelID() {
        return TopHotelID;
    }

    public void setTopHotelID(int TopHotelID) {
        this.TopHotelID = TopHotelID;
    }

    public int getHotelID() {
        return HotelID;
    }

    public void setHotelID(int HotelID) {
        this.HotelID = HotelID;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String HotelName) {
        this.HotelName = HotelName;
    }

}
