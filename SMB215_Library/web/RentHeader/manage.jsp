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
            <section id="content"><div class="ic"><div class="inner_copy">All <a href="http://www.magentothemesworld.com" title="Best Magento Templates">premium Magento themes</a> at magentothemesworld.com!</div></div>
                <div class="container_12">
                    <div class="wrapper">
                        <div class="pull-right">
                            <a href="./GetBooks"><input type="submit" name="Submit" value="New Rent Order" class="button"/></a>
                        </div>
                        <div class="clear2"></div>
                            `<%
                             if(!request.getParameter("listSize").equals("0"))
                             {
                            
                            %> 
                            <form id="form" name="form" action="SearchByNumber" method="post" >
                                <label><span class="text-form">Search By Order Number</span> <input type="text" class="inputText" id="orderNb" 
                                                        name="orderNb" value=""><input type="submit" name="Submit" value="Search" class="button"/></label> 
                            </form>
                            <% if(request.getParameter("isFilteringMode")!=null && request.getParameter("isFilteringMode").equals("true")) {%>
                            <a href="GetRentHeaders"><input type="submit" name="Submit" value="Show All" class="button"/></a>
                            <%}%>
                          <div class="CSSTableGenerator" >
                            <table >
                                <tbody>
                                    <tr>
                                        <td width="10%">Lateness</td>
                                        <td width="10%"># Number</td>
                                        <td>Customer Name</td>
                                        <td>Submit Date</td>
                                        <td>Books Nb</td>
                                        <td width="10%">Actions</td>
                                    </tr>
                                <c:forEach items="${rentHeadersList}" var="rent">
                                    <tr>
                                        <td>
                                           <c:choose>
                                            <c:when test="${rentHeaderMap.get(rent).equals('Late')}" >
                                                <span style="color: red" class="fa fa-lg fa-exclamation-triangle" title="Late"></span>
                                            </c:when>
                                            <c:otherwise>
                                                <span style="color: green" class="fa fa-lg fa-exclamation-triangle" title="Not Late"></span> 
                                            </c:otherwise>
                                            </c:choose>
                                        
                                        </td>
                                        <td>${rent.getId()}</td>
                                        <td>${rent.getCutomerName()}</td>
                                        <td>${rent.submitDate}</td>
                                        <td>${rent.getBooksNb()}</td>
                                        <td><a href="GetRentHeader?id=${rent.id}" title="View Details" class="fa fa-lg fa fa-eye"></a></td>
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
                        <div class="clear"></div>
                        


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



