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
import model.ServiceMechanic;
import mylib.DBUtils;

/**
 *
 * @author ASUS
 */
public class ServiceMechanicDAO {

    public boolean updateServiceTicket(String serviceTicketID, String serviceID,
            String hours, String comment, String rate) {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[ServiceMehanic] "
                        + "SET hours = ?, comment = ?, rate = ? "
                        + "WHERE serviceTicketID = ? AND serviceID=?";

                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, hours);
                st.setString(2, comment);
                st.setString(3, rate);
                st.setString(4, serviceTicketID);
                st.setString(5, serviceID);

                int rowsUpdated = st.executeUpdate();
                return rowsUpdated > 0;
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

        return false;
    }

    public ServiceMechanic getServiceMechanicByServiceTicketId(String serviceTicketId, String serviceId) {
        ServiceMechanic mecha = new ServiceMechanic();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [serviceTicketID], [serviceID], [mechanicID], [hours], [comment], [rate] "
                        + "FROM [Car_Dealership].[dbo].[ServiceMehanic] WHERE serviceTicketID = ? and serviceID =?";

                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, serviceTicketId);
                st.setString(2, serviceId);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String serviceTicketID = table.getString("serviceTicketID");
                        String serviceID = table.getString("serviceID");
                        String mechanicID = table.getString("mechanicID");
                        String hours = table.getString("hours");
                        String comment = table.getString("comment");
                        double rate = table.getDouble("rate");
                        mecha = new ServiceMechanic(serviceTicketID, serviceID, mechanicID, hours, comment, rate);
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

        return mecha;
    }

    public ArrayList<ServiceMechanic> getServiceMechanicByServiceTicketId(String id) {
        ArrayList<ServiceMechanic> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [serviceTicketID], [serviceID], [mechanicID], [hours], [comment], [rate] "
                        + "FROM [Car_Dealership].[dbo].[ServiceMehanic] WHERE serviceTicketID = ?";

                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, id);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String serviceTicketID = table.getString("serviceTicketID");
                        String serviceID = table.getString("serviceID");
                        String mechanicID = table.getString("mechanicID");
                        String hours = table.getString("hours");
                        String comment = table.getString("comment");
                        double rate = table.getDouble("rate");
                        ServiceMechanic mecha = new ServiceMechanic(serviceTicketID, serviceID, mechanicID, hours, comment, rate);
                        list.add(mecha);
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

    public ArrayList<ServiceMechanic> getAllServiceMechanic() {
        ArrayList<ServiceMechanic> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT  [serviceTicketID]\n"
                        + "      ,[serviceID]\n"
                        + "      ,[mechanicID]\n"
                        + "      ,[hours]\n"
                        + "      ,[comment]\n"
                        + "      ,[rate]\n"
                        + "  FROM [Car_Dealership].[dbo].[ServiceMehanic]";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String serviceTicketID = table.getString("serviceTicketID");
                        String serviceID = table.getString("serviceID");
                        String mechanicID = table.getString("mechanicID");
                        String hours = table.getString("hours");
                        String comment = table.getString("comment");
                        Double rate = table.getDouble("rate");
                        ServiceMechanic mecha = new ServiceMechanic(serviceTicketID, serviceID, mechanicID, hours, comment, rate);
                        list.add(mecha);
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
