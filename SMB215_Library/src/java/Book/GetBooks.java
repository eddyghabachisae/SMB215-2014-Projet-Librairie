/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Book;

import Item.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Douha
 */
@WebServlet(name = "GetBooks", urlPatterns = {"/GetBooks"})
public class GetBooks extends HttpServlet {

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
        BookBean bookBean = new BookBean();
        List<Book> tempBooksList = bookBean.getBooks();
        List<Book> booksList = new ArrayList();
        for(Book book:tempBooksList){
            System.err.println(book.getItem().toString());
            boolean isactive =book.getItem().isActive;
            boolean isAvailable =book.getItem().isAvailable;
        if(isactive==true && isAvailable==true){
            booksList.add(book);
        }
        }
        request.setAttribute("booksList", booksList);
        request.getRequestDispatcher("Book/booksList.jsp").forward(request, response);
   
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

    


