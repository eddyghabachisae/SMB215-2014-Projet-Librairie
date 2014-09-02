<%@page import="Profession.ProfessionBean"%>
<%@page import="Profession.Profession"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View professions</title>
    </head>
    <body>
        <div>
            <h2>Existing Profession</h2>
            <table border="2">
                <thead>
                <tr>
                    <th>Professions Id </th>
                    <th>Profession Description </th>
             
                </tr>
                <thead>
                <tbody>
                <%
                       ProfessionBean pf = new ProfessionBean();
                        List<Profession> list = pf.getprofessions();
                        for (Profession p : list) {
                    %>

                   
                <tr>
                        <td><%=String.valueOf(p.getprfid())%></td>
                        <td><%=p.getprfdescription()%></td>
                        <td>
                            <form method="post" action="UpdateProfession.jsp">
                                   <table> <input type="hidden" name="updateprfid" value="<%=String.valueOf(p.getprfid())%>"/> 
                                    <input type="submit" name ="update" value="Modify"/> 
                                </form>
                        </td>
                        <td>
                            <form method="post" action="DelProfession">
                                    <input type="hidden" name="deleteId" value="<%=String.valueOf(p.getprfid())%>"/> 
                                    <input type="submit" value="Delete"/> 
                </table>
                                </form>
                        </td>
                    </tr>
                     <%
                        }
                    %>
                    </tbody>
            </table>
                    <br>
                    <p><a href="index.html">Back to home page</a></p>
                       <a href="addBranch.jsp">Add Branch</a>
                       <a href="viewBranch.jsp">View Branch</a>
                    
        </div>
    </body>
</html>
