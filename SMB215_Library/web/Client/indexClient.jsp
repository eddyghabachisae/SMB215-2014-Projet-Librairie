<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
        <% 
        if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
      response.sendRedirect("login.jsp");
        }
    %>
    <head>
        <title>Client Home Page</title>
        <%@ include file="../main.html" %>
    </head>
    
    <body id="page1">
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
                <div class="container_12">
                    <div class="wrapper">
                        <div class="pull-left">
                            Welcome to the Profile page of user: <b><%= request.getParameter("username") %></b><br />
                            
                            <h1>General Information:</h1><br /><br />
                            First Name: <i><%= request.getParameter("FirstName") %></i> <br/>
                            Last Name: <i><%= request.getParameter("LastName") %></i><br />
                            </br>
Please select an option from the below:
                        </div><br />
                         
                            
                        
                        <div class="clear2"></div>
            
                        <div class="clear"></div>
                        


                    </div>
                </div>
            </section>           

<section id="Edit"><div class="ic"></div>
                <div class="container_12">
                    <div class="wrapper">
                        <div class="pull-left">
                            <a href="GetClient"><input type="submit" name="Submit" value="Edit My Profile" class="button"/></a>
                            <a href="GetClient"><input type="submit" name="Submit" value="Borrow a book" class="button"/></a>
                            <a href="GetClient"><input type="submit" name="Submit" value="Borrowed Books List" class="button"/></a>
                            <a href="GetClient"><input type="submit" name="Submit" value="change your password" class="button"/></a>
                        </div>
                        <div class="clear2"></div>
            
                        <div class="clear"></div>
                        


                    </div>
                </div>
            </section>

            <!--==============================footer=================================-->
            <footer>
                <div class="inner">
                    <div class="footer-bg">
                        ISAE &copy; 2014
                    </div>
                </div>
            </footer>
        </div>
        <script type="text/javascript"> Cufon.now();</script>
    </body>
</html>



