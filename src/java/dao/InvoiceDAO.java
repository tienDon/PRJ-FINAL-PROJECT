/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DTO.InvoiceDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Invoice;
import mylib.DBUtils;

/**
 *
 * @author ASUS
 */
public class InvoiceDAO {

    public InvoiceDTO getInvoiceDetail(String invoiceID) {
        Connection cn = null;
        InvoiceDTO result = null;
        try {
            cn = DBUtils.getConnection();
            String sql = "SELECT si.*, sp.salesName, cu.custName\n"
                    + "FROM SalesInvoice si join SalesPerson sp \n"
                    + "on si.salesID = sp.salesID\n"
                    + "join Customer cu on cu.custID = si.custID\n"
                    + "where invoiceID = ?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, invoiceID);
            ResultSet table = st.executeQuery();
            if (table != null) {
                while (table.next()) {
                    String invoiceDate = table.getString("invoiceDate");
                    String salesID = table.getString("salesID");
                    String carID = table.getString("carID");
                    String custID = table.getString("custID");
                    String salesName = table.getString("salesName");
                    String custName = table.getString("custName");

                    result = new InvoiceDTO(new Invoice(invoiceDate, salesID, carID, custID), salesName, custName);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();;
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public Invoice getInvoiceById(String invoiceID) {
        Connection cn = null;
        Invoice result = new Invoice();
        try {
            cn = DBUtils.getConnection();
            String sql = "SELECT [invoiceID]\n"
                    + "      ,[invoiceDate]\n"
                    + "      ,[salesID]\n"
                    + "      ,[carID]\n"
                    + "      ,[custID]\n"
                    + "  FROM [Car_Dealership].[dbo].[SalesInvoice]"
                    + "  WHERE invoiceID = ?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, invoiceID);
            ResultSet table = st.executeQuery();
            if (table != null) {
                while (table.next()) {
                    String invoiceDate = table.getString("invoiceDate");
                    String salesID = table.getString("salesID");
                    String carID = table.getString("carID");
                    String custID = table.getString("custID");
                    result = new Invoice(invoiceDate, salesID, carID, custID);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();;
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public ArrayList<Invoice> getAllInvoices() {

        Connection cn = null;
        ArrayList<Invoice> list = new ArrayList<>();
        try {
            cn = DBUtils.getConnection();
            String sql = "SELECT [invoiceID]\n"
                    + "      ,[invoiceDate]\n"
                    + "      ,[salesID]\n"
                    + "      ,[carID]\n"
                    + "      ,[custID]\n"
                    + "  FROM [Car_Dealership].[dbo].[SalesInvoice]";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet table = st.executeQuery();
            if (table != null) {
                while (table.next()) {
                    String invoiceID = table.getString("invoiceID");
                    String invoiceDate = table.getString("invoiceDate");
                    String salesID = table.getString("salesID");
                    String carID = table.getString("carID");
                    String custID = table.getString("custID");
                    list.add(new Invoice(invoiceID, invoiceDate, salesID, carID, custID));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();;
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
