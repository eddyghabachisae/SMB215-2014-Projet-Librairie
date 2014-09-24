/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package purchaseOrderDetail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.DBconnection;
import puchaseOrderHeader.POHeader;

/**
 *
 * @author eddy
 */
public class PODetailBean {
    
    public List<PODetail> getPODetails(Long poh) {
        List<PODetail> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select pod_id,"
                    + "item_id, itm_name, pod_quantity, pod_unitcost, pod_quantity*pod_unitcost pod_total "
                    + "From purchasedetails "
                    + "Inner Join item on item_id=itm_id "
                    + "Where purchaseheader_id = " + poh
                    + " order by pod_id");
            while (rs.next()) {
                PODetail pod = new PODetail();
                pod.setId(rs.getLong(1));
                pod.setItem(rs.getLong(2));
                pod.setItemname(rs.getString(3));
                pod.setQuantity(rs.getInt(4));
                pod.setUnitcost(rs.getFloat(5));
                pod.setTotal(rs.getFloat(6));
                list.add(pod);
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
    
    public void addPODetail (PODetail pod){
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
                   con.setAutoCommit(false);
            pstmt = con.prepareStatement("Insert Into purchasedetails "
                    + "(pod_quantity, pod_unitcost, purchaseheader_id, item_id) "
                    + "Values(?,?,?,?)");
            
            pstmt.setInt(1, pod.getQuantity());
            pstmt.setFloat(2, pod.getUnitcost());
            pstmt.setLong(3, pod.getPohid());
            pstmt.setLong(4, pod.getItem());
            
            pstmt.execute();
            
            pstmt = con.prepareStatement("Insert Into warehouse "
                    + "(item_id, branch_id) "
                    + "Values(?,?)");
            
            pstmt.setInt(1, pod.getQuantity());
            pstmt.setLong(2, pod.getItem());            
            
            pstmt.execute();
             con.commit();
           
        } catch (SQLException | ClassNotFoundException ex) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex2) {
                    System.err.println("Caught Exception: " + ex2.getMessage());
                }
            }
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
    
    public PODetail getPODetail(long id) {
        PODetail pod = null;
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From purchasedetails Where pod_id=" + id);
            if (rs.next()) {
                pod = new PODetail();
                pod.setId(rs.getLong(1));
                pod.setQuantity(rs.getInt(2));
                pod.setUnitcost(rs.getFloat(3));
                pod.setPohid(rs.getLong(4));
                pod.setItem(rs.getLong(5));
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
        return pod;
    }
    
    public void modifyPODetail(PODetail pod) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Update purchasedetails Set pod_quantity=?, "
                    + "pod_unitcost=?, item_id=? Where pod_id=?");
            pstmt.setInt(1, pod.getQuantity());
            pstmt.setFloat(2, pod.getUnitcost());
            pstmt.setLong(3, pod.getItem());
            pstmt.setLong(4, pod.getId());
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
    
     public void deletePODetail(long id) {
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            stmt.execute("Delete From purchasedetails Where pod_id = " + String.valueOf(id));
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

     public void updatePOHeaderTotal(Long poh) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Update purchaseheader Inner Join " 
                + "(Select purchaseheader_id, sum(pod_quantity*pod_unitcost) as total " 
                + "From purchasedetails " 
                + "Where purchaseheader_id = " + poh  
                + " Group by purchaseheader_id) as tt " 
                + "On purchaseheader.poh_id = tt.purchaseheader_id "
                + "Set purchaseheader.poh_total = tt.total ");
            
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
