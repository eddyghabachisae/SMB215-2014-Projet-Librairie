
package Bran;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddBranch", urlPatterns = {"/AddBranch"})
public class AddBranch extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Branch bran = new Branch();
        bran.setbrhid(Integer.parseInt(request.getParameter("brhid")));   
        bran.setbrhname(request.getParameter("brhname"));  
        bran.setbrhcity(Integer.parseInt(request.getParameter("brhcity")));
        bran.setbrhaddress(request.getParameter("brhaddress"));
        bran.setbrhemail(request.getParameter("brhemail"));
        bran.setbrhphone(request.getParameter("brhphone"));
        bran.setbrhfax(request.getParameter("brhfax"));
        bran.setbrhmobile(request.getParameter("brhmobile"));
        bran.setbrhisactive(Boolean.getBoolean(request.getParameter("brhisactive")));
        
  
        
        bran.setbrhactivatesince(new Date( request.getParameter("brhactivesince")));
        bran.setbrhdeactivatedsince(new Date(request.getParameter("brhdeactivatedsince")));
               
                      
                                            
        BranchBean br = new BranchBean();
        br.addBranch(bran);
        response.sendRedirect("addBranch.jsp");
 
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
