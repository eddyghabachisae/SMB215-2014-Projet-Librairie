package country;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddCountry", urlPatterns = {"/AddCountry"})
public class AddCountry extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Country cnt = new Country();
        cnt.setShortName(request.getParameter("txtCountryShortName"));
        cnt.setName(request.getParameter("txtCountryName"));
        CountryBean cntBean = new CountryBean();
        cntBean.addCountry(cnt);
        response.sendRedirect("country/editCountry.jsp");
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
