/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emplo;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddEmployee", urlPatterns = {"/AddEmployee"})
public class AddEmployee extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Employee emp = new Employee();
//        emp.setempid(Integer.parseInt(request.getParameter("empid")));
        emp.setempssn(Integer.parseInt(request.getParameter("empssn")));
        emp.setempusername(request.getParameter("empusername"));
        emp.setemppassword(request.getParameter("emppassword"));
        emp.setempfirstname(request.getParameter("empfirstname"));
        emp.setemplastname(request.getParameter("emplastname"));
        emp.setempgender(Boolean.getBoolean(request.getParameter("empgender")));
        emp.setempmaritalstatus(Boolean.getBoolean(request.getParameter("empmaritalstatus")));
        emp.setempdateofbirth(new Date(request.getParameter("empdateofbirth")));  
        emp.setempcity(Integer.parseInt(request.getParameter("empcity")));
        emp.setempaddress(request.getParameter("empaddress"));
        emp.setemphomephone(request.getParameter("empworkphone"));
        emp.setempmobile(request.getParameter("empmobile"));
        emp.setemppersonalemail(request.getParameter("emppersonalemail"));
        emp.setempworkphone(request.getParameter("empworkphone"));
        emp.setempworkext(Integer.parseInt(request.getParameter("empworkext")));
        emp.setempworkfax(request.getParameter("empworkfax"));
        emp.setempworkemail(request.getParameter("empworkemail"));
        emp.setempprofession(Integer.parseInt(request.getParameter("empprofession")));
        emp.setempremarks(request.getParameter("empremarks"));
        emp.setempbranch(Integer.parseInt(request.getParameter("empbranch")));
        emp.setempisactive(Boolean.getBoolean(request.getParameter("empisactive")));
     
        emp.setempdeactivatedsince(new Date(request.getParameter("empdeactivatedsince")));
        emp.setempdeactivatedreason(request.getParameter("empdeactivatedreason"));
        
                                               
                                            
        EmployeeBean eb = new EmployeeBean();
        eb.addEmployee(emp);
        response.sendRedirect("addEmployee.jsp");
 
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
