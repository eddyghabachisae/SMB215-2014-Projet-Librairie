/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supplierBranchItem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.DBconnection;


/**
 *
 * @author eddy
 */
public class SupplierBranchItemBean {
    
    public List<SupplierBranchItem> getSupplierBranchItems(long sbr) {
        List<SupplierBranchItem> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select spi_id, supplierBranch_id, item_id, itm_name, "
                    + "spi_price, spi_shippingdays, spi_price*lib_secondarycurrencyrate "
                    + "From supitem "
                    + "Inner Join item on item_id=itm_id "
                    + "Left Join library on 1=1 "
                    + "Where supplierBranch_id = " + sbr + " order by itm_name");
            while (rs.next()) {
                SupplierBranchItem spi = new SupplierBranchItem();
                spi.setId(rs.getInt(1));
                spi.setSupplierbranch(rs.getLong(2));
                spi.setItem(rs.getLong(3));
                spi.setItemname(rs.getString(4));
                spi.setPrice(rs.getFloat(5));
                spi.setShippingdays(rs.getInt(6));
                spi.setSecondaryprice(rs.getFloat(7));
                list.add(spi);
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
    
    public void deleteSupplierBranchItem(long id) {
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            stmt.execute("Delete From supitem Where spi_id = " + String.valueOf(id));
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
    
    public SupplierBranchItem getSupplierBranchItem(long id) {
        SupplierBranchItem spi = null;
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select spi_id, supplierBranch_id, item_id, itm_name, "
                    + "spi_price, spi_shippingdays "
                    + "From supitem "
                    + "Inner Join item on item_id=itm_id "
                    + "Where spi_id = " + id);
            while (rs.next()) {
                spi = new SupplierBranchItem();
                 spi.setId(rs.getInt(1));
                spi.setSupplierbranch(rs.getLong(2));
                spi.setItem(rs.getLong(3));
                spi.setItemname(rs.getString(4));
                spi.setPrice(rs.getFloat(5));
                spi.setShippingdays(rs.getInt(6));
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
        return spi;
    }
    
    
    public void modifySupplierBranchItem(SupplierBranchItem spi) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Update supitem Set spi_price=?, "
                    + "spi_shippingdays=? Where spi_id=?");
            pstmt.setFloat(1, spi.getPrice());
            pstmt.setInt(2, spi.getShippingdays());
            pstmt.setLong(3, spi.getId());
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
    
    public void addSupplierBranchItem(SupplierBranchItem spi) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Insert Into supitem "
                    + "(spi_price, spi_shippingdays, item_id, supplierbranch_id) "
                    + "Values(?,?,?,?)");

            pstmt.setFloat(1, spi.getPrice());
            pstmt.setInt(2, spi.getShippingdays());
            pstmt.setLong(3, spi.getItem());
            pstmt.setLong(4, spi.getSupplierbranch());
            
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

}
    

