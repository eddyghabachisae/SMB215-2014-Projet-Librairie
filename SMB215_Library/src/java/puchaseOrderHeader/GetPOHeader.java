/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puchaseOrderHeader;
import branch.Branch;
import branch.BranchBean;
import supplier.Supplier;
import supplier.SupplierBean;
import supplierbranch.SupplierBranch;
import supplierbranch.SupplierBranchBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eddy
 */
@WebServlet(name = "GetPOHeader", urlPatterns = {"/GetPOHeader"})
public class GetPOHeader extends HttpServlet {

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
        POHeaderBean pohBean = new POHeaderBean();
        BranchBean brhBean = new BranchBean();
       List<Branch> branches =brhBean.getBranchesList();
       request.setAttribute("branches", branches);
       SupplierBean supBean = new SupplierBean();
       List<Supplier> suppliers = supBean.getSuppliers();
       request.setAttribute("suppliers", suppliers);
              SupplierBranchBean sbrBean = new SupplierBranchBean();
       List<SupplierBranch> supplierbranches = sbrBean.getSupplierBranchesList();
       request.setAttribute("supplierbranches", supplierbranches);
        request.getRequestDispatcher("purchaseOrderHeader/editPOHeader.jsp?branch=&supplier=&supplierbranch=&orderdate=&shippingdate=&deliverydate=").forward(request, response);
        
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
