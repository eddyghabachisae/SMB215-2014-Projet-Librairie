/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BookCategory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Douha
 */
@WebServlet(name = "SaveBookCategory", urlPatterns = {"/SaveBookCategory"})
public class SaveBookCategory extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookCategory bookCat = new BookCategory();
        bookCat.setCode(request.getParameter("code"));
        bookCat.setDescription(request.getParameter("description"));
        BookCategoryBean bookCatBean = new BookCategoryBean();
        
   
        if (!request.getParameter("id").equals("")) {
            System.err.println("fet 3al ifff");
            bookCat.setId(Long.parseLong(request.getParameter("id")));
            bookCatBean.modifyBookCategory(bookCat);
            response.sendRedirect("GetBookCategories");
            
        } else {
            System.err.println("fet 3al elseee");
            bookCatBean.addBookCategory(bookCat);
            response.sendRedirect("GetBookCategories");
        }
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
