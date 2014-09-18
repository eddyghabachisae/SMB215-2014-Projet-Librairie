package library;

import java.sql.*;
import main.DBconnection;

public class LibraryBean {

    public void getLibrary(Library lib) {

        Connection con = null;
        Statement stmt = null;

        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From library");
            if (rs.next()) {
                lib.setId(rs.getInt(1));
                lib.setName(rs.getString(2));
                lib.setMainBranch(rs.getInt(12));
                lib.setWebsite(rs.getString(3));
                lib.setRentalDays(rs.getInt(4));
                lib.setReservationDays(rs.getInt(5));
                lib.setMaxReserve(rs.getInt(6));
                lib.setRentalAlert(rs.getInt(7));
                lib.setReservationAlert(rs.getInt(8));
                lib.setMainCurrency(rs.getString(9));
                lib.setSecondaryCurrency(rs.getString(10));
                lib.setSecondaryCurrencyRate(rs.getFloat(11));
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
    }

        public void UpdateLibrary(Library lib) {
        Connection con = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select lib_id From library");
            if(rs.next()) {
            pstmt = con.prepareStatement("Update library Set lib_name=?, "
                    + "lib_website=?, lib_rentaldays=?, lib_reservationdays=?,"
                    + "lib_maxreserve=?, lib_rentalalert=?, lib_reservationalert=?,"
                    + "lib_maincurrency=?, lib_secondarycurrency=?, lib_secondarycurrencyrate=?,"
                    + "mainBranch_id=? Where 1=1");
            pstmt.setString(1, lib.getName());
            pstmt.setString(2, lib.getWebsite());
            pstmt.setInt(3, lib.getRentalDays());
            pstmt.setInt(4, lib.getReservationDays());
            pstmt.setInt(5, lib.getMaxReserve());
            pstmt.setInt(6, lib.getRentalAlert());
            pstmt.setInt(7, lib.getReservationAlert());
            pstmt.setString(8, lib.getMainCurrency());
            pstmt.setString(9, lib.getSecondaryCurrency());
            pstmt.setFloat(10, lib.getSecondaryCurrencyRate());
            pstmt.setInt(11, lib.getMainBranch());
            pstmt.executeUpdate(); 
            } else {
                            pstmt = con.prepareStatement("Insert Into library (lib_name, "
                    + "lib_website, lib_rentaldays, lib_reservationdays,"
                    + "lib_maxreserve, lib_rentalalert, lib_reservationalert,"
                    + "lib_maincurrency, lib_secondarycurrency, lib_secondarycurrencyrate,"
                    + "mainBranch_id) Values (?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, lib.getName());
            pstmt.setString(2, lib.getWebsite());
            pstmt.setInt(3, lib.getRentalDays());
            pstmt.setInt(4, lib.getReservationDays());
            pstmt.setInt(5, lib.getMaxReserve());
            pstmt.setInt(6, lib.getRentalAlert());
            pstmt.setInt(7, lib.getReservationAlert());
            pstmt.setString(8, lib.getMainCurrency());
            pstmt.setString(9, lib.getSecondaryCurrency());
            pstmt.setFloat(10, lib.getSecondaryCurrencyRate());
            pstmt.setInt(11, lib.getMainBranch());
            pstmt.execute(); 
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Caught Exception: " + ex.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
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
}
