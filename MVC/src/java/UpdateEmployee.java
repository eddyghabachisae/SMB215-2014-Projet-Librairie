

package emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateEmployee", urlPatterns = {"/UpdateEmployee"})
public class UpdateEmployee extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Employee emp = new Employee();
        //emp.setempid(Integer.parseInt(request.getParameter("empid")));
        emp.setempssn(Integer.parseInt(request.getParameter("empssn")));
        emp.setempfirstname(request.getParameter("empfirstname"));
        emp.setemplastname(request.getParameter("emplastname"));
        emp.setempgender(Boolean.getBoolean(request.getParameter("empgender")));
        emp.setempworkphone(request.getParameter("empworkphone"));
        emp.setempworkext(Integer.parseInt (request.getParameter("empworkext")));
        emp.setempworkfax(request.getParameter("empworkfax"));
        emp.setempworkemail(request.getParameter("empworkemail"));
        EmployeeBean eb = new EmployeeBean();
        eb.updateEmployee(emp);
        response.sendRedirect("viewEmployees.jsp");       
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