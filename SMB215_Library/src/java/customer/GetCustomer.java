/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package customer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "GetCustomer", urlPatterns = {"/GetCustomer"})
public class GetCustomer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != null){
            CustomerBean cntBean = new CustomerBean();
            Customer cnt = cntBean.getCustomer(Integer.valueOf(request.getParameter("id")));
            response.sendRedirect("Customer/editCustomer.jsp?" 
                    +"id=" + cnt.getId()
                    +"&username=" + cnt.getUsername() 
                    +"&password=" + cnt.getPassword()
                    +"firstname=" + cnt.getFirstname()
                    +"&username=" + cnt.getUsername() 
                    +"&lastname=" + cnt.getLastname()
                    +"gender=" + cnt.getGender()
                    +"&maritalstatus=" + cnt.getMaritalstatus()
                    +"&dateofbirth=" + cnt.getDateofbirth()
                    +"address=" + cnt.getAddress()
                    +"&city=" + cnt.getCity()
                    +"&phone=" + cnt.getPhone()
                    +"mobile=" + cnt.getMobile()
                    +"&email=" + cnt.getEmail()
                    +"&remarks=" + cnt.getRemarks()
                    +"isactive=" + cnt.getIsactive());
        } else {
               response.sendRedirect("Customer/editCustomer.jsp?id=&code=&name=");
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
