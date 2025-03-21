/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ServiceTicket;
import mylib.DBUtils;

/**
 *
 * @author ASUS
 */
public class ServiceTicketDAO {

    
    public ArrayList<ServiceTicket> getALLServiceTicket() {
        ArrayList<ServiceTicket> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [serviceTicketID]\n"
                        + "      ,[dateReceived]\n"
                        + "      ,[dateReturned]\n"
                        + "      ,[custID]\n"
                        + "      ,[carID]\n"
                        + "  FROM [Car_Dealership].[dbo].[ServiceTicket]";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String serviceTicketID = table.getString("serviceTicketID");
                        String dateReceived = table.getString("dateReceived");
                        String dateReturned = table.getString("dateReturned");
                        String custID = table.getString("custID");
                        String carID = table.getString("carID");
                        ServiceTicket i = new ServiceTicket(serviceTicketID, dateReceived, dateReturned, custID, carID);
                        list.add(i);
                    }
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

    public ArrayList<ServiceTicket> getServiceTicketByID(String id, String type) {
        ArrayList<ServiceTicket> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [serviceTicketID]\n"
                        + "      ,[dateReceived]\n"
                        + "      ,[dateReturned]\n"
                        + "      ,[custID]\n"
                        + "      ,[carID]\n"
                        + "  FROM [Car_Dealership].[dbo].[ServiceTicket]";

                if (type.equals("custID")) {
                    sql = sql + "WHERE custID =?";
                } else if (type.equals("carID")) {
                    sql = sql + "WHERE carID =?";
                } else if (type.equals("dateReceived")) {
                    sql = sql + "WHERE dateReceived =?";
                } else if (type.equals("serviceTicketID")) {
                    sql = sql + "WHERE serviceTicketID =?";
                }

                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, id);

                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String serviceTicketID = table.getString("serviceTicketID");
                        String dateReceived = table.getString("dateReceived");
                        String dateReturned = table.getString("dateReturned");
                        String custID = table.getString("custID");
                        String carID = table.getString("carID");
                        list.add(new ServiceTicket(serviceTicketID, dateReceived, dateReturned, custID, carID));
                    }
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
