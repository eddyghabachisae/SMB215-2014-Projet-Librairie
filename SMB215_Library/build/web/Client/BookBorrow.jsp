<%@page import="Client.ClientBook.Availability"%>
<%@page import="Client.ClientBook.AvailabilityBean"%>
<%@page import="java.util.List"%>
<%@page import="Book.Book"%>
<%@page import="Book.BookBean"%>
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
<section id="content"><div class="ic"></div>
                <div class="container_12">
                    <div class="wrapper">
                        <article class="grid_8">
                            <div class="indent-right">
                                <h3 class="prev-indent-bot">Borrow <%=request.getParameter("item_name")%>  from Library database</h3>

                                <div id="content3"> 
                                        <form id="form" name="form" action="../borrowBook" method="post" OnSubmit="return fncSubmit();" >                    
                                        <fieldset>
                                            
                                            <label><span class="text-form">are you sure you want to borrow this item?</span></label>
                                            
                                            <div class="wrapper">
                                                <div class="extra-wrap">		
                                                    <div class="buttons">
                                                        <input type="hidden" name="item_id" value="<%=request.getParameter("item_id")%>" />
                                                        <input type="hidden" name="item_min" value="<%=request.getParameter("item_min")%>" />
                                                        <input type="submit" name="Submit" value="Confirm" class="button"  />
                                                        <a href="indexClient.jsp"><input type="button" name="Cancel" value="Cancel" class="button"/></a>
                                                    </div> 
                                                </div>
                                            </div>                      
                                        </fieldset>						

                                    </form>

                                    
                                </div>
                            </div>
                        </article>

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



