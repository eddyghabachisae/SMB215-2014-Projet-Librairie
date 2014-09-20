<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
        <% 
        if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
      response.sendRedirect("login.jsp");
        }
    %>
    <%@ include file="../main.html" %>
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
                        <h1>Supplier: <%=request.getParameter("suppliername")%></h1>
                        <div class="pull-right">
                            <a href="GetSupplierBranch?supplier=<%=request.getParameter("supplier")%>&amp;suppliername=<%=request.getParameter("suppliername")%>"><input type="submit" name="Submit" value="Add New Supplier Branch" class="button"/></a>
                        </div>
                        <div class="clear2"></div>
                        <div class="CSSTableGenerator" >        
        <table >
                                <tbody>
                                    <tr>
                                        <td width="10%">Active</td>
                                        <td>Name</td>
                                        <td>Contact Name</td>
                                        <td>Phone</td>
                                        <td>Items</td>
                                        <td width="10%">Actions</td>
                                    </tr>
            <c:forEach items="${supplierBranches}" var="sbr">
                <tr>
                    <td><c:choose>
                                                    <c:when test="${sbr.isactive==true}" >
                                                        <a href="" title="Active" class="fa fa-lg fa-check"></a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a href="" title="Not Active" class="fa fa-lg fa-times"></a>   
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                    <td>${sbr.name}</td>
                    <td>${sbr.contactname}</td>
                    <td>${sbr.phone}</td>
                    <td><a href="GetSupplierBranchItems?id=${sbr.id}&amp;supplierbranchname=${sbr.name}">Items</a></td>
                    <td>
                        <c:choose>
                                                    <c:when test="${sbr.isactive==true}" >
                                                        <a href="DeactivateSupplierBranch?id=${sbr.id}&amp;supplierid=${sbr.supplier}&amp;suppliername=<%=request.getParameter("suppliername")%>" title="Deactivate" class="fa fa-lg fa-times"></a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a href="ActivateSupplierBranch?id=${sbr.id}&amp;supplierid=${sbr.supplier}&amp;suppliername=<%=request.getParameter("suppliername")%>" title="Activate" class="fa fa-lg fa-check"></a>   
                                                    </c:otherwise>
                                                </c:choose>
                        <a href="GetSupplierBranch?id=${sbr.id}&amp;supplier=${sbr.supplier}&amp;suppliername=<%=request.getParameter("suppliername")%>" title="Edit" class="fa fa-lg fa-pencil-square-o"></a>
                        <a href="DeleteSupplierBranch?id=${sbr.id}?supplier=${sbr.supplier}" title="Delete" class="fa fa-lg fa-trash-o"></a> 
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



