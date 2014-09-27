package itemCategory;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetItemCategories", urlPatterns = {"/GetItemCategories"})
public class GetItemCategories extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ItemCategoryBean itcBean = new ItemCategoryBean();
        List<ItemCategory> itemCategories = itcBean.getItemCategories();
        request.setAttribute("itemCategories", itemCategories);
        int listSize= itemCategories.size();
        request.getRequestDispatcher("itemCategory/viewItemCategory.jsp?listSize="+listSize).forward(request, response);
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
