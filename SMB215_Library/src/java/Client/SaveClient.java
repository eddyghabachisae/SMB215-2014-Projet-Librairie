package Client;

import supplier.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.DBconnection;

@WebServlet(name = "SaveClient", urlPatterns = {"/SaveClient"})
public class SaveClient extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            
            // get form variables *******************************************
            //session id
            Object attribute = req.getSession().getAttribute("userid");
            long id = Long.parseLong(String.valueOf(attribute));   
            //username
            String form_user = req.getParameter("username");
            
            
            // establish connection *************************************
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());
            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            
         
            // update query execution *******************************
            pstmt = con.prepareStatement("Update customer Set cst_username=" + form_user + "Where cst_id=" + id);
            pstmt.executeUpdate();
            
            
            // Go to View profile page ******************************
            response.sendRedirect("ViewClient.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Caught Exception: " + ex.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println("Caught Exception: " + ex.getMessage());
            }   
    }

    


}
