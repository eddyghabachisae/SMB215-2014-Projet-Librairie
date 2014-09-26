/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gender;

import gender.*;
import Client.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.DBconnection;
import gender.Gender;

public class GetGendersBean {
    

public List<Gender> getGenders() {
        List<Gender> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            
                      
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select id, gender_desc From gender order by gender_desc");
            while (rs.next()) {
                Gender gen = new Gender();
                gen.setId(rs.getInt(1));
                gen.setGender(rs.getString(2));
                list.add(gen);
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
