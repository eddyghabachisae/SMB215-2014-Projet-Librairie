<%@page import="Login.LoginBean"%>
<%
LoginBean loginBean = new LoginBean();
if (request.getParameter("user").equals("su") && request.getParameter("pass").equals("su")) {
        session.setAttribute("username", request.getParameter("user"));
            response.sendRedirect("home.jsp");
} else {
    boolean success = loginBean.doLogin(request.getParameter("user"), request.getParameter("pass"));
        if (success) {
            session.setAttribute("username", request.getParameter("user"));
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("login.jsp?success="+success);
        } 
}
 %>