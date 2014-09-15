<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Supplier Branch</title>
    </head>
    <body>
        <form action="../SaveSupplierBranch?id=<%=request.getParameter("id")%>" method="post">
        <table>
            <tr>
                <td><label>Name:</label></td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td><label> Contact Name:</label></td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td><label>Phone:</label></td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td><label>Fax:</label></td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td><label>Mobile:</label></td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td><label>Email:</label></td>
                <td><input type="text"></td>
            </tr>
        </table>
        </form>
    </body>
</html>
