<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add profession</title>
    </head>
    <body>
        <div>
            <form action="Addprofession" method="post">
                <h2>Add new profession</h2>
                <table>
                    <tr>
                        <td><label>profession ID:</label></td>
                        <td><input type="text" name="prfid"/></td>
                    </tr>
                    <tr>
                        <td><label>profession description</label></td>
                        <td><input type="text" name="prfdescription"/></td>
                    </tr>
                    <tr>
                        <td>
                            <button type="submit">Add profession</button>
                        </td>
                    </tr>
                </table>
            </form>
            <br>
            <p><a href="index.html">Back to home page</a></p>
        </div>
    </body>
</html>
