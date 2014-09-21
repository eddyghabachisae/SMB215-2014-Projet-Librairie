/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package purchaseOrderDetail;

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
                    + "item_id, pod_quantity, pod_unitcost, pod_quantity*pod_unitcost pod_total "
                    + "From purchasedetails "
                    + "Where purchaseheader_id = " + poh
                    + " order by pod_id");
            while (rs.next()) {
                PODetail pod = new PODetail();
                pod.setItem(rs.getLong(1));
                pod.setQuantity(rs.getInt(2));
                pod.setUnitcost(rs.getFloat(3));
                pod.setTotal(rs.getFloat(4));
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
    
}
