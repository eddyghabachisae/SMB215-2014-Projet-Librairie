/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supplierBranchItem;

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
            ResultSet rs = stmt.executeQuery("Select spi_id, item_id, itm_name, "
                    + "spi_price, spi_shippingdays "
                    + "From supitem "
                    + "Inner Join item on item_id=itm_id "
                    + "Where supplierBranch_id = " + sbr + " order by itm_name");
            while (rs.next()) {
                SupplierBranchItem spi = new SupplierBranchItem();
                spi.setId(rs.getInt(1));
                spi.setItem(rs.getInt(2));
                spi.setItemname(rs.getString(3));
                spi.setPrice(rs.getFloat(4));
                spi.setShippingdays(rs.getInt(5));
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
    
}
