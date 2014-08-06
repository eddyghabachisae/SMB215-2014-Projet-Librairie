<%@page import="emp.Employee"%>
<%@page import="emp.EmployeeBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Update</title>
    </head>
    <body>
        <%
            int id = Integer.parseInt(request.getParameter("updateId"));
            EmployeeBean eb = new EmployeeBean();
            Employee e = eb.getEmployee(id);
        %>
        <div>
            <form action="UpdateEmployee" method="post">
                <h1>Update Employee ID:<%=e.getEmpId()%></h1>
                <label><input type="hidden" name="empId" id="empId" value="<%=e.getEmpId()%>"/></label>                    
                <label>Name</label>
                <input type="text" name="empName" value="<%=e.getEmpName()%>"/>
                <button type="submit">Update Employee</button>
            </form>
        </div>   
    </body>
</html>