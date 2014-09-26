<%@page import="Item.Item"%>
<%@page import="Item.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
     <%
        if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
            response.sendRedirect("login.jsp");
        }
    %>
    <%@ include file="../main.html" %>
    <script src="./public/javascripts/jQuery.print.js"></script>
    <body id="page5">
        <div class="main">
            <!--==============================header=================================-->
            <header>
                <div class="container_12">
                    <div class="wrapper">
                        <div class="grid_12">
                            <div class="wrapper border-bot">
                                <h1><a href="home.jsp">Library</a></h1>
                                <nav>
                                    <ul class="menu">
                                        <li><a class="active" href="${pageContext.request.contextPath}/home.jsp">Main</a></li>
                                        <li><a href="">Logout</a></li>
                                    </ul>
                                </nav>
                            </div>

                        </div>
                    </div>
                </div>
            </header>

            <!--==============================content================================-->
            <section id="content">
                <div class="container_12">
                    <div class="wrapper">
                        <article class="grid_8">
                            <div class="indent-right">
                                <h3 class="prev-indent-bot"><%=request.getParameter("name")%></h3>
                                 <div id="content3">
                                  <% if(!request.getParameter("imgBarcodePath").equals("")) { %> 
                                  <div class="printable">
                                  <img  src="<%=request.getParameter("imgBarcodePath")%>" style="width:150px; height:50px;"  />
                                   </div>
                                  <a href=""  >print</a> 
                                  <%} else {%>
                                  <div class="emptyList_box">No Barcode !</div>
                                  <%} %>
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
       
       <script type="text/javascript">
 
        // When the document is ready, initialize the link so
        // that when it is clicked, the printable area of the
        // page will print.
        $(
            function(){
 
                // Hook up the print link.
                $( "a" )
                    .attr( "href", "javascript:void( 0 )" )
                    .click(
                        function(){
                            // Print the DIV.
                            $( ".printable" ).print();
 
                            // Cancel click event.
                            return( false );
                        }
                        )
                ;
 
            }
            );
 
    </script>
    </body>
</html>