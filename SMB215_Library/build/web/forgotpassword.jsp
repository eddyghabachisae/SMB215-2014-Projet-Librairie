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
    <h1>Forgot your password?</h1><br>
  <form action="forgotpassword" method="post">
    <input type="text" name="user" placeholder="please type your username">
    
    <input type="submit" name="login" class="login login-submit" value="Send me new password">
  </form>

  <div class="login-help">
     <% if ((request.getParameter("success") != null) && (request.getParameter("success").equals("false"))) { %>
      <p style="text-align:center;color:red">username doesn't exist! Try again</p>
      <%}%>
  </div>
</div>


</body>

</html>
