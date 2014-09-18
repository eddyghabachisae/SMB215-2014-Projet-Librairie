package BookStatus;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.DBconnection;

public class BookStatusBean {

    public List<BookStatus> getBookStatus() {
        List<BookStatus> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From bookStatus order by bks_id");
        
            while (rs.next()) {
                BookStatus bookStatus = new BookStatus();
                bookStatus.setId(rs.getLong(1));
                bookStatus.setReservedCopies(rs.getInt(2));
                bookStatus.setSection(rs.getString(3));
                bookStatus.setShelf(rs.getString(4));
                bookStatus.setBranch_id(rs.getLong(5));
                
                list.add(bookStatus);
               
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

    public void deleteBookStatus(long id) {
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            stmt.execute("Delete From bookstatus Where bks_id = " + String.valueOf(id));
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

    public long addBookStatus (BookStatus bookCat) {

        Connection con = null;
        PreparedStatement pstmt = null;
        long id = 0 ;

        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Insert Into bookstatus "
                    + "(bks_reservedcopies, bks_section,bks_shelf, branch_id) Values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, bookCat.getReservedCopies());
            pstmt.setString(2, bookCat.getSection());
            pstmt.setString(3, bookCat.getShelf());
            pstmt.setLong(4, bookCat.getBranch_id());
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

    public BookStatus getBookStatus(long id) {
        BookStatus bookStatus = null;
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From bookstatus Where bks_id=" + id);
            bookStatus = new BookStatus();
            if (rs.next()) {
                bookStatus = new BookStatus();
                bookStatus.setId(rs.getLong(1));
                bookStatus.setReservedCopies(rs.getInt(2));
                bookStatus.setSection(rs.getString(3));
                bookStatus.setShelf(rs.getString(4));
                bookStatus.setBranch_id(rs.getLong(5));
                
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
        return bookStatus;
    }

    public void modifyBookStatus (BookStatus bookStatus) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Update bookStatus Set bks_section=?, bks_shelf=?, branch_id=? Where bks_id=?");
           
            pstmt.setString(1, bookStatus.getSection());
            pstmt.setString(2, bookStatus.getShelf());
            pstmt.setLong(3, bookStatus.getBranch_id());
            pstmt.setLong(4, bookStatus.getId());
            
             
            
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
