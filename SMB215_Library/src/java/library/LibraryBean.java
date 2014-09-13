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
            ResultSet rs = stmt.executeQuery("Select lib_id, lib_name, lib_logo,"
                    + "lib_website, lib_mainbranch, lib_rentaldays, lib_reservationdays,"
                    + "lib_maxreserve, lib_rentalalert, lib_reservationalert,"
                    + "lib_maincurrency, lib_secondarycurrency, lib_secondarycurrencyrate From tbl_library");
            if (rs.next()) {
                lib.setId(rs.getInt(1));
                lib.setName(rs.getString(2));
                lib.setWebsite(rs.getString(4));
                lib.setMainBranch(rs.getInt(5));
                lib.setRentalDays(rs.getInt(6));
                lib.setReservationDays(rs.getInt(7));
                lib.setMaxReserve(rs.getInt(8));
                lib.setRentalAlert(rs.getInt(9));
                lib.setReservationAlert(rs.getInt(10));
                lib.setMainCurrency(rs.getString(11));
                lib.setSecondaryCurrency(rs.getString(12));
                lib.setSecondaryCurrencyRate(rs.getFloat(13));
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

}
