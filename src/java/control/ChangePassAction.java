/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

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
public class ChangePassAction extends ActionSupport implements SessionAware {

    private String OldPassword;
    private String NewPassword;
    private Boolean error;
    private Map<String, Object> sessionMap;
    UserBean user;

    @Override
    public String execute() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        user = new UserBean();
        String user1 = (String) sessionMap.get("userName");
        if (!user.checkPass(user1, this.OldPassword.toString())) {
            addActionError("Invalid Current Password");
            error = true;
        } else if(user.changePass(user1, this.NewPassword.toString())){
            addActionError("Change password successful");
            error = false;
        }else {
            addActionError("System error has occurred please try again later.");
            error = true;
        }
            
        if (!error) {
            return "success";
        } else {
            return "error";
        }
    }

    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public String getOldPassword() {
        return OldPassword;
    }

    public void setOldPassword(String OldPassword) {
        this.OldPassword = OldPassword;
    }

    public String getNewPassword() {
        return NewPassword;
    }

    public void setNewPassword(String NewPassword) {
        this.NewPassword = NewPassword;
    }

}
