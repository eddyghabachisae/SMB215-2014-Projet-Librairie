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
                                    
			
                            <br>
                            <div class="CSSTableGenerator" >
                            <table id="booksTable">
                                <tbody>
                                    <tr>
                                        <td width="70%">Book Name</td>
                                        <td width="10%">Rent Price</td>
                                        <td width="2%">Actions</td>
                                    </tr>
                                <c:forEach items="${rentDetailsList}" var="det">
                                    <tr>
                                        <td>${det.getBook().title}</td>
                                        <td>${det.getBook().rentPrice} <%=request.getParameter("currency")%></td>
                                        <td>
                                            <a  onclick="" title="Return" class="fa fa-lg  fa-mail-reply-all"></a> 
                                        </td>
                                    </tr>
                                </c:forEach>
                                    <tr>
                                        <td colspan="3"><span id="total" style="margin-left:80%;"> Total: <%= request.getParameter("total")%></span></td>
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