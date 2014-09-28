/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RentHeader;

import BookStatus.BookStatus;
import BookStatus.BookStatusBean;
import Employee.Employee;
import Employee.EmployeeBean;
import RentDetails.RentDetails;
import RentDetails.RentDetailsBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.Library;
import library.LibraryBean;
import utils.Utils;

/**
 *
 * @author Douha
 */
@WebServlet(name = "ReturnBook", urlPatterns = {"/ReturnBook"})
public class ReturnBook extends HttpServlet {

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
            String id = request.getParameter("id");
            if(id!=null && id.equals("")==false){
                Date returnDate = Utils.getNowDateTime();
                java.sql.Date sqlDate = new java.sql.Date(returnDate.getTime());
                RentDetailsBean detailsBean = new RentDetailsBean();
                RentDetails rentDetails = detailsBean.getRentDetails(Long.parseLong(id));
                rentDetails.setReturnedDate(sqlDate);
                detailsBean.modifyRentDetails(rentDetails);
                EmployeeBean employeeBean = new EmployeeBean();
                Employee employee = employeeBean.getEmployees(Integer.parseInt(request.getParameter("employee")));
                BookStatusBean booksStatusBean = new BookStatusBean();
                BookStatus bookStatus = booksStatusBean.getBookStatusByBranch(rentDetails.getBook_id(), employee.getempbranch());
                System.err.println(bookStatus.toString());
                int reservedCopies = bookStatus.getReservedCopies() - 1;
                bookStatus.setReservedCopies(reservedCopies);
                System.err.println(bookStatus.toString());
                booksStatusBean.modifyResevredCopies(bookStatus);
                
            RentHeaderBean rentHeaderBean = new RentHeaderBean();
            RentHeader rentHeader = rentHeaderBean.getRentHeader(rentDetails.getRentHeader_id());
            Date date1 = rentHeader.getSubmitDate();
            Date date2 = Utils.getNowDateTime();
            long daysDifference = Utils.getDifferenceBetween(date1, date2);
            RentDetailsBean rentDetailsBean = new RentDetailsBean();
            List<RentDetails> rentDetailsList = rentDetailsBean.getRentDetailss(rentHeader.getId());
            request.setAttribute("rentDetailsList", rentDetailsList);
            LibraryBean libraryBean = new LibraryBean();
            Library library = libraryBean.getLibrary();
            String currency = "";
            long rentalDays =0;
            if(library!=null){
             currency = library.getMainCurrency();
             rentalDays = library.getRentalDays();
            }
            boolean isLate = false;
            if(daysDifference > rentalDays)
                isLate = true;
             boolean allReturned = false;
            for(RentDetails rd:rentDetailsList){
                if(rd.getReturnedDate()!=null)
                    allReturned=true;
                else
                    allReturned = false;
            }
            if(allReturned ==true)
                isLate =false;
            long lateDays =daysDifference- rentalDays;
             request.getRequestDispatcher("RentHeader/viewDetails.jsp?"
                     +"total="+rentHeader.getTotal()
                     +"&customer="+rentHeader.getCutomerName()
                     +"&currency="+currency
                     +"&orderDate="+rentHeader.getSubmitDate()
                     +"&isLate="+isLate
                     +"&lateDays="+lateDays).forward(request, response);
         
                
                
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
