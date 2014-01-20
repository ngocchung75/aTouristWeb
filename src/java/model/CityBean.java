/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import common.ConnectDatabase;
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
        return nameCity;
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
