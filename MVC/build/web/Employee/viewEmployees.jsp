
<%@page import="emplo.EmployeeBean"%>
<%@page import="emplo.Employee"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View employee</title>
    </head>
    <body>
        <div>
            <h2>Existing employees</h2>
            <table border="2">
                <thead>
                <tr>
                    <th>Employee Id </th>
                    <th>Employee Name </th>
             
                </tr>
                <thead>
                <tbody>
                <%
                        EmployeeBean eb = new EmployeeBean();
                        List<Employee> list = eb.getEmployees();
                        for (Employee e : list) {
                    %>

                   
                <tr>
                        <td><%=String.valueOf(e.getempid())%></td>
                        <td><%=e.getempssn()%></td>
                        <td>
                            <form method="post" action="UpdateEmployee.jsp">
                                   <table> <input type="hidden" name="updateempid" value="<%=String.valueOf(e.getempid())%>"/> 
                                    <input type="submit" name ="update" value="Modify"/> 
                                </form>
                        </td>
                        <td>
                            <form method="post" action="DelEmployee">
                                    <input type="hidden" name="deleteId" value="<%=String.valueOf(e.getempid())%>"/> 
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
                     
        </div>
    </body>
</html>
