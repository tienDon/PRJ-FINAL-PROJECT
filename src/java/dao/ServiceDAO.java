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
import model.Service;
import model.ServiceTicket;
import mylib.DBUtils;

/**
 *
 * @author ASUS
 */
public class ServiceDAO {

    public boolean deleteService(String serviceID) {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            String sql = "DELETE FROM [dbo].[Service]\n"
                    + "      WHERE serviceID = ?";
            
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, serviceID);
            return st.executeUpdate()>0;
            
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

    public boolean updateService(String serviceID, String serviceName, String hourlyRate) {
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            String sql = "UPDATE [dbo].[Service]\n"
                    + "SET \n"
                    + "    serviceName = ?,\n"
                    + "    hourlyRate = ?\n"
                    + "WHERE \n"
                    + "    serviceID = ?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, serviceName);
            st.setString(2, hourlyRate);
            st.setString(3, serviceID);

            return st.executeUpdate() > 0;

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

    public boolean addNewService(String serviceName, String hourlyRate) {

        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO Service (serviceID, serviceName, hourlyRate)\n"
                        + "VALUES ((SELECT ISNULL(MAX(serviceID), 0) + 1 FROM Service), ?, ?);";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, serviceName);
                st.setString(2, hourlyRate);
                return st.executeUpdate() > 0;
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

    public ArrayList<Service> getServiceByType(String key, String type) {
        ArrayList<Service> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String columnName = "";
                switch (type) {
                    case "serviceID":
                        columnName = "serviceID";
                        break;
                    case "serviceName":
                        columnName = "serviceName";
                        break;
                    case "hourlyRate":
                        columnName = "hourlyRate";
                        break;
                }
                String sql = "SELECT [serviceID]\n"
                        + "      ,[serviceName]\n"
                        + "      ,[hourlyRate]\n"
                        + "  FROM [Car_Dealership].[dbo].[Service]"
                        + "where " + columnName + "=?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, key);

                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String serviceID = table.getString("serviceID");
                        String serviceName = table.getString("serviceName");
                        String hourlyRate = table.getString("hourlyRate");
                        list.add(new Service(serviceID, serviceName, hourlyRate));
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

    public ArrayList<Service> getAllServices() {
        ArrayList<Service> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [serviceID]\n"
                        + "      ,[serviceName]\n"
                        + "      ,[hourlyRate]\n"
                        + "  FROM [Car_Dealership].[dbo].[Service]";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String serviceID = table.getString("serviceID");
                        String serviceName = table.getString("serviceName");
                        String hourlyRate = table.getString("hourlyRate");
                        Service i = new Service(serviceID, serviceName, hourlyRate);
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
}
