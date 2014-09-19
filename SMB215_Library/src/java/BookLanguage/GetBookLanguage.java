/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BookLanguage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "GetBookLanguage", urlPatterns = {"/GetBookLanguage"})
public class GetBookLanguage extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != null){
            BookLanguageBean cntBean = new BookLanguageBean();
            BookLanguage cnt = cntBean.getBookLanguage(Integer.valueOf(request.getParameter("id")));
            response.sendRedirect("BookLanguage/editLanguage.jsp?" 
                    +"id=" + cnt.getId()
                    +"&code=" + cnt.getCode() 
                    +"&name=" + cnt.getName());
        } else {
               response.sendRedirect("BookLanguage/editLanguage.jsp?id=&code=&name=");
        }
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
