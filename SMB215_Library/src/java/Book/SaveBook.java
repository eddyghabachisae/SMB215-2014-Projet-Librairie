/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Book;

import BookStatus.BookStatus;
import BookStatus.BookStatusBean;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
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
 * @author Douha
 */
@WebServlet(name = "SaveBook", urlPatterns = {"/SaveBook"})
public class SaveBook extends HttpServlet {

    
  
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
        
        Book book = new Book();
        book.setTitle(request.getParameter("title"));
        book.setSubtitle(request.getParameter("subtitle"));
        book.setIsbn(request.getParameter("isbn"));
        book.setPublisher(request.getParameter("publisher"));
        Date publishDate = null;
        try {
            publishDate = Utils.getDateFromString(request.getParameter("publishDate"));
        } catch (ParseException ex) {
            Logger.getLogger(SaveBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(publishDate!=null){
        java.sql.Date sqlDate = new java.sql.Date(publishDate.getTime());
        book.setPublishDate(sqlDate);
        }
        book.setPagesNb(Integer.parseInt(request.getParameter("pagesNb")));
        book.setRentPrice(Double.parseDouble(request.getParameter("rentPrice")));
        book.setLanguage_id(Long.parseLong(request.getParameter("language")));
        book.setBookCategory_id(Long.parseLong(request.getParameter("category")));
        book.setAuthor_id(Long.parseLong(request.getParameter("author")));
        book.setItem_id(Long.parseLong(request.getParameter("item_id")));
        BookStatus bookStatus = new BookStatus();
        bookStatus.setBranch_id(Long.parseLong(request.getParameter("branch")));
        bookStatus.setSection(request.getParameter("section"));
        bookStatus.setShelf(request.getParameter("shelf"));
        BookBean bookBean = new BookBean();
        BookStatusBean bookStatusBean = new BookStatusBean();
        if(!request.getParameter("bookStatus_id").equals("")){
           System.err.println("fet 3al ifff book status");
           bookStatus.setId(Long.parseLong(request.getParameter("bookStatus_id")));
           bookStatusBean.modifyBookStatus(bookStatus);
           book.setBookStatus_id(Long.parseLong(request.getParameter("bookStatus_id")));
        }
        else{
            System.err.println("fet 3al elseee book status");
            long bookStatus_id= bookStatusBean.addBookStatus(bookStatus);
            book.setBookStatus_id(bookStatus_id);
        }
        System.err.println(book.toString());
        System.err.println(bookStatus.toString());
        System.err.println("id bookkk"+request.getParameter("id"));
        if (!request.getParameter("id").equals("")) {
            System.err.println("fet 3al ifff");
            book.setId(Long.parseLong(request.getParameter("id")));
            bookBean.modifyBook(book);
            response.sendRedirect("GetItems");
        } else {
            System.err.println("fet 3al elseee");
            bookBean.addBook(book);
            response.sendRedirect("GetItems");
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
