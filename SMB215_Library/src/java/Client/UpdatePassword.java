package Client;

import supplier.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.DBconnection;

@WebServlet(name = "UpdatePassword", urlPatterns = {"/UpdatePassword"})
public class UpdatePassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            
            // get form variables *******************************************
            //Get Session id
            Object attribute = req.getSession().getAttribute("userid");
            long id = Long.parseLong(String.valueOf(attribute));   
            //Get old password
            String form_OldPassword = req.getParameter("OldPassword");
            //Get new password
            String form_newpassword = req.getParameter("newpassword");
            
 
            // establish connection *************************************
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());
            Statement stmt = null;
            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            
            // Check if old password match
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From customer where cst_password='" + form_OldPassword +"'");
            
            if(!rs.next()) // if old password doesn't match
            {
              // Go back to change password page ******************************
              response.sendRedirect("Client/ClientChangePassword.jsp?wrongoldpassword=true");
            }
            else
            {
            
            // update query execution *******************************
            pstmt = con.prepareStatement("Update customer Set cst_password='" + form_newpassword  + "' Where cst_id=" + id);
            pstmt.executeUpdate();            
            
            // Go to View profile page ******************************
            response.sendRedirect("Client/indexClient.jsp");
            }
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

}
