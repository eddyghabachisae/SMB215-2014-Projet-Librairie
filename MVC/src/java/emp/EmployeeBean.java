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
    private static final String Database_URL = "jdbc:mysql://localhost:3306/test";
    private static final String Username = "root";
    private static final String Password = "ubuntu";

    public void addEmployee(Employee emp) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {

            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(Database_URL, Username, Password);
            pstmt = con.prepareStatement("INSERT INTO employee(empId,empName) VALUES(?,?);");
            pstmt.setInt(1, emp.getEmpId());
            pstmt.setString(2, emp.getEmpName());
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee ORDER BY empId");
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmpId(rs.getInt(1));
                emp.setEmpName(rs.getString(2));
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
            stmt.execute("DELETE FROM employee WHERE empId=" + String.valueOf(id));
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
            pstmt = con.prepareStatement("UPDATE employee SET empName=? WHERE empId=?");
            pstmt.setString(1, e.getEmpName());
            pstmt.setInt(2, e.getEmpId());
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee WHERE empId=" + id);
            if (rs.next()) {
                emp = new Employee();
                emp.setEmpId(rs.getInt(1));
                emp.setEmpName(rs.getString(2));
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
