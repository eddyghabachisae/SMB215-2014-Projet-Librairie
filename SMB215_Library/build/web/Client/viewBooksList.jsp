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
                                long userId = Long.parseLong(String.valueOf(attribute));   
                                
                                //generate Books list
                                BookBean BooksBean = new BookBean();
                                List<Book> Bookslist = BooksBean.getBooks();  
                                pageContext.setAttribute("Bookslist1", Bookslist);
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
                                    <td><strong>Publisher</strong></td>
                                    <td><strong>Publish Date</strong></td>
                                    <td><strong>ISBN</strong></td>
                                    <td><strong>Actions</strong></td>
                                </tr>
                                <c:forEach items="${Bookslist1}" var="bok1">  
                                <tr>
                                     <td width="200px">${bok1.title}</td>
                                     <td>${bok1.subtitle}</td>
                                     <td>${bok1.publisher}</td>
                                     <td>${bok1.publishDate}</td>
                                     <td>${bok1.isbn}</td>
                                     <td>
                                         <a href="BookAvailability.jsp?bok_id=${bok1.id}"><input type="submit" name="Submit" value="Check Availability" class="button"></a>
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



