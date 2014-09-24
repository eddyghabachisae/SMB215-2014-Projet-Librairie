/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package purchaseOrderDetail;

import Item.Item;
import Item.ItemBean;
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
@WebServlet(name = "GetPODetail", urlPatterns = {"/GetPODetail"})
public class GetPODetail extends HttpServlet {

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
        ItemBean itmBean = new ItemBean();
       List<Item> items = itmBean.getItemsByPOH(Long.parseLong(request.getParameter("pohid")));
       request.setAttribute("items", items);
       if (request.getParameter("id") != null){
          PODetailBean podBean = new PODetailBean();
          PODetail pod = podBean.getPODetail(Long.parseLong(request.getParameter("id")));
          request.getRequestDispatcher("purchaseOrderDetail/editPODetail.jsp?" 
                    +"id=" + pod.getId()
                    +"&quantity=" + pod.getQuantity() 
                    +"&unitcost=" + pod.getUnitcost()
                    +"&item=" + pod.getItem()
                    +"&pohid=" + pod.getPohid()
                    +"&branch=" + request.getParameter("branch")
                    +"&supplierbranch=" + request.getParameter("supplierbranch")).forward(request,response); 
       } else {
           request.getRequestDispatcher("purchaseOrderDetail/editPODetail.jsp?"
                 + "id=&quantity=&unitcost=").forward(request,response); 
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
