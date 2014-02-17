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
public class RoleBean {

    private int RoleID;
    private String RoleName;

    public RoleBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public RoleBean(int RoleID, String RoleName) {
        this.RoleID = RoleID;
        this.RoleName = RoleName;
    }
    
    public int roleIDLast() throws ClassNotFoundException, SQLException {
        int roleID = 0;
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_roles";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            roleID = rs.getInt("RoleID");
        }
        return roleID;
    }

    public void addRole(String roleName) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String insert_role = "insert into atourist_roles values(?,?)";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(insert_role);

        int roleID = roleIDLast();
        roleID++;
        // Parameters start with 1
        pre.setInt(1, roleID);
        pre.setString(2, roleName);

        pre.executeUpdate();
        cnn.close();
        pre.close();
    }

    public int deleteRole(int roleID) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String delete_role = "delete from atourist_roles where RoleID=?";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(delete_role);
        pre.setInt(1, roleID);

        int check = pre.executeUpdate();
        cnn.close();
        pre.close();
        return check;
    }

    public void updateRole(int roleID, String roleName) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String update_account = "Update atourist_roles set RoleName=? where RoleID=?";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(update_account);

        // Parameters start with 1
        pre.setString(1, roleName);
        pre.setInt(2, roleID);

        pre.executeUpdate();
        cnn.close();
        pre.close();
    }

    public List<RoleBean> getAllRole() throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_roles";
        java.sql.Statement st = cnn.createStatement();
        List<RoleBean> roleLiss = new ArrayList<RoleBean>();
        ResultSet rs;
        rs = st.executeQuery(sql);
        while (rs.next()) {
            RoleBean role;
            int RoleID1 = rs.getInt(1);
            String RoleName1 = rs.getString(2);
            role = new RoleBean(RoleID1, RoleName1);
            roleLiss.add(role);
        }
        return roleLiss;
    }

    public RoleBean getRoleWithID(int roleID) throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_roles where RoleID='" + roleID + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        if (rs.next()) {
            RoleBean role;
            int RoleID1 = rs.getInt(1);
            String RoleName1 = rs.getString(2);
            role = new RoleBean(RoleID1, RoleName1);
            return role;
        } else {
            return null;
        }
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }

}
