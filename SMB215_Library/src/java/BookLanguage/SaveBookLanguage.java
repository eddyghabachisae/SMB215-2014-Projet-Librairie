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

@WebServlet(name = "SaveBookLanguage", urlPatterns = {"/SaveBookLanguage"})
public class SaveBookLanguage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookLanguage cnt = new BookLanguage();
        cnt.setCode(request.getParameter("code"));
        cnt.setName(request.getParameter("name"));
        BookLanguageBean cntBean = new BookLanguageBean();
        if (!request.getParameter("id").equals("")) {
            cnt.setId(Long.parseLong(request.getParameter("id")));
            cntBean.modifyBookLanguage(cnt);
            response.sendRedirect("GetBookLanguages");
        } else {
            cntBean.addBookLanguage(cnt);
            response.sendRedirect("GetBookLanguages");
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
