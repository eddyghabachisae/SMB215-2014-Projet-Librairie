package main;

public class DBconnection {
    
    private static String JDBC_DRIVER;
    private static String DATABASE_URL;
    private static String DB_USERNAME;
    private static String DB_PASSWORD;

    public DBconnection(String JDBC_DRIVER, String DATABASE_URL, 
            String DB_USERNAME, String DB_PASSWORD) {
        this.JDBC_DRIVER = JDBC_DRIVER;
        this.DATABASE_URL = DATABASE_URL;
        this.DB_USERNAME = DB_USERNAME;
        this.DB_PASSWORD = DB_PASSWORD;
    }
    
    public static String getJDBC_DRIVER() {
        return JDBC_DRIVER;
    }

    public static void setJDBC_DRIVER(String JDBC_DRIVER) {
        DBconnection.JDBC_DRIVER = JDBC_DRIVER;
    }

    public static String getDATABASE_URL() {
        return DATABASE_URL;
    }

    public static void setDATABASE_URL(String DATABASE_URL) {
        DBconnection.DATABASE_URL = DATABASE_URL;
    }

    public static String getDB_USERNAME() {
        return DB_USERNAME;
    }

    public static void setDB_USERNAME(String DB_USERNAME) {
        DBconnection.DB_USERNAME = DB_USERNAME;
    }

    public static String getDB_PASSWORD() {
        return DB_PASSWORD;
    }

    public static void setDB_PASSWORD(String DB_PASSWORD) {
        DBconnection.DB_PASSWORD = DB_PASSWORD;
    }

  
    
    
}
