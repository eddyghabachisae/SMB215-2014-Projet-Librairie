package province;

import city.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.DBconnection;

@WebServlet(name = "insertProvince", urlPatterns = {"/insertProvince"})
public class insertProvince extends HttpServlet {

@Override
   protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException /*ParseException*/ {
         
        Connection con = null;
        PreparedStatement pstmt = null;
        try {

            //Get form country id
            int form_cntid = Integer.parseInt(req.getParameter("country"));
            //Get province name
            String form_provincename = req.getParameter("provincename");
            //Get province code
            String form_provincecode = req.getParameter("provincecode");
            
        
        // establish connection *************************************
           
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());
            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            Statement stmt = null; 
        
            // Check if Province EXISTS             
            stmt = con.createStatement();
            ResultSet rs;
            
                rs = stmt.executeQuery("Select pvc_name From province where pvc_name='" + form_provincename + "' & country_id =" + form_cntid);
   
            
            while (rs.next()) 
            {
            if(!rs.next()) // if no such province exists
                {
        
                Province pvc = new Province();
                pvc.setCode(form_provincecode);
                pvc.setName(form_provincename);
                ProvinceBean pvcBean = new ProvinceBean();
                pvcBean.addProvince(pvc);
                response.sendRedirect("province/indexProvince.jsp");
                }
            else
                {
                // Go back to modify profile page ******************************
                  response.sendRedirect("province/addProvince.jsp?existingprovincename=true");
                }
            }
    



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
                    } 
                            catch (SQLException ex) {
                        System.err.println("Caught Exception: " + ex.getMessage());
                    }   
            }
}
}



       

