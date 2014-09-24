
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profession</title>
    </head>
    <body>
        <h1>Professions:</h1>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Description</td>
           
            </tr>
            <c:forEach items="${Professions}" var="prf">
                <tr>
                    <td>${prf.id}</td>
                    <td>${prf.description}</td>
                    <td>
                        <a href="GetProfession?id=${prf.id}">Modify</a>
                        <a href="DeleteProfession?id=${prf.id}">Delete</a> 
                    </td>
                </tr>
            </c:forEach>
        </table>
         <a href="GetProfession">Add</a>
    </body>
</html>