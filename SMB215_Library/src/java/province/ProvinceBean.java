package province;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.DBconnection;

public class ProvinceBean {

    public void addProvince(Province pvc) {

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
            ResultSet rs = idstmt.executeQuery("Select ifnull(max(pvc_id),0)+1 From tbl_province");
            rs.next();
            id = rs.getInt(1);

            pstmt = con.prepareStatement("Insert Into tbl_province Values(?,?,?,?)");

            pstmt.setInt(1, id);
            pstmt.setString(2, pvc.getShortName());
            pstmt.setString(3, pvc.getName());
            pstmt.setInt(4, pvc.getcountry());

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

    public List<Province> getProvinces() {
        List<Province> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From province "
                    + "order by pvc_name");
            while (rs.next()) {
                Province pvc = new Province();
                pvc.setId(rs.getInt(1));
                pvc.setName(rs.getString(3));
                pvc.setcountry(rs.getInt(4));
                list.add(pvc);
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
    
    public List<Province> getCities() {
        List<Province> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From tbl_province order by pvc_shortname");
            while (rs.next()) {
                Province pvc = new Province();
                pvc.setId(rs.getInt(1));
                pvc.setShortName(rs.getString(2));
                pvc.setName(rs.getString(3));
                pvc.setcountry(rs.getInt(4));
                list.add(pvc);
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

    public void deleteProvince(int id) {
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            stmt.execute("Delete From tbl_province Where pvc_id = " + String.valueOf(id));
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

    public Province getProvince(int id) {
        Province pvc = null;
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From tbl_province Where pvc_id=" + id);
            if (rs.next()) {
                pvc = new Province();
                pvc.setId(rs.getInt(1));
                pvc.setShortName(rs.getString(2));
                pvc.setName(rs.getString(3));
                pvc.setcountry(rs.getInt(3));
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
        return pvc;
    }

    public void modifyProvince(Province pvc) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Update tbl_province Set pvc_shortname=?, "
                    + "pvc_name=? Where pvc_id=?");
            pstmt.setString(1, pvc.getShortName());
            pstmt.setString(2, pvc.getName());
            pstmt.setInt(4, pvc.getcountry());
            pstmt.setInt(3, pvc.getId());
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
