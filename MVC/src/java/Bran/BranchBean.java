/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bran;

import java.util.Date;
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

public class BranchBean {

    private static final String JDBC_Driver = "com.mysql.jdbc.Driver";
    private static final String Database_URL = "jdbc:mysql://localhost:3306/origine";
    private static final String Username = "root";
    private static final String Password = "";

    public void addBranch(Branch bran) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {


            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            pstmt = con.prepareStatement("INSERT INTO Branch(brhid,brhname,brhcity,brhaddress,brhemail,brhphone,brhfax,brhmobile,brhisactive,brhactivesince,brhdeactivatedsince) VALUES(?,?,?,?,?,?,?,?,?,?,?);");
                 
           pstmt.setInt(1, bran.getbrhid());
           pstmt.setString(2, bran.getbrhname());
           pstmt.setInt(3, bran.getbrhcity());
           pstmt.setString(4, bran.getbrhaddress());
           pstmt.setString(5, bran.getbrhemail());
           pstmt.setString(6, bran.getbrhphone());
           pstmt.setString(7, bran.getbrhfax());
           pstmt.setString(8, bran.getbrhmobile());
           pstmt.setBoolean(9, bran.getbrhisactive());
           pstmt.setDate(10, new java.sql.Date(bran.getbrhactivatesince().getDate()));
           pstmt.setDate(11, new java.sql.Date(bran.getbrhdeactivatedsince().getDate()));
         

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
                Logger.getLogger(BranchBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
  
            
    public List<Branch> getBranchs() {
        List<Branch> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Branch ORDER BY brhid");
            while (rs.next()) {
                Branch Bran = new Branch();
                Bran.setbrhid(rs.getInt(1));
                Bran.setbrhname(rs.getString(2));
                Bran.setbrhcity(rs.getInt(3));
                Bran.setbrhaddress(rs.getString(4));
                Bran.setbrhemail(rs.getString(5));
                Bran.setbrhphone(rs.getString(6));
                Bran.setbrhfax(rs.getString(7));
                Bran.setbrhmobile(rs.getString(8));
                Bran.setbrhisactive(rs.getBoolean(9));
                Bran.setbrhactivatesince(rs.getDate(10));
                Bran.setbrhdeactivatedsince(rs.getDate(11));
//java.util.Date
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
            stmt.execute("DELETE FROM Branch WHERE brhid=" + String.valueOf(id));
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
                Logger.getLogger(BranchBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

     public void update(Branch b) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            pstmt = con.prepareStatement("UPDATE Branch SET brhname=?,brhcity=?,brhaddress=?,brhemail=?,brhphone=?,brhfax=?,brhmobile=?,brhisactive=?,brhactivesince=?,brhdeactivatedsince=? WHERE brhid=?");
            pstmt.setString(1, b.getbrhname());
            pstmt.setInt(2, b.getbrhcity());
            pstmt.setString(3, b.getbrhaddress());
            pstmt.setString(4, b.getbrhemail());
            pstmt.setString(5, b.getbrhphone());
            pstmt.setString(6, b.getbrhfax());
            pstmt.setString(7, b.getbrhmobile());
            pstmt.setBoolean(8, b.getbrhisactive());           
            pstmt.setDate(9, new java.sql.Date(b.getbrhactivatedsince().getDate()));
                        pstmt.setDate(10, new java.sql.Date(b.getbrhdeactivatedsince().getDate()));
              
            pstmt.setInt(11, b.getbrhid());
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
                Logger.getLogger(BranchBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
       public Branch getBranch(int id) {
        Branch bran = null;
        Connection con = null;
        java.sql.Statement stmt = null;
        try {
            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Branch WHERE brhid=" + id);
            if (rs.next()) {
                bran = new Branch();
                bran.setbrhid(rs.getInt(1));
                bran.setbrhname(rs.getString(2));           
                bran.setbrhcity(rs.getInt(3));  
                bran.setbrhaddress(rs.getString(4));
                bran.setbrhemail(rs.getString(5)); 
                bran.setbrhphone(rs.getString(6));
                bran.setbrhfax(rs.getString(7));
                bran.setbrhmobile(rs.getString(8));
                bran.setbrhisactive(rs.getBoolean(9));  
                bran.setbrhactivatedsince(new java.sql.Date(rs.getDate(10).getDate()));
                bran.setbrhdeactivatedsince(rs.getDate(11));
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
                Logger.getLogger(BranchBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return bran;
    }

}
