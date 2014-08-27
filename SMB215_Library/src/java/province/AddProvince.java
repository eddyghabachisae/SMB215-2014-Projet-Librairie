package province;

import province.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddProvince", urlPatterns = {"/AddProvince"})
public class AddProvince extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Province cit = new Province();
        cit.setShortName(request.getParameter("txtProvinceShortName"));
        cit.setName(request.getParameter("txtProvinceName"));
        ProvinceBean citBean = new ProvinceBean();
        citBean.addProvince(cit);
        response.sendRedirect("province/editProvince.jsp");
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
