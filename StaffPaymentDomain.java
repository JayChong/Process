/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
/**
 *
 * @author alvin
 */
public class StaffPaymentDomain implements Serializable {
 private String paymentID;
 private String StaffID;
 private Date date;
 private String TimeDepart;
 private String Arrive;
 private String Origin;
 private String Destination;
 private double Price;
 private String BusID;

    public StaffPaymentDomain() {
    }

    public StaffPaymentDomain(String paymentID, String StaffID, Date date, String TimeDepart, String Arrive, String Origin, String Destination, double Price, String BusID) {
        this.paymentID = paymentID;
        this.StaffID = StaffID;
        this.date = date;
        this.TimeDepart = TimeDepart;
        this.Arrive = Arrive;
        this.Origin = Origin;
        this.Destination = Destination;
        this.Price = Price;
        this.BusID = BusID;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getStaffID() {
        return StaffID;
    }

    public void setStaffID(String StaffID) {
        this.StaffID = StaffID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTimeDepart() {
        return TimeDepart;
    }

    public void setTimeDepart(String TimeDepart) {
        this.TimeDepart = TimeDepart;
    }

    public String getArrive() {
        return Arrive;
    }

    public void setArrive(String Arrive) {
        this.Arrive = Arrive;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getBusID() {
        return BusID;
    }

    public void setBusID(String BusID) {
        this.BusID = BusID;
    }
    
}
