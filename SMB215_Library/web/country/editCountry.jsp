<%@page import="country.Country"%>
<%@page import="country.CountryBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% String title = "Add";
            if (request.getParameter("id") != null) {
                title = "Modify";
            }
        %>
        <title> <%=title%> country</title>
    </head>
    <body>
        <%
            String action = "../AddCountry";
            int id = 0;
            String shortName = "";
            String name = "";
            if (request.getParameter("id") != null) {
                action = "../ModifyCountry";
                id = Integer.parseInt(request.getParameter("id"));
                CountryBean cntBean = new CountryBean();
                Country cnt = cntBean.getCountry(id);
                id = cnt.getId();
                shortName = cnt.getShortName();
                name = cnt.getName();
            }
        %>
        <h1>Country</h1>
        <form action="<%= action%>"  method="post">
            <input type="hidden" id="txtCountryId" name="txtCountryId" 
                   value ="<%=String.valueOf(id)%>">
            <table>
                <tr>
                    <td><label for="txtCountryShortName">Short name:</label></td>
                    <td><input type="text" id="txtCountryShortName" 
                               name="txtCountryShortName" value="<%= shortName%>"></td>
                </tr>
                <tr>
                    <td><label for="txtCountryName">Name:</label></td>
                    <td><input type="text" id="txtCountryName" name="txtCountryName" 
                               value="<%= name%>"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit">Save</button></td>
                </tr>
            </table>
        </form>
        <p><a href="viewCountry.jsp">Back to countries</a></p>
    </body>
</html>
