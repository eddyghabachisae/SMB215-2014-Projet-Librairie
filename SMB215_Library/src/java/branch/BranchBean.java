package branch;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.DBconnection;

public class BranchBean {
    
    public List<Branch> getBranchesList() {
        List<Branch> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
        DBconnection dbCon = new DBconnection();
        
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select brh_id, brh_name "
                    + "From branch order by brh_name");
            while (rs.next()) {
                Branch brh = new Branch();
                brh.setId(rs.getInt(1));
                brh.setName(rs.getString(2));
                list.add(brh);
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
    
     public Branch getBranch(long id) {
        Branch branch = null;
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From branch Where brh_id=" + id);
            branch = new Branch();
            if (rs.next()) {
                branch = new Branch();
                branch.setId(rs.getLong(1));
                branch.setName(rs.getString(2));
                branch.setAddress(rs.getString(3));
                branch.setEmail(rs.getString(4));
                branch.setPhone(rs.getString(5));
                branch.setFax(rs.getString(6));
                branch.setMobile(rs.getString(7));
                branch.setIsActive(rs.getBoolean(8));
                branch.setActiveSince(rs.getDate(9));
                branch.setDeactivatedSince(rs.getDate(10));
                branch.setCity(rs.getInt(11));
                
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
        return branch;
    }

    
}
