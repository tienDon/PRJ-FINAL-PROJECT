/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class ServiceMechanic {

    private String serviceTicketID;
    private String serviceID;
    private String mechanicID;
    private String hours;
    private String comment;
    private double rate;

    public ServiceMechanic() {
    }

    public ServiceMechanic(String serviceTicketID, String serviceID, String mechanicID, String hours, String comment, double rate) {
        this.serviceTicketID = serviceTicketID;
        this.serviceID = serviceID;
        this.mechanicID = mechanicID;
        this.hours = hours;
        this.comment = comment;
        this.rate = rate;
    }

    public String getServiceTicketID() {
        return serviceTicketID;
    }

    public String getServiceID() {
        return serviceID;
    }

    public String getMechanicID() {
        return mechanicID;
    }

    public String getHours() {
        return hours==null?"":hours;
    }

    public String getComment() {
        return (comment != null) ? comment : "";
    }

    public double getRate() {
        return rate;
    }

}
