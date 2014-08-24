<%@page import="country.CountryBean"%>
<%@page import="country.Country"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Countries</title>
    </head>
    <body>
        <h1>Countries</h1>
        <p><a href="editCountry.jsp">Add country</a></p>
        <table border="1">
            <thead>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>Short Name</td>
                    <td>Name</td>
                </tr>
            </thead>
            <tbody>
                <%
                    CountryBean cntBean = new CountryBean();
                    List<Country> list = cntBean.getCountries();
                    for (Country cnt : list) {
                %>
                <tr>
                    <td>
                        <form method="post" action="editCountry.jsp">
                            <input type="hidden" name="id" 
                                   value="<%=String.valueOf(cnt.getId())%>"/> 
                            <input type="image" src="../images/modify.png" alt="modify" 
                                   title="modify"> 
                        </form>
                    </td>
                    <td>
                        <form method="post" action="../DeleteCountry">
                            <input type="hidden" name="id" 
                                   value="<%=String.valueOf(cnt.getId())%>"/> 
                            <input type="image" src="../images/delete.png" alt="delete" 
                                   title="delete"> 
                        </form>
                    </td>
                    <td><%=String.valueOf(cnt.getShortName())%></td>
                    <td><%=cnt.getName()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>


