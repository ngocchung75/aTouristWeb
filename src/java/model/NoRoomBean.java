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
public class NoRoomBean {

    private String NoRoomID;
    private String NoRoomCount;

    public NoRoomBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public NoRoomBean(String NoRoomID, String NoRoomCount) {
        this.NoRoomID = NoRoomID;
        this.NoRoomCount = NoRoomCount;
    }

    public String getNoRoomID() {
        return NoRoomID;
    }

    public void setNoRoomID(String NoRoomID) {
        this.NoRoomID = NoRoomID;
    }

    public String getNoRoomCount() {
        return NoRoomCount;
    }

    public void setNoRoomCount(String NoRoomCount) {
        this.NoRoomCount = NoRoomCount;
    }
}
