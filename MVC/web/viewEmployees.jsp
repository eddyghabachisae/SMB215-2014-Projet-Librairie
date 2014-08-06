<%@page import="emp.EmployeeBean"%>
<%@page import="emp.Employee"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View employees</title>
    </head>
    <body>
        <div>
            <h2>Existing employees</h2>
            <table border="1">
                <thead>
                <tr>
                    <th>Employee Id</th>
                    <th>Employee Name</th>
                </tr>
                </thead>
                <tbody>
                <%
                        EmployeeBean eb = new EmployeeBean();
                        List<Employee> list = eb.getEmployees();
                        for (Employee e : list) {
                    %>

                    <tr>
                        <td><%=String.valueOf(e.getEmpId())%></td>
                        <td><%=e.getEmpName()%></td>
                        <td>
                            <form method="post" action="UpdateEmployee.jsp">
                                    <input type="hidden" name="updateId" value="<%=String.valueOf(e.getEmpId())%>"/> 
                                    <input type="submit" value="Modify"/> 
                                </form>
                        </td>
                        <td>
                            <form method="post" action="DelEmployee">
                                    <input type="hidden" name="delId" value="<%=String.valueOf(e.getEmpId())%>"/> 
                                    <input type="submit" value="Delete"/> 
                                </form>
                        </td>
                    </tr>
                     <%
                        }
                    %>
                    </tbody>
            </table>
                    <br>
                    <p><a href="index.html">Back to homepage</a></p>
        </div>
    </body>
</html>
