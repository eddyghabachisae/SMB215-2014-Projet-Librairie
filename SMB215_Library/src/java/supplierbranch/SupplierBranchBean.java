package supplierbranch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.DBconnection;


public class SupplierBranchBean {
    
    public List<SupplierBranch> getSupplierBranches(int sup) {
        List<SupplierBranch> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select sbr_id, sbr_name, supplier_id, "
                    + "sbr_contactname, sbr_phone, sbr_isactive "
                    + "From supplierbranch Where supplier_id= " +sup+ " order by sbr_name");
            while (rs.next()) {
                SupplierBranch sbr = new SupplierBranch();
                sbr.setId(rs.getInt(1));
                sbr.setName(rs.getString(2));
                sbr.setSupplier(rs.getInt(3));
                sbr.setContactname(rs.getString(4));
                sbr.setPhone(rs.getString(5));
                sbr.setIsactive(rs.getBoolean(6));
                list.add(sbr);
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
    
    public void deleteSupplierBranch(int id) {
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            stmt.execute("Delete From supplierbranch Where sbr_id = " + String.valueOf(id));
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

    public void addSupplierBranch(SupplierBranch sbr) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Insert Into supplierbranch "
                    + "(sbr_name, sbr_contactname, sbr_address, sbr_phone, sbr_fax, sbr_mobile, "
                    + "sbr_email, sbr_remarks, sbr_isactive, sbr_deactivationreason, "
                    + "city_id, supplier_id) "
                    + "Values(?,?,?,?,?,?,?,?,?,?,?,?)");

            pstmt.setString(1, sbr.getName());
            pstmt.setString(2, sbr.getContactname());
            pstmt.setString(3, sbr.getAddress());
            pstmt.setString(4, sbr.getPhone());
            pstmt.setString(5, sbr.getFax());
            pstmt.setString(6, sbr.getMobile());
            pstmt.setString(7, sbr.getEmail());
            pstmt.setString(8, sbr.getRemarks());
            pstmt.setBoolean(9, sbr.getIsactive());
            pstmt.setString(10, sbr.getDeactivationreason());
            pstmt.setInt(11, sbr.getCity());
            pstmt.setInt(12, sbr.getSupplier());

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
