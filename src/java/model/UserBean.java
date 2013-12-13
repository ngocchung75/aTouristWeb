/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import common.ConnectDatabase;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author CHUNG TOOC
 */
public class UserBean {
    
    private int UserID;
    private int RoleID;
    private String UserName;
    private String UserPass;
    private String FullName;
    private String Gender;
    private String YearOfBirth;
    private String Image;
    private String Email;
    private String Phone;
    private String UserAddress;
    private Date Created;
    private Date LastLogin;
    
    public UserBean() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public boolean checkLogin(String user, String pass) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException
    {
        //String temp = this.getPassword();
        //String pass = HashMD5.convertToMD5(temp);
        //String pass = this.getUserPass();
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_users where UserName=? and UserPass=? ";
        java.sql.PreparedStatement pre = cnn.prepareStatement(sql);
        pre.setString(1, user);
        pre.setString(2, pass);
        ResultSet rs = pre.executeQuery();
        if(rs.next())
            return true;
        else
            return false;
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

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
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

    public Date getLastLogin() {
        return LastLogin;
    }

    public void setLastLogin(Date LastLogin) {
        this.LastLogin = LastLogin;
    }
}
