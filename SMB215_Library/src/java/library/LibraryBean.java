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

}
