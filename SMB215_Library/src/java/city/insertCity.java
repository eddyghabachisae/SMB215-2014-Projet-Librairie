package city;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

@WebServlet(name = "insertCity", urlPatterns = {"/insertCity"})
public class insertCity extends HttpServlet {

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException /*ParseException*/ {
        String form_citname = req.getParameter("cityname");
            //Get first name
        String form_citcode = req.getParameter("citycode");
            //Get last name
        
        // establish connection *************************************
            Connection con = null;
            DBconnection dbCon = new DBconnection();
            try {
                Class.forName(dbCon.getJDBC_DRIVER());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(insertCity.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                        dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            } catch (SQLException ex) {
                Logger.getLogger(insertCity.class.getName()).log(Level.SEVERE, null, ex);
            }
            Statement stmt = null; 
        
            // Check if CITY EXISTS             
            stmt = con.createStatement();
            ResultSet rs;
            try {
                rs = stmt.executeQuery("Select cty_name From city where cty_name='" + form_citname + "'");
            } catch (SQLException ex) {
                Logger.getLogger(insertCity.class.getName()).log(Level.SEVERE, null, ex);
            }
            String newuser;
            while (rs.next()) 
            {
            if(!rs.next()) // if no such user exists
                {
        
                City cit = new City();
                cit.setCode(form_citcode);
                cit.setName(form_citname);
                CityBean citBean = new CityBean();
                citBean.addCity(cit);
                response.sendRedirect("city/indexCity.jsp");
                }
            else
                {
                // Go back to modify profile page ******************************
                  response.sendRedirect("Client/editClient.jsp?existingusername=true");
                }
            }
    }



}
