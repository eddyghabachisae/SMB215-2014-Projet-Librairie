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
                        <div class="pull-right">
                            <a href="GetBookCategory"><input type="submit" name="Submit" value="Add New Category" class="button"/></a>
                        </div>
                        <div class="clear2"></div>
                        <div class="CSSTableGenerator" >
                            <table >
                                <tbody>
                                    <tr>
                                        <td width="30%">Code</td>
                                        <td>Description</td>
                                        <td width="10%">Actions</td>
                                    </tr>
                                <c:forEach items="${bookCategoriesList}" var="bookCat">
                                    <tr>
                                        <td>${bookCat.code}</td>
                                        <td>${bookCat.description}</td>
                                        <td>
                                            <a href="GetBookCategory?id=${bookCat.id}" title="Edit" class="fa fa-lg fa-pencil-square-o"></a>
                                            <a href="DeleteBookCategory?id=${bookCat.id}" tite="Delete" class="fa fa-lg fa-trash-o"></a> 
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
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



