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
