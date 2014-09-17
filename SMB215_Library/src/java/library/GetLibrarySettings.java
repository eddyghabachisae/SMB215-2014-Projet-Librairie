package library;

import branch.Branch;
import branch.BranchBean;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetLibrarySettings", urlPatterns = {"/GetLibrarySettings"})
public class GetLibrarySettings extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       LibraryBean libBean = new LibraryBean();
       Library lib = new Library();
       libBean.getLibrary(lib);
       BranchBean brhBean = new BranchBean();
       List<Branch> branches =brhBean.getBranchesList();
       request.setAttribute("branches", branches);
       if (lib.getId() == 0) {
           request.getRequestDispatcher("library/editSettings.jsp?id=&name=&mainbranch=&website=&rentaldays=&reservationdays=&maxreserve=&rentalalert=&reservationalert=&maincurrency=&secondarycurrency=&secondarycurrencyrate=").forward(request, response);
       } else {
       request.getRequestDispatcher("library/editSettings.jsp?"
               + "id="+lib.getId() 
       + "&name="+lib.getName()
       + "&mainbranch="+lib.getMainBranch()
       + "&website="+lib.getWebsite()
       + "&rentaldays="+lib.getRentalDays()
       + "&reservationdays="+lib.getReservationDays()
       + "&maxreserve="+lib.getMaxReserve()
       + "&reservationalert="+lib.getReservationAlert()
       + "&rentalalert="+lib.getRentalAlert()
       + "&maincurrency="+lib.getMainCurrency()
       + "&secondarycurrency="+lib.getSecondaryCurrency()
       + "&secondarycurrencyrate="+lib.getSecondaryCurrencyRate()).forward(request, response);
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
