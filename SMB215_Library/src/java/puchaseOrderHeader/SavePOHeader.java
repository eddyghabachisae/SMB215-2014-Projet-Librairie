/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puchaseOrderHeader;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Utils;

/**
 *
 * @author eddy
 */
@WebServlet(name = "SavePOHeader", urlPatterns = {"/SavePOHeader"})
public class SavePOHeader extends HttpServlet {

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
        POHeader poh = new POHeader();
        poh.setBranch(Long.parseLong(request.getParameter("branch")));
        poh.setSupplierbranch(Long.parseLong(request.getParameter("supplierbranch")));

        if ((request.getParameter("orderdate") != null) && !(request.getParameter("orderdate").equals(""))) {
            String orderdateformat = request.getParameter("orderdate").substring(3, 5) + "/"
                    + request.getParameter("orderdate").substring(0, 2) + "/"
                    + request.getParameter("orderdate").substring(6, 10);

            java.util.Date orderdate = null;
            try {
                orderdate = Utils.getDateFromString(orderdateformat);
            } catch (ParseException ex) {
                Logger.getLogger(SavePOHeader.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (orderdate != null) {
                java.sql.Date sqlDate = new java.sql.Date(orderdate.getTime());
                poh.setOrderdate(sqlDate);
            }
        }

        if ((request.getParameter("shippingdate") != null) && !(request.getParameter("shippingdate").equals(""))) {
            String shippingdateformat = request.getParameter("shippingdate").substring(3, 5) + "/"
                    + request.getParameter("shippingdate").substring(0, 2) + "/"
                    + request.getParameter("shippingdate").substring(6, 10);

            java.util.Date shippingdate = null;
            try {
                shippingdate = Utils.getDateFromString(shippingdateformat);
            } catch (ParseException ex) {
                Logger.getLogger(SavePOHeader.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (shippingdate != null) {
                java.sql.Date sqlDate = new java.sql.Date(shippingdate.getTime());
                poh.setShippingdate(sqlDate);
            }
        }
        
                if ((request.getParameter("deliverydate") != null) && !(request.getParameter("deliverydate").equals(""))) {
            String deliverydateformat = request.getParameter("deliverydate").substring(3, 5) + "/"
                    + request.getParameter("deliverydate").substring(0, 2) + "/"
                    + request.getParameter("deliverydate").substring(6, 10);

            java.util.Date deliverydate = null;
            try {
                deliverydate = Utils.getDateFromString(deliverydateformat);
            } catch (ParseException ex) {
                Logger.getLogger(SavePOHeader.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (deliverydate != null) {
                java.sql.Date sqlDate = new java.sql.Date(deliverydate.getTime());
                poh.setDeliverydate(sqlDate);
            }
        }

        poh.setEmployee(Long.parseLong(request.getParameter("employee")));
        POHeaderBean pohBean = new POHeaderBean();
        if (!request.getParameter("id").equals("null")) {
            poh.setId(Long.parseLong(request.getParameter("id")));
            pohBean.modifyPOHeader(poh);
            response.sendRedirect("GetPOHeaders");
        } else {
            long id = pohBean.addPOHeader(poh);
            response.sendRedirect("GetPOHeader?mode=edit&id=" + id);
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
