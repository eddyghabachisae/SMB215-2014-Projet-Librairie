<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Country</h1>
        <form action="AddCountry" method="post">
            <table>
                <tr>
                    <td><label for="txtCountryShortName">Short name:</label></td>
                    <td><input type="text" id="txtCountryShortName" name="txtCountryShortName"></td>
                </tr>
                <tr>
                    <td><label for="txtCountryName">Name:</label></td>
                    <td><input type="text" id="txtCountryName" name="txtCountryName"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit">Save</button></td>
            </tr>
            </table>
        </form>
    </body>
</html>
