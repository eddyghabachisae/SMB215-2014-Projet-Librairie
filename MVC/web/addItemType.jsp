<%-- 
    Document   : addItemType
    Created on : Aug 15, 2014, 3:36:44 PM
    Author     : Elie X2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Item Type</title>
    </head>
    <body>
      <div>
            <form action="AddItemType" method="post">
                <h2>Add new Item Type</h2>
                <table>
                    <tr>
                        <td><label>Type ID:</label></td>
                        <td><input type="text" name="typeid"/></td>
                    </tr>
                    <tr>
                        <td><label>Label:</label></td>
                        <td><input type="text" name="typelabel"/></td>
                    </tr>
                    <tr>
                        <td>
                            <button type="submit">Add new Item type</button>
                        </td>
                    </tr>
                </table>
            </form>
            <br>
            <p><a href="index.html">Back to homepage</a></p>
        </div>
    </body>
</html>
