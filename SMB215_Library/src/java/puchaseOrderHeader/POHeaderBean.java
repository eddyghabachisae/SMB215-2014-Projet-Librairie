/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puchaseOrderHeader;

import java.sql.Connection;
import java.sql.DriverManager;
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
            ResultSet rs = stmt.executeQuery("Select poh_id, poh_total "
                    + "From purchaseheader order by poh_id");
            while (rs.next()) {
                POHeader poh = new POHeader();
                poh.setId(rs.getInt(1));
                poh.setTotal(rs.getFloat(2));
                
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

}
