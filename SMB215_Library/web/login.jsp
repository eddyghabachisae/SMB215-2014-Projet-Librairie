<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">

  <title>Login</title>
  <link rel="stylesheet" href="public/stylesheets/login.css" media="screen" type="text/css" />

</head>

<body>

  <div class="login-card">
    <h1>Log-in</h1><br>
  <form action="DoLogin" method="post">
    <input type="text" name="user" placeholder="Username">
    <input type="password" name="pass" placeholder="Password">
    <input type="submit" name="login" class="login login-submit" value="login">
  </form>

  <div class="login-help">
     <% if ((request.getParameter("success") != null) && (request.getParameter("success").equals("false"))) { %>
      <p style="text-align:center;color:red">Login failed! Try again</p>
      <%}%>
  </div>
</div>


</body>

</html>
