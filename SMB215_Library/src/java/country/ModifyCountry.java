package country;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ModifyCountry", urlPatterns = {"/ModifyCountry"})
public class ModifyCountry extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Country cnt = new Country();
        cnt.setId(Integer.parseInt(request.getParameter("txtCountryId")));
        cnt.setShortName(request.getParameter("txtCountryShortName"));
        cnt.setName(request.getParameter("txtCountryName"));
        CountryBean cntBean = new CountryBean();
        cntBean.modifyCountry(cnt);
        response.sendRedirect("country/viewCountry.jsp");
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
