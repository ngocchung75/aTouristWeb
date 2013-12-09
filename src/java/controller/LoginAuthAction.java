/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author CHUNG TOOC
 */
public class LoginAuthAction {

    private String username;
    private String password;

    public String execute() {

        if (this.username.equals("admin")
                && this.password.equals("admin123")) {
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
