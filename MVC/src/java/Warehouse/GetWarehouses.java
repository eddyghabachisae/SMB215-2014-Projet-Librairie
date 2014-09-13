

package Warehouse;


import Warehouse.Warehouse;
import Warehouse.WarehouseBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetWarehouses", urlPatterns = {"/GetWarehouses"})
public class GetWarehouses extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        WarehouseBean wrsBean = new WarehouseBean();
        List<Warehouse> Warehouses = wrsBean.getWarehouses();
        request.setAttribute("Warehouses", Warehouses);
        request.getRequestDispatcher("Warehouse/viewWarehouse.jsp").forward(request, response);
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
