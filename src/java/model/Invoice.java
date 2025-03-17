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
public class Invoice {
    private String invoiceID;
    private String invoiceDate;
    private String salesID;
    private String carID;
    private String custID;

    public Invoice() {
    }

    public Invoice(String invoiceID, String invoiceDate, String salesID, String carID, String custID) {
        this.invoiceID = invoiceID;
        this.invoiceDate = invoiceDate;
        this.salesID = salesID;
        this.carID = carID;
        this.custID = custID;
    }

    public Invoice(String invoiceDate, String salesID, String carID, String custID) {
        this.invoiceDate = invoiceDate;
        this.salesID = salesID;
        this.carID = carID;
        this.custID = custID;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public String getSalesID() {
        return salesID;
    }

    public String getCarID() {
        return carID;
    }

    public String getCustID() {
        return custID;
    }

    
    
    
}
