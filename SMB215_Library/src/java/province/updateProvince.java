package province;

import country.*;
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

@WebServlet(name = "updateProvince", urlPatterns = {"/updateProvince"})
public class updateProvince extends HttpServlet {

@Override
   protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException /*ParseException*/ {
         
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
               
                //Get city id
            int form_id = Integer.parseInt(req.getParameter("pvc_id"));
                            //Get city id
            int form_cntid = Integer.parseInt(req.getParameter("country"));
                //Get city name
            String form_pvcname = req.getParameter("provincename");
                //Get city code
            String form_pvccode = req.getParameter("provincecode");
                //Get last name
        
        // establish connection *************************************
           
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());
            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            Statement stmt = null; 
        
            // Check if CITY EXISTS             
                          
            // Check if province exists
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select pvc_name From province where pvc_name='" + form_pvcname + "' AND country_id =" + form_cntid);
            int newprovince;
            
            if(!rs.next()) // if no such province exists
                {
                // update query execution *******************************

                    Province pvc = new Province();
                    pvc.setId(form_id);
                    pvc.setCode(form_pvccode);
                    pvc.setName(form_pvcname);
                    pvc.setcountry(form_cntid);
                    ProvinceBean pvcBean = new ProvinceBean();
                    pvcBean.modifyProvince(pvc);
                    response.sendRedirect("province/indexProvince.jsp");
                    }    
            //city exisit    
            else { 
            ResultSet rs1 = stmt.executeQuery("Select pvc_id From province where pvc_name='" + form_pvcname + "' AND country_id =" + form_cntid);
            while (rs1.next()) 
            {
                newprovince = rs1.getInt(1); 
                if (form_id == newprovince){ ///check if we are updating the same city
                
                    // update query execution *******************************

                    Province pvc = new Province();
                    pvc.setId(form_id);
                    pvc.setCode(form_pvccode);
                    pvc.setName(form_pvcname);
                    pvc.setcountry(form_cntid);
                    ProvinceBean pvcBean = new ProvinceBean();
                    pvcBean.modifyProvince(pvc);
                    response.sendRedirect("province/indexProvince.jsp");
                    }
            
                else
                    {
                    // Go back to modify profile page ******************************
                     response.sendRedirect("province/editProvince.jsp?pvc1_id=" + form_id + "&&pvc1_name=" + form_pvcname + "&&existingprovincename=true");
                    }
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



       

