package Item;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SaveItem", urlPatterns = {"/SaveItem"})
public class SaveItem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Item item = new Item();
        item.setName(request.getParameter("name"));
        item.setDescription(request.getParameter("description"));
        item.setAvgUnitCost(Double.parseDouble(request.getParameter("avgCost")));
        item.setSaleRentPrice(Double.parseDouble(request.getParameter("saleRentPrice")));
        item.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        item.setMinLimit(Integer.parseInt(request.getParameter("minLimit")));
        item.setMaxLimit(Integer.parseInt(request.getParameter("maxLimit")));
        item.setIsAvailable(Boolean.parseBoolean(request.getParameter("available")));
        item.setIsActive(Boolean.parseBoolean(request.getParameter("active")));
        item.setItemCategory_id(Long.parseLong(request.getParameter("category")));
        ItemBean itemBean = new ItemBean();
        if (!request.getParameter("id").equals("")) {
            item.setId(Integer.parseInt(request.getParameter("id")));
            itemBean.modifyItem(item);
            response.sendRedirect("GetItems");
        } else {
            itemBean.addItem(item);
            response.sendRedirect("GetItems");
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
