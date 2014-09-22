/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package purchaseOrderDetail;

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
@WebServlet(name = "SavePODetail", urlPatterns = {"/SavePODetail"})
public class SavePODetail extends HttpServlet {

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
        PODetail pod = new PODetail();
        pod.setItem(Long.parseLong(request.getParameter("selecteditem")));
        pod.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        pod.setUnitcost(Float.parseFloat(request.getParameter("unitcost")));
        pod.setPohid(Long.parseLong(request.getParameter("pohid")));
        PODetailBean podBean = new PODetailBean();
        if (!request.getParameter("id").equals("")){
            pod.setId(Integer.parseInt(request.getParameter("id")));
            podBean.modifyPODetail(pod);
            response.sendRedirect("GetPOHeader?id="+request.getParameter("pohid"));
        } else {
            podBean.addPODetail(pod);
            response.sendRedirect("GetPODetail?pohid="+request.getParameter("pohid"));
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
