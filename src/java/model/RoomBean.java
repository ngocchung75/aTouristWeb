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
public class RoomBean {

    private int RoomID;
    private int HotelID;
    private String RTypeName;
    private int RNumPeople;
    private int RCount;
    private String RoomDes;
    private String RImage;
    private double RoomPrice;

    public RoomBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public RoomBean(int RoomID, int HotelID, String RTypeName, int RNumPeople,
            int RCount, String RoomDes, String RImage, double RoomPrice) {
        this.RoomID = RoomID;
        this.HotelID = HotelID;
        this.RTypeName = RTypeName;
        this.RNumPeople = RNumPeople;
        this.RCount = RCount;
        this.RoomDes = RoomDes;
        this.RImage = RImage;
        this.RoomPrice = RoomPrice;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int RoomID) {
        this.RoomID = RoomID;
    }

    public int getHotelID() {
        return HotelID;
    }

    public void setHotelID(int HotelID) {
        this.HotelID = HotelID;
    }

    public String getRTypeName() {
        return RTypeName;
    }

    public void setRTypeName(String RTypeName) {
        this.RTypeName = RTypeName;
    }

    public int getRNumPeople() {
        return RNumPeople;
    }

    public void setRNumPeople(int RNumPeople) {
        this.RNumPeople = RNumPeople;
    }

    public int getRCount() {
        return RCount;
    }

    public void setRCount(int RCount) {
        this.RCount = RCount;
    }

    public String getRoomDes() {
        return RoomDes;
    }

    public void setRoomDes(String RoomDes) {
        this.RoomDes = RoomDes;
    }

    public double getRoomPrice() {
        return RoomPrice;
    }

    public void setRoomPrice(double RoomPrice) {
        this.RoomPrice = RoomPrice;
    }

    public String getRImage() {
        return RImage;
    }

    public void setRImage(String RImage) {
        this.RImage = RImage;
    }

}
