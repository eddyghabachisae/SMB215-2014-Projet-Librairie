package Client.ClientBook;

import city.*;
import city.*;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.DBconnection;

@WebServlet(name = "transferBook", urlPatterns = {"/transferBook"})
public class transferBook extends HttpServlet {

      @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException /*ParseException*/ {
         
        Connection con = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        try {
            
            // get form variables *******************************************
            //Get Session id
            Object attribute = req.getSession().getAttribute("userid");
            Integer id = Integer.parseInt(String.valueOf(attribute)); 
   
            //Get Item
            long form_itemid = Long.parseLong(req.getParameter("item_id"));
            //Get  min qty
            Integer form_itemmin = Integer.parseInt(req.getParameter("item_min"));
            //Get  newitem_id
            Integer form_newitemid = Integer.parseInt(req.getParameter("towarehouse"));
 
            // establish connection *************************************
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());
            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            Statement stmt = null; 
            
            
            stmt = con.createStatement();
            pstmt = con.prepareStatement("Update item Set itm_quantity= itm_quantity + 1 Where itm_id=" + form_newitemid);
            pstmt.executeUpdate();
            
            Statement stmt1 = null; 
        
            pstmt1 = con.prepareStatement("Update item Set itm_quantity='" + (form_itemmin - 1)  + "' Where itm_id=" + form_itemid);
            pstmt1.executeUpdate();
                
            // Go to View profile page ******************************
            response.sendRedirect("Client/indexClient.jsp");
      
               
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Caught Exception: " + ex.getMessage());
        //} catch (ParseException ex) {
     //     Logger.getLogger(SaveClient.class.getName()).log(Level.SEVERE, null, ex);
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
