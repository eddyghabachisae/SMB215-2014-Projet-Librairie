package Item;

import Book.Book;
import Book.BookBean;
import BookStatus.BookStatus;
import BookStatus.BookStatusBean;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteItem", urlPatterns = {"/DeleteItem"})
public class DeleteItem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BookBean bookBean = new BookBean();
        Book book= bookBean.getBookFormItem(id);
        if(book!=null){
            BookStatusBean statusBean = new BookStatusBean();
            List<BookStatus> bookStatusList = statusBean.getBookStatuss(book.getId());
            for(BookStatus bs:bookStatusList){
                statusBean.deleteBookStatus(bs.getId());
            }
            bookBean.deleteBook(book.getId());
        }
        ItemBean itemBean = new ItemBean();
        itemBean.deleteItem(id);
        response.sendRedirect("GetItems");
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
