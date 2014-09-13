package itemCategory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetItemCategory", urlPatterns = {"/GetItemCategory"})
public class GetItemCategory extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != null){
            ItemCategoryBean itcBean = new ItemCategoryBean();
            ItemCategory itc = itcBean.getItemCategory(Integer.valueOf(request.getParameter("id")));
            response.sendRedirect("itemCategory/editItemCategory.jsp?" 
                    +"id=" + itc.getId()
                    +"&code=" + itc.getCode() 
                    +"&description=" + itc.getDescription());
        } else {
               response.sendRedirect("itemCategory/editItemCategory.jsp?id=&code=&description=");
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
