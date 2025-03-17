/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Customer;
import mylib.DBUtils;

/**
 *
 * @author user
 */
public class CustomerDAO {
    
    public boolean updateCus(String custID, String custName, String phone, String sex, String custAddress){
        Connection cn=null;
        try{
          cn=DBUtils.getConnection();
          if(cn!=null){
              String sql = "UPDATE dbo.Customer " +
                         "SET custName = ?, phone = ?, sex = ?, cusAddress = ? " +
                         "WHERE custID = ?";
            
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, custName);
            st.setString(2, phone);
            st.setString(3, sex);
            st.setString(4, custAddress);
            st.setString(5, custID);

            int rowsAffected = st.executeUpdate(); // Thực thi UPDATE
            return rowsAffected > 0; // Kiểm tra xem có dòng nào bị ảnh hưởng không
          }
        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(cn!=null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    public Customer checkLogin(String name, String phone){
        Customer rs=null;
        Connection cn=null;
        try{
          cn=DBUtils.getConnection();
          if(cn!=null){
              String sql = "select custID,custName,phone,sex,cusAddress\n"
                      + "from dbo.Customer\n"
                      + "where custName = ? and phone=?";
              PreparedStatement st=cn.prepareStatement(sql);
              st.setString(1, name);
              st.setString(2, phone);
              ResultSet table=st.executeQuery();
                if(table!=null){
                  while(table.next()){
                      int custid=table.getInt("custID");
                      String custname=table.getString("custName");
                      //String phone=""+table.getString("phone");
                      String sex=table.getString("sex");
                      String custadd=table.getString("cusAddress");
                      rs=new Customer(custid, custname, phone, sex, custadd);
                      
                  }
              }
          }
        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(cn!=null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
}
