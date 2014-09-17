package Book;


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
import Book.Book;
import main.DBconnection;

public class BookBean {

    public List<Book> getBooks() {
        List<Book> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From book order by bok_id");
        
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getLong(1));
                book.setTitle(rs.getString(2));
                book.setSubtitle(rs.getString(3));
                book.setIsbn(rs.getString(4));
                book.setPublisher(rs.getString(5));
                book.setPublishDate(rs.getDate(6));
                book.setPagesNb(rs.getInt(7));
                book.setBookCategory_id(rs.getLong(8));
                book.setLanguage_id(rs.getLong(9));
                book.setBookAuthor_id(rs.getLong(10));
                book.setItem_id(rs.getLong(11));
                book.setBookStatus_id(rs.getLong(12));
                list.add(book);
               
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

    public List<Book> getBooksByBranch(int branch_id) {
        List<Book> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM book Inner Join bookstatus On bookstatus_id=bks_id WHERE branch_id= "+branch_id+" Order by bok_id");
        
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getLong(1));
                book.setTitle(rs.getString(2));
                book.setSubtitle(rs.getString(3));
                book.setIsbn(rs.getString(4));
                book.setPublisher(rs.getString(5));
                book.setPublishDate(rs.getDate(6));
                book.setPagesNb(rs.getInt(7));
                book.setBookCategory_id(rs.getLong(8));
                book.setLanguage_id(rs.getLong(9));
                book.setBookAuthor_id(rs.getLong(10));
                book.setItem_id(rs.getLong(11));
                book.setBookStatus_id(rs.getLong(12));
                list.add(book);
               
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
    
    public List<Book> getBooksByAuthors(int [] author_id) {
        List<Book> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            
            String query="SELECT * FROM book Inner Join bookauthors On bookauthor_id=bka_id WHERE author_id IN (";
         
            for(int aid:author_id)
            {
            	query+=aid+",";
            }
            
            query=Utils.str_RemoveLastChar(query);
           
            query+=") Order by bok_id";
            
            
            ResultSet rs = stmt.executeQuery(query);
        
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getLong(1));
                book.setTitle(rs.getString(2));
                book.setSubtitle(rs.getString(3));
                book.setIsbn(rs.getString(4));
                book.setPublisher(rs.getString(5));
                book.setPublishDate(rs.getDate(6));
                book.setPagesNb(rs.getInt(7));
                book.setBookCategory_id(rs.getLong(8));
                book.setLanguage_id(rs.getLong(9));
                book.setBookAuthor_id(rs.getLong(10));
                book.setItem_id(rs.getLong(11));
                book.setBookStatus_id(rs.getLong(12));
                list.add(book);
               
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

    public List<Book> getBooksByBookCategory(int [] bookcategory_id) {
        List<Book> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            
            
            String query="SELECT * FROM book Where bookcategory_id IN (";
            
            for(int bcid:bookcategory_id)
            {
            	query+=bcid+",";
            }
            
            query=Utils.str_RemoveLastChar(query);
           
            query+=") Order by bok_id";
            
            
            
            ResultSet rs = stmt.executeQuery(query);
        
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getLong(1));
                book.setTitle(rs.getString(2));
                book.setSubtitle(rs.getString(3));
                book.setIsbn(rs.getString(4));
                book.setPublisher(rs.getString(5));
                book.setPublishDate(rs.getDate(6));
                book.setPagesNb(rs.getInt(7));
                book.setBookCategory_id(rs.getLong(8));
                book.setLanguage_id(rs.getLong(9));
                book.setBookAuthor_id(rs.getLong(10));
                book.setItem_id(rs.getLong(11));
                book.setBookStatus_id(rs.getLong(12));
                list.add(book);
               
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
    
    
    public void deleteBook(long id) {
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            stmt.execute("Delete From book Where bok_id = " + String.valueOf(id));
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

    public void addBook(Book book) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Insert Into book "
                    + "(bok_id, bok_title, bok_subtitle,bok_isbn,bok_publisher,bok_publisherdate,bok_nbpages,bookCategory_id,bookLanguage_id,BookAuthor_id,item_id,bookstatus_id) Values(?,?,?,?,?,?,?,?,?,?,?,?)");

            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getSubtitle());
            pstmt.setString(3, book.getIsbn());
            pstmt.setString(4, book.getPublisher());
            pstmt.setDate(5, (Date) book.getPublishDate());
            pstmt.setInt(6, book.getPagesNb());
            pstmt.setLong(7, book.getBookCategory_id());
            pstmt.setLong(8, book.getLanguage_id());
            pstmt.setLong(9, book.getBookAuthor_id());
            pstmt.setLong(10, book.getItem_id());
            pstmt.setLong(11, book.getBookStatus_id());
            pstmt.execute();

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

    public Book getBook(long id) {
        Book book = null;
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From Book Where bok_id=" + id);
            book = new Book();
            if (rs.next()) {
                book = new Book();
                book.setId(rs.getLong(1));
                book.setTitle(rs.getString(2));
                book.setSubtitle(rs.getString(3));
                book.setIsbn(rs.getString(4));
                book.setPublisher(rs.getString(5));
                book.setPublishDate(rs.getDate(6));
                book.setPagesNb(rs.getInt(7));
                book.setBookCategory_id(rs.getLong(8));
                book.setLanguage_id(rs.getLong(9));
                book.setBookAuthor_id(rs.getLong(10));
                book.setItem_id(rs.getLong(11));
                book.setBookStatus_id(rs.getLong(12));
                
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
        return book;
    }

    public void modifyBook(Book book) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Update book Set bok_title=?, bok_subtitle=?, bok_isbn=?,"
                    + "bok_publisher=?,bok_publisherdate=?,"
                    + "bok_nbpages=?,bookCategory_id=?,"
                    + "bookLanguage_id=?,BookAuthor_id=?,item_id=?,"
                    + "bookstatus_id=? Where bok_id=?");
           
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getSubtitle());
            pstmt.setString(3, book.getIsbn());
            pstmt.setString(4, book.getPublisher());
            pstmt.setDate(5, (Date) book.getPublishDate());
            pstmt.setInt(6, book.getPagesNb());
            pstmt.setLong(7, book.getBookCategory_id());
            pstmt.setLong(8, book.getLanguage_id());
            pstmt.setLong(9, book.getBookAuthor_id());
            pstmt.setLong(10, book.getItem_id());
            pstmt.setLong(11, book.getBookStatus_id());
            pstmt.setLong(12, book.getId());
            
            
             
            
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
