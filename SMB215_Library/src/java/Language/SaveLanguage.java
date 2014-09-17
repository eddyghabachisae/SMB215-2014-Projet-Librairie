/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Language;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SaveLanguage", urlPatterns = {"/SaveLanguage"})
public class SaveLanguage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Language cnt = new Language();
        cnt.setCode(request.getParameter("code"));
        cnt.setName(request.getParameter("name"));
        LanguageBean cntBean = new LanguageBean();
        if (!request.getParameter("id").equals("")) {
            cnt.setId(Integer.parseInt(request.getParameter("id")));
            cntBean.modifyLanguage(cnt);
            response.sendRedirect("GetLanguages");
        } else {
            cntBean.addLanguage(cnt);
            response.sendRedirect("GetLanguage");
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
