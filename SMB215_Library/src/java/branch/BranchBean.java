package branch;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.DBconnection;

public class BranchBean {
    
    public List<Branch> getBranchesSummary() {
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
                    + "From tbl_branch order by brh_name");
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

    
}
