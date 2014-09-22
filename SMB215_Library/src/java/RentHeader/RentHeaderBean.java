package RentHeader;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.DBconnection;

public class RentHeaderBean {

     public List<RentHeader> getRentHeaders() {
        List<RentHeader> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From rentHeader order by rnt_id");
        
            while (rs.next()) {
                RentHeader rentHeader = new RentHeader();
                rentHeader.setId(rs.getLong(1));
                rentHeader.setSubmitDate(rs.getDate(2));
                rentHeader.setTotal(rs.getDouble(3));
                rentHeader.setCustomer_id(rs.getLong(4));
                rentHeader.setEmployee_id(rs.getLong(5));
                rentHeader.setBranch_id(rs.getLong(6));
                list.add(rentHeader);
               
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
   
    
    public void deleteRentHeader(long id) {
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            stmt.execute("Delete From rentHeader Where rnt_id = " + String.valueOf(id));
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

    public long addRentHeader(RentHeader rentHeader) {

        Connection con = null;
        PreparedStatement pstmt = null;
        long id =0;

        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Insert Into RentHeader "
                    + "(rnt_date, rnt_total,cutomer_id,employee_id,branch_id) Values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

            pstmt.setDate(1, rentHeader.getSubmitDate());
            pstmt.setDouble(2, rentHeader.getTotal());
            pstmt.setLong(3, rentHeader.getCustomer_id());
            pstmt.setLong(4, rentHeader.getEmployee_id());
            pstmt.setLong(5, rentHeader.getBranch_id());
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

   public RentHeader getRentHeader(long id) {
        RentHeader rentHeader = null;
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From rentHeader Where rnt_id=" + id);
            rentHeader = new RentHeader();
            if (rs.next()) {
                rentHeader = new RentHeader();
                rentHeader.setId(rs.getLong(1));
                rentHeader.setSubmitDate(rs.getDate(2));
                rentHeader.setTotal(rs.getDouble(3));
                rentHeader.setCustomer_id(rs.getLong(4));
                rentHeader.setEmployee_id(rs.getLong(5));
                rentHeader.setBranch_id(rs.getLong(6));
                
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
        return rentHeader;
    }
   

    public void modifyRentHeader(RentHeader rentHeader) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Update rentHeader Set rnt_date=?, rnt_total=?, cutomer_id=?,"
                    + "employee_id=?,branch_id=?  Where rnt_id=?");
            
            pstmt.setDate(1, rentHeader.getSubmitDate());
            pstmt.setDouble(2, rentHeader.getTotal());
            pstmt.setLong(3, rentHeader.getCustomer_id());
            pstmt.setLong(4, rentHeader.getEmployee_id());
            pstmt.setLong(5, rentHeader.getBranch_id());
            pstmt.setLong(6, rentHeader.getId());
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
