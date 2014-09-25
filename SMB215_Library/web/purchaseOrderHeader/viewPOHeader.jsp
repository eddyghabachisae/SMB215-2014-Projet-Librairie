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
        <title>PO Header</title>
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
                        <div class="pull-right">
                            <a href="GetPOHeader?mode=add"><input type="submit" name="Submit" value="New Purchase Order" class="button"/></a>
                        </div>
                        <div class="clear2"></div>
                        <div class="CSSTableGenerator" >
                            <table>
                                <tbody>
                                    <tr>
                                        <td>Order Date</td>
                                        <td>Status</td>
                                        <td>Supplier</td>
                                        <td>Branch</td>
                                        <td>Ordered by</td>
                                        <td>Total 
                                            <%= (session.getAttribute("mainCurrency")!=null?session.getAttribute("mainCurrency"):"")%>
                                        </td>
                                        <% if(session.getAttribute("mainCurrency")!=null) {%>
                                        <td>Total 
                                            <%= session.getAttribute("secondaryCurrency")%>
                                        </td><%}%>
                                        <td width="10%">Actions</td>
                                    </tr>

                                    <c:forEach items="${poheaders}" var="poh">
                                        <tr>
                                            <td>${poh.orderdate}</td>
                                            <td>${poh.status}</td>
                                            <td>${poh.suppliername}</td>
                                            <td>${poh.branchname}</td>
                                            <td>${poh.employeename}</td>
                                            <td>${poh.total}</td>
                                             <% if(session.getAttribute("secondaryCurrency")!=null) {%>
                                        <td> 
                                            ${poh.totalsecondary}
                                        </td><%}%>
                                            <td>
                                                           <c:set var="deliverydate" value="${poh.deliverydate}"/>               
                                       <% if ((pageContext.getAttribute("deliverydate") == null) || (pageContext.getAttribute("deliverydate") == "")) { %>
                                                <a href="GetPOHeader?mode=edit&amp;id=${poh.id}" title="Edit" class="fa fa-lg fa-pencil-square-o"></a>
                                              <a href="DeletePOHeader?id=${poh.id}" title="Delete" class="fa fa-lg fa-trash-o"></a> 
                                              <%} else {%>
                                              <a href="GetPOHeader?mode=view&amp;id=${poh.id}" title="View" >View</a>
                                              <%}%>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                                               </div>
                        <div class="clear"></div>
                        <div id="tnt_pagination">
                            <span class="disabled_tnt_pagination">Prev</span>
                            <span class="active_tnt_link">1</span>
                            <a href="#2">2</a>
                            <a href="#3">3</a>
                            <a href="#3">4</a>
                            <a href="#5">5</a>
                            <a href="#6">6</a>
                            <a href="#7">7</a>
                            <a href="#8">8</a>
                            <a href="#9">9</a>
                            <a href="#10">10</a>
                            <a href="#forwaed">Next</a></div>


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
