package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemTypeBean {

    private static final String JDBC_Driver = "com.mysql.jdbc.Driver";
    private static final String Database_URL = "jdbc:mysql://localhost:3306/test";
    private static final String Username = "root";
    private static final String Password = "";

    public void addItemType(ItemType type) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {

            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            pstmt = con.prepareStatement("INSERT INTO itemtype(Id,name) VALUES(?,?);");
            pstmt.setInt(1, type.getTypeId());
            pstmt.setString(2, type.getTypeLabel());
            pstmt.execute();

        } catch ( SQLException | ClassNotFoundException ex) {
           

        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ItemTypeBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<ItemType> getItemTypes() {
        List<ItemType> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM itemtype ORDER BY Id");
            while (rs.next()) {
                ItemType type = new ItemType();
                type.setTypeId(rs.getInt(1));
                type.setTypeLabel(rs.getString(2));
                list.add(type);
            }
        } catch (SQLException | ClassNotFoundException ex) {

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {

            }
        }
        return list;
    }

    public void delete(int id) {
        Connection con = null;
        java.sql.Statement stmt = null;
        try {
            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            stmt = con.createStatement();
            stmt.execute("DELETE FROM itemtype WHERE Id=" + String.valueOf(id));
        } catch (SQLException | ClassNotFoundException ex) {

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
     public void update(ItemType type) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            pstmt = con.prepareStatement("UPDATE itemtype SET name=? WHERE Id=?");
            pstmt.setString(1, type.getTypeLabel());
            pstmt.setInt(2, type.getTypeId());
            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {

        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
       public ItemType getItemType(int id) {
        ItemType type = null;
        Connection con = null;
        java.sql.Statement stmt = null;
        try {
            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM itemtype WHERE Id=" + id);
            if (rs.next()) {
                type = new ItemType();
                type.setTypeId(rs.getInt(1));
                type.setTypeLabel(rs.getString(2));
            }
        } catch (SQLException | ClassNotFoundException ex) {

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return type;
    }

}
