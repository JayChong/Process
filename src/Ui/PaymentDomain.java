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
public class PaymentDomain implements Serializable{
 private String paymentID;
 private Date date;
 private String TimeDepart;
 private String Arrive;
 private String Origin;
 private String Destination;
 private double Price;
 private String BusID;

    public PaymentDomain() {
    }

    public PaymentDomain(String paymentID, Date date, String TimeDepart, String Arrive, String Origin, String Destination, double Price, String BusID) {
        this.paymentID = paymentID;
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

    public Date getDate() {
        return date;
    }

    public String getTimeDepart() {
        return TimeDepart;
    }

    public String getArrive() {
        return Arrive;
    }

    public String getOrigin() {
        return Origin;
    }

    public String getDestination() {
        return Destination;
    }

    public double getPrice() {
        return Price;
    }

    public String getBusID() {
        return BusID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTimeDepart(String TimeDepart) {
        this.TimeDepart = TimeDepart;
    }

    public void setArrive(String Arrive) {
        this.Arrive = Arrive;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public void setBusID(String BusID) {
        this.BusID = BusID;
    }
 
}
