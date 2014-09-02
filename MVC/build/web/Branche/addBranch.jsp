<%-- 
    Document   : addBranch
    Created on : Aug 27, 2014, 8:08:04 AM
    Author     : Roukaya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Branch</title>
    </head>
    <body>
        <div>
            <form action="AddBranch" method="post">
                <h2>Add new Branch</h2>
                <table>
                    <tr>
                        <td><label>Branch ID:</label></td>
                        <td><input type="text" name="brhid"/></td>
                    </tr>
                     <tr>
                   
                    
                     <tr>
                        <td><label>Branch  Name:</label></td>
                        <td><input type="text" name="brhname"/></td>
                    </tr>
                      <tr>
                   
                     <tr>
                        <td><label>Branch City:</label></td>
                        <td><input type="text" name="brhcity"/></td>
                    </tr>
                     <tr>
                        <td><label>Branch Address:</label></td>
                        <td><input type="text" name="brhaddress"/></td>
                    </tr>
                  
                
                      <tr>
                        <td><label>Branch Email:</label></td>
                        <td><input type="text" name="brhemail"/></td>
                    </tr>
                      <tr>
                        <td><label>Branch Phone</label></td>
                        <td><input type="text" name="brhphone"/></td>
                    </tr>
                      <tr>
                 <tr>
                        <td><label>Branch Fax:</label></td>
                        <td><input type="text" name="brhfax"/></td>
                    </tr>
                     <tr>
                        <td><label>Branch Mobile:</label></td>
                        <td><input type="text" name="brhmobile"/></td>
                    </tr>
                     <tr>
                        <td><label>Branch is Active:</label></td>
                        <td><input type="text" name="brhisactive"/></td>
                    </tr>
                     <tr>
                        <td><label>Active Since</label></td>
                        <td><input type="text" name="brhactivesince"/></td>
                    </tr>
                   
                      <tr>
                        <td><label>Branch Deactivated Reason:</label></td>
                        <td><input type="text" name="brhdeactivatedsince"/></td>
                    </tr>
                        <td>
                            <button type="submit">Add Branch</button>
                        </td>
                    </tr>
                </table>
            </form>
            <br>
            <p><a href="Page.html">Back to home page</a></p>
        </div>
    </body>
</html>
