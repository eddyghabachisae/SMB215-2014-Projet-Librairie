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
            Client clt1 = cltBean.getClient(1);  //replace 1 with session variable correspondant to user id

        
            //System.out.println(clt.getId());
            
            response.sendRedirect("Client/indexClient.jsp?id=" + clt1.getId()
                 + "&username=" + clt1.getUsername() 
                 + "&FirstName=" + clt1.getFirstname()
                 + "&LastName=" + clt1.getLastname()
                 + "&Gender=" + clt1.getGender()   
                 + "&Maritalstatus=" + clt1.getMaritalstatus()
                 + "&Address=" + clt1.getAddress()
                 + "&City=" + clt1.getCity()
                 + "&Phone=" + clt1.getPhone()
                 + "&Mobile=" + clt1.getMobile()   
                 + "&Email=" + clt1.getEmail()
                 + "&Remarks=" + clt1.getRemarks()
                 + "&Isactive=" + clt1.getIsactive()                 
            );            

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
