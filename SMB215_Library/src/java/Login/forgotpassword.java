package Login;

import city.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.DBconnection;

@WebServlet(name = "forgotpassword", urlPatterns = {"/forgotpassword"})
public class forgotpassword extends HttpServlet {

@Override
   protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException /*ParseException*/ {
         
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
               
                //Get user email
            String form_username = req.getParameter("user");

        
        // establish connection *************************************
           
            DBconnection dbCon = new DBconnection();
            Class.forName(dbCon.getJDBC_DRIVER());
            con = DriverManager.getConnection(dbCon.getDATABASE_URL(),
                    dbCon.getDB_USERNAME(), dbCon.getDB_PASSWORD());
            Statement stmt = null; 
        
            // Check if user match             
                          

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select cst_email From customer where cst_username='" + form_username + "'");
            
            
            if(!rs.next()) // if not
                {
                // update query execution *******************************

                    response.sendRedirect("login.jsp?resetpassfail=1");
                    }    
            //username exist so send temporary password    
            else { 
              char[] CHARSET_AZ_09 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();  
              String TempPass = randomString(CHARSET_AZ_09, 8);
              
              PreparedStatement pstmt1 = null;
              pstmt1 = con.prepareStatement("Update customer Set cst_password='" + TempPass  + "' where cst_username='" + form_username + "'");
              pstmt1.executeUpdate();
              



              
              // parameters
              	String mailSmtpHost = "77.42.130.40";
		String mailTo = "dany.wazen@gmail.com";
		String mailCc = "dany.wazen@gmail.com";
		String mailFrom = "dany@ogero.gov.lb";
		String mailSubject = "Email from Library administrator - reset password";
		String mailText = "This is an email from Java, please find below your new temporary password: <br />" + TempPass;

		//sendEmail(mailTo, mailCc, mailFrom, mailSubject, mailText, mailSmtpHost);
              
              response.sendRedirect("login.jsp?resetpasssuccess=2");
           
    
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
   
   
   public static String randomString(char[] characterSet, int length) {
    Random random = new SecureRandom();
    char[] result = new char[length];
    for (int i = 0; i < result.length; i++) {
        // picks a random index out of character set > random character
        int randomCharIndex = random.nextInt(characterSet.length);
        result[i] = characterSet[randomCharIndex];
    }
    return new String(result);
}
   
   
public static void sendEmail(String to, String cc, String from, String subject, String text, String smtpHost) {
		try {
			Properties properties = new Properties();
			properties.put("mail.smtp.host", smtpHost);
			Session emailSession = Session.getDefaultInstance(properties);

			Message emailMessage = new MimeMessage(emailSession);
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			emailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
			emailMessage.setFrom(new InternetAddress(from));
			emailMessage.setSubject(subject);
			emailMessage.setText(text);

			emailSession.setDebug(true);

			Transport.send(emailMessage);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}   
   
}



       

