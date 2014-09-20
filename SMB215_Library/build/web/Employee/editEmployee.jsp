<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Employee</title>
    </head>
    <body>
        <h1>Employee</h1>
        <form action="../SaveEmployee?id=<%=request.getParameter("id")%>" method="post">
            <table>
                <tr>
                    <td><label>SSN:</label></td>
                    <td><input type="text" name="empssn" value="<%=request.getParameter("empssn")%>"></td>
                </tr>
                <tr>
                    <td><label>Username:</label></td>
                    <td><input type="text" name="empusername" value="<%=request.getParameter("empusername")%>"></td>
                </tr>
                
                
             <tr>
                    <td><label>Password:</label></td>
                    <td><input type="text" name="emppassword" value="<%=request.getParameter("emppassword")%>"></td>
                </tr>
                
                 <tr>
                    <td><label>First Name:</label></td>
                    <td><input type="text" name="empfirstname" value="<%=request.getParameter("empfirstname")%>"></td>
                </tr>
                
                 <tr>
                    <td><label>Last  Name:</label></td>
                    <td><input type="text" name="emplastname" value="<%=request.getParameter("emplastname")%>"></td>
                </tr>
                
                 <tr>
                    <td><label>Genre:</label></td>
                    <td><input type="radio" name="empgender" value="1"/>Female</td>
                     <td><input type="radio" name="empgender" value="2"/>Male</td>
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
                    <td><input type="text" name="empdateofbirth" value="<%=request.getParameter("empdateofbirth")%>"></td>
                </tr>

                 <tr>
                    <td><label>City:</label></td>
                    <td><input type="text" name="empcity" value="<%=request.getParameter("empcity")%>"></td>
                </tr>
                
                 <tr>
                    <td><label>Address:</label></td>
                    <td><input type="text" name="empaddress" value="<%=request.getParameter("empaddress")%>"></td>
                </tr>
                
                 <tr>
                    <td><label>Home Phone:</label></td>
                    <td><input type="text" name="emphomephone" value="<%=request.getParameter("emphomephone")%>"></td>
                </tr>
                
                 <tr>
                    <td><label>Mobile:</label></td>
                    <td><input type="text" name="empmobile" value="<%=request.getParameter("empmobile")%>"></td>
                </tr>
                
                 <tr>
                    <td><label>Personal Email</label></td>
                    <td><input type="text" name="emppersonalemail" value="<%=request.getParameter("emppersonalemail")%>"></td>
                </tr>
                
                 <tr>
                    <td><label>Work Phone:</label></td>
                    <td><input type="text" name="empworkphone" value="<%=request.getParameter("empworkphone")%>"></td>
                </tr>
                
                  
                    <tr>
                    <td><label>Work ext:</label></td>
                    <td><input type="text" name="empworkext" value="<%=request.getParameter("empworkext")%>"></td>
                </tr>
                
                
                
                  <tr>
                    <td><label>Work Fax:</label></td>
                    <td><input type="text" name="empworkfax" value="<%=request.getParameter("empworkfax")%>"></td>
                </tr>
                  <tr>
                    <td><label>Work email:</label></td>
                    <td><input type="text" name="empworkemail" value="<%=request.getParameter("empworkemail")%>"></td>
                </tr>
                
                
                  <tr>
                    <td><label>Profession:</label></td>
                    <td><input type="text" name="empprofession" value="<%=request.getParameter("empprofession")%>"></td>
                </tr>
                
                
                <tr>
                    <td><label>Remarks:</label></td>
                    <td><input type="text" name="empremarks" value="<%=request.getParameter("empremarks")%>"></td>
                </tr>
                
                 <tr>
                    <td><label>Branch:</label></td>
                    <td><input type="text" name="empbranch" value="<%=request.getParameter("empbranch")%>"></td>
                </tr>
                
                 <tr>
                    <td><label>Active::</label></td>
                    <td><input type="text" name="empisactive" value="<%=request.getParameter("empisactive")%>"></td>
                </tr>
                
                 <tr>
                    <td><label>Active Since:</label></td>
                    <td><input type="text" name="empactivesince" value="<%=request.getParameter("empactivesince")%>"></td>
                </tr>
                
                 <tr>
                    <td><label>Deactivated Since:</label></td>
                    <td><input type="text" name="empdeactivatedsince" value="<%=request.getParameter("empdeactivatedsince")%>"></td>
                </tr>
                
                 <tr>
                    <td><label>Deactivated Reason:</label></td>
                    <td><input type="text" name="empdeactivatedreason" value="<%=request.getParameter("empdeactivatedreason")%>"></td>
                </tr>
                
                   
                        <td><input type="text" name=""/></td>
                    </tr>
            </table>
            <button type="submit">Save</button>
        </form>
                <a href="../GetEmployees">Back</a>
    </body>
</html>
