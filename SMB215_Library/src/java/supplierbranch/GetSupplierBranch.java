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
        //CityBean ctyBean = new CityBean();
        //List<City> cities = 
                //ctyBean.getCities();
        //request.setAttribute("cities", cities);
        if (request.getParameter("id") != null) {
            SupplierBranchBean sbrBean = new SupplierBranchBean();
            SupplierBranch sbr = sbrBean.getSupplierBranch(Integer.valueOf(request.getParameter("id")));
            response.sendRedirect("supplierBranch/editSupplierBranch.jsp?"
                    + "id=" + sbr.getId()
                    + "&name=" + sbr.getName()
                    + "&contactname=" + sbr.getContactname()
                    + "&phone=" + sbr.getPhone()
                    + "&fax=" + sbr.getFax()
                    + "&mobile=" + sbr.getMobile()
                    + "&email=" + sbr.getEmail()
                    + "&remarks=" + sbr.getRemarks()
                    + "&isactive=" + sbr.getIsactive()
                    + "&deactivationreason=" + ((sbr.getIsactive() == false) ? sbr.getDeactivationreason() : "")
                    + "&city=" + sbr.getCity()
                    + "&supplier=" + sbr.getSupplier()
                    + "&suppliername=" + request.getParameter("suppliername"));
        } else {
            request.getRequestDispatcher("supplierBranch/editSupplierBranch.jsp?id=&supplier="+request.getParameter("suppliername")+"&name=&contactname=&city=&address=&phone=&fax=&mobile=&email=&remarks=&isactive=&deactivationreason=").forward(request, response);
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
