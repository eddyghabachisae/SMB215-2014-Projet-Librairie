package main;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/LibraryDB";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "ubuntu";

    public DBconnection() {
    }
    
    public String getJDBC_DRIVER() {
        return JDBC_DRIVER;
    }

    public String getDATABASE_URL() {
        return DATABASE_URL;
    }

    public String getDB_USERNAME() {
        return DB_USERNAME;
    }

    public String getDB_PASSWORD() {
        return DB_PASSWORD;
    }
  
     public Connection connect()  
    {  
    Connection connection = null;  
    try  
    {  
        String username = DB_USERNAME;  
        String password = DB_PASSWORD;  
        String url = "jdbc:mysql://localhost:3306/LibraryDB";  
        Class.forName("com.mysql.jdbc.Driver").newInstance();  
        connection = DriverManager.getConnection(url,username,password);  
        System.out.println("Connection Established!");  
    }  
    catch(Exception e)  
    {  
        System.out.println("There was some error while establishing connection to the database"+e);  
    }  
    finally  
    {  
        try  
        {  
        connection.close();  
        System.out.println("Connection Successfully Closed.");  
        }  
        catch(Exception e)  
        {  
        System.out.println("There was some error while closing connection to the database");  
        }  
    }  
        return connection;
    }  
}
