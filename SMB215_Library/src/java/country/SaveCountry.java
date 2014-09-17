package country;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SaveCountry", urlPatterns = {"/SaveCountry"})
public class SaveCountry extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Country cnt = new Country();
        cnt.setCode(request.getParameter("code"));
       cnt.setName(request.getParameter("name"));
        CountryBean cntBean = new CountryBean();
        if (!request.getParameter("id").equals("")) {
            cnt.setId(Integer.parseInt(request.getParameter("id")));
            cntBean.modifyCountry(cnt);
            response.sendRedirect("GetCountries");
        } else {
            cntBean.addCountry(cnt);
            response.sendRedirect("GetCountry");
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
