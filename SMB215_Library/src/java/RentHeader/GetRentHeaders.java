/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RentHeader;

import RentDetails.RentDetails;
import RentDetails.RentDetailsBean;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
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
@WebServlet(name = "GetRentHeaders", urlPatterns = {"/GetRentHeaders"})
public class GetRentHeaders extends HttpServlet {

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
        RentHeaderBean rentHeaderBean = new RentHeaderBean();
        List<RentHeader> rentHeadersList = rentHeaderBean.getRentHeaders();
        LibraryBean libraryBean = new LibraryBean();
        Library library = libraryBean.getLibrary();
        long rentalDays =0;
        if(library!=null){
         rentalDays = library.getRentalDays();
        }
        HashMap<RentHeader,String> rentHeaderMap = new HashMap<RentHeader,String>();
        for(RentHeader rentHeader: rentHeadersList){
            String msg = "";
            RentDetailsBean bean = new RentDetailsBean();
            List<RentDetails> rentDetailsList =  bean.getRentDetailss(rentHeader.getId());
            Date date1 = rentHeader.getSubmitDate();
            Date date2 = Utils.getNowDateTime();
            long daysDifference = Utils.getDifferenceBetween(date1, date2);
            if(daysDifference < rentalDays){
                msg = "Not Late";
            }
            for(RentDetails rd: rentDetailsList){
            if((rd.getReturnedDate()==null || rd.getReturnedDate().equals("")) && (daysDifference > rentalDays)){
                    msg= "Late";
            }
            if((rd.getReturnedDate()!=null && rd.getReturnedDate().equals("")==false) && (daysDifference > rentalDays)){
                    msg= "Not Late";
            }
            }
            
            rentHeaderMap.put(rentHeader, msg);
            System.err.println("msggg:"+msg);
            }
        request.setAttribute("rentHeaderMap", rentHeaderMap);
        request.setAttribute("rentHeadersList", rentHeadersList);
        int listSize = rentHeadersList.size();
        request.getRequestDispatcher("RentHeader/manage.jsp?listSize="+listSize).forward(request, response);
   
        
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

    


