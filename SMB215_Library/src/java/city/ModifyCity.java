package city;

import city.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ModifyCity", urlPatterns = {"/ModifyCity"})
public class ModifyCity extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        City cit = new City();
        cit.setId(Integer.parseInt(request.getParameter("txtCityId")));
        cit.setShortName(request.getParameter("txtCityShortName"));
        cit.setName(request.getParameter("txtCityName"));
        CityBean citBean = new CityBean();
        citBean.modifyCity(cit);
        response.sendRedirect("city/viewCity.jsp");
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
