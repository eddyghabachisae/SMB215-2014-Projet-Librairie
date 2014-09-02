
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
                <h1>Update Employee ID:<%=e.getempid()%></h1>
                <label><input type="hidden" name="empid" id="empid" value="<%=e.getempid()%>"/></label>   
                  <h1>Update Emp ssn:<%=e.getempssn()%></h1>
                <label><input type="hidden" name="empssn" id="empssn:" value="<%=e.getempssn()%>"/></label> 
                <label>Name</label>
                <input type="text" name="empfirstname" value="<%=e.getempfirstname()%>"/>
                <input type="text" name="emplastname" value="<%=e.getemplastname()%>"/>
                <input type="text" name="empgender" value="<%=e.getempgender()%>"/>
                <input type="text" name="empworkphone" value="<%=e.getempworkphone()%>"/>
                 <input type="text" name="empworkext" value="<%=e.getempworkext()%>"/>
                <input type="text" name="empworkfax" value="<%=e.getempworkfax()%>"/>
                <input type="text" name="empworkemail" value="<%=e.getempworkemail()%>"/>
                <button type="submit">Update Employee</button>
                   
            </form>
        </div>   
    </body>
</html>
