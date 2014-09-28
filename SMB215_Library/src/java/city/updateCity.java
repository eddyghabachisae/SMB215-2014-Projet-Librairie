package city;

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

@WebServlet(name = "updateCity", urlPatterns = {"/updateCity"})
public class updateCity extends HttpServlet {

@Override
   protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException /*ParseException*/ {
         
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
               
                //Get city id
            int form_id = Integer.parseInt(req.getParameter("cit_id"));
                //Get city name
            String form_citname = req.getParameter("cityname");
                //Get city code
            String form_citcode = req.getParameter("citycode");
                //Get last name
        
        // establish connection *************************************
           
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());
            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            Statement stmt = null; 
        
            // Check if CITY EXISTS             
                          
            // Check if old password match
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select cty_id From city where cty_name='" + form_citname + "'");
            int newcity;
            
            if(!rs.next()) // if no such city exists
                {
                // update query execution *******************************

                    City cit = new City();
                    cit.setId(form_id);
                    cit.setCode(form_citcode);
                    cit.setName(form_citname);
                    CityBean citBean = new CityBean();
                    citBean.modifyCity(cit);
                    response.sendRedirect("city/indexCity.jsp");
                    }    
            //city exisit    
            else { 
            ResultSet rs1 = stmt.executeQuery("Select cty_id From city where cty_name='" + form_citname + "'");
            while (rs1.next()) 
            {
                newcity = rs1.getInt(1); 
                if (form_id == newcity){ ///check if we are updating the same city
                
                    // update query execution *******************************

                    City cit = new City();
                    cit.setId(form_id);
                    cit.setCode(form_citcode);
                    cit.setName(form_citname);
                    CityBean citBean = new CityBean();
                    citBean.modifyCity(cit);
                    response.sendRedirect("city/indexCity.jsp");
                    }
            
                else
                    {
                    // Go back to modify profile page ******************************
                      response.sendRedirect("city/editCity.jsp?existingcityname=true&cit_id=" + form_id);
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



       

