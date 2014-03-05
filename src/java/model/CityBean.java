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
public class CityBean {

    private int CityID;
    private String HotelCity;
    private List<CityBean> citylist;
    private CityBean city;

    public CityBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CityBean(int CityID, String HotelCity) {
        this.CityID = CityID;
        this.HotelCity = HotelCity;
    }

    public int cityIDLast() throws ClassNotFoundException, SQLException {
        int cityID = 0;
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_city ORDER BY CityID ASC";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            cityID = rs.getInt("CityID");
        }
        cnn.close();
        st.close();
        return cityID;
    }

    public void addCity(String cityName) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String insert_city = "insert into atourist_city values(?,?)";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(insert_city);

        int cityID = cityIDLast();
        cityID++;
        // Parameters start with 1
        pre.setInt(1, cityID);
        pre.setString(2, cityName);

        pre.executeUpdate();
        cnn.close();
        pre.close();
    }

    public int deleteCity(int cityID) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String delete_city = "delete from atourist_city where CityID=?";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(delete_city);
        pre.setInt(1, cityID);

        int check = pre.executeUpdate();
        cnn.close();
        pre.close();
        return check;
    }

    public void updateCity(int cityID, String cityName) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String update_account = "Update atourist_city set HotelCity=? where CityID=?";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(update_account);

        // Parameters start with 1
        pre.setString(1, cityName);
        pre.setInt(2, cityID);

        pre.executeUpdate();
        cnn.close();
        pre.close();
    }

    public List<CityBean> getAllCity() throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_city";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        citylist = new ArrayList();

        while (rs.next()) {
            int CityID1 = rs.getInt(1);
            String HotelCity1 = rs.getString(2);

            city = new CityBean(CityID1, HotelCity1);
            citylist.add(city);
        }
        cnn.close();
        st.close();
        return citylist;
    }

    public String getNameCity(int CityID) throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_city where CityID='" + CityID + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        String nameCity = "";
        if (rs.next()) {
            nameCity = rs.getString(2);
        }
        cnn.close();
        st.close();
        return nameCity;
    }

    public CityBean getCityWithID(int cityID) throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_city where CityID='" + cityID + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        if (rs.next()) {
            CityBean city1;
            int CityID1 = rs.getInt(1);
            String HotelCity1 = rs.getString(2);
            city1 = new CityBean(CityID1, HotelCity1);
            cnn.close();
            st.close();
            return city1;
        } else {
            cnn.close();
            st.close();
            return null;
        }
    }

    public int getCityID() {
        return CityID;
    }

    public void setCityID(int CityID) {
        this.CityID = CityID;
    }

    public String getHotelCity() {
        return HotelCity;
    }

    public void setHotelCity(String HotelCity) {
        this.HotelCity = HotelCity;
    }

    public List<CityBean> getCitylist() {
        return citylist;
    }

}
