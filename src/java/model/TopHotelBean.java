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
public class TopHotelBean {

    private int TopHotelID;
    private int HotelID;

    public TopHotelBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public TopHotelBean(int TopHotelID, int HotelID) {
        this.TopHotelID = TopHotelID;
        this.HotelID = HotelID;
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
        return tophotellist;
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

}
