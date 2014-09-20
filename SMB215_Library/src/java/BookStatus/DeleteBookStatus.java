package BookCategory;

import BookStatus.BookStatusBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteBookStatus", urlPatterns = {"/DeleteBookStatus"})
public class DeleteBookStatus extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        BookStatusBean bookStatusBean = new BookStatusBean();
        long book_id= bookStatusBean.getBookStatus(id).getBook_id();
        bookStatusBean.deleteBookStatus(id);
        response.sendRedirect("GetBookStatus?book_id="+book_id);
        
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
