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
           <section id="content1"><div class="ic"></div>
                                <%
                                //parse session id variable to long type
                                Object attribute = request.getSession().getAttribute("userid");
                                long userId = Long.parseLong(String.valueOf(attribute));   
                                
                                int bookid = Integer.parseInt(request.getParameter("bok_id"));
                                //generate Books list
                                AvailabilityBean AvailabilitiesBean = new AvailabilityBean();
                                List<Availability> Availabilitylist = AvailabilitiesBean.getAvailability(bookid);  
                                pageContext.setAttribute("Availabilitylist1", Availabilitylist);
                                %>
                                
                           <br />
                            
                            <table width="100%"cellspacing=0" cellpading="0">
                                
                                <tr>
                                    <td colspan="6" valign="bottom"><h3 class="prev-indent-bot">View Availability of Selected Book in Library database</h3></td>  
                                    <td align="right"></td>
                                </tr>
                                <tr>
                                    <td colspan="6"><hr width="100%"></td>
                                </tr>
                                <c:forEach items="${Availabilitylist1}" var="avail1">  
                                <tr>
                                    <td width="200px"><strong>Book Title</strong></td>
                                    <td><strong>Item title/code</strong></td>
                                    <td><strong>Warehouse</strong></td>
                                    <td><strong>Branch</strong></td>
                                    <td><strong>City</strong></td>
                                    <td><strong>Actions</strong></td>
                                </tr>
                                
                                <tr>
                                     <td width="200px">${avail1.book_title}</td>
                                     <td>${avail1.item_name}</td>
                                     <td>${avail1.wrh_name}</td>
                                     <td>${avail1.brh_name}</td>
                                     <td>${avail1.cty_name}</td>
                                     <td>

                                        <a href="BookBorrow.jsp?item_id=${avail1.item_id}&&item_name=${avail1.item_name}&&item_min=${avail1.itm_quantity}"><input type="submit" name="Submit" value="Borrow This Item" class="button" <c:if test="${avail1.itm_minlimit >= avail1.itm_quantity}">disabled</c:if>></a>
                                        

                                     </td>
                                </tr>
                                                                <tr>
                                    <td width="200px"><strong>Minimum Allowed Quantity</strong></td>
                                    <td><strong>Maximum Allowed Quantity</strong></td>
                                    <td><strong>Available Quantity</strong></td>
                                    <td colspan="2"><strong></strong></td>
                                    <td><a href="BookTransfer.jsp?bok_id=${avail1.book_id}&&item_id=${avail1.item_id}&&item_min=${avail1.itm_quantity}"><input type="submit" name="Submit" value="Request Transfer this Item" class="button" <c:if test="${avail1.itm_minlimit >= avail1.itm_quantity}">disabled</c:if>></a></td>

                                </tr>
                                
                                <tr>
                                     <td width="200px">${avail1.itm_minlimit}</td>
                                     <td>${avail1.itm_maxlimit}</td>
                                     <td>${avail1.itm_quantity}</td>
                                     <td colspan="4"><strong></strong></td>
                                </tr>
                                
                                <tr>
                                     <td colspan="7"><strong><hr width ="100%"/></strong></td>
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



