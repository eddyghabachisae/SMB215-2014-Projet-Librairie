
<%
session.setAttribute("username", null);
session.setAttribute("userid", null);
session.invalidate();
response.sendRedirect("login.jsp");
%>