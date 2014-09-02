/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bran;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateBranch", urlPatterns = {"/UpdateBranch"})
public class UpdateBranch extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Branch Bran = new Branch();
        Bran.setbrhid(Integer.parseInt(request.getParameter("brhid")));     
        Bran.setbrhname(request.getParameter("brhname"));
        Bran.setbrhcity(Integer.parseInt(request.getParameter("brhcity")));
        Bran.setbrhaddress(request.getParameter("brhaddress"));
        Bran.setbrhemail(request.getParameter("brhemail"));
        Bran.setbrhphone(request.getParameter("brhphone"));
        Bran.setbrhfax(request.getParameter("brhfax"));
        Bran.setbrhmobile(request.getParameter("brhmobile"));
        Bran.setbrhisactive(Boolean.getBoolean(request.getParameter("brhisactive")));
        
        //java.sql.Date d =new java.sql.Date();
        
//          new java.sql.Date(rs.getDate(10).getDate()));
          java.util.Date d=new java.util.Date(request.getParameter("brhactivesince"));
          java.util.Date d2=new java.util.Date(request.getParameter("brhactivedsince"));  
        //Bran.setbrhdeactivatedsince(new java.sql.Date(request.getParameter("brhdeactivatedsince")));
        
        
        
        Bran.setbrhactivatesince(new java.sql.Date(d.getDate()));//    Date.valueOf(request.getParameter("brhactivesince")));
        Bran.setbrhdeactivatedsince(new java.sql.Date(d2.getDate()));
          
      BranchBean br = new BranchBean();
        br.update(Bran);
        response.sendRedirect("viewBranch.jsp");       
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