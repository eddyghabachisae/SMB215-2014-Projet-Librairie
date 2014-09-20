
package Profession;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SaveProfession", urlPatterns = {"/SaveProfession"})
public class SaveProfession extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Profession prof = new Profession();
       
        prof.setDescription(request.getParameter("description"));
        ProfessionBean profBean = new ProfessionBean();
        if (!request.getParameter("id").equals("")) {
            prof.setId(Integer.parseInt(request.getParameter("id")));
            profBean.modifyProfession(prof);
            response.sendRedirect("GetProfessions");
        } else {
            profBean.addProfession(prof);
            response.sendRedirect("GetProfession");
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
