package BookCategory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetBookCategory", urlPatterns = {"/GetBookCategory"})
public class GetBookCategory extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != null){
            BookCategoryBean bookCatBean = new BookCategoryBean();
            BookCategory bookCat = bookCatBean.getBookCategory(Integer.valueOf(request.getParameter("id")));
            request.getRequestDispatcher("BookCategory/bookCategoryForm.jsp?" 
                     +"id=" + bookCat.getId()
                     +"&code=" + bookCat.getCode()
                     +"&description=" + bookCat.getDescription()).forward(request, response);
        } else {
            request.getRequestDispatcher("BookCategory/bookCategoryForm.jsp?" 
                     +"id=&code=&description=").forward(request, response);
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
