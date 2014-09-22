
package Employee;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.DBconnection;

public class EmployeeBean {
    
    
           public List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From employee ORDER BY emp_id");
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
        return list;
    }
public void deleteEmployee(int id) {
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            stmt.execute("Delete From employee Where emp_id = " + String.valueOf(id));
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
           

      public void addEmployee(Employee emp) {

        Connection con = null;
        PreparedStatement pstmt = null;
       

        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
          

            pstmt = con.prepareStatement("Insert Into Employee "
             +"(emp_ssn, emp_username, emp_password, emp_firstname, emp_lastname, emp_gender, "
                    + "emp_maritalstatus, emp_dateofbirth, emp_city, emp_address, emp_emphomephone,"
                    + " emp_empmobile,emp_personalemail, emp_workphone, emp_workext, emp_workfax, "
                    + "emp_workemail, emp_profession, emp_remarks, emp_branch, emp_isactive, "
                    + "emp_activesince, emp_deactivatedsince, emp_deactivatedreason)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

       
           //tmt.setInt(1, emp.getempid());
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
            System.err.println("Caught Exception: " + ex.getMessage());
            }
         
         finally {

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
      
  

      public Employee getEmployees(int id) {
        Employee emp = null;
        Connection con = null;
        Statement stmt = null;
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From Employee Where emp_id=" + id);
            if (rs.next()) {
            
                  emp = new Employee();
                emp.setempid(rs.getInt(1));
                emp.setempssn(rs.getInt(2));
                emp.setempusername(rs.getString(3));
                emp.setemppassword(rs.getString(4));
                emp.setempfirstname(rs.getString(5));
                emp.setemplastname(rs.getString(6));
                emp.setempgender(rs.getBoolean(7));
                emp.setempmaritalstatus(rs.getBoolean(8));
                emp.setempdateofbirth(rs.getDate(9));
                emp.setempaddress(rs.getString(10));
                emp.setemphomephone(rs.getString(11));
                emp.setempmobile(rs.getString(12));
                emp.setemppersonalemail(rs.getString(13));
                emp.setempworkphone(rs.getString(14));
                emp.setempworkext(rs.getInt(15));
                emp.setempworkfax(rs.getString(16));
                emp.setempworkemail(rs.getString(17));
                emp.setempremarks(rs.getString(18));
                emp.setempisactive(rs.getBoolean(19));
                emp.setempactivesince(rs.getDate(20));
                emp.setempdeactivatedsince(rs.getDate(21));
                emp.setempdeactivatedreason(rs.getString(22));
                emp.setempcity(rs.getInt(23));
                emp.setempprofession(rs.getInt(24));
                emp.setempbranch(rs.getInt(25));
           
              
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
        return emp;
    }
      
      
         public void updateEmployee(Employee e) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());

            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
           pstmt = con.prepareStatement("Update Employee SET emp_firstname=?,emp_lastname=?,emp_gender=?,emp_workphone=?,emp_workext=?,emp_workfax=?,emp_workemail=? WHERE emp_id=?And emp_ssn=?");
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
            System.err.println("Caught Exception: " + ex.getMessage());
        } 
        finally {
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
