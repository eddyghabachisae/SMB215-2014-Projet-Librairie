/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetEmployee", urlPatterns = {"/GetEmployee"})
public class GetEmployee extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != null){
            EmployeeBean empBean = new EmployeeBean();
            Employee emp = empBean.getEmployees(Integer.valueOf(request.getParameter("empid")));
            response.sendRedirect("Employees/editEmployee.jsp?" 
                    +"id=" + emp.getempid()
                    +"&ssn=" + emp.getempssn() 
                    +"&username=" + emp.getempusername()
                     +"&password=" + emp.getemppassword()                
                     +"&firstname=" + emp.getempfirstname()
                    +"&lastname=" + emp.getemplastname() 
                    +"&gender=" + emp.getempgender()
                     +"&maritalstatus=" + emp.getempmaritalstatus()
                    +"&dateofbirth=" + emp.getempdateofbirth() 
                    +"&city=" + emp.getempcity() 
                     +"address=" + emp.getempaddress()
                    +"&phomephone=" + emp.getemphomephone() 
                    +"&mobile=" + emp.getempmobile()
                     +"&personalemail=" + emp.getemppersonalemail()                
                     +"&workphone=" + emp.getempworkphone()
                    +"&workext=" + emp.getempworkext()
                    +"&workfax=" + emp.getempworkfax() 
                    +"&workemail=" + emp.getempworkemail()
                     +"&profession=" + emp.getempprofession()                
                     +"&remarks=" + emp.getempremarks()
                    +"&branch=" + emp.getempbranch() 
                    +"&isactive=" + emp.getempisactive()
                     +"&activesinces=" + emp.getempactivesince()
                    +"&deactivatedsince=" + emp.getempdeactivatedsince() 
                     +"&deactivatedreason=" + emp.getempdeactivatedreason()
            );                      
                          
        } else {
               response.sendRedirect("GetEmployees/editEmployee.jsp?empid=&empssn=&empusername=&emppassword=&empfirstname=&emplastname=&empgender=&empmaritalstatus=&empdateofbirth=&empcity=&empaddress"
                 + "=&emphomephone=&empmobile=&emppersonalemail=&empworkphone=&empworkext=&empworkfax=&empworkemail=&empprofession=&empremarks"
                   + "=&empbranch=&empisactive=&empactivesince=&empdeactivatedsince=&empdeactivatedreason");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
