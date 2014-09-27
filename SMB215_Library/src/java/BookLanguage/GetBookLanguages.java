/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BookLanguage;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "GetBookLanguages", urlPatterns = {"/GetBookLanguages"})
public class GetBookLanguages extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookLanguageBean cntBean = new BookLanguageBean();
        List<BookLanguage> bookLanguagesList = cntBean.getBookLanguages();
        request.setAttribute("Languages", bookLanguagesList);
        int listSize= bookLanguagesList.size();
        request.getRequestDispatcher("BookLanguage/viewLanguage.jsp?listSize="+listSize).forward(request, response);
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
