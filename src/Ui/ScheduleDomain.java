/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class ScheduleDomain implements Serializable{
 private String BusScheduleID;
 private Date BusScheduleDate;
 private String BusScheduleTimeDepart;
 private String BusScheduleArrive;
 private String BusScheduleOrigin;
 private String BusScheduleDestination;
 private String BusSchedulePrice;
 private String BusID;
 

    public void setBusScheduleID(String BusScheduleID) {
        this.BusScheduleID = BusScheduleID;
    }

    public void setBusScheduleDate(Date BusScheduleDate) {
        this.BusScheduleDate = BusScheduleDate;
    }

    public void setBusScheduleTimeDepart(String BusScheduleTimeDepart) {
        this.BusScheduleTimeDepart = BusScheduleTimeDepart;
    }

    public void setBusScheduleArrive(String BusScheduleArrive) {
        this.BusScheduleArrive = BusScheduleArrive;
    }

    public void setBusScheduleOrigin(String BusScheduleOrigin) {
        this.BusScheduleOrigin = BusScheduleOrigin;
    }

    public void setBusScheduleDestination(String BusScheduleDestination) {
        this.BusScheduleDestination = BusScheduleDestination;
    }
    public void setBusSchedulePrice(String BusSchedulePrice) {
        this.BusSchedulePrice = BusSchedulePrice;
    }
    public void setBusID(String BusID) {
        this.BusID = BusID;
    }

    public ScheduleDomain() {
    }

    public ScheduleDomain(String BusScheduleID, Date BusScheduleDate, String BusScheduleTimeDepart, String BusScheduleArrive, String BusScheduleOrigin, String BusScheduleDestination,String BusSchedulePrice, String BusID) {
        this.BusScheduleID = BusScheduleID;
        this.BusScheduleDate = BusScheduleDate;
        this.BusScheduleTimeDepart = BusScheduleTimeDepart;
        this.BusScheduleArrive = BusScheduleArrive;
        this.BusScheduleOrigin = BusScheduleOrigin;
        this.BusScheduleDestination = BusScheduleDestination;
        this.BusSchedulePrice= BusSchedulePrice;
        this.BusID = BusID;
    }

    public String getBusScheduleID() {
        return BusScheduleID;
    }

    public Date getBusScheduleDate() {
        return BusScheduleDate;
    }

    public String getBusScheduleTimeDepart() {
        return BusScheduleTimeDepart;
    }

    public String getBusScheduleArrive() {
        return BusScheduleArrive;
    }

    public String getBusScheduleOrigin() {
        return BusScheduleOrigin;
    }

    public String getBusScheduleDestination() {
        return BusScheduleDestination;
    }
    public String getBusSchedulePrice() {
        return BusSchedulePrice;
    }
    public String getBusID() {
        return BusID;
    }
         
    
}
