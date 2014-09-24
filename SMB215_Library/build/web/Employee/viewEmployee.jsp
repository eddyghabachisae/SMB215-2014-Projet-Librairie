<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee</title>
    </head>
    <body>
        <h1>Employees:</h1>
        <table border="1">
            
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
            <c:forEach items="${Employees}" var="emp">
                <tr>
                    <td>${emp.ssn}</td>
                    <td>${emp.username}</td>                 
                    <td>${emp.password}</td>
                    <td>${emp.firstname}</td>
                    <td>${emp.lastname}</td>
                    <td>${emp.username}</td>
                    <td>${emp.gender}</td>
                    <td>${emp.maritalstatus}</td>
                    <td>${emp.dateofbirth}</td>
                    <td>${emp.city}</td>
                    <td>${emp.address}</td>
                    <td>${emp.homephone}</td>
                    <td>${emp.mobile}</td>
                    <td>${emp.personalemail}</td>
                    <td>${emp.workphone}</td>
                    <td>${emp.workext}</td>
                    <td>${emp.workfax}</td>
                    <td>${emp.workemail}</td>
                    <td>${emp.profession}</td>
                    <td>${emp.remarks}</td>
                    
                    <td>${emp.branch}</td>
                    <td>${emp.isactive}</td>                 
                    <td>${emp.activesince}</td>
                    <td>${emp.deactivatedsince}</td>
                    <td>${emp.deactivatedreason}</td>
                       <tr>
           
                    <td>
                        <a href="GetEmployee?id=${emp.id}">Modify</a>
                        <a href="DeleteEmployee?id=${emp.id}">Delete</a> 
                    </td>
                </tr>
            </c:forEach>
        </table>
         <a href="GetEmployee">Add</a>
    </body>
</html>
