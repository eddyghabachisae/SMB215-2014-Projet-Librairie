/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemBean {

    private static final String JDBC_Driver = "com.mysql.jdbc.Driver";
    private static final String Database_URL = "jdbc:mysql://localhost:3306/test";
    private static final String Username = "root";
    private static final String Password = "";

    public void addItem(Item item) throws ParseException {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {

            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            pstmt = con.prepareStatement("INSERT INTO item(itemid,item_name,date_de_publication,Itemtypeid) VALUES(?,?,?,?);");
            pstmt.setInt(1, item.getItemId());
            pstmt.setString(2, item.getItemName());            
            pstmt.setDate(3, new java.sql.Date(item.getItemDatepb().getTime()) );
            pstmt.setInt(4,item.getItemType().getTypeId());
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
                Logger.getLogger(ItemBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<Item> getItems() {
        
        List<ItemType> typeslist=new ItemTypeBean().getItemTypes();
        
        List<Item> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT itemid,item_name,date_de_publication,Itemtypeid FROM item ORDER BY itemid");
            while (rs.next()) {
                Item item=new Item();
                item.setItemId(rs.getInt(1));
                item.setItemName(rs.getString(2));
                item.setItemDatepb(rs.getDate(3));
                
                ItemType type = new ItemType();
                type.setTypeId(rs.getInt(4));
                type.setTypeLabel("");
                for(ItemType lst_type :typeslist)
                {
                if(lst_type.getTypeId()==type.getTypeId())
                {
                type.setTypeLabel(lst_type.getTypeLabel());
                }
                }
               
                item.setItemType(type);
                
                list.add(item);
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
            stmt.execute("DELETE FROM item WHERE itemid=" + String.valueOf(id));
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
                Logger.getLogger(ItemBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
     public void update(Item item) {
         
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            pstmt = con.prepareStatement("UPDATE item SET Item_name=?, date_de_publication=?, Itemtypeid=? WHERE itemid=?");
            pstmt.setInt(4, item.getItemId());
            pstmt.setString(1, item.getItemName());            
            pstmt.setDate(2, new java.sql.Date(item.getItemDatepb().getTime()) );
            pstmt.setInt(3,item.getItemType().getTypeId());
            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            String s=ex.toString();
            String test="test";

        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ItemBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
       public Item getItem(int id) {
           
           List<ItemType> typeslist=new ItemTypeBean().getItemTypes();
           
        Item item = null;
        Connection con = null;
        java.sql.Statement stmt = null;
        try {
            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT itemid,item_name,date_de_publication,Itemtypeid FROM item WHERE itemid=" + id);
            if (rs.next()) {
                item = new Item();
                
                item.setItemId(rs.getInt(1));
                item.setItemName(rs.getString(2));
                item.setItemDatepb(rs.getDate(3));
                
                ItemType type=new ItemType();
                type.setTypeId(rs.getInt(4));
                type.setTypeLabel("");
                for(ItemType lst_type : typeslist)
                {
                if(type.getTypeId()==lst_type.getTypeId())
                {
                    type.setTypeLabel(lst_type.getTypeLabel());
                }
                }
                item.setItemType(type);
                
                
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
                Logger.getLogger(ItemBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return item;
    }

}
