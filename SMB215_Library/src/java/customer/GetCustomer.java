/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package customer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Enums.Gender;
import utils.Enums.MaritalStatus;


@WebServlet(name = "GetCustomer", urlPatterns = {"/GetCustomer"})
public class GetCustomer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            List<Gender> genderlist;
            genderlist = Arrays.asList(Gender.values());
            List<MaritalStatus> maritalstatuslist;
            maritalstatuslist = Arrays.asList(MaritalStatus.values());
        if (request.getParameter("id") != null){
            CustomerBean cntBean = new CustomerBean();
            Customer cnt = cntBean.getCustomer(Integer.valueOf(request.getParameter("id")));
            request.setAttribute("gender", genderlist);
            request.setAttribute("maritalstatus", maritalstatuslist);
            request.getRequestDispatcher("Customer/editCustomer.jsp?" 
                    +"id=" + cnt.getId()
                    +"&username=" + cnt.getUsername() 
                    +"&password=" + cnt.getPassword()
                    +"&firstname=" + cnt.getFirstname()
                    +"&lastname=" + cnt.getLastname()
                    +"&gender=" + cnt.getGender()
                    +"&maritalstatus=" + cnt.getMaritalstatus()
                    +"&dateofbirth=" + cnt.getDateofbirth()
                    +"&address=" + cnt.getAddress()
                    +"&city=" + cnt.getCity()
                    +"&phone=" + cnt.getPhone()
                    +"&mobile=" + cnt.getMobile()
                    +"&email=" + cnt.getEmail()
                    +"&remarks=" + cnt.getRemarks()
                    +"&isactive=" + cnt.getIsactive()).forward(request, response);
        } else {
            request.setAttribute("gender", genderlist);
            request.setAttribute("maritalstatus", maritalstatuslist);
               request.getRequestDispatcher("Customer/editCustomer.jsp?id=&username=&password="
               +"&firstname=&lastname=&gender=&maritalstatus=&dateofbirth=&address=&city=&phone=&"
               + "&mobile=&email=&remarks=&isactive=").forward(request, response);
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
