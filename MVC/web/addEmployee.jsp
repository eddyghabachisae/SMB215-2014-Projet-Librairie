<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Employee</title>
    </head>
    <body>
        <div>
            <form action="AddEmployee" method="post">
                <h2>Add new employee</h2>
                <table>
                    <tr>
                        <td><label>Employee ID:</label></td>
                        <td><input type="text" name="empId"/></td>
                    </tr>
                    <tr>
                        <td><label>Employee Name:</label></td>
                        <td><input type="text" name="empName"/></td>
                    </tr>
                    <tr>
                        <td>
                            <button type="submit">Add Employee</button>
                        </td>
                    </tr>
                </table>
            </form>
            <br>
            <p><a href="index.html">Back to homepage</a></p>
        </div>
    </body>
</html>
