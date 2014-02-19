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
public class LoginAuthAction extends ActionSupport implements SessionAware {

    private String username;
    private String password;
    private Boolean error;
    private Map<String, Object> sessionMap;
    UserBean user;

    @Override
    public String execute() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        if (this.username.equals("")) {
            addActionError("Please Enter Username and Password.");
            error = true;
        } else if (this.password.equals("")) {
            addActionError("Please Enter Username and Password");
            error = true;
        } else {
            user = new UserBean();
            error = !user.checkLogin(this.username.toString(), this.password.toString());
            if (error) {
                addActionError("Sign In - Invalid Username or Password.");
            }
        }
        if (!error) {
            
            UserBean rs = user.getUser(this.username.toString());
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
            

            Map session = ActionContext.getContext().getSession();
            session.put("session-userid", UserID1);
            session.put("session-role", RoleID1);
            session.put("session-gender", Gender1);
            session.put("logined", "true");

            return "success";
        } else {
            return "error";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
}
