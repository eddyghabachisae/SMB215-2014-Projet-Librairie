/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import main.DBconnection;

/**
 *
 * @author eddy
 */
public class LoginBean {
    
        public boolean doLogin(Login login, String username, String password) {
        Connection con = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        boolean success = false;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Select emp_username, emp_password, emp_id From employee "
                    + "Where emp_username=? and emp_password=?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
             if (rs.next()) {
                login.setUsername(rs.getString(1));
                login.setPassword(rs.getString(2));
                login.setId(rs.getLong(3));
                success = true;
            } else {
                
                // Check if user is a client?
                    pstmt1 = con.prepareStatement("Select cst_username, cst_password, cst_id From customer "
                            + "Where cst_username=? and cst_password=?");
                    pstmt1.setString(1, username);
                    pstmt1.setString(2, password);
                    ResultSet rs1 = pstmt1.executeQuery();
                     if (rs1.next()) {
                        login.setUsername(rs1.getString(1));
                        login.setPassword(rs1.getString(2));
                        login.setId(rs1.getLong(3));
                        success = true;
                    } else {
                        success = false;
                    }
            }
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
        return success;
    }
}
    
    
