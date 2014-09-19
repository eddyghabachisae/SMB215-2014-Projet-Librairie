package itemCategory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SaveItemCategory", urlPatterns = {"/SaveItemCategory"})
public class SaveItemCategory extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ItemCategory itc = new ItemCategory();
        itc.setCode(request.getParameter("code"));
        itc.setDescription(request.getParameter("description"));
        ItemCategoryBean itcBean = new ItemCategoryBean();
        if (!request.getParameter("id").equals("")) {
            itc.setId(Long.parseLong(request.getParameter("id")));
            itcBean.modifyItemCategory(itc);
            response.sendRedirect("GetItemCategories");
        } else {
            itcBean.addItemCategory(itc);
            response.sendRedirect("GetItemCategories");
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
