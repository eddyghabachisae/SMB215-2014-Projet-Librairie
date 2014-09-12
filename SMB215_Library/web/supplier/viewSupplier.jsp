<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Suppliers</title>
    </head>
    <body>
        <h1>Suppliers:</h1>
        <table border="1">
            <tr>
                <td>Name</td>
                <td>Actions</td>
            </tr>
            <c:forEach items="${suppliers}" var="sup">
                <tr>
                    <td>${sup.name}</td>
                    <td>
                        <a href="GetSupplier?id=${sup.id}">Modify</a>
                        <a href="DeleteSupplier?id=${sup.id}">Delete</a> 
                    </td>
                </tr>
            </c:forEach>
        </table>
         <a href="GetSupplier">Add</a>
    </body>
</html>
