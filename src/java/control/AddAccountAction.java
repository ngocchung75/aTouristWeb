/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Map;
import model.UserBean;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author CHUNG TOOC
 */
public class AddAccountAction extends ActionSupport implements SessionAware {

    private String RegisterUsername;
    private String RegisterPassword;
    private String FullName;
    private String RegisterEmail;
    private String Mobile;
    private int check;
    UserBean user;
    private Map<String, Object> sessionMap;

    @Override
    public String execute() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        //i = user.addAccount(this);
        user = new UserBean();
        String username = this.getRegisterUsername().toString();
        String email = this.getRegisterEmail().toString();

        if (user.existUsername(username)) {
            addActionError("Create My Account - This Username already exists.");
            return "error";
        } else if (user.existEmail(email)) {
            addActionError("Create My Account - This Email already exists.");
            return "error";
        } else {
            check = user.addAccount(this);
            if (check > 0) {
                Map session = ActionContext.getContext().getSession();
                session.remove("session-userid");
                session.remove("session-role");
                session.remove("session-gender");
                session.remove("logined");

                UserBean rs = user.getUser(this.RegisterUsername.toString());
                int UserID1 = rs.getUserID();
                int RoleID1 = rs.getRoleID();
                String FullName1 = rs.getFullName();
                String Gender1 = rs.getGender();
                String YearOfBirth1 = rs.getYearOfBirth();
                String Email1 = rs.getEmail();
                String Phone1 = rs.getPhone();
                String UserAddress1 = rs.getUserAddress();

                sessionMap.put("UserID", UserID1);
                sessionMap.put("RoleID", RoleID1);
                sessionMap.put("userName", username);
                sessionMap.put("FullName", FullName1);
                sessionMap.put("Gender", Gender1);
                sessionMap.put("YearOfBirth", YearOfBirth1);
                sessionMap.put("Email", Email1);
                sessionMap.put("Phone", Phone1);
                sessionMap.put("UserAddress", UserAddress1);

                session.put("session-userid", UserID1);
                session.put("session-role", RoleID1);
                session.put("session-gender", Gender1);
                session.put("logined", "true");

                return "success";
            }
            return "error";
        }
    }

    public String getRegisterUsername() {
        return RegisterUsername;
    }

    public void setRegisterUsername(String RegisterUsername) {
        this.RegisterUsername = RegisterUsername;
    }

    public String getRegisterPassword() {
        return RegisterPassword;
    }

    public void setRegisterPassword(String RegisterPassword) {
        this.RegisterPassword = RegisterPassword;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getRegisterEmail() {
        return RegisterEmail;
    }

    public void setRegisterEmail(String RegisterEmail) {
        this.RegisterEmail = RegisterEmail;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
}
