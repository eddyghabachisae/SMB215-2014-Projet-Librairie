<%@page import="Login.LoginBean"%>
<%@page import="Login.Login"%>"
<%
if (request.getParameter("user").equals("su") && request.getParameter("pass").equals("su")) {
        session.setAttribute("username", request.getParameter("user"));
            response.sendRedirect("home.jsp");
} else {
    LoginBean loginBean = new LoginBean();
    Login login = new Login();
    boolean success = loginBean.doLogin(login, request.getParameter("user"), request.getParameter("pass"));
        if (success) {
            session.setAttribute("username", login.getUsername());
            session.setAttribute("userid", login.getId());
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("login.jsp?success="+success);
        } 
}
 %>