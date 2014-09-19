/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import main.DBconnection;

/**
 *
 * @author eddy
 */
public class LoginBean {
    
    public boolean doLogin(String username, String password) {
        
        Connection con = null;
        Statement stmt = null;
        Boolean success = false;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select emp_username, emp_password "
                    + "From supplier Where emp_username=" + username
            + " and emp_password=" +password);
            if (rs.next()) {
                Login login = new Login();
                login.setUsername(rs.getString(1));
                login.setPassword(rs.getString(2));
                success = true;
            } else {
                success = false;
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
        return success;
    }
}
