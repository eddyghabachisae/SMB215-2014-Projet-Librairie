package Client;

import Client.*;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import main.DBconnection;

@WebServlet(name = "GetClient", urlPatterns = {"/GetClient"})
public class GetClient extends HttpServlet {
    
    


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Client clt = new Client();
            //int id = 1;
            //clt.setId(id);
                        
            ClientBean cltBean = new ClientBean();
            Client clt1 = cltBean.getClient(1);

        
            System.out.println(clt.getId());
            
            response.sendRedirect("Client/indexClient.jsp?id=" + clt1.getId());
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
