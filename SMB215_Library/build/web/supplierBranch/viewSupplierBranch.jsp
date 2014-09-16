<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Supplier Branch</title>
    </head>
    <body>
        <h1>Supplier Branches:</h1>
        <table border="1">
            <tr>
                <td>Name</td>
                <td>Actions</td>
            </tr>
            <c:forEach items="${supplierBranches}" var="sbr">
                <tr>
                    <td>${sbr.name}</td>
                    <td>
                        <a href="GetSupplierBranch?id=${sbr.id}&supplier=${sbr.supplier}">Modify</a>
                        <a href="DeleteSupplierBranch?id=${sbr.id}?supplier=${sbr.supplier}">Delete</a> 
                    </td>
                </tr>
            </c:forEach>
        </table>
         <a href="GetSupplierBranch?supplier=${sbr.supplier}">Add</a>
         <a href="GetSuppliers">Back</a>
    </body>
</html>
