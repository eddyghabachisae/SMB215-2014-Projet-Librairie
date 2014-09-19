package supplierbranch;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "GetSupplierBranches", urlPatterns = {"/GetSupplierBranches"})
public class GetSupplierBranches extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SupplierBranchBean sbrBean = new SupplierBranchBean();
        List<SupplierBranch> supplierBranches = 
                sbrBean.getSupplierBranches(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("supplierBranches", supplierBranches);
        request.getRequestDispatcher("supplierBranch/viewSupplierBranch.jsp"
                + "?supplier="+request.getParameter("id")
                + "&suppliername="+request.getParameter("suppliername")).forward(request, response);
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
