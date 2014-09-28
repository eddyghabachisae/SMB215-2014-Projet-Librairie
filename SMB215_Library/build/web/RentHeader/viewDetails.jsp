<%@page import="java.text.SimpleDateFormat"%>
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
                        	<h3 class="prev-indent-bot">Order Details</h3>
                                
                                <div id="content3"> 
                                    <p><b>Cutomer  Name:</b> <%=request.getParameter("customer")%></p>
                                    <p><b>OrderDate    :</b> <%=request.getParameter("orderDate")%></p>
                                    <% if(request.getParameter("isLate").equals("true")){%>
                                    <div class="msg_box">The Customer has not Return These Books! He is Late <%=request.getParameter("lateDays")%> Days !</div>
			            <%}%>
                            <br>
                            <div class="CSSTableGenerator" >
                            <table id="booksTable">
                                <tbody>
                                    <tr>
                                        <td width="70%">Book Name</td>
                                        <td width="20%">Rent Price</td>
                                        <td width="20%">Return Date</td>
                                        <td width="2%">Actions</td>
                                    </tr>
                                <c:forEach items="${rentDetailsList}" var="det">
                                    <tr>
                                        <td>${det.getBook().title}</td>
                                        <td>${det.getBook().rentPrice} <%=request.getParameter("currency")%></td>
                                        <td>
                                            <c:choose>
                                            <c:when test="${det.getReturnedDate()!=null}" >
                                            ${det.getReturnedDate()}
                                            </c:when>
                                                <c:otherwise>
                                                    Not Returned!
                                                </c:otherwise>
                                             </c:choose>
                                            </td>
                                        <td>
                                            <c:choose>
                                            <c:when test="${det.getReturnedDate()==null}" >
                                            <form id="form" name="form" action="ReturnBook?id=${det.getId()}" method="post" > 
                                            <input type="hidden" value="<%= session.getAttribute("userid")%>" name="employee"/>
                                            <input type="submit" name="Submit" value="Submit" class="button"/>
                                            </form>
                                            </c:when>
                                                <c:otherwise>
                                                   Returned!
                                                </c:otherwise>
                                             </c:choose>
                                       </td>
                                    </tr>
                                </c:forEach>
                                    <tr>
                                        <td colspan="4"><span id="total" style="margin-left:80%;"> Total: <%= request.getParameter("total")%></span></td>
                                    </tr>
                                </tbody>
                            </table>        
                                </div>
                            		<div class="wrapper">
                                        <div class="extra-wrap">		
                                            <div class="buttons">
                                                        <a href="GetRentHeaders"><input type="button" name="back" value="Back" class="button"/></a>
                                            </div> 
										
                                        </div>
										
                                      </div>  						
                            </form>
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
	<script type="text/javascript"> Cufon.now(); </script>
</body>

</html>