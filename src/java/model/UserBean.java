/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.PreparedStatement;
import common.ConnectDatabase;
import common.HashMD5;
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
public class UserBean {

    private int UserID;
    private int RoleID;
    private String RoleName;
    private String UserName;
    private String UserPass;
    private String FullName;
    private String Gender;
    private String YearOfBirth;
    private String Email;
    private String Phone;
    private String UserAddress;
    private Date Created;

    public UserBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserBean(int UserID, int RoleID, String UserName, String FullName, String Gender, String YearOfBirth, String Email, String Phone, String UserAddress, Date Created) {
        this.UserID = UserID;
        this.RoleID = RoleID;
        this.UserName = UserName;
        this.FullName = FullName;
        this.Gender = Gender;
        this.YearOfBirth = YearOfBirth;
        this.Email = Email;
        this.Phone = Phone;
        this.UserAddress = UserAddress;
        this.Created = Created;
    }

    public UserBean(int UserID, int RoleID, String UserName, String FullName, String Gender, String YearOfBirth, String Email, String Phone, String UserAddress) {
        this.UserID = UserID;
        this.RoleID = RoleID;
        this.UserName = UserName;
        this.FullName = FullName;
        this.Gender = Gender;
        this.YearOfBirth = YearOfBirth;
        this.Email = Email;
        this.Phone = Phone;
        this.UserAddress = UserAddress;
    }

    public UserBean(int UserID, int RoleID, String RoleName, String UserName, String FullName, String Gender, String YearOfBirth, String Email, String Phone, String UserAddress, Date Created) {
        this.UserID = UserID;
        this.RoleID = RoleID;
        this.RoleName = RoleName;
        this.UserName = UserName;
        this.FullName = FullName;
        this.Gender = Gender;
        this.YearOfBirth = YearOfBirth;
        this.Email = Email;
        this.Phone = Phone;
        this.UserAddress = UserAddress;
        this.Created = Created;
    }

    public boolean checkLogin(String user, String pass) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        String pass1 = HashMD5.convertToMD5(pass);
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_users where UserName=? and UserPass=? ";
        java.sql.PreparedStatement pre = cnn.prepareStatement(sql);
        pre.setString(1, user);
        pre.setString(2, pass1);
        ResultSet rs = pre.executeQuery();
        return rs.next();
    }

    public int addAccount(AddAccountAction reg) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {

        String temp = reg.getRegisterPassword();
        String pass = HashMD5.convertToMD5(temp);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        String dateNow = dateFormat.format(date).toString();

        int userID = userIDLast();
        userID++;

        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String insert_account = "insert into atourist_users values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(insert_account);
        pre.setInt(1, userID);
        pre.setInt(2, 2);
        pre.setString(3, reg.getRegisterUsername());
        pre.setString(4, pass);
        pre.setString(5, reg.getFullName());
        pre.setString(6, "Male");
        pre.setString(7, "1900");
        pre.setString(8, reg.getRegisterEmail());
        pre.setString(9, reg.getMobile());
        pre.setString(10, "Danang, Vietnam");
        pre.setDate(11, Date.valueOf(dateNow));

        int check = pre.executeUpdate();
        cnn.close();
        pre.close();
        return check;
    }

    public UserBean getUser(String username) throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_users where UserName='" + username + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        if (rs.next()) {
            UserBean user;
            int UserID1 = rs.getInt(1);
            int RoleID1 = rs.getInt(2);
            String UserName1 = rs.getString(3);
            String FullName1 = rs.getString(5);
            String Gender1 = rs.getString(6);
            String YearOfBirth1 = rs.getString(7);
            String Email1 = rs.getString(8);
            String Phone1 = rs.getString(9);
            String UserAddress1 = rs.getString(10);

            user = new UserBean(UserID1, RoleID1, UserName1, FullName1, Gender1, YearOfBirth1, Email1, Phone1, UserAddress1);
            return user;
        } else {
            return null;
        }
    }

    public boolean existUsername(String username) throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_users where UserName='" + username + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        boolean kq = false;
        if (rs.next()) {
            kq = true;
        }
        return kq;
    }

    public boolean existEmail(String email) throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_users where Email='" + email + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        boolean kq = false;
        if (rs.next()) {
            kq = true;
        }
        return kq;
    }

    public boolean checkPass(String user, String pass) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        String pass1 = HashMD5.convertToMD5(pass);
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_users where UserName='" + user + "' and UserPass='" + pass1 + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        boolean kq = false;
        if (rs.next()) {
            kq = true;
        }
        return kq;
    }

    public boolean changePass(String username, String pass) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        String pass1 = HashMD5.convertToMD5(pass);
        int check = 0;
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "Update atourist_users set UserPass='" + pass1 + "' where UserName='" + username + "'";
        java.sql.Statement st = cnn.createStatement();
        check = st.executeUpdate(sql);
        boolean kq = false;
        if (check != 0) {
            kq = true;
        }
        return kq;
    }

    public void changePassword(int userID, String pass) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        String pass1 = HashMD5.convertToMD5(pass);
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String update_account = "Update atourist_users set UserPass=? where UserID=?";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(update_account);

        // Parameters start with 1
        pre.setString(1, pass1);
        pre.setInt(2, userID);
        pre.executeUpdate();
        pre.close();
        cnn.close();
    }

    public void changeRole(int userID, int roleID) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String update_account = "Update atourist_users set RoleID=? where UserID=?";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(update_account);

        // Parameters start with 1
        pre.setInt(1, roleID);
        pre.setInt(2, userID);
        pre.executeUpdate();
        cnn.close();
        pre.close();
    }

    public boolean updateProfile(String username, String FullName, String Gender, String YearOfBirth, String Email, String Mobile, String Address) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        int check = 0;
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "Update atourist_users set FullName='" + FullName + "', Gender='" + Gender + "', YearOfBirth='" + YearOfBirth + "', Email='" + Email + "', Phone='" + Mobile + "', UserAddress='" + Address + "' where UserName='" + username + "'";
        java.sql.Statement st = cnn.createStatement();
        check = st.executeUpdate(sql);
        boolean kq = false;
        if (check != 0) {
            kq = true;
        }
        return kq;
    }

    public int userIDLast() throws ClassNotFoundException, SQLException {
        int userID = 0;
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_users ORDER BY UserID ASC";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            userID = rs.getInt("UserID");
        }
        return userID;
    }

    public void addUser(UserBean user) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        String temp = user.getUserPass();
        String pass = HashMD5.convertToMD5(temp);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        String dateNow = dateFormat.format(date).toString();

        int userID = userIDLast();
        userID++;

        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String insert_account = "insert into atourist_users values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(insert_account);

        // Parameters start with 1
        pre.setInt(1, userID);
        pre.setInt(2, user.getRoleID());
        pre.setString(3, user.getUserName());
        pre.setString(4, pass);
        pre.setString(5, user.getFullName());
        pre.setString(6, user.getGender());
        pre.setString(7, user.getYearOfBirth());
        pre.setString(8, user.getEmail());
        pre.setString(9, user.getPhone());
        pre.setString(10, user.getUserAddress());
        pre.setDate(11, Date.valueOf(dateNow));

        pre.executeUpdate();
        cnn.close();
        pre.close();
    }

    public int deleteUser(int userId) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String delete_account = "delete from atourist_users where UserID=?";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(delete_account);
        pre.setInt(1, userId);

        int check = pre.executeUpdate();
        cnn.close();
        pre.close();
        return check;
    }

    public void updateUser(UserBean user) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String update_account = "Update atourist_users set RoleID=?, UserName=?, FullName=?, Gender=?, YearOfBirth=?, Email=?, Phone=?, UserAddress=? where UserID=?";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(update_account);

        // Parameters start with 1
        pre.setInt(1, user.getRoleID());
        pre.setString(2, user.getUserName());
        pre.setString(3, user.getFullName());
        pre.setString(4, user.getGender());
        pre.setString(5, user.getYearOfBirth());
        pre.setString(6, user.getEmail());
        pre.setString(7, user.getPhone());
        pre.setString(8, user.getUserAddress());
        pre.setInt(9, user.getUserID());

        pre.executeUpdate();
        cnn.close();
        pre.close();

    }

    public List<UserBean> getAllUsers() throws ClassNotFoundException, SQLException {
        List<UserBean> usersliss = new ArrayList<UserBean>();
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_users";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        while (rs.next()) {
            UserBean user;
            RoleBean roleBean = new RoleBean();
            RoleBean role = new RoleBean();
            int UserID1 = rs.getInt(1);
            int RoleID1 = rs.getInt(2);
            role = roleBean.getRoleWithID(RoleID1);
            String RoleName1 = role.getRoleName();
            String UserName1 = rs.getString(3);
            String FullName1 = rs.getString(5);
            String Gender1 = rs.getString(6);
            String YearOfBirth1 = rs.getString(7);
            String Email1 = rs.getString(8);
            String Phone1 = rs.getString(9);
            String UserAddress1 = rs.getString(10);
            Date Created1 = rs.getDate(11);

            user = new UserBean(UserID1, RoleID1, RoleName1, UserName1, FullName1, Gender1, YearOfBirth1, Email1, Phone1, UserAddress1, Created1);
            usersliss.add(user);
        }
        cnn.close();
        return usersliss;
    }

    public List<UserBean> getAllUsersRole(int roleid) throws ClassNotFoundException, SQLException {
        List<UserBean> usersliss = new ArrayList<UserBean>();

        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_users where RoleID='" + roleid + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        while (rs.next()) {
            UserBean user;
            RoleBean roleBean = new RoleBean();
            RoleBean role = new RoleBean();
            int UserID1 = rs.getInt(1);
            int RoleID1 = rs.getInt(2);
            role = roleBean.getRoleWithID(RoleID1);
            String RoleName1 = role.getRoleName();
            String UserName1 = rs.getString(3);
            String FullName1 = rs.getString(5);
            String Gender1 = rs.getString(6);
            String YearOfBirth1 = rs.getString(7);
            String Email1 = rs.getString(8);
            String Phone1 = rs.getString(9);
            String UserAddress1 = rs.getString(10);
            Date Created1 = rs.getDate(11);

            user = new UserBean(UserID1, RoleID1, RoleName1, UserName1, FullName1, Gender1, YearOfBirth1, Email1, Phone1, UserAddress1, Created1);
            usersliss.add(user);
        }
        st.close();
        cnn.close();
        return usersliss;
    }

    public UserBean getUserID(int userId) throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_users where UserID='" + userId + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        if (rs.next()) {
            UserBean user;
            RoleBean roleBean = new RoleBean();
            RoleBean role = new RoleBean();
            int UserID1 = rs.getInt(1);
            int RoleID1 = rs.getInt(2);
            role = roleBean.getRoleWithID(RoleID1);
            String RoleName1 = role.getRoleName();
            String UserName1 = rs.getString(3);
            String FullName1 = rs.getString(5);
            String Gender1 = rs.getString(6);
            String YearOfBirth1 = rs.getString(7);
            String Email1 = rs.getString(8);
            String Phone1 = rs.getString(9);
            String UserAddress1 = rs.getString(10);
            Date Created1 = rs.getDate(11);

            user = new UserBean(UserID1, RoleID1, RoleName1, UserName1, FullName1, Gender1, YearOfBirth1, Email1, Phone1, UserAddress1, Created1);
            st.close();
            cnn.close();
            return user;
        } else {
            st.close();
            cnn.close();
            return null;
        }
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserPass() {
        return UserPass;
    }

    public void setUserPass(String UserPass) {
        this.UserPass = UserPass;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getYearOfBirth() {
        return YearOfBirth;
    }

    public void setYearOfBirth(String YearOfBirth) {
        this.YearOfBirth = YearOfBirth;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getUserAddress() {
        return UserAddress;
    }

    public void setUserAddress(String UserAddress) {
        this.UserAddress = UserAddress;
    }

    public Date getCreated() {
        return Created;
    }

    public void setCreated(Date Created) {
        this.Created = Created;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }
}
