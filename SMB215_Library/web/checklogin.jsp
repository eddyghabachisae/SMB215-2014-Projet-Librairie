<%@page import="Login.LoginBean"%>
<%
LoginBean loginBean = new LoginBean();
        boolean success = loginBean.doLogin(request.getParameter("user"), request.getParameter("pass"));
        if (success) {
            session.setAttribute("username", request.getParameter("user"));
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("login.jsp?success="+success);
        } 
 %>