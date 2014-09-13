/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Warehouse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.DBconnection;

public class WarehouseBean {
    
    public List<Warehouse> getWarehouses() {
        List<Warehouse> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From Warehouse Where swr_isactive=1 order by wrs_id");
            while (rs.next()) {
                Warehouse wrs = new Warehouse();
                wrs.setId(rs.getInt(1));
                wrs.setQuantity(rs.getInt(2));
                 wrs.setSalerentprice(rs.getDouble(3));
                  wrs.setMinlimit(rs.getInt(4));
                   wrs.setIsavailable(rs..getboolean(5));
                    wrs.setIsavailable(rs.getboolean(6));
                list.add(wrs);

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
