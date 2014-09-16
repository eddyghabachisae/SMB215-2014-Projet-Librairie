package Item;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.DBconnection;

public class ItemBean {

    public List<Item> getItems() {
        List<Item> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From item order by itm_id");
        
            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getLong(1));
                item.setName(rs.getString(2));
                item.setBarcode(rs.getString(3));
                item.setImgBracodePath(rs.getString(4));
                item.setImgPath(rs.getString(5));
                item.setDescription(rs.getString(6));
                item.setAvgUnitCost(rs.getDouble(7));
                item.setSaleRentPrice(rs.getDouble(8));
                item.setMinLimit(rs.getInt(9));
                item.setMaxLimit(rs.getInt(10));
                item.setQuantity(rs.getInt(11));
                item.setIsAvailable(rs.getBoolean(12));
                item.setIsActive(rs.getBoolean(13));
                item.setDeactivationReason(rs.getString(14));
                item.setItemCategory_id(rs.getInt(15));
                list.add(item);
               
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

    public void deleteItem(long id) {
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            stmt.execute("Delete From item Where itm_id = " + String.valueOf(id));
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

    public void addItem(Item item) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            pstmt = con.prepareStatement("Insert Into item (itm_name, itm_barcode, itm_barcodeimgpath, itm_imgpath, itm_description, itm_avgunitcost, itm_salerentprice, itm_minlimit, itm_maxlimit, itm_quantity, itm_isavailable, itm_isactive, itm_deactivationreason, itemCategory_id) Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getBarcode());
            pstmt.setString(3, item.getImgBracodePath());
            pstmt.setString(4, item.getImgPath());
            pstmt.setString(5, item.getDescription());
            pstmt.setDouble(6, item.getAvgUnitCost());
            pstmt.setDouble(7, item.getSaleRentPrice());
            pstmt.setInt(8, item.getMinLimit());
            pstmt.setInt(9, item.getMaxLimit());
            pstmt.setInt(10, item.getQuantity());
            pstmt.setBoolean(11, item.getIsAvailable());
            pstmt.setBoolean(12, item.getIsActive());
            pstmt.setString(13, item.getDeactivationReason());
            pstmt.setLong(14, item.getItemCategory_id());
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

    public Item getItem(long id) {
        Item item = null;
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            System.err.println("idddddddddddddddd:"+id);
            ResultSet rs = stmt.executeQuery("Select * From item Where itm_id=" + id);
            item = new Item();
            if (rs.next()) {
                item = new Item();
                item.setId(rs.getLong(1));
                item.setName(rs.getString(2));
                item.setBarcode(rs.getString(3));
                item.setImgBracodePath(rs.getString(4));
                item.setImgPath(rs.getString(5));
                item.setDescription(rs.getString(6));
                item.setAvgUnitCost(rs.getDouble(7));
                item.setSaleRentPrice(rs.getDouble(8));
                item.setMinLimit(rs.getInt(9));
                item.setMaxLimit(rs.getInt(10));
                item.setQuantity(rs.getInt(11));
                item.setIsAvailable(rs.getBoolean(12));
                item.setIsActive(rs.getBoolean(13));
                item.setDeactivationReason(rs.getString(14));
                item.setItemCategory_id(rs.getInt(15));
                
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
        return item;
    }

    public void modifyItem(Item item) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            pstmt = con.prepareStatement("Update item Set itm_name=?, itm_barcode=?, itm_barcodeimgpath=?,"
                    + "itm_imgpath=?,itm_description=?,"
                    + "itm_avgunitcost=?,itm_salerentprice=?,"
                    + "itm_minlimit=?,itm_maxlimit=?,itm_quantity=?,"
                    + "itm_isavailable=?,itm_isactive=?,"
                    + "itm_deactivationreason=?,itemCategory_id=?  Where itm_id=?");
           
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getBarcode());
            pstmt.setString(3, item.getImgBracodePath());
            pstmt.setString(4, item.getImgPath());
            pstmt.setString(5, item.getDescription());
            pstmt.setDouble(6, item.getAvgUnitCost());
            pstmt.setDouble(7, item.getSaleRentPrice());
            pstmt.setInt(8, item.getMinLimit());
            pstmt.setInt(9, item.getMaxLimit());
            pstmt.setInt(10, item.getQuantity());
            pstmt.setBoolean(11, item.getIsAvailable());
            pstmt.setBoolean(12, item.getIsActive());
            pstmt.setString(13, item.getDeactivationReason());
            pstmt.setLong(14, item.getItemCategory_id());
            
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
