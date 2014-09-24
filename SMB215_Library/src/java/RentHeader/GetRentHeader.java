package RentHeader;


import RentDetails.RentDetails;
import RentDetails.RentDetailsBean;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.Library;
import library.LibraryBean;

@WebServlet(name = "GetRentHeader", urlPatterns = {"/GetRentHeader"})
public class GetRentHeader extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != null && !request.getParameter("id").equals("") && !request.getParameter("id").equals("0")){
            RentHeaderBean rentHeaderBean = new RentHeaderBean();
            RentHeader rentHeader = rentHeaderBean.getRentHeader(Long.parseLong(request.getParameter("id")));
            RentDetailsBean rentDetailsBean = new RentDetailsBean();
            List<RentDetails> rentDetailsList = rentDetailsBean.getRentDetailss(rentHeader.getId());
            request.setAttribute("rentDetailsList", rentDetailsList);
            LibraryBean libraryBean = new LibraryBean();
            Library library = libraryBean.getLibrary();
            String currency = "";
            if(library!=null){
             currency = library.getMainCurrency();
            }
             request.getRequestDispatcher("RentHeader/viewDetails.jsp?"
                     +"total="+rentHeader.getTotal()
                     +"&customer="+rentHeader.getCutomerName()
                     +"&currency="+currency
                     +"&orderDate="+rentHeader.getSubmitDate()).forward(request, response);
        }

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
