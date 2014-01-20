/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author CHUNG TOOC
 */
public class BookingBean {

    private int BookID;
    private int UserID;
    private int RoomID;
    private int HotelID;
    private Date StartDate;
    private Date EndDate;
    private int RCountBook;
    private double RPrices;
    private double Total;
    private int StatusID;

    public BookingBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public BookingBean(int BookID, int UserID, int RoomID, int HotelID, Date StartDate, Date EndDate,
            int RCountBook, double RPrices, double Total, int StatusID) {
        this.BookID = BookID;
        this.UserID = UserID;
        this.RoomID = RoomID;
        this.HotelID = HotelID;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.RCountBook = RCountBook;
        this.RPrices = RPrices;
        this.Total = Total;
        this.StatusID = StatusID;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int BookID) {
        this.BookID = BookID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
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

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public int getRCountBook() {
        return RCountBook;
    }

    public void setRCountBook(int RCountBook) {
        this.RCountBook = RCountBook;
    }

    public double getRPrices() {
        return RPrices;
    }

    public void setRPrices(double RPrices) {
        this.RPrices = RPrices;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public int getStatusID() {
        return StatusID;
    }

    public void setStatusID(int StatusID) {
        this.StatusID = StatusID;
    }

}
