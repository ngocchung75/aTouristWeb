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
public class MyProfileAction extends ActionSupport implements SessionAware {

    private String FullName;
    private String Gender;
    private String YearOfBirth;
    private String Email;
    private String Mobile;
    private String Address;
    private Boolean error;
    private Map<String, Object> sessionMap;
    UserBean user;

    @Override
    public String execute() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        user = new UserBean();
        String Gender1 = "";
        String user1 = (String) sessionMap.get("userName");
        String FullName1 = this.FullName.toString();
        String temp = this.Gender.toString();
        if("1".equals(temp))
            Gender1 = "Male";
        else Gender1 = "Female";
        
        String YearOfBirth1 = this.YearOfBirth.toString();
        String Email1 = this.Email.toString();
        String Mobile1 = this.Mobile.toString();
        String Address1 = this.Address.toString();

        if (user.updateProfile(user1, FullName1, Gender1, YearOfBirth1, Email1, Mobile1, Address1)) {
            addActionError("Update Profile successful");
            error = false;
        } else {
            addActionError("System error has occurred please try again later.");
            error = true;
        }
        if (!error) {
            UserBean rs = user.getUser(user1);
            int UserID2 = rs.getUserID();
            int RoleID2 = rs.getRoleID();
            String FullName2 = rs.getFullName();
            String Gender2 = rs.getGender();
            String YearOfBirth2 = rs.getYearOfBirth();
            String Email2 = rs.getEmail();
            String Phone2 = rs.getPhone();
            String UserAddress2 = rs.getUserAddress();

            sessionMap.put("UserID", UserID2);
            sessionMap.put("RoleID", RoleID2);
            sessionMap.put("userName", user1);
            sessionMap.put("FullName", FullName2);
            sessionMap.put("Gender", Gender2);
            sessionMap.put("YearOfBirth", YearOfBirth2);
            sessionMap.put("Email", Email2);
            sessionMap.put("Phone", Phone2);
            sessionMap.put("UserAddress", UserAddress2);

            Map session = ActionContext.getContext().getSession();
            session.put("session-role", RoleID2);
            session.put("session-gender", Gender2);
            session.put("logined", "true");

            return "success";
        } else {
            return "error";
        }
    }

    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
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

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

}
