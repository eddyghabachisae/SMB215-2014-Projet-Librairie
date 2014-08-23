package country;

import java.sql.*;
import main.DBconnection;

public class CountryBean {
    
    public void addCountry(Country cnt){
        
        int id;
        Connection con = null;
        PreparedStatement pstmt = null;
        Statement idstmt = null;
       
            
        
        try{
             DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());
            
            
            con = DriverManager.getConnection(dbCon.getDATABASE_URL(), 
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            con.setAutoCommit(false);
            idstmt = con.createStatement();
            ResultSet rs = idstmt.executeQuery("Select ifnull(max(cnt_id),0)+1 From tbl_country");
            rs.next();
            id = rs.getInt(1);
                    
            pstmt = con.prepareStatement("Insert Into tbl_country Values(?,?,?)");
            
            pstmt.setInt(1, id);
            pstmt.setString(2, cnt.getShortName());
            pstmt.setString(3, cnt.getName());
            
            pstmt.execute();
            
            con.commit();
            
        }catch (SQLException | ClassNotFoundException ex) {
             System.err.println("Caught Exception: " + ex.getMessage()); 
            if (con != null) {
                 try{
                con.rollback();}
                catch (SQLException ex2){
                     System.err.println("Caught Exception: " + ex2.getMessage());
                }
             } 
        } finally {
            
            try {
               
                if (idstmt != null) {
                    idstmt.close();
                }
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
    }
    
    
}
