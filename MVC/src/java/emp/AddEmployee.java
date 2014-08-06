package emp;

import java.io.IOException;
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
        emp.setEmpId(Integer.parseInt(request.getParameter("empId")));
        emp.setEmpName(request.getParameter("empName"));
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
