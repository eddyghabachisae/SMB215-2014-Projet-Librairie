/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Author;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SaveAuthor", urlPatterns = {"/SaveAuthor"})
public class SaveAuthor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Author cnt = new Author();
        cnt.setCode(request.getParameter("code"));
        cnt.setName(request.getParameter("name"));
        AuthorBean cntBean = new AuthorBean();
        if (!request.getParameter("id").equals("")) {
            cnt.setId(Integer.parseInt(request.getParameter("id")));
            cntBean.modifyAuthor(cnt);
            response.sendRedirect("GetAuthors");
        } else {
            cntBean.addAuthor(cnt);
            response.sendRedirect("GetAuthors");
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
