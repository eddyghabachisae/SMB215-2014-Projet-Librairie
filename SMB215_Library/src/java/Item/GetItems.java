/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Item;

import com.google.zxing.WriterException;
import java.io.File;
import java.io.IOException;
import static java.security.AccessController.getContext;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Douha
 */
@WebServlet(name = "GetItems", urlPatterns = {"/GetItems"})
public class GetItems extends HttpServlet {

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
            throws ServletException, IOException, WriterException {
        ItemBean itemBean = new ItemBean();
        List<Item> itemsList = itemBean.getItems();
        request.setAttribute("itemsList", itemsList);
        int listSize= itemsList.size();
        request.getRequestDispatcher("Item/manage.jsp?listSize="+listSize).forward(request, response);
   
        }
  
    
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (WriterException ex) {
            Logger.getLogger(GetItems.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (WriterException ex) {
            Logger.getLogger(GetItems.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    }

    


