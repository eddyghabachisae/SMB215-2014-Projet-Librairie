package supplierbranch;

import city.City;
import city.CityBean;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetSupplierBranch", urlPatterns = {"/GetSupplierBranch"})
public class GetSupplierBranch extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CityBean ctyBean = new CityBean();
        List<City> cities = 
                ctyBean.getCities();
        request.setAttribute("cities", cities);
        if (request.getParameter("id") != null) {
//            SupplierBranchBean sbrBean = new SupplierBranchBean();
//            SupplierBranch sbr = sbrBean.getSupplierBranch(Integer.valueOf(request.getParameter("id")));
//            response.sendRedirect("supplier/editSupplier.jsp?"
//                    + "id=" + sup.getId()
//                    + "&name=" + sup.getName()
//                    + "&website=" + sup.getWebsite()
//                    + "&remarks=" + sup.getRemarks()
//                    + "&isactive=" + sup.getIsactive()
//                    + "&deactivationreason=" + ((sup.getIsactive() == false) ? sup.getDeactivationreason() : ""));
        } else {
            request.getRequestDispatcher("supplierBranch/editSupplierBranch.jsp?id=&supplier="+request.getParameter("supplier")+"&name=&contactname=&city=&address=&phone=&fax=&mobile=&email=&remarks=&isactive=&deactivationreason=").forward(request, response);
       //     response.sendRedirect("supplierBranch/editSupplierBranch.jsp?id=&supplier="+request.getParameter("supplier")+"&name=&contactname=&city=&address=&phone=&fax=&mobile=&email=&remarks=&isactive=&deactivationreason=");
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
