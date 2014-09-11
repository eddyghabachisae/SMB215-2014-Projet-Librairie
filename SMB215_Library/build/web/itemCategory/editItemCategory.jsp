<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Item Category</title>
    </head>
    <body>
        <h1>Item Category</h1>
        <form action="../SaveItemCategory?id=<%=request.getParameter("id")%>" method="post">
            <table>
                <tr>
                    <td><label>Code:</label></td>
                    <td><input type="text" name="code" value="<%=request.getParameter("code")%>"></td>
                </tr>
                <tr>
                    <td><label>Description</label></td>
                    <td><input type="text" name="description" value="<%=request.getParameter("description")%>"></td>
                </tr>
            </table>
            <button type="submit">Save</button>
        </form>
                <a href="../GetItemCategories">Back</a>
    </body>
</html>
