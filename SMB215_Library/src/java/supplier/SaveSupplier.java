package supplier;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SaveSupplier", urlPatterns = {"/SaveSupplier"})
public class SaveSupplier extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Supplier sup = new Supplier();
        sup.setName(request.getParameter("name"));
        sup.setWebsite(request.getParameter("website"));
        sup.setRemarks(request.getParameter("remarks"));
        sup.setIsactive(request.getParameter("isactive").equals("true"));
        sup.setDeactivationreason(request.getParameter("deactivationreason"));
        SupplierBean supBean = new SupplierBean();
        if (!request.getParameter("id").equals("")) {
            sup.setId(Integer.parseInt(request.getParameter("id")));
            supBean.modifySupplier(sup);
            response.sendRedirect("GetSuppliers");
        } else {
            supBean.addSupplier(sup);
            response.sendRedirect("GetSupplier");
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
