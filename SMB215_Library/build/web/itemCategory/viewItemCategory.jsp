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
        <title>Item Category</title>
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
            <section id="content"><div class="ic"><div class="inner_copy">All <a href="http://www.magentothemesworld.com" title="Best Magento Templates">premium Magento themes</a> at magentothemesworld.com!</div></div>
                <div class="container_12">
                    <div class="wrapper">
                        <div class="pull-right">
                            <a href="GetItemCategory"><input type="submit" name="Submit" value="Add New Item Category" class="button"/></a>
                        </div>
                        <div class="clear2"></div>
                        <div class="CSSTableGenerator" >
                            <table border="1">
            <tr>
                <td>Code</td>
                <td>Description</td>
                <td width="10%">Actions</td>
            </tr>
            <c:forEach items="${itemCategories}" var="itc">
                <tr>
                    <td>${itc.code}</td>
                    <td>${itc.description}</td>
                    <td>
                        <a href="GetItemCategory?id=${itc.id}" title="Edit" class="fa fa-lg fa-pencil-square-o"></a>
                        <a href="DeleteItemCategory?id=${itc.id}" title="Delete" class="fa fa-lg fa-trash-o"></a> 
                    </td>
                </tr>
            </c:forEach>
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
