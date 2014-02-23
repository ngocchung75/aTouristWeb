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
public class StatusBean {

    private int StatusID;
    private String StatusName;

    public StatusBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public StatusBean(int StatusID, String StatusName) {
        this.StatusID = StatusID;
        this.StatusName = StatusName;
    }

    public int statusIDLast() throws ClassNotFoundException, SQLException {
        int statusID = 0;
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_status ORDER BY StatusID ASC";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            statusID = rs.getInt("StatusID");
        }
        return statusID;
    }

    public void addStatus(String statusName) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String insert_status = "insert into atourist_status values(?,?)";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(insert_status);

        int statusID = statusIDLast();
        statusID++;
        // Parameters start with 1
        pre.setInt(1, statusID);
        pre.setString(2, statusName);

        pre.executeUpdate();
        cnn.close();
        pre.close();
    }

    public int deleteStatus(int statusID) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String delete_status = "delete from atourist_status where StatusID=?";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(delete_status);
        pre.setInt(1, statusID);

        int check = pre.executeUpdate();
        cnn.close();
        pre.close();
        return check;
    }

    public void updateStatus(int statusID, String statusName) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String update_account = "Update atourist_status set StatusName=? where StatusID=?";
        PreparedStatement pre = (PreparedStatement) cnn.prepareStatement(update_account);

        // Parameters start with 1
        pre.setString(1, statusName);
        pre.setInt(2, statusID);

        pre.executeUpdate();
        cnn.close();
        pre.close();
    }

    public List<StatusBean> getAllStatus() throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_status";
        java.sql.Statement st = cnn.createStatement();
        List<StatusBean> statusLiss = new ArrayList<StatusBean>();
        ResultSet rs;
        rs = st.executeQuery(sql);
        while (rs.next()) {
            StatusBean status;
            int StatusID1 = rs.getInt(1);
            String StatusName1 = rs.getString(2);
            status = new StatusBean(StatusID1, StatusName1);
            statusLiss.add(status);
        }
        return statusLiss;
    }

    public StatusBean getStatusWithID(int statusID) throws ClassNotFoundException, SQLException {
        ConnectDatabase connect = new ConnectDatabase();
        java.sql.Connection cnn = connect.Connect();
        String sql = "select * from atourist_status where StatusID='" + statusID + "';";
        java.sql.Statement st = cnn.createStatement();
        ResultSet rs;
        rs = st.executeQuery(sql);
        if (rs.next()) {
            StatusBean status;
            int StatusID1 = rs.getInt(1);
            String StatusName1 = rs.getString(2);
            status = new StatusBean(StatusID1, StatusName1);
            return status;
        } else {
            return null;
        }
    }

    public int getStatusID() {
        return StatusID;
    }

    public void setStatusID(int StatusID) {
        this.StatusID = StatusID;
    }

    public String getStatusName() {
        return StatusName;
    }

    public void setStatusName(String StatusName) {
        this.StatusName = StatusName;
    }
}
