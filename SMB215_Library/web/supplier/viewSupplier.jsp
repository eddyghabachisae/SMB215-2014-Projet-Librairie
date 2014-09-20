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
                        <div class="pull-right">
                            <a href="GetSupplier"><input type="submit" name="Submit" value="Add New Supplier" class="button"/></a>
                        </div>
                        <div class="clear2"></div>
                        <div class="CSSTableGenerator" >        
                            <table >
                                <tbody>
                                    <tr>
                                        <td width="10%">Active</td>
                                        <td>Name</td>
                                        <td>Website</td>
                                        <td>Branches</td>
                                        <td width="10%">Actions</td>
                                    </tr>
                                    <c:forEach items="${suppliers}" var="sup">
                                        <tr>
                                            <td><c:choose>
                                                    <c:when test="${sup.isactive==true}" >
                                                        <a href="" title="Active" class="fa fa-lg fa-check"></a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a href="" title="Not Active" class="fa fa-lg fa-times"></a>   
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>${sup.name}</td>
                                            <td>${sup.website}</td>
                                            <td>
                                                <a href="GetSupplierBranches?id=${sup.id}&amp;suppliername=${sup.name}">Branches</a>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${sup.isactive==true}" >
                                                        <a href="DeactivateSupplier?id=${sup.id}" title="Deactivate" class="fa fa-lg fa-times"></a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a href="ActivateSupplier?id=${sup.id}" title="Activate" class="fa fa-lg fa-check"></a>   
                                                    </c:otherwise>
                                                </c:choose>
                                                <a href="GetSupplier?id=${sup.id}" title="Edit" class="fa fa-lg fa-pencil-square-o"></a>
                                                <a href="DeleteSupplier?id=${sup.id}" title="Delete" class="fa fa-lg fa-trash-o"></a> 
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



