package supplierbranch;

import country.Country;
import country.CountryBean;
import province.Province;
import province.ProvinceBean;
import city.City;
import city.CityBean;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetSupplierBranch", urlPatterns = {"/GetSupplierBranch"})
public class GetSupplierBranch extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CountryBean cntBean = new CountryBean();
        List<Country> countries = 
        cntBean.getCountries();
        request.setAttribute("countries", countries);
        ProvinceBean pvcBean = new ProvinceBean();
        List<Province> provinces = pvcBean.getProvinces();
        request.setAttribute("provinces", provinces);
        CityBean ctyBean = new CityBean();
        List<City> cities = ctyBean.getCities();
        request.setAttribute("cities", cities);
        if (request.getParameter("id") != null) {
            SupplierBranchBean sbrBean = new SupplierBranchBean();
            SupplierBranch sbr = sbrBean.getSupplierBranch(Integer.valueOf(request.getParameter("id")));
            request.getRequestDispatcher("supplierBranch/editSupplierBranch.jsp?"
                    + "id=" + sbr.getId()
                    + "&name=" + sbr.getName()
                    + "&contactname=" + sbr.getContactname()
                    + "&phone=" + sbr.getPhone()
                    + "&fax=" + sbr.getFax()
                    + "&mobile=" + sbr.getMobile()
                    + "&email=" + sbr.getEmail()
                    + "&remarks=" + sbr.getRemarks()
                    + "&isactive=" + sbr.getIsactive()
                    + "&deactivationreason=" + ((sbr.getIsactive() == false) ? sbr.getDeactivationreason() : "")
                    + "&city=" + sbr.getCity()
                    + "&province=" + sbr.getProvince()
                    + "&country=" + sbr.getCountry()
                    + "&supplier=" + sbr.getSupplier()
                    + "&suppliername=" + request.getParameter("suppliername")).forward(request, response);
        } else {
            request.getRequestDispatcher("supplierBranch/editSupplierBranch.jsp?id=&supplier="+request.getParameter("supplier")+"&suppliername="+request.getParameter("suppliername")+"&name=&contactname=&city=&country=&province=&address=&phone=&fax=&mobile=&email=&remarks=&isactive=&deactivationreason=").forward(request, response); 
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
