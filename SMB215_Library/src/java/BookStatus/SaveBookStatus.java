/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BookStatus;

import BookCategory.*;
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
@WebServlet(name = "SaveBookStatus", urlPatterns = {"/SaveBookStatus"})
public class SaveBookStatus extends HttpServlet {

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
        BookStatus bookStatus = new BookStatus();
        bookStatus.setBook_id(Long.parseLong(request.getParameter("book_id")));
        bookStatus.setBranch_id(Long.parseLong(request.getParameter("branch")));
        bookStatus.setSection(request.getParameter("section"));
        bookStatus.setShelf(request.getParameter("shelf"));
        BookStatusBean bookStatusBean = new BookStatusBean();
        
   
        if (!request.getParameter("id").equals("")) {
            System.err.println("fet 3al ifff");
            bookStatus.setId(Long.parseLong(request.getParameter("id")));
            bookStatusBean.modifyBookStatus(bookStatus);
            response.sendRedirect("GetBookStatus?book_id="+bookStatus.getBook_id()+"&id=");
            
        } else {
            System.err.println("fet 3al elseee");
            bookStatusBean.addBookStatus(bookStatus);
            response.sendRedirect("GetBookStatus?book_id="+bookStatus.getBook_id()+"&id=");
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
