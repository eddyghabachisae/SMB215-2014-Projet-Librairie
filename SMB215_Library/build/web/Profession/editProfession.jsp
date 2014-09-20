

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Profession</title>
    </head>
    <body>
        <h1>Profession</h1>
        <form action="../SaveProfession?id=<%=request.getParameter("id")%>" method="post">
            <table>
                <tr>
                    <td><label>Id:</label></td>
                    <td><input type="text" name="id" value="<%=request.getParameter("id")%>"></td>
                </tr>
                <tr>
                    <td><label>Description</label></td>
                    <td><input type="text" name="description" value="<%=request.getParameter("description")%>"></td>
                </tr>
            </table>
            <button type="submit">Save</button>
        </form>
                <a href="../GetProfessions">Back</a>
    </body>
</html>
