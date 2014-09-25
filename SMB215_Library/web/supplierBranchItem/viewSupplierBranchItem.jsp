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
        <title>Supplier Branch Item</title>
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
                        <h1>Supplier branch: <%=request.getParameter("supplierbranchname")%></h1>
                        <div class="pull-right">
                            <a href="GetSupplierBranchItem?supplierbranchid=<%=request.getParameter("id")%>&amp;supplierbranchname=<%=request.getParameter("supplierbranchname")%>"><input type="submit" name="Submit" value="Add Item" class="button"/></a>
                        </div>
                        <div class="clear2"></div>
                        <div class="CSSTableGenerator" >        
        <table >
                                <tbody>
                                    <tr>
                                        
                                        <td>Item</td>
                                        <td>Price <%= (session.getAttribute("mainCurrency")!=null?session.getAttribute("mainCurrency"):"")%></td>
                                             <% if(session.getAttribute("secondaryCurrency")!=null) {%>               
                                                            <td>Price 
                                            <%= session.getAttribute("secondaryCurrency")%>
                                        </td><%}%>
                                        <td>Shipping days</td>
                                        <td width="10%">Actions</td>
                                    </tr>
            <c:forEach items="${supplierBranchItems}" var="spi">
                <tr>
                    
                    <td>${spi.itemname}</td>
                    <td>${spi.price}</td>
                    <% if(session.getAttribute("secondaryCurrency")!=null) {%>               
                    <td>${spi.secondaryprice}</td><%}%>
                    <td>${spi.shippingdays}</td>
                    <td>
                        <a href="GetSupplierBranchItem?id=${spi.id}&amp;supplierbranchid=${spi.supplierbranch}&amp;supplierbranchname=<%=request.getParameter("supplierbranchname")%>" title="Edit" class="fa fa-lg fa-pencil-square-o"></a>
                        <a href="DeleteSupplierBranchItem?id=${spi.id}&amp;supplierbranchid=${spi.supplierbranch}&amp;supplierbranchname=<%=request.getParameter("supplierbranchname")%>" title="Delete" class="fa fa-lg fa-trash-o"></a> 
                    </td>
                </tr>
            </c:forEach>
        </table>
         </div>
                        <div class="clear"></div>
                        <div id="tnt_pagination">
                            <span class="disabled_tnt_pagination">Prev</span>
                            <span class="active_tnt_link">1</span>
                            <a href="#1">2</a>
                            <a href="#2">3</a>
                            <a href="#3">4</a>
                            <a href="#5">5</a>
                            <a href="#6">6</a>
                            <a href="#7">7</a>
                            <a href="#8">8</a>
                            <a href="#9">9</a>
                            <a href="#10">10</a>
                            <a href="#forward">Next</a></div>


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



