package city;

import city.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.DBconnection;

public class CityBean {

    public void addCity(City cit) {

        int id;
        Connection con = null;
        PreparedStatement pstmt = null;
        Statement idstmt = null;

        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            con.setAutoCommit(false);
            idstmt = con.createStatement();
            ResultSet rs = idstmt.executeQuery("Select ifnull(max(cit_id),0)+1 From tbl_city");
            rs.next();
            id = rs.getInt(1);

            pstmt = con.prepareStatement("Insert Into tbl_city Values(?,?,?,?)");

            pstmt.setInt(1, id);
            pstmt.setString(2, cit.getShortName());
            pstmt.setString(3, cit.getName());
            pstmt.setString(4, cit.getprovince());

            pstmt.execute();

            con.commit();

        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Caught Exception: " + ex.getMessage());
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex2) {
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

    public List<City> getCities() {
        List<City> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From tbl_city order by cit_shortname");
            while (rs.next()) {
                City cit = new City();
                cit.setId(rs.getInt(1));
                cit.setShortName(rs.getString(2));
                cit.setName(rs.getString(3));
                cit.setprovince(rs.getString(4));
                list.add(cit);
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

    public void deleteCity(int id) {
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            stmt.execute("Delete From tbl_city Where cit_id = " + String.valueOf(id));
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

    public City getCity(int id) {
        City cit = null;
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From tbl_city Where cit_id=" + id);
            if (rs.next()) {
                cit = new City();
                cit.setId(rs.getInt(1));
                cit.setShortName(rs.getString(2));
                cit.setName(rs.getString(3));
                cit.setprovince(rs.getString(3));
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
        return cit;
    }

    public void modifyCity(City cit) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Update tbl_city Set cit_shortname=?, "
                    + "cit_name=? Where cit_id=?");
            pstmt.setString(1, cit.getShortName());
            pstmt.setString(2, cit.getName());
            pstmt.setString(4, cit.getprovince());
            pstmt.setInt(3, cit.getId());
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
