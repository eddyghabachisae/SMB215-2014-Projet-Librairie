
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Employee</title>
    </head>
    <body>
        <div>
            <form action="AddEmployee" method="post">
                <h2>Add new employee</h2>
                <table>
                    <tr>
                        <td><label>Employee ID:</label></td>
                        <td><input type="text" name="empid"/></td>
                    </tr>
                     <tr>
                        <td><label> SSN:</label></td>
                        <td><input type="text" name="empssn:"/></td>
                    </tr>
                     <tr>
                        <td><label>Username:</label></td>
                        <td><input type="text" name="empusername"/></td>
                    </tr>
                     <tr>
                        <td><label>Password:</label></td>
                        <td><input type="text" name="emppassword"/></td>
                    </tr>
                    <tr>
                        <td><label>First Name:</label></td>
                        <td><input type="text" name="empfirstname"/></td>
                    </tr>
                    
                     <tr>
                        <td><label>Last  Name:</label></td>
                        <td><input type="text" name="emplastname"/></td>
                    </tr>
                      <tr>
                        <td><label>Genre:</label></td>
                        <td><input type="radio" name="empgender" value ="1"/>Female</td>
                        <td><input type="radio" name="empgender" value ="2"/>Male</td>
                        
                    </tr>
                     <tr>
                        <td><label>Marital Status</label></td>
                      
                         <td><input type="radio" name="empmaritalstatus" value ="1"/>Single</td>
                        <td><input type="radio" name="empmaritalstatus" value ="2"/>Married</td>
                         <td><input type="radio" name="empmaritalstatus" value ="3"/>Separated</td>
                        <td><input type="radio" name="empmaritalstatus" value ="4"/>Divorced</td>
                         <td><input type="radio" name="empmaritalstatus" value ="5"/>Widowed</td>
                       
                  
                    </tr>
                      <tr>
                        <td><label>Date Of Birth :</label></td>
                        <td><input type="text" name="empdateofbirth"/></td>
                    </tr>
                     <tr>
                        <td><label>City:</label></td>
                        <td><input type="text" name="empcity"/></td>
                    </tr>
                     <tr>
                        <td><label>Address:</label></td>
                        <td><input type="text" name="empaddress"/></td>
                    </tr>`
                    
                     <tr>
                        <td><label>Home Phone:</label></td>
                        <td><input type="text" name="emphomephone"/></td>
                    </tr>
                    
                      <tr>
                        <td><label>Home Phone</label></td>
                        <td><input type="text" name="emphomephone"/></td>
                    </tr>
                      <tr>
                        <td><label>Mobile</label></td>
                        <td><input type="text" name="empmobile"/></td>
                    </tr>
                       <tr>
                        <td><label>Personal Email</label></td>
                        <td><input type="text" name="emppersonalemail"/></td>
                    </tr>
                      <tr>
                        <td><label>Work Phone</label></td>
                        <td><input type="text" name="empworkphone"/></td>
                    </tr>
                      <tr>
                        <td><label>Work ext :</label></td>
                        <td><input type="text" name="empworkext"/></td>
                    </tr>
                     <tr>
                        <td><label>Work Fax:</label></td>
                        <td><input type="text" name="empworkfax"/></td>
                    </tr>
                    
                     <tr>
                        <td><label>Work Email:</label></td>
                        <td><input type="text" name="empworkemail"/></td>
                    </tr>
                    
              
                    
                      <tr>
                        <td><label>Profession:</label></td>
                        <td><input type="text" name="empprofession"/></td>
                    </tr>
                      <tr>
                        <td><label>Remarks</label></td>
                        <td><input type="text" name="Empremarks"/></td>
                    </tr>
                     <tr>
                        <td><label>Branch:</label></td>
                        <td><input type="text" name="empbranch"/></td>
                    </tr>
                     <tr>
                        <td><label>Active:</label></td>
                        <td><input type="text" name="empisactive"/></td>
                    </tr>
                     <tr>
                        <td><label>Active Since</label></td>
                        <td><input type="text" name="empactivesince"/></td>
                    </tr>
                      <tr>
                        <td><label>Deactivated Since</label></td>
                        <td><input type="text" name="empdeactivatedsince"/></td>
                    </tr>
                      <tr>
                        <td><label>Deactivated Reason:</label></td>
                        <td><input type="text" name="empdeactivatedreason"/></td>
                    </tr>
                        <td>
                            <button type="submit">Add Employee</button>
                        </td>
                    </tr>
                </table>
            </form>
            <br>
            <p><a href="Page1.html">Back to home page</a></p>
        </div>
    </body>
</html>

           