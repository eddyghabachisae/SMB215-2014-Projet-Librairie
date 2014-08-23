<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
    <center>
        <form action="home.jsp" method="post"> 
            <table>
                <tr>
                    <td colspan="2">
                        <img src="images/logo.png" alt="logo" height="171" width="249">
                    </td>
                </tr>
                <tr>
                    <td>
                        Username:
                    </td>
                    <td>
                        <input type="text" autofocus>
                    </td>
                </tr>
                <tr>
                    <td>
                        Password:
                    </td>
                    <td>
                        <input type="password">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align:right">
                        <button type="submit">Login</button>
                    </td>
                </tr>
            </table>
        </form>
    </center>
    </body>
</html>
