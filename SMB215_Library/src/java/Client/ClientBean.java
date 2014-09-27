/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Client;

import Client.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.DBconnection;
import Client.Client;

public class ClientBean {
        public Client getClient(long id) {
        Client cust = null;
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From customer Where cst_id=" + id);
            
            if (rs.next()) {
                cust = new Client();
                cust.setId(rs.getInt(1));
                cust.setUsername(rs.getString(2));
                cust.setPassword(rs.getString(3));
                cust.setFirstname(rs.getString(4));
                cust.setLastname(rs.getString(5));
                cust.setGender(rs.getInt(6));
                cust.setMaritalstatus(rs.getInt(7));
                cust.setDateofbirth(rs.getDate(8));
                cust.setAddress(rs.getString(9));
                 cust.setPhone(rs.getString(10));
                cust.setMobile(rs.getString(11));
                cust.setEmail(rs.getString(12));
                cust.setRemarks(rs.getString(13));
                cust.setIsactive(rs.getBoolean(14));
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
        return cust;
    }
        public List<Client> getClients(long id) {
        List<Client> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From customer where cst_id=" + id);
        
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getLong(1));
                client.setUsername(rs.getString(2));
                client.setPassword(rs.getString(3));
                client.setFirstname(rs.getString(4));
                client.setLastname(rs.getString(5));
                client.setGender(rs.getInt(6));
                client.setMaritalstatus(rs.getInt(7));
                client.setDateofbirth(rs.getDate(8));
                client.setAddress(rs.getString(9));
                client.setCity(rs.getString(10));
                client.setPhone(rs.getString(11));
                client.setMobile(rs.getString(12));
                client.setEmail(rs.getString(13));
                client.setRemarks(rs.getString(14));
                client.setIsactive(rs.getBoolean(15));
                list.add(client);
               
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

	public List<Client> getClients() {
        List<Client> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From customer order by cst_id");
        
            while (rs.next()) {
                Client client = new Client();
                 client.setId(rs.getLong(1));
                client.setUsername(rs.getString(2));
                client.setPassword(rs.getString(3));
                client.setFirstname(rs.getString(4));
                client.setLastname(rs.getString(5));
                client.setGender(rs.getInt(6));
                client.setMaritalstatus(rs.getInt(7));
                client.setDateofbirth(rs.getDate(8));
                client.setAddress(rs.getString(9));
                client.setCity(rs.getString(10));
                client.setPhone(rs.getString(11));
                client.setMobile(rs.getString(12));
                client.setEmail(rs.getString(13));
                client.setRemarks(rs.getString(14));
                client.setIsactive(rs.getBoolean(15));
                list.add(client);
               
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
        
        
    }

