package supplierbranch;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SaveSupplierBranch", urlPatterns = {"/SaveSupplierBranch"})
public class SaveSupplierBranch extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       SupplierBranch sbr = new SupplierBranch();
        sbr.setName(request.getParameter("name"));
        sbr.setContactname(request.getParameter("contactname"));
        sbr.setCity(Integer.parseInt(request.getParameter("selectedcity")));
        sbr.setAddress(request.getParameter("address"));
        sbr.setPhone(request.getParameter("phone"));
        sbr.setFax(request.getParameter("fax"));
        sbr.setMobile(request.getParameter("mobile"));
        sbr.setEmail(request.getParameter("email"));
        sbr.setRemarks(request.getParameter("remarks"));
        if (request.getParameter("isactive")!= null){
        sbr.setIsactive(request.getParameter("isactive").equals("on"));
        } else {
            sbr.setIsactive(false);
        }
        sbr.setDeactivationreason(request.getParameter("deactivationreason"));
        sbr.setSupplier(Integer.parseInt(request.getParameter("supplier")));
        SupplierBranchBean sbrBean = new SupplierBranchBean();
        if (!request.getParameter("id").equals("")) {
            sbr.setId(Integer.parseInt(request.getParameter("id")));
            sbrBean.modifySupplierBranch(sbr);
            response.sendRedirect("GetSupplierBranches?id="+request.getParameter("supplier")+
                    "&suppliername="+request.getParameter("suppliername"));
        } else {
            sbrBean.addSupplierBranch(sbr);
            response.sendRedirect("GetSupplierBranch?supplier="+request.getParameter("supplier")+
                    "&suppliername="+request.getParameter("suppliername"));
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
