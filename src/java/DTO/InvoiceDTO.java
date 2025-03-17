/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import model.Invoice;

/**
 *
 * @author ASUS
 */
public class InvoiceDTO {
    private Invoice invoice;  // Chứa thông tin hóa đơn gốc
    private String salesName; // Chứa tên nhân viên
    private String custName;  // Chứa tên khách hàng

    public InvoiceDTO() {
    }

    public InvoiceDTO(Invoice invoice, String salesName, String custName) {
        this.invoice = invoice;
        this.salesName = salesName;
        this.custName = custName;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public String getSalesName() {
        return salesName;
    }

    public String getCustName() {
        return custName;
    }
}

