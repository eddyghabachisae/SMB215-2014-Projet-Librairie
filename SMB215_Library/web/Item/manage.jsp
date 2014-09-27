<%@page import="itemCategory.ItemCategory"%>
<%@page import="itemCategory.ItemCategoryBean"%>
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
                                        <li><a class="active" href="${pageContext.request.contextPath}/home.jsp">Main</a></li>
                                        <li><a href="">Logout</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>

                    <div class="clear"></div>
                </div>
            </header>

            <!--==============================content================================-->
            <section id="content">
                <div class="container_12">
                    <div class="wrapper">
                        <article class="grid_2">
                            <div class="box" style="height:40px;">
                               <a href="./GetItemCategories" style="margin-left: 20%;margin-top: 5%; text-decoration:none;"> Item Category</a>
                            </div>
                        </article>
                        <article class="grid_2">
                            <div class="box" style="height:40px;">
                               <a href="./GetBookCategories" style="margin-left: 20%;margin-top: 5%; text-decoration:none;"> Book Category</a>
                            </div>
                        </article>
                          <article class="grid_2">
                            <div class="box" style="height:40px;">
                               <a href="./GetBookLanguages" style="margin-left: 20%;margin-top: 5%; text-decoration:none;"> Book Language</a>
                            </div>
                            </article>
                         <article class="grid_2">
                            <div class="box" style="height:40px;">
                               <a href="./GetAuthors" style="margin-left: 20%;margin-top: 5%; text-decoration:none;"> Book Authors</a>
                            </div>
                           </article>
                        
                        <div class="pull-right">
                            <a href="GetItem"><input type="submit" name="Submit" value="Add New Item" class="button"/></a>
                        </div>
                        <div class="clear2"></div>
                         <%
                             if(!request.getParameter("listSize").equals("0"))
                             {
                            
                          %> 
                        <div class="CSSTableGenerator" >
                            <table >
                                <tbody>
                                    <tr>
                                        <td width="10%">Availability</td>
                                        <td width="10%">is Active</td>
                                        <td>Name</td>
                                        <td>Category</td>
                                        <td>Quantity</td>
                                        <td width="10%">Actions</td>
                                    </tr>
                                <c:forEach items="${itemsList}" var="item">
                                    <tr>
                                        <td><c:choose>
                                            <c:when test="${item.isAvailable==true}" >
                                                <a href="" title="Available" class="fa fa-lg fa-check" ></a>
                                            </c:when>
                                            <c:otherwise>
                                             <a href="" title="Not Available" class="fa fa-lg fa-times" ></a>   
                                            </c:otherwise>
                                            </c:choose></td>
                                        <td><c:choose>
                                            <c:when test="${item.isActive==true}" >
                                                <a href="" title="Active" class="fa fa-lg fa-check"></a>
                                            </c:when>
                                            <c:otherwise>
                                             <a href="" title="Not Active"class="fa fa-lg fa-times"></a>   
                                            </c:otherwise>
                                            </c:choose></td>
                                        <td>${item.name}</td>
                                        <td>${item.getItemCategoryName()}</td>
                                        <td>${item.quantity}</td>
                                        <td>
                                            <c:choose>
                                            <c:when test="${item.isActive==true}" >
                                                <a href="DeactivateItem?id=${item.id}" title="Deactivate" class="fa fa-lg fa-times"></a>
                                            </c:when>
                                            <c:otherwise>
                                             <a href="ActivateItem?id=${item.id}" title="Activate" class="fa fa-lg fa-check"></a>   
                                            </c:otherwise>
                                            </c:choose>
                                            <a href="GetItem?id=${item.id}" title="Edit" class="fa fa-lg fa-pencil-square-o"></a>
                                            <a href="DeleteItem?id=${item.id}" tite="Delete" class="fa fa-lg fa-trash-o"></a> 
                                            <a href="PrintBracode?id=${item.id}" tite="Print" class="fa fa-lg fa-print"></a> 
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                                         <%}
                             else{
                            %>
                            <br>
                            <div class="emptyList_box">List is Empty!</div>
                            <%}%>
                        </div>
                        


                    </div>
                </div>
            </section>

            <!--==============================footer=================================-->
            <footer>
                <div class="inner">
                    <div class="footer-bg">
                    ISAE &copy; 2014</div>
                </div>
            </footer>
        </div>
        <script type="text/javascript"> Cufon.now();</script>
    </body>
</html>



