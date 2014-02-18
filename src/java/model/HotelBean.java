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
public class HotelBean {

    private int HotelID;
    private int UserID;
    private String UserName;
    private String HotelName;
    private String HotelEmail;
    private String HotelPhone;
    private String HotelAddress;
    private int CityID;
    private String HotelCity;
    private String HotelMap;
    private String HotelRating;
    private String HotelDes;
    private String HotelDesShort;
    private String HotelPol;
    private String HotelFac;
    private String HotelImage;
    private String HotelWebsite;
    private String HotelPriceFrom;
    private String TimeCheckIn;
    private String TimeCheckOut;
    UserBean userBean;

    public HotelBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public HotelBean(int HotelID, int UserID, String HotelName) {
        this.HotelID = HotelID;
        this.UserID = UserID;
        this.HotelName = HotelName;
    }

    public HotelBean(int HotelID, int UserID, String UserName, String HotelName, String HotelEmail, String HotelPhone,
            String HotelAddress, int CityID, String HotelCity, String HotelMap, String HotelRating, String HotelDes, String HotelDesShort, String HotelPol,
            String HotelFac, String HotelImage, String HotelWebsite, String HotelPriceFrom, String TimeCheckIn, String TimeCheckOut) {
        this.HotelID = HotelID;
        this.UserID = UserID;
        this.UserName = UserName;
        this.HotelName = HotelName;
        this.HotelEmail = HotelEmail;
        this.HotelPhone = HotelPhone;
        this.HotelAddress = HotelAddress;
        this.CityID = CityID;
        this.HotelCity = HotelCity;
        this.HotelMap = HotelMap;
        this.HotelRating = HotelRating;
        this.HotelDes = HotelDes;
        this.HotelDesShort = HotelDesShort;
        this.HotelPol = HotelPol;
        this.HotelFac = HotelFac;
        this.HotelImage = HotelImage;
        this.HotelWebsite = HotelWebsite;
        this.HotelPriceFrom = HotelPriceFrom;
        this.TimeCheckIn = TimeCheckIn;
        this.TimeCheckOut = TimeCheckOut;
    }

    public List<HotelBean> getAllHotel() throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_hotels";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        List<HotelBean> hotellist = null;
        hotellist = new ArrayList();

        while (rs.next()) {
            HotelBean hotel;
            UserBean user = new UserBean();
            CityBean city = new CityBean();
            int HotelID1 = rs.getInt(1);
            int UserID1 = rs.getInt(2);
            userBean = new UserBean();
            user = userBean.getUserID(UserID1);
            String UserName1 = user.getUserName();
            String HotelName1 = rs.getString(3);
            String HotelEmail1 = rs.getString(4);
            String HotelPhone1 = rs.getString(5);
            String HotelAddress1 = rs.getString(6);
            int CityID1 = rs.getInt(7);
            String HotelCity1 = city.getNameCity(CityID1);
            String HotelMap1 = rs.getString(8);
            String HotelRating1 = rs.getString(9);
            String HotelDes1 = rs.getString(10);
            String HotelDesShort1 = rs.getString(11);
            String HotelPol1 = rs.getString(12);
            String HotelFac1 = rs.getString(13);
            String HotelImage1 = rs.getString(14);
            String HotelWebsite1 = rs.getString(15);
            String HotelPriceFrom1 = rs.getString(16);
            String TimeCheckIn1 = rs.getString(17);
            String TimeCheckOut1 = rs.getString(18);

            hotel = new HotelBean(HotelID1, UserID1, UserName1, HotelName1, HotelEmail1, HotelPhone1, HotelAddress1, CityID1, HotelCity1,
                    HotelMap1, HotelRating1, HotelDes1, HotelDesShort1, HotelPol1, HotelFac1, HotelImage1, HotelWebsite1, HotelPriceFrom1, TimeCheckIn1, TimeCheckOut1);
            hotellist.add(hotel);
        }
        return hotellist;
    }

    public List<HotelBean> getAllHotelCity(int CityID) throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_hotels where CityID='" + CityID + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        List<HotelBean> hotellist = null;
        hotellist = new ArrayList();

        while (rs.next()) {
            HotelBean hotel;
            UserBean user = new UserBean();
            CityBean city = new CityBean();
            int HotelID1 = rs.getInt(1);
            int UserID1 = rs.getInt(2);
            userBean = new UserBean();
            user = userBean.getUserID(UserID1);
            String UserName1 = user.getUserName();
            String HotelName1 = rs.getString(3);
            String HotelEmail1 = rs.getString(4);
            String HotelPhone1 = rs.getString(5);
            String HotelAddress1 = rs.getString(6);
            int CityID1 = rs.getInt(7);
            String HotelCity1 = city.getNameCity(CityID1);
            String HotelMap1 = rs.getString(8);
            String HotelRating1 = rs.getString(9);
            String HotelDes1 = rs.getString(10);
            String HotelDesShort1 = rs.getString(11);
            String HotelPol1 = rs.getString(12);
            String HotelFac1 = rs.getString(13);
            String HotelImage1 = rs.getString(14);
            String HotelWebsite1 = rs.getString(15);
            String HotelPriceFrom1 = rs.getString(16);
            String TimeCheckIn1 = rs.getString(17);
            String TimeCheckOut1 = rs.getString(18);

            hotel = new HotelBean(HotelID1, UserID1, UserName1, HotelName1, HotelEmail1, HotelPhone1, HotelAddress1, CityID1, HotelCity1,
                    HotelMap1, HotelRating1, HotelDes1, HotelDesShort1, HotelPol1, HotelFac1, HotelImage1, HotelWebsite1, HotelPriceFrom1, TimeCheckIn1, TimeCheckOut1);
            hotellist.add(hotel);
        }
        return hotellist;
    }

    public HotelBean getHotel(int HotelID) throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_hotels where HotelID='" + HotelID + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        if (rs.next()) {
            HotelBean hotel;
            UserBean user = new UserBean();
            CityBean city = new CityBean();
            int HotelID1 = rs.getInt(1);
            int UserID1 = rs.getInt(2);
            userBean = new UserBean();
            user = userBean.getUserID(UserID1);
            String UserName1 = user.getUserName();
            String HotelName1 = rs.getString(3);
            String HotelEmail1 = rs.getString(4);
            String HotelPhone1 = rs.getString(5);
            String HotelAddress1 = rs.getString(6);
            int CityID1 = rs.getInt(7);
            String HotelCity1 = city.getNameCity(CityID1);
            String HotelMap1 = rs.getString(8);
            String HotelRating1 = rs.getString(9);
            String HotelDes1 = rs.getString(10);
            String HotelDesShort1 = rs.getString(11);
            String HotelPol1 = rs.getString(12);
            String HotelFac1 = rs.getString(13);
            String HotelImage1 = rs.getString(14);
            String HotelWebsite1 = rs.getString(15);
            String HotelPriceFrom1 = rs.getString(16);
            String TimeCheckIn1 = rs.getString(17);
            String TimeCheckOut1 = rs.getString(18);

            hotel = new HotelBean(HotelID1, UserID1, UserName1, HotelName1, HotelEmail1, HotelPhone1, HotelAddress1, CityID1, HotelCity1,
                    HotelMap1, HotelRating1, HotelDes1, HotelDesShort1, HotelPol1, HotelFac1, HotelImage1, HotelWebsite1, HotelPriceFrom1, TimeCheckIn1, TimeCheckOut1);
            return hotel;
        } else {
            return null;
        }
    }

    public List<HotelBean> getTopHotel() throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();

        List<HotelBean> hotellist = null;
        hotellist = new ArrayList();

        TopHotelBean tophotel = new TopHotelBean();
        List<TopHotelBean> tophotellist = null;
        tophotellist = new ArrayList();
        tophotellist = tophotel.getTopHotel();

        for (int i = 0; i < tophotellist.size(); i++) {
            String sql = "select * from atourist_hotels where HotelID='" + tophotellist.get(i).getHotelID() + "';";
            java.sql.Statement st = cnn.createStatement();
            ResultSet rs;
            rs = st.executeQuery(sql);
            if (rs.next()) {
                HotelBean hotel;
                UserBean user = new UserBean();
                CityBean city = new CityBean();
                int HotelID1 = rs.getInt(1);
                int UserID1 = rs.getInt(2);
                userBean = new UserBean();
                user = userBean.getUserID(UserID1);
                String UserName1 = user.getUserName();
                String HotelName1 = rs.getString(3);
                String HotelEmail1 = rs.getString(4);
                String HotelPhone1 = rs.getString(5);
                String HotelAddress1 = rs.getString(6);
                int CityID1 = rs.getInt(7);
                String HotelCity1 = city.getNameCity(CityID1);
                String HotelMap1 = rs.getString(8);
                String HotelRating1 = rs.getString(9);
                String HotelDes1 = rs.getString(10);
                String HotelDesShort1 = rs.getString(11);
                String HotelPol1 = rs.getString(12);
                String HotelFac1 = rs.getString(13);
                String HotelImage1 = rs.getString(14);
                String HotelWebsite1 = rs.getString(15);
                String HotelPriceFrom1 = rs.getString(16);
                String TimeCheckIn1 = rs.getString(17);
                String TimeCheckOut1 = rs.getString(18);

                hotel = new HotelBean(HotelID1, UserID1, UserName1, HotelName1, HotelEmail1, HotelPhone1, HotelAddress1, CityID1, HotelCity1,
                        HotelMap1, HotelRating1, HotelDes1, HotelDesShort1, HotelPol1, HotelFac1, HotelImage1, HotelWebsite1, HotelPriceFrom1, TimeCheckIn1, TimeCheckOut1);
                hotellist.add(hotel);
            }
        }
        return hotellist;
    }

    public int hotelIDLast() throws ClassNotFoundException, SQLException {
        int hotelID = 0;
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_hotels";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            hotelID = rs.getInt("HotelID");
        }
        return hotelID;
    }

    public void addHotel(HotelBean hotel) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String insert_hotel = "insert into atourist_hotels values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(insert_hotel);

        int hotelID = hotelIDLast();
        hotelID++;
        // Parameters start with 1
        pre.setInt(1, hotelID);
        pre.setInt(2, hotel.getUserID());
        pre.setString(3, hotel.getHotelName());
        pre.setString(4, hotel.getHotelEmail());
        pre.setString(5, hotel.getHotelPhone());
        pre.setString(6, hotel.getHotelAddress());
        pre.setInt(7, hotel.getCityID());
        pre.setString(8, hotel.getHotelMap());
        pre.setString(9, hotel.getHotelRating());
        pre.setString(10, hotel.getHotelDes());
        pre.setString(11, hotel.getHotelDesShort());
        pre.setString(12, hotel.getHotelPol());
        pre.setString(13, hotel.getHotelFac());
        pre.setString(14, hotel.getHotelImage());
        pre.setString(15, hotel.getHotelWebsite());
        pre.setString(16, hotel.getHotelPriceFrom());
        pre.setString(17, hotel.getTimeCheckIn());
        pre.setString(18, hotel.getTimeCheckOut());

        pre.executeUpdate();
        cnn.close();
        pre.close();
    }

    public int deleteHotel(int hotelID) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String delete_booking = "delete from atourist_bookings where HotelID=?";
        PreparedStatement pre1 = (PreparedStatement) cnn.prepareStatement(delete_booking);
        pre1.setInt(1, hotelID);
        pre1.executeUpdate();
        pre1.close();

        String delete_rooms = "delete from atourist_rooms where HotelID=?";
        PreparedStatement pre2 = (PreparedStatement) cnn.prepareStatement(delete_rooms);
        pre2.setInt(1, hotelID);
        pre2.executeUpdate();
        pre2.close();

        String delete_hotel = "delete from atourist_hotels where HotelID=?";
        PreparedStatement pre3 = (PreparedStatement) cnn.prepareStatement(delete_hotel);
        pre3.setInt(1, hotelID);
        int check = pre3.executeUpdate();
        
        cnn.close();
        pre3.close();
        return check;
    }

    public void updateHotel(HotelBean hotel) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String update_hotel = "Update atourist_hotels set UserID=?, HotelName=?, HotelEmail=?, HotelPhone=?, HotelAddress=?, CityID=?, \n"
                + "HotelMap=?, HotelRating=?, HotelDes=?, HotelDesShort=?, HotelPol=?, HotelFac=?, HotelImage=?, HotelWebsite=?, HotelPriceFrom=?, TimeCheckIn=?, TimeCheckOut=? where HotelID=?";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(update_hotel);

        // Parameters start with 1
        pre.setInt(1, hotel.getUserID());
        pre.setString(2, hotel.getHotelName());
        pre.setString(3, hotel.getHotelEmail());
        pre.setString(4, hotel.getHotelPhone());
        pre.setString(5, hotel.getHotelAddress());
        pre.setInt(6, hotel.getCityID());
        pre.setString(7, hotel.getHotelMap());
        pre.setString(8, hotel.getHotelRating());
        pre.setString(9, hotel.getHotelDes());
        pre.setString(10, hotel.getHotelDesShort());
        pre.setString(11, hotel.getHotelPol());
        pre.setString(12, hotel.getHotelFac());
        pre.setString(13, hotel.getHotelImage());
        pre.setString(14, hotel.getHotelWebsite());
        pre.setString(15, hotel.getHotelPriceFrom());
        pre.setString(16, hotel.getTimeCheckIn());
        pre.setString(17, hotel.getTimeCheckOut());
        pre.setInt(18, hotel.getHotelID());

        pre.executeUpdate();
        cnn.close();
        pre.close();
    }

    public void updateHotelAdmin(int hotelID, int userID) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String update_hotel = "Update atourist_hotels set UserID=? where HotelID=?";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(update_hotel);

        // Parameters start with 1
        pre.setInt(1, userID);
        pre.setInt(2, hotelID);

        pre.executeUpdate();
        cnn.close();
        pre.close();
    }

    public int getHotelID() {
        return HotelID;
    }

    public void setHotelID(int HotelID) {
        this.HotelID = HotelID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String HotelName) {
        this.HotelName = HotelName;
    }

    public String getHotelEmail() {
        return HotelEmail;
    }

    public void setHotelEmail(String HotelEmail) {
        this.HotelEmail = HotelEmail;
    }

    public String getHotelPhone() {
        return HotelPhone;
    }

    public void setHotelPhone(String HotelPhone) {
        this.HotelPhone = HotelPhone;
    }

    public String getHotelAddress() {
        return HotelAddress;
    }

    public void setHotelAddress(String HotelAddress) {
        this.HotelAddress = HotelAddress;
    }

    public String getHotelMap() {
        return HotelMap;
    }

    public void setHotelMap(String HotelMap) {
        this.HotelMap = HotelMap;
    }

    public String getHotelDes() {
        return HotelDes;
    }

    public void setHotelDes(String HotelDes) {
        this.HotelDes = HotelDes;
    }

    public String getHotelPol() {
        return HotelPol;
    }

    public void setHotelPol(String HotelPol) {
        this.HotelPol = HotelPol;
    }

    public String getHotelFac() {
        return HotelFac;
    }

    public void setHotelFac(String HotelFac) {
        this.HotelFac = HotelFac;
    }

    public String getHotelImage() {
        return HotelImage;
    }

    public void setHotelImage(String HotelImage) {
        this.HotelImage = HotelImage;
    }

    public String getHotelPriceFrom() {
        return HotelPriceFrom;
    }

    public void setHotelPriceFrom(String HotelPriceFrom) {
        this.HotelPriceFrom = HotelPriceFrom;
    }

    public String getTimeCheckIn() {
        return TimeCheckIn;
    }

    public void setTimeCheckIn(String TimeCheckIn) {
        this.TimeCheckIn = TimeCheckIn;
    }

    public String getTimeCheckOut() {
        return TimeCheckOut;
    }

    public void setTimeCheckOut(String TimeCheckOut) {
        this.TimeCheckOut = TimeCheckOut;
    }

    public String getHotelCity() {
        return HotelCity;
    }

    public void setHotelCity(String HotelCity) {
        this.HotelCity = HotelCity;
    }

    public String getHotelDesShort() {
        return HotelDesShort;
    }

    public void setHotelDesShort(String HotelDesShort) {
        this.HotelDesShort = HotelDesShort;
    }

    public String getHotelRating() {
        return HotelRating;
    }

    public void setHotelRating(String HotelRating) {
        this.HotelRating = HotelRating;
    }

    public String getHotelWebsite() {
        return HotelWebsite;
    }

    public void setHotelWebsite(String HotelWebsite) {
        this.HotelWebsite = HotelWebsite;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public int getCityID() {
        return CityID;
    }

    public void setCityID(int CityID) {
        this.CityID = CityID;
    }

}
