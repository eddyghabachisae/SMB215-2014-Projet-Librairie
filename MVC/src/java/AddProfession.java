

package Profession;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddProfession", urlPatterns = {"/AddProfession"})
public class AddProfession extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Profession prof = new Profession();
        prof.setId(Integer.parseInt(request.getParameter("id")));
        prof.setDescription(request.getParameter("description"));
        ProfessionBean cntBean = new ProfessionBean();
        cntBean.addProfession(prof);
        
     
        response.sendRedirect("addProfession.jsp");
 
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
