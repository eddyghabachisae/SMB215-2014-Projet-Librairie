<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Client.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml" xmlns:h="http://java.sun.com/jsf/html">
        <% 
        if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
      response.sendRedirect("login.jsp");
        }
    %>
    <h:head>
        <title>Client Home Page</title>
        <%@ include file="../main.html" %>
    </h:head>
    
    <h:body id="page1">
        <div class="main">
            <!--==============================header=================================-->
            <header>
                <div class="container_12">
                    <div class="wrapper p3">
                        <div class="grid_12">
                            <div class="wrapper border-bot">
                                <h1><a href="${pageContext.request.contextPath}/home.jsp">Library</a></h1>
                                <nav>
                                    <ul class="menu">
                                        <li><b><% out.print(session.getAttribute("username"));%></b></li>
                                        <li><a class="active" href="${pageContext.request.contextPath}/home.jsp">Main</a></li>
                                    <li><a href="logout.jsp">Logout</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>

                    <div class="clear"></div>
                </div>
            </header>
<!--==============================content================================-->
 <section id="content1"><div class="ic"></div>
     
                            Welcome to the Profile page of user: <b><%= request.getParameter("username") %></b><br />
                            
                            <table width="100%"cellspacing=0" cellpading="0">
                                <tr><td colspan="2"><h1>General Information:</h1><br /><br /></td></tr>
                                <tr>
                            <td  width="150px"><image src="../images/Client/<%= request.getParameter("id") %>.jpg" border="2" /> </td><td>
                                Full Name:
                                    
                            <i><%= request.getParameter("FirstName") %> <%= request.getParameter("LastName") %></i> <br/>
                            Gender:  <i><%= request.getParameter("Gender") %> </i> <br/>
                            Marital status:  <i><%= request.getParameter("Maritalstatus") %> </i> <br/>
                            Address:  <i><%= request.getParameter("Address") %> </i> <br/>
                            City:  <i><%= request.getParameter("City") %> </i> <br/>
                            Phone:  <i><%= request.getParameter("Phone") %> </i> <br/>
                            Mobile:  <i><%= request.getParameter("Mobile") %> </i> <br/>
                            Email:  <i><%= request.getParameter("Email") %> </i> <br/>
                            Remarks:  <i><%= request.getParameter("Remarks") %> </i> <br/>
                            Is active?  <i><%= request.getParameter("Isactive") %> </i> <br/>                            
                            </br></td>
                            </tr>
                            <tr><td colspan="2">Please select an option from the below:</td></tr>
                            <tr><td colspan="2">
                                    <form action="${pageContext.request.contextPath}/GetClients" method="post"><input type="submit" name="Submit" value="Edit My Profile" class="button>/form>
                                   <a href="GetClient"><input type="submit" name="Submit" value="Borrow a book" class="button"/></a>
                            <a href="GetClient"><input type="submit" name="Submit" value="Borrowed Books List" class="button"/></a>
                            <a href="GetClient"><input type="submit" name="Submit" value="change your password" class="button"/></a>
                                </td>
                            </tr>
            </section>           



            <!--==============================footer=================================-->

        </div>   
         
        <script type="text/javascript"> Cufon.now();</script>
    </h:body>
</html>



