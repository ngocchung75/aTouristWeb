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
import java.text.ParseException;
import java.util.Map;
import model.UserBean;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author CHUNG TOOC
 */
public class SupplierProfileAction extends ActionSupport implements SessionAware {

    private String UserNameUpdate;
    private String FullNameUpdate;
    private String GenderUpdate;
    private String YearOfBirthUpdate;
    private String EmailUpdate;
    private String PhoneUpdate;
    private String AddressUpdate;
    private Map<String, Object> sessionMap;
    UserBean userBean;

    public String GetSupplierProfileView() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        String checklogin = (String) session.get("logined");
        if (!"true".equals(checklogin)) {
            return "error";
        } else {
            session.remove("user_supplier");
            UserBean userList1 = new UserBean();
            String user1 = "admin";
            if (!sessionMap.isEmpty()) {
                user1 = (String) sessionMap.get("userName");
            }
            userBean = new UserBean();
            userList1 = userBean.getUser(user1);

            session.put("user_supplier", userList1);
            return "success";
        }
    }

    public String SaveSupplierProfile() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        userBean = new UserBean();
        userBean.updateProfile(this.UserNameUpdate, this.FullNameUpdate, this.GenderUpdate, this.YearOfBirthUpdate, this.EmailUpdate, this.PhoneUpdate, this.AddressUpdate);

        return "success";
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public String getUserNameUpdate() {
        return UserNameUpdate;
    }

    public void setUserNameUpdate(String UserNameUpdate) {
        this.UserNameUpdate = UserNameUpdate;
    }

    public String getFullNameUpdate() {
        return FullNameUpdate;
    }

    public void setFullNameUpdate(String FullNameUpdate) {
        this.FullNameUpdate = FullNameUpdate;
    }

    public String getGenderUpdate() {
        return GenderUpdate;
    }

    public void setGenderUpdate(String GenderUpdate) {
        this.GenderUpdate = GenderUpdate;
    }

    public String getYearOfBirthUpdate() {
        return YearOfBirthUpdate;
    }

    public void setYearOfBirthUpdate(String YearOfBirthUpdate) {
        this.YearOfBirthUpdate = YearOfBirthUpdate;
    }

    public String getEmailUpdate() {
        return EmailUpdate;
    }

    public void setEmailUpdate(String EmailUpdate) {
        this.EmailUpdate = EmailUpdate;
    }

    public String getPhoneUpdate() {
        return PhoneUpdate;
    }

    public void setPhoneUpdate(String PhoneUpdate) {
        this.PhoneUpdate = PhoneUpdate;
    }

    public String getAddressUpdate() {
        return AddressUpdate;
    }

    public void setAddressUpdate(String AddressUpdate) {
        this.AddressUpdate = AddressUpdate;
    }

}
