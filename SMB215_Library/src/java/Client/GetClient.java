package client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetClient", urlPatterns = {"/GetClient"})
public class GetClient extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != null){
            ClientBean supBean = new ClientBean();
            Client sup = supBean.getClient(Integer.valueOf(request.getParameter("id")));
            response.sendRedirect("client/editClient.jsp?" 
                    +"id=" + sup.getId()
                    +"&name=" + sup.getName() 
                    +"&website=" + sup.getWebsite()
                    +"&remarks=" + sup.getRemarks()
                    +"&isactive=" + sup.getIsactive()
                    +"&deactivationreason=" + ((sup.getIsactive()==false)?sup.getDeactivationreason():""));
        } else {
               response.sendRedirect("client/editClient.jsp?id=&name=&website=&remarks=&isactive=&deactivationreason=");
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
