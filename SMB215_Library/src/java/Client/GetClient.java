package Client;

import Client.*;
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
            ClientBean cltBean = new ClientBean();
            Client clt = cltBean.getClient(1);

            response.sendRedirect("Client/indexClient.jsp?id=" + clt.getId());
               //     +"&username=" + clt.getUsername() 
                 //   +"&FirstName=" + clt.getFirstname()
                   // +"&LastName=" + clt.getLastname());
        //} else {
         //      response.sendRedirect("Client/indexClient.jsp?id=&username=&FirstName=&LastName=");
        //}
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
