
<%@page import="emp.EmployeeBean"%>
<%@page import="emp.Employee"%>
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
            <table border="1">
                <thead>
                <tr>
                     </th>Employee ID</th>
                     <th> SSN </th>
                     <th>Username </th>
                      <th>Password</th>
                      <th>First Name </th>
                      <th> Last  Name </th>
                       <th>Genre </th>
                        <th>Marital Status</th>
                        <th> Date Of Birth</th>
                          <th> City </th>
                           <th> Address </th>
                            <th>Home Phone</th>
                                <th>Mobile</th>
                              <th> Personal Email</th>
                              <th>Work Phone</th>
                                <th>work ext</th>
                                 <th> Work Fax</th>
                                      <th>Work Email</th>
                                      <th> Profession</th>
                                        <th>  Remarks</th>
                                           <th>  Branch </th>
                                           <th> Active</th>
                                   <th> Active Since</th>
                               <th> Deactivated Since</th>
                                 <th> Deactivated Reason </th>

                  
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
                        <td><%=String.valueOf(e.getempssn())%></td>
                            <td><%=e.getempusername()%></td>
                            <td><%=e.getemppassword()%></td> 
                           <td><%=e.getempfirstname()%></td>
                            <td><%=e.getemplastname()%></td>
                            <td><%=String.valueOf(e.getempgender())%></td>
                         <td><%=String.valueOf(e.getempmaritalstatus())%></td>
                          <td><%=new java.sql.Date(e.getempdateofbirth().getDate())%></td>
                           <td><%=String.valueOf(e.getempcity())%></td>  
                            <td><%=e.getempaddress()%></td>
                             <td><%=e.getemphomephone()%></td>
                        <td><%=e.getempmobile()%></td>
                         <td><%=e.getemppersonalemail()%></td>   
                          <td><%=e.getempworkphone()%></td>  
                        <td><%=String.valueOf(e.getempworkext())%></td>
                        <td><%=e.getempworkfax()%></td>
                        <td><%=e.getempworkemail()%></td>
                        <td><%=String.valueOf(e.getempprofession())%></td>
                        <td><%=e.getempremarks()%></td>
                        <td><%=String.valueOf(e.getempbranch())%></td>
                        <td><%=String.valueOf(e.getempisactive())%></td>
                        <td><%=new java.sql.Date(e.getempactivesince().getDate())%></td>
                        <td><%=new java.sql.Date(e.getempdeactivatedsince().getDate())%></td>
                        <td><%=e.getempdeactivatedreason()%></td>
      
                        
                        
                     
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
                    <p><a href="Page1.html">Back to home page</a></p>
                     
        </div>
    </body>
</html>
