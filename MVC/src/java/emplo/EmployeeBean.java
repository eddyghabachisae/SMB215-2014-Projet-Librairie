
package emp;

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

public class EmployeeBean {

    private static final String JDBC_Driver = "com.mysql.jdbc.Driver";
    private static final String Database_URL = "jdbc:mysql://localhost:3306/origine";
    private static final String Username = "root";
    private static final String Password = "";

    public void addEmployee(Employee emp) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {

            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            pstmt = con.prepareStatement("INSERT INTO employee(empid,empssn,empusername,emppassword,empfirstname,emplastname,empgender,empmaritalstatus,empdateofbirth,empcity,empaddress,emphomephone,empmobile,emppersonalemail,empworkphone,empworkext,empworkfax,empworkemail,empprofession,empremarks,empbranch,empisactive,empactivesince,empdeactivatedsince,empdeactivatedreason) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
           

                    
           pstmt.setInt(1, emp.getempid());
           pstmt.setInt(2, emp.getempssn());
           pstmt.setString(3, emp.getempusername());
           pstmt.setString(4, emp.getemppassword());
           pstmt.setString(5, emp.getempfirstname());
           pstmt.setString(6, emp.getemplastname());
           pstmt.setBoolean(7, emp.getempgender());
           pstmt.setBoolean(8, emp.getempmaritalstatus());
            pstmt.setDate(9, new java.sql.Date(emp.getempdateofbirth().getDate()));
           
           pstmt.setInt(10, emp.getempcity());
           pstmt.setString(11, emp.getempaddress());
           pstmt.setString(12, emp.getemphomephone());
           pstmt.setString(13, emp.getempmobile());
           pstmt.setString(14, emp.getemppersonalemail());
           pstmt.setString(15, emp.getempworkphone());
           pstmt.setInt(16, emp.getempworkext());
           pstmt.setString(17, emp.getempworkfax());
           pstmt.setString(18, emp.getempworkemail());
           pstmt.setInt(19, emp.getempprofession());
           pstmt.setString(20, emp.getempremarks());
           pstmt.setInt(21, emp.getempbranch());
           pstmt.setBoolean(22, emp.getempisactive());
            pstmt.setDate(23, new java.sql.Date(emp.getempactivesince().getDate()));
            pstmt.setDate(24, new java.sql.Date(emp.getempdeactivatedsince().getDate()));
          
           pstmt.setString(25, emp.getempdeactivatedreason());

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
                Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
  
            
    public List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee ORDER BY empid");
            while (rs.next()) {
                Employee emp = new Employee();
//                emp.setempid(rs.getInt(1));
                emp.setempssn(rs.getInt(2));
                emp.setempusername(rs.getString(3));
                emp.setemppassword(rs.getString(4));
                emp.setempfirstname(rs.getString(5));
                emp.setemplastname(rs.getString(6));
                emp.setempgender(rs.getBoolean(7));
                emp.setempmaritalstatus(rs.getBoolean(8));
                emp.setempdateofbirth(rs.getDate(9));
                emp.setempcity(rs.getInt(10));
                emp.setempaddress(rs.getString(11));
                emp.setemphomephone(rs.getString(12));
                emp.setempmobile(rs.getString(13));
                emp.setemppersonalemail(rs.getString(14));
                emp.setempworkphone(rs.getString(15));
                emp.setempworkext(rs.getInt(16));
                emp.setempworkfax(rs.getString(17));
                emp.setempworkemail(rs.getString(18));
                emp.setempprofession(rs.getInt(19));
                emp.setempremarks(rs.getString(20));
                emp.setempbranch(rs.getInt(21));
                emp.setempisactive(rs.getBoolean(22));
                emp.setempactivesince(rs.getDate(23));
                emp.setempdeactivatedsince(rs.getDate(24));
                emp.setempdeactivatedreason(rs.getString(25));
               
                list.add(emp);
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
            stmt.execute("DELETE FROM employee WHERE empid=" + String.valueOf(id));
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
                Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

     public void update(Employee e) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            pstmt = con.prepareStatement("UPDATE employee SET empfirstname=?,emplastname=?,empgender=?,empworkphone=?,empworkext=?,empworkfax=?,empworkemail=? WHERE empid=?And empssn=?");
            pstmt.setString(1, e.getempfirstname());
            pstmt.setString(2, e.getemplastname());
            pstmt.setBoolean(3, e.getempgender());
            pstmt.setString(4, e.getempworkphone());
            pstmt.setInt(5, e.getempworkext());
            pstmt.setString(6, e.getempworkfax());
            pstmt.setString(7, e.getempworkemail());
            pstmt.setInt(8, e.getempid());
            pstmt.setInt(9, e.getempssn());
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
                Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
       public Employee getEmployee(int id) {
        Employee emp = null;
        Connection con = null;
        java.sql.Statement stmt = null;
        try {
            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee WHERE empid=" + id);
            if (rs.next()) {
                emp = new Employee();
               // emp.setempid(rs.getInt(1));
                emp.setemplastname(rs.getString(2));
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
                Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return emp;
    }

}
