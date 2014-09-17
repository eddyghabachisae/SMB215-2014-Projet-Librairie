package library;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SaveLibrary", urlPatterns = {"/SaveLibrary"})
public class SaveLibrary extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Library lib = new Library();
        lib.setName(request.getParameter("name"));
        lib.setMainBranch(Integer.parseInt(request.getParameter("mainbranch_id")));
        lib.setWebsite(request.getParameter("website"));
        lib.setRentalDays(Integer.parseInt(request.getParameter("rentaldays")));
        lib.setReservationDays(Integer.parseInt(request.getParameter("reservationdays")));
        lib.setMaxReserve(Integer.parseInt(request.getParameter("mainreserve")));
        lib.setRentalAlert(Integer.parseInt(request.getParameter("rentalalert")));
        lib.setReservationAlert(Integer.parseInt(request.getParameter("reservationalert")));
        lib.setMainCurrency(request.getParameter("maincurrency"));
        lib.setSecondaryCurrency(request.getParameter("secondarycurrency"));
        lib.setSecondaryCurrencyRate(Float.parseFloat(request.getParameter("secondarycurrencyrate")));
        LibraryBean libBean = new LibraryBean();

        libBean.UpdateLibrary(lib);
        response.sendRedirect("GetLibrarySettings");

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
