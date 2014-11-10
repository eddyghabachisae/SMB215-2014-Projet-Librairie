<%@page import="Client.ClientBook.Borrowed"%>
<%@page import="Client.ClientBook.BorrowedBean"%>
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
           <section id="content1"><div class="ic"></div>
                                <%
                                //parse session id variable to long type
                                Object attribute = request.getSession().getAttribute("userid");
                                Integer userid = Integer.parseInt(String.valueOf(attribute));  
                                
                                //generate Books list
                                BorrowedBean BorrowedbksBean = new BorrowedBean();
                                List<Borrowed> Borrowedlist = BorrowedbksBean.getBorrowed(userid);  
                                pageContext.setAttribute("Borrowedlist1", Borrowedlist);
                                %>
                                
                           <br />
                            
                            <table width="100%"cellspacing=0" cellpading="0">
                                
                                <tr>
                                    <td colspan="6" valign="bottom">View list of existing Books in Library database</td>  
                                    <td align="right"></td>
                                </tr>
                                <tr>
                                    <td colspan="6"><hr width="100%"></td>
                                </tr>
                                <tr>
                                    <td width="200px"><strong>Book Title</strong></td>
                                    <td><strong>Subtitle</strong></td>                                    
                                    <td><strong>Borrowing Date</strong></td>
                                    <td><strong>returned</strong></td>
                                    <td><strong></strong></td>
                                    <td></td>
                                </tr>
                                <c:forEach items="${Borrowedlist1}" var="boks1">  
                                <tr>
                                     <td width="200px">${boks1.bok_title}</td>
                                     <td>${boks1.bok_subtitle}</td>
                                     <td>${boks1.reservation_date}</td>
                                     <td>
                                     <c:choose>
                                            <c:when test="${boks1.returned == 'false'}">No.
                                            </c:when>
                                            <c:otherwise>Yes
                                            </c:otherwise>
                                      </c:choose>
                                     
                                     
                                     
                                     </td>
                                     <td></td>
                                     <td>
                                         
                                     </td>
                                </tr>
                                </c:forEach>

                            </table>
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



