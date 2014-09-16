/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.DBconnection;
import supplier.Supplier;

/**
 *
 * @author Dell
 */
public class CustomerBean {
    
    public List<Customer> getCustomer() {
        List<Customer> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From customer order by cst_firstname");
            while (rs.next()) {
                Customer cust = new Customer();
                cust.setId(rs.getInt(1));
                cust.setFirstname(rs.getString(4));
                cust.setLastname(rs.getString(5));
                cust.setGender(rs.getInt(6));
                cust.setCity(rs.getString(10));
                cust.setMobile(rs.getString(12));
                cust.setEmail(rs.getString(13));
                list.add(cust);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Caught Exception: " + ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println("Caught Exception: " + ex.getMessage());
            }
        }
        return list;
    }
    
    public void deleteCustomer(int id) {
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            stmt.execute("Delete From customer Where cst_id = " + String.valueOf(id));
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Caught Exception: " + ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println("Caught Exception: " + ex.getMessage());
            }
        }
    }
    
    public void addCustomer(Customer cust) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Insert Into customer "
                    + "(cst_username, cst_password, cst_firstname, cst_lastname, cst_gender_id, cst_maritalstatus, cst_dateofbirth, cst_address, cst_city, cst_phone, cst_mobile, cst_email, cst_remarks, cst_isactive) "
                    + "Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            pstmt.setString(1, cust.getUsername());
            pstmt.setString(2, cust.getPassword());
            pstmt.setString(3, cust.getFirstname());
            pstmt.setString(4, cust.getLastname());
            pstmt.setInt(5, cust.getGender());
            pstmt.setInt(6, cust.getMaritalstatus());
            pstmt.setDate(7, (Date) cust.getDateofbirth());
            pstmt.setString(8, cust.getAddress());
            pstmt.setString(9, cust.getCity());
            pstmt.setString(10, cust.getPhone());
            pstmt.setString(11, cust.getMobile());
            pstmt.setString(12, cust.getEmail());
            pstmt.setString(13, cust.getRemarks());
            pstmt.setBoolean(14, cust.getIsactive());

            pstmt.execute();

        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Caught Exception: " + ex.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println("Caught Exception: " + ex.getMessage());
            }
        }
    }
    
    public Customer getCustomer(int id) {
        Customer cust = null;
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From customer Where cst_id=" + id);
            if (rs.next()) {
                cust = new Customer();
                cust.setId(rs.getInt(1));
                cust.setUsername(rs.getString(2));
                cust.setPassword(rs.getString(3));
                cust.setFirstname(rs.getString(4));
                cust.setLastname(rs.getString(5));
                cust.setGender(rs.getInt(6));
                cust.setMaritalstatus(rs.getInt(7));
                cust.setDateofbirth(rs.getDate(8));
                cust.setAddress(rs.getString(9));
                cust.setCity(rs.getString(10));
                cust.setPhone(rs.getString(11));
                cust.setMobile(rs.getString(12));
                cust.setEmail(rs.getString(13));
                cust.setRemarks(rs.getString(14));
                cust.setIsactive(rs.getBoolean(15));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Caught Exception: " + ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println("Caught Exception: " + ex.getMessage());
            }
        }
        return cust;
    }
    
    public void modifyCustomer(Customer cust) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Update customer Set cst_username=?, "
                    +"cst_password=?, cst_firstname=?, cst_lastname=?, cst_gender_id=?, "
                    +"cst_maritalstatus=?, cst_dateofbirth=?, cst_address=?, cst_city=?, "
                    +"cst_phone=?, cst_mobile=?, cst_email=?, cst_remarks=?, cst_isactive=?"
                    + " Where cst_id=?");
            pstmt.setString(1, cust.getUsername());
            pstmt.setString(2, cust.getPassword());
            pstmt.setString(3, cust.getFirstname());
            pstmt.setString(4, cust.getLastname());
            pstmt.setInt(5, cust.getGender());
            pstmt.setInt(6, cust.getMaritalstatus());
            pstmt.setDate(7, (Date) cust.getDateofbirth());
            pstmt.setString(8, cust.getAddress());
            pstmt.setString(9, cust.getCity());
            pstmt.setString(10, cust.getPhone());
            pstmt.setString(11, cust.getMobile());
            pstmt.setString(12, cust.getEmail());
            pstmt.setString(13, cust.getRemarks());
            pstmt.setString(14, (cust.getIsactive()==true)?"1":"0");
            pstmt.setInt(15, cust.getId());
            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Caught Exception: " + ex.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println("Caught Exception: " + ex.getMessage());
            }
        }
    }
    
}
