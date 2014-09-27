<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
            <section id="content"><div class="ic"></div>
                <div class="container_12">
                    <div class="wrapper">
                        <h3 class="">Book Authors</h3>
                        <a href="./GetItems"><input type="submit" name="Submit" value="Back To Items" class="button"/></a>
                        <div class="pull-right">
                            <a href="GetAuthor"><input type="submit" name="Submit" value="Add New Author" class="button"/></a>
                        </div>
                        <div class="clear2"></div>
                        <%
                             if(!request.getParameter("listSize").equals("0"))
                             {
                            
                          %>
                        <div class="CSSTableGenerator" >
                            <table>
                                <tbody>
                                    <tr>
                                        <td>Code</td>
                                        <td>Name</td>
                                        <td width="10%">Actions</td>
                                    </tr>

                                    <c:forEach items="${authors}" var="cnt">
                                        <tr>
                                            <td>${cnt.code}</td>
                                            <td>${cnt.name}</td>
                                            <td>
                                                <a href="GetAuthor?id=${cnt.id}" title="Edit" class="fa fa-lg fa-pencil-square-o"></a>
                                                <a href="DeleteAuthor?id=${cnt.id}" title="Delete" class="fa fa-lg fa-trash-o"></a> 
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
                        ISAE &copy; 2014
                    </div>
                </div>
            </footer>
        </div>
        <script type="text/javascript"> Cufon.now();</script>
    </body>
</html>
