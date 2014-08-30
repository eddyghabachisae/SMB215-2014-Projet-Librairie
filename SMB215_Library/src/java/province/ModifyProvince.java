package province;


import province.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ModifyProvince", urlPatterns = {"/ModifyProvince"})
public class ModifyProvince extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Province cit = new Province();
        cit.setId(Integer.parseInt(request.getParameter("txtProvinceId")));
        cit.setShortName(request.getParameter("txtProvinceShortName"));
        cit.setName(request.getParameter("txtProvinceName"));
        ProvinceBean citBean = new ProvinceBean();
        citBean.modifyProvince(cit);
        response.sendRedirect("province/viewProvince.jsp");
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
