/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RentHeader;


import Book.Book;
import Book.BookBean;
import BookStatus.BookStatus;
import BookStatus.BookStatusBean;
import Employee.Employee;
import Employee.EmployeeBean;
import RentDetails.RentDetails;
import RentDetails.RentDetailsBean;
import java.io.IOException;
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
@WebServlet(name = "SaveRentHeader", urlPatterns = {"/SaveRentHeader"})
public class SaveRentHeader extends HttpServlet {

 
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
        System.err.print("user idd"+request.getParameter("employee"));
        String [] selectedBook = request.getParameterValues("selectedBooks");
        BookBean bookBean = new BookBean();
        double totalPrice = 0;
        RentHeaderBean rentHeaderBean = new RentHeaderBean();
        RentHeader rentHeader =new RentHeader();
        rentHeader.setCustomer_id(Long.parseLong(request.getParameter("selectedCustomer")));
        rentHeader.setEmployee_id(Long.parseLong(request.getParameter("employee")));
        EmployeeBean employeeBean = new EmployeeBean();
        Employee employee = employeeBean.getEmployees(Integer.parseInt(request.getParameter("employee")));
        //System.err.print(employee.toString());
        rentHeader.setBranch_id(employee.getempbranch());
        java.util.Date date = Utils.getNowDateTime();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        rentHeader.setSubmitDate(sqlDate);
        long rentHeaderId = rentHeaderBean.addRentHeader(rentHeader);
        rentHeader= rentHeaderBean.getRentHeader(rentHeaderId);
        RentDetailsBean rentDetailsBean = new RentDetailsBean();
        for(int i=0;i<selectedBook.length;i++){
          Book book = new Book();
          book = bookBean.getBook(Long.parseLong(selectedBook[i]));
          BookStatusBean booksStatusBean = new BookStatusBean();
          System.err.println("employee branch"+employee.getempbranch());
          BookStatus bookStatus = booksStatusBean.getBookStatusByBranch(Long.parseLong(selectedBook[i]), employee.getempbranch());
          System.err.println(bookStatus.toString());
          int reservedCopies = bookStatus.getReservedCopies() +1;
          bookStatus.setReservedCopies(reservedCopies);
          System.err.println(bookStatus.toString());
          booksStatusBean.modifyResevredCopies(bookStatus);
          totalPrice+= book.getRentPrice();
          RentDetails rentDetail = new RentDetails();
          rentDetail.setBook_id(Long.parseLong(selectedBook[i]));
          rentDetail.setRentHeader_id(rentHeaderId);
          rentDetailsBean.addRentDetails(rentDetail);
        }
        rentHeader.setTotal(totalPrice);
        rentHeaderBean.modifyRentHeader(rentHeader);
        response.sendRedirect("GetRentHeaders");
       
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
