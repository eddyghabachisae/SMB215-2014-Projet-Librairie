/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RentDetails;

import Item.*;
import Book.Book;
import Book.BookBean;
import customer.Customer;
import customer.CustomerBean;
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
@WebServlet(name = "SaveSelectedBook", urlPatterns = {"/SaveSelectedBook"})
public class SaveSelectedBook extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.err.println("fet 3al get");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String [] selectedBook = request.getParameterValues("selectedBooks");
        List<Book> booksList= new ArrayList();
        BookBean bookBean = new BookBean();
        double totalPrice = 0;
        for(int i=0;i<selectedBook.length;i++){
          Book book = new Book();
          book = bookBean.getBook(Long.parseLong(selectedBook[i]));
          totalPrice+= book.getRentPrice();
          booksList.add(book);
        }
         request.setAttribute("booksList", booksList);
         CustomerBean customerBean = new CustomerBean();
         List<Customer> customersList= customerBean.getCustomers();
         request.setAttribute("customersList", customersList);
        request.getRequestDispatcher("RentHeader/rentHeaderForm.jsp?totalPrice="+totalPrice+"&selectedCustomer=").forward(request, response);
       
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
