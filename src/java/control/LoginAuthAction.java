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
import model.UserBean;

/**
 *
 * @author CHUNG TOOC
 */
public class LoginAuthAction extends ActionSupport {

    private String username;
    private String password;
    private Boolean error;
    UserBean user;

    @Override
    public String execute() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        if (this.username.equals("")) {
            addActionError("Please Enter user id.");
            error = true;
        } else if (this.password.equals("")) {
            addActionError("Please Enter password.");
            error = true;
        }
        /*
        if (this.username.equals("admin")
                && this.password.equals("admin123")) {
            error = false;
        } else {
            addActionError("Invalid userid or password.");
            error = true;
        }*/
        user = new UserBean();
        error = !user.checkLogin(this.username.toString(),this.password.toString());
        
        if (!error) {
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
}
