

package Profession;

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

public class ProfessionBean {

    private static final String JDBC_Driver = "com.mysql.jdbc.Driver";
    private static final String Database_URL = "jdbc:mysql://localhost:3306/origine";
    private static final String Username = "root";
    private static final String Password = "";

    public void addprofession(Profession prof) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {

            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            pstmt = con.prepareStatement("INSERT INTO profession(prfid,prfdescription) VALUES(?,?);");
            pstmt.setInt(1, prof.getprfid());
            pstmt.setString(2, prof.getprfdescription());
            pstmt.execute();

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
                Logger.getLogger(ProfessionBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
  
            
    public List<Profession> getprofessions() {
        List<Profession> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM profession ORDER BY prfid");
            while (rs.next()) {
                Profession prof = new Profession();
                prof.setprfid(rs.getInt(1));
                prof.setprfdescription(rs.getString(2));
                list.add(prof);
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
            stmt.execute("DELETE FROM profession WHERE prfid=" + String.valueOf(id));
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
                Logger.getLogger(ProfessionBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
     public void update(Profession p) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            pstmt = con.prepareStatement("UPDATE profession SET prfdescription=? WHERE prfid=?");
            pstmt.setString(1, p.getprfdescription());
            pstmt.setInt(2, p.getprfid());
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
                Logger.getLogger(ProfessionBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
       public Profession getprofessions(int id) {
        Profession prof = null;
        Connection con = null;
        java.sql.Statement stmt = null;
        try {
            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM profession WHERE prfid=" + id);
            if (rs.next()) {
                prof = new Profession();
                prof.setprfid(rs.getInt(1));
                prof.setprfdescription(rs.getString(2));
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
                Logger.getLogger(ProfessionBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return prof;
    }

}
