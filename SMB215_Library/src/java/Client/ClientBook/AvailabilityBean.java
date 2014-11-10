/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Client.ClientBook;
import Book.Book;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.Utils;
import main.DBconnection;
/**
 *
 * @author dany.wazen
 */
public class AvailabilityBean {
    
    public List<Availability> getAvailability(int a) {
        List<Availability> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT\n" +
"    `book`.`bok_id`\n" +
"    , `item`.`itm_name`\n" +
"    , `book`.`bok_title`\n" +
"    , `warehouse`.`wrh_name`\n" +
"    , `branch`.`brh_name`\n" +
"    , `city`.`cty_name`\n" +
"    , `item`.`itm_minlimit`\n" +
"    , `item`.`itm_maxlimit`\n" +
"    , `item`.`itm_quantity`\n" +
"    , `item`.`itm_id`\n" +
"FROM\n" +
"    `librarydb`.`item`\n" +
"    INNER JOIN `librarydb`.`book` \n" +
"        ON (`item`.`bok_id` = `book`.`bok_id`)\n" +
"    INNER JOIN `librarydb`.`warehouse` \n" +
"        ON (`item`.`wrh_id` = `warehouse`.`wrh_id`)\n" +
"    INNER JOIN `librarydb`.`branch` \n" +
"        ON (`warehouse`.`branch_id` = `branch`.`brh_id`)\n" +
"    INNER JOIN `librarydb`.`city` \n" +
"        ON (`branch`.`city_id` = `city`.`cty_id`)\n" +
"WHERE (`book`.`bok_id`= " + a +")");
        
            while (rs.next()) {
                Availability availability = new Availability();
                availability.setBook_id(rs.getLong(1));
                availability.setItem_name(rs.getString(2));
                availability.setBook_title(rs.getString(3));
                availability.setWrh_name(rs.getString(4));
                availability.setBrh_name(rs.getString(5));
                availability.setCty_name(rs.getString(6));
                availability.setitm_minlimit(rs.getInt(7));
                availability.setItm_maxlimit(rs.getInt(8));
                availability.setItm_quantity(rs.getInt(9));
                availability.setItem_id(rs.getLong(10));
                list.add(availability);
               
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
        System.err.println(list.size());
        return list;
    }
    
        public long addBookReservation(long a, Integer b, Date c) {

        Connection con = null;
        PreparedStatement pstmt = null;
        long id =0;

        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Insert Into bookreservation "
                    + "(itm_id, client_id, reservation_date, returned) Values ("+ a + "," + b + "," + c + ",0)");

;
            
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
        return id;
    }
    
}
