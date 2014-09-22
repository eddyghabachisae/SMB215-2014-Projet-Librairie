/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puchaseOrderHeader;

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
public class POHeaderBean {

    public List<POHeader> getPOHeaders() {
        List<POHeader> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select poh_id,"
                    + "CASE WHEN poh_orderdate!='0000-00-00' THEN poh_orderdate END poh_orderdate,"
                    + "CASE WHEN poh_shippingdate!='0000-00-00' THEN poh_shippingdate END poh_shippingdate,"
                    + "CASE WHEN poh_deliverydate!='0000-00-00' THEN poh_deliverydate END poh_deliverydate,"
                    + "sup_name, brh_name, CONCAT(emp_firstname,' ',emp_lastname) emp_name, poh_total "
                    + "From purchaseheader "
                    + "Inner Join supplierbranch on sbr_id=supplierBranch_id "
                    + "Inner Join supplier on supplier_id=sup_id "
                    + "Inner Join branch on branch_id=brh_id "
                    + "Inner Join employee on employee_id=emp_id "
                    + "order by poh_id");
            while (rs.next()) {
                POHeader poh = new POHeader();
                poh.setId(rs.getInt(1));
                poh.setOrderdate(rs.getDate(2));
                poh.setDeliverydate(rs.getDate(4));
                poh.setStatus(rs.getDate(3), rs.getDate(4));
                poh.setSuppliername(rs.getString(5));
                poh.setBranchname(rs.getString(6));
                poh.setEmployeename(rs.getString(7));
                poh.setTotal(rs.getFloat(8));

                list.add(poh);
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

    public POHeader getPOHeader(long id) {
        POHeader poh = null;
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select poh_id,"
                    + "CASE WHEN poh_orderdate!='0000-00-00' THEN poh_orderdate END poh_orderdate,"
                    + "CASE WHEN poh_shippingdate!='0000-00-00' THEN poh_shippingdate END poh_shippingdate,"
                    + "CASE WHEN poh_deliverydate!='0000-00-00' THEN poh_deliverydate END poh_deliverydate,"
                    + "sup_name, brh_name, CONCAT(emp_firstname,' ',emp_lastname) emp_name, poh_total, "
                    + "sup_id, brh_id, sbr_id "
                    + "From purchaseheader "
                    + "Inner Join supplierbranch on sbr_id=supplierBranch_id "
                    + "Inner Join supplier on supplier_id=sup_id "
                    + "Inner Join branch on branch_id=brh_id "
                    + "Inner Join employee on employee_id=emp_id "
                    + "Where poh_id=" + id);
            while (rs.next()) {
                poh = new POHeader();
                poh.setId(rs.getInt(1));
                poh.setOrderdate(rs.getDate(2));
                poh.setShippingdate(rs.getDate(3));
                poh.setDeliverydate(rs.getDate(4));
                poh.setStatus(rs.getDate(3), rs.getDate(4));
                poh.setSuppliername(rs.getString(5));
                poh.setBranchname(rs.getString(6));
                poh.setEmployeename(rs.getString(7));
                poh.setTotal(rs.getFloat(8));
                poh.setSupplier(rs.getLong(9));
                poh.setBranch(rs.getLong(10));
                poh.setSupplierbranch(rs.getLong(11));
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
        return poh;
    }

    public long addPOHeader(POHeader poh) {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        long pohid = 0;

        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Insert Into purchaseheader "
                    + "(poh_orderdate, poh_shippingdate, poh_deliverydate, "
                    + "branch_id, employee_id, supplierBranch_id) "
                    + "Values(?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            pstmt.setDate(1, poh.getOrderdate());
            pstmt.setDate(2, poh.getShippingdate());
            pstmt.setDate(3, poh.getDeliverydate());

            pstmt.setLong(4, poh.getBranch());
            pstmt.setLong(5, poh.getEmployee());
            pstmt.setLong(6, poh.getSupplierbranch());

            pstmt.execute();

            rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                pohid = rs.getLong(1);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Caught Exception: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println("Caught Exception: " + ex.getMessage());
            }
            return pohid;
        }
    }

    public void deletePOHeader(long id) {
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            con.setAutoCommit(false);
            stmt = con.createStatement();
            stmt.execute("Delete From purchasedetails Where purchaseheader_id = " + String.valueOf(id));
            stmt.execute("Delete From purchaseheader Where poh_id = " + String.valueOf(id));
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

}
