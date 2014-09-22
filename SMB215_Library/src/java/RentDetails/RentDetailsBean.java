package RentDetails;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.DBconnection;

public class RentDetailsBean {

     public List<RentDetails> getRentDetailss() {
        List<RentDetails> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From rentDetails order by rnd_id");
        
            while (rs.next()) {
                RentDetails rentDetails = new RentDetails();
                rentDetails.setId(rs.getLong(1));
                rentDetails.setReturnedDate(rs.getDate(2));
                rentDetails.setBook_id(rs.getLong(3));
                rentDetails.setRentHeader_id(rs.getLong(4));
                list.add(rentDetails);
               
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
     
      public List<RentDetails> getRentDetailss(long rentHeader_id) {
        List<RentDetails> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From rentDetails Where rentHeader_id="+String.valueOf(rentHeader_id));
        
            while (rs.next()) {
                RentDetails rentDetails = new RentDetails();
                rentDetails.setId(rs.getLong(1));
                rentDetails.setReturnedDate(rs.getDate(2));
                rentDetails.setBook_id(rs.getLong(3));
                rentDetails.setRentHeader_id(rs.getLong(4));
                list.add(rentDetails);
               
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
   
    
    public void deleteRentDetails(long id) {
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            stmt.execute("Delete From rentDetails Where rnd_id = " + String.valueOf(id));
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
    }

    public long addRentDetails(RentDetails rentDetails) {

        Connection con = null;
        PreparedStatement pstmt = null;
        long id =0;

        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Insert Into RentDetails "
                    + "( book_id,rentHeader_id) Values(?,?)",Statement.RETURN_GENERATED_KEYS);

            pstmt.setLong(1, rentDetails.getBook_id());
            pstmt.setLong(2, rentDetails.getRentHeader_id());
            pstmt.execute();
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            id = rs.getLong(1);
            
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

   public RentDetails getRentDetails(long id) {
        RentDetails rentDetails = null;
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From rentDetails Where rnd_id=" + id);
            rentDetails = new RentDetails();
            if (rs.next()) {
                rentDetails = new RentDetails();
                rentDetails.setId(rs.getLong(1));
                rentDetails.setReturnedDate(rs.getDate(2));
                rentDetails.setBook_id(rs.getLong(3));
                rentDetails.setRentHeader_id(rs.getLong(4));
                
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
        return rentDetails;
    }
   

    public void modifyRentDetails(RentDetails rentDetails) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Update rentDetails Set rnt_returneddate=?, book_id=?, rentHeader_id=?,"
                    +" Where rnd_id=?");
            
            pstmt.setDate(1, rentDetails.getReturnedDate());
            pstmt.setLong(2, rentDetails.getBook_id());
            pstmt.setLong(3, rentDetails.getRentHeader_id());
            pstmt.executeUpdate();
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
    }

   
}
