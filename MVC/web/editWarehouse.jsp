

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
        <title>Edit Ware House</title>
    </head>
    <body>
        <h1>Ware House</h1>
        <form action="../SaveWarehouse?id=<%=request.getParameter("id")%>" method="post">
            <table>
                <tr>
                    <td><label>Id</label></td>
                    <td><input type="text" name="id" value="<%=request.getParameter("id")%>"></td>
                </tr>
                <tr>
                    <td><label>Quantity</label></td>
                    <td><input type="text" name="quantity" value="<%=request.getParameter("quantity")%>"></td>
                </tr>
                  <tr>
                    <td><label>Sale Rent Price</label></td>
                    <td><input type="text" name="salerentprice" value="<%=request.getParameter("salerentprice")%>"></td>
                </tr>
                
                  <tr>
                    <td><label>Mix limit</label></td>
                    <td><input type="text" name="minlimit" value="<%=request.getParameter("minlimit")%>"></td>
                </tr>
                  <tr>
                    <td><label>Max limit</label></td>
                    <td><input type="text" name="maxlimit" value="<%=request.getParameter("maxlimit")%>"></td>
                </tr>
                  <tr>
                    <td><label>Is Available</label></td>
                    <td><input type="text" name="isavailable" value="<%=request.getParameter("isavailable")%>"></td>
                </tr>
                
                  <tr>
                    <td><label>Is Active</label></td>
                    <td><input type="text" name="isactive" value="<%=request.getParameter("isactive")%>"></td>
                </tr>
            </table>
            <button type="submit">Save</button>
        </form>
                <a href="../GetWarehouses">Back</a>
    </body>
</html>
