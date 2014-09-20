

package Emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SaveEmployee", urlPatterns = {"/SaveEmployee"})
public class SaveEmployee extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Employee emp = new Employee();
        emp.setempssn(Integer.parseInt(request.getParameter("empssn")));
        emp.setempusername(request.getParameter("empusername"));
        emp.setemppassword(request.getParameter("emppassword"));
        emp.setempfirstname(request.getParameter("empfirstname"));
        emp.setemplastname(request.getParameter("emplastname"));
        emp.setempgender(Boolean.getBoolean(request.getParameter("empgender")));
        emp.setempmaritalstatus(Boolean.getBoolean(request.getParameter("empmaritalstatus")));
        emp.setempdateofbirth(new java.sql.Date(emp.getempdateofbirth().getDate()));
        emp.setempcity(Integer.parseInt(request.getParameter("empcity")));
        emp.setempaddress(request.getParameter("empaddress"));
        emp.setemphomephone(request.getParameter("emphomephone"));
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
        emp.setempactivesince(new java.sql.Date(emp.getempactivesince().getDate()));            
        emp.setempdeactivatedsince(new java.sql.Date(emp.getempdeactivatedsince().getDate()));                 
        emp.setempdeactivatedreason(request.getParameter("empdeactivatedreason"));  
                        
               
        EmployeeBean empBean = new EmployeeBean();
        if (!request.getParameter("empid").equals("")) {
            emp.setempid(Integer.parseInt(request.getParameter("empid")));
            empBean.updateEmployee(emp);
            response.sendRedirect("GetEmployees");
        } else {
           empBean.addEmployee(emp);
            response.sendRedirect("GetEmployee");
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
