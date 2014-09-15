<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item category</title>
    </head>
    <body>
        <h1>Item categories:</h1>
        <table border="1">
            <tr>
                <td>Code</td>
                <td>Description</td>
                <td>Actions</td>
            </tr>
            <c:forEach items="${itemCategories}" var="itc">
                <tr>
                    <td>${itc.code}</td>
                    <td>${itc.description}</td>
                    <td>
                        <a href="GetItemCategory?id=${itc.id}">Modify</a>
                        <a href="DeleteItemCategory?id=${itc.id}">Delete</a> 
                    </td>
                </tr>
            </c:forEach>
        </table>
         <a href="GetItemCategory">Add</a>
    </body>
</html>
