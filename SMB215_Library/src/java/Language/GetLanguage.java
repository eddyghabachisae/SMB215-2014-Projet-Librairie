/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Language;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "GetLanguage", urlPatterns = {"/GetLanguage"})
public class GetLanguage extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != null){
            LanguageBean cntBean = new LanguageBean();
            Language cnt = cntBean.getLanguage(Integer.valueOf(request.getParameter("id")));
            response.sendRedirect("language/editLanguage.jsp?" 
                    +"id=" + cnt.getId()
                    +"&code=" + cnt.getCode() 
                    +"&name=" + cnt.getName());
        } else {
               response.sendRedirect("language/editLanguage.jsp?id=&code=&name=");
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
