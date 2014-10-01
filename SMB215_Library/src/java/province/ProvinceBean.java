package province;

import country.Country;
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
            ResultSet rs = idstmt.executeQuery("Select ifnull(max(pvc_id),0)+1 From province");
            rs.next();
            id = rs.getInt(1);

            pstmt = con.prepareStatement("Insert Into province Values(?,?,?,?)");

            pstmt.setInt(1, id);
            pstmt.setString(2, pvc.getCode());
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
            ResultSet rs = stmt.executeQuery("SELECT `province`.`pvc_id`" +
", `province`.`pvc_code`" +
", `province`.`pvc_name`" +
", `province`.`country_id`" +
", `country`.`cnt_name`" +
"FROM" +
" `librarydb`.`province`" +
" INNER JOIN `librarydb`.`country`" +
" ON (`province`.`country_id` = `country`.`cnt_id`);");
            while (rs.next()) {
                Province pvc = new Province();
                pvc.setId(rs.getInt(1));
                pvc.setCode(rs.getString(2));
                pvc.setName(rs.getString(3));
                pvc.setcountry(rs.getInt(4));

                list.add(pvc);
;
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
            stmt.execute("Delete From province Where pvc_id = " + id);
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
            ResultSet rs = stmt.executeQuery("Select * From province Where pvc_id=" + id);
            if (rs.next()) {
                pvc = new Province();
                pvc.setId(rs.getInt(1));
                pvc.setCode(rs.getString(2));
                pvc.setName(rs.getString(3));
                pvc.setcountry(rs.getInt(4));
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

            pstmt = con.prepareStatement("Update province Set pvc_code=?, "
                    + "pvc_name=?, country_id=? Where pvc_id=?");
            pstmt.setString(1, pvc.getCode());
            pstmt.setString(2, pvc.getName());
            pstmt.setInt(3, pvc.getcountry());
            pstmt.setInt(4, pvc.getId());
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
