package main;

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
  
}
