<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Supplier</title>
    </head>
    <body>
        <h1>Supplier</h1>
        <form action="../SaveSupplier?id=<%=request.getParameter("id")%>" method="post">
            <table>
                <tr>
                    <td><label>Name:</label></td>
                    <td><input type="text" name="name" value="<%=request.getParameter("name")%>"></td>
                </tr>
                <tr>
                    <td><label>Website</label></td>
                    <td><input type="text" name="website" value="<%=request.getParameter("website")%>"></td>
                </tr>
                <tr>
                    <td><label>Remarks</label></td>
                    <td><textarea name="remarks" ><%=request.getParameter("remarks")%></textarea>
                    </td>
                <tr>
                    <td><label>Active</label></td>
                    <td>
                        <input type="radio" id="isactiveyes" name="isactive" value="true" 
                               <% if (request.getParameter("isactive").equals("true")) {%> 
                               checked <%}%>>
                        <label for="isactiveyes">Yes</label> 
                        <input type="radio" id="isactiveno" name="isactive" value="false"
                                <% if (request.getParameter("isactive").equals("false")) {%> 
                               checked <%}%>>
                        <label for="isactiveno">No</label>
                    </td>
                </tr>
                <tr>
                    <td><label>Deactivation reason</label></td>
                    <td><textarea name="deactivationreason" ><%=request.getParameter("deactivationreason")%></textarea>
                    </td>
                </tr>
            </table>
            <button type="submit">Save</button>
        </form>
        <a href="../GetSuppliers">Back</a>
    </body>
</html>
