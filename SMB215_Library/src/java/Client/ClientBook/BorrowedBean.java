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
public class BorrowedBean {
    
    public List<Borrowed> getBorrowed(int a) {
        List<Borrowed> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT\n" +
"    `book`.`bok_title`\n" +
"    , `book`.`bok_subtitle`\n" +
"    , `bookreservation`.`returned`\n" +
"    , `bookreservation`.`reservation_date`\n" +
"FROM\n" +
"    `librarydb`.`item`\n" +
"    INNER JOIN `librarydb`.`book` \n" +
"        ON (`item`.`bok_id` = `book`.`bok_id`)\n" +
"    INNER JOIN `librarydb`.`bookreservation` \n" +
"        ON (`bookreservation`.`itm_id` = `item`.`itm_id`)\n" +
"WHERE (`bookreservation`.`client_id`= 1);");
        
            while (rs.next()) {
                Borrowed borrowed = new Borrowed();
                borrowed.setBok_title(rs.getString(1));
                borrowed.setBok_subtitle(rs.getString(2));
                borrowed.setReturned(rs.getBoolean(3));
                borrowed.setReservation_date(rs.getDate(4));
                list.add(borrowed);
               
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
