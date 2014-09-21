/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supplierBranchItem;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eddy
 */
@WebServlet(name = "SaveSupplierBranchItem", urlPatterns = {"/SaveSupplierBranchItem"})
public class SaveSupplierBranchItem extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      SupplierBranchItem spi = new SupplierBranchItem();
        spi.setPrice(Float.parseFloat(request.getParameter("price")));
        spi.setShippingdays(Integer.parseInt(request.getParameter("shippingdays")));
        spi.setItem(Long.parseLong(request.getParameter("selecteditem")));
        spi.setSupplierbranch(Long.parseLong(request.getParameter("supplierbranchid")));
        SupplierBranchItemBean spiBean = new SupplierBranchItemBean();
        if (!request.getParameter("id").equals("")) {
            spi.setId(Integer.parseInt(request.getParameter("id")));
            spiBean.modifySupplierBranchItem(spi);
            response.sendRedirect("GetSupplierBranchItems?id="+request.getParameter("supplierbranchid")+
                    "&supplierbranchname="+request.getParameter("supplierbranchname"));
        } else {
            spiBean.addSupplierBranchItem(spi);
            response.sendRedirect("GetSupplierBranchItem?supplierbranchid="+request.getParameter("supplierbranchid")+
                    "&supplierbranchname="+request.getParameter("supplierbranchname"));
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
