<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Warehouse</title>
    </head>
    <body>
        <h1>Ware House:</h1>
        <table border="1">
     
            <tr>
                <td>Id</td>
                <td>Quantity</td>
                <td>Sale Rent Price</td>
                 <td>Min limit</td>
                <td>Max limit</td>
                <td>Sale Is Available</td>
                 <td>Is Active</td>
                
            </tr>
            <c:forEach items="${Warehouses}" var="itc">
                <tr>
                    <td>${wrs.id}</td>
                    <td>${wrs.Quantity}</td>
                    <td>${wrs.salerentprice}</td>
                    <td>${wrs.minlimi}</td>
                    <td>${wrs.minlimi}</td>
                    <td>${wrs.saleisavailable}</td>
                    <td>${wrs.isactive}</td>
                    
                    <td>
                        <a href="GetItemCategory?id=${wrs.id}">Modify</a>
                        <a href="DeleteItemCategory?id=${wrs.id}">Delete</a> 
                    </td>
                </tr>
            </c:forEach>
        </table>
         <a href="GetWarehouse">Add</a>
    </body>
</html>