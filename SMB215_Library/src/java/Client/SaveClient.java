package Client;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.DBconnection;

@WebServlet(name = "SaveClient", urlPatterns = {"/SaveClient"})
public class SaveClient extends HttpServlet {

   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException /*ParseException*/ {
         
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            
            // get form variables *******************************************
            //Get Session id
            Object attribute = req.getSession().getAttribute("userid");
            long id = Long.parseLong(String.valueOf(attribute));   
            //Get username
            String form_user = req.getParameter("username");
            //Get first name
            String form_firstname = req.getParameter("firstname");
            //Get last name
            String form_lastname = req.getParameter("lastname");
            //Get Gender
            int form_gender = Integer.parseInt(req.getParameter("gender"));
            //Get Marital
            int form_marital = Integer.parseInt(req.getParameter("marital")); 
            //Get DoB
           // String formDoB = req.getParameter("timestamp");
           // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           // Date form_DoB = sdf.parse(formDoB);
            //String formattedDate = sdf.format(form_DoB);
            //Get phone
            String form_address = req.getParameter("address");
            //Get phone
            String form_phone = req.getParameter("phone");
            //Get mobile
            String form_mobile = req.getParameter("mobile");
            //Get email
            String form_email = req.getParameter("email");
            //Get remarks
            String form_remarks = req.getParameter("remarks");
 
            // establish connection *************************************
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());
            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            Statement stmt = null; 
            
            // Check if old password match
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select cst_username From customer where cst_id=" + id);
            String newuser;
            while (rs.next()) 
            {
                newuser = rs.getString(1); 
                if (!form_user.equals(newuser)){
                Statement stmt1 = null;
                stmt1 = con.createStatement();
                ResultSet rs1 = stmt1.executeQuery("Select * From customer where cst_username='" + form_user + "'"); 

                if(!rs1.next()) // if no such user exists
                {
                // update query execution *******************************
                pstmt = con.prepareStatement("Update customer Set cst_username='" + form_user + 
                        "' ,cst_firstname='" + form_firstname + 
                        "' ,cst_lastname='" + form_lastname +
                        "' ,cst_gender_id='" + form_gender +
                        "' ,cst_maritalstatus='" + form_marital +
                        //"' ,cst_dateofbirth='" + (Date) form_DoB +
                        "' ,cst_address='" + form_address + 
                        "' ,cst_phone='" + form_phone + 
                        "' ,cst_mobile='" + form_mobile + 
                        "' ,cst_email='" + form_email + 
                        "' ,cst_remarks='" + form_remarks + 
                        "' Where cst_id=" + id);
                pstmt.executeUpdate();


                // Go to View profile page ******************************
                response.sendRedirect("Client/indexClient.jsp");
                }              
                else
                {
                // Go back to modify profile page ******************************
                  response.sendRedirect("Client/editClient.jsp?existingusername=true");
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
            } catch (SQLException ex) {
                System.err.println("Caught Exception: " + ex.getMessage());
            }   
    }
        
    }
    
       
}