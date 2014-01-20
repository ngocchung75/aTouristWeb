/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
