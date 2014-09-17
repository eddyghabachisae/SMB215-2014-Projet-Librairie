/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package customer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SaveCustomer", urlPatterns = {"/SaveCustomer"})
public class SaveCustomer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        Customer cnt = new Customer();
        cnt.setUsername(request.getParameter("username"));
        cnt.setPassword(request.getParameter("password"));
        cnt.setFirstname(request.getParameter("firstname"));
        cnt.setLastname(request.getParameter("lastname"));
        cnt.setGender(Integer.parseInt(request.getParameter("gender")));
        cnt.setMaritalstatus(Integer.parseInt(request.getParameter("maritalstatus")));
        String date = request.getParameter("dateofbirth");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        Date d = sdf.parse(date);
        cnt.setDateofbirth(d);
        cnt.setAddress(request.getParameter("address"));
        cnt.setCity(request.getParameter("city"));
        cnt.setPhone(request.getParameter("phone"));
        cnt.setMobile(request.getParameter("mobile"));
        cnt.setEmail(request.getParameter("email"));
        cnt.setRemarks(request.getParameter("remarks"));
        cnt.setIsactive(Boolean.parseBoolean(request.getParameter("isactive")));
        CustomerBean cntBean = new CustomerBean();
        if (!request.getParameter("id").equals("")) {
            cnt.setId(Integer.parseInt(request.getParameter("id")));
            cntBean.modifyCustomer(cnt);
            response.sendRedirect("GetCustomers");
        } else {
            cntBean.addCustomer(cnt);
            response.sendRedirect("GetCustomer");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(SaveCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(SaveCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
