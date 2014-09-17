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
                                        <li><a href="">Inbox</a></li>
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
                            <a href="GetItem"><input type="submit" name="Submit" value="Add New Item" class="button"/></a>
                        </div>
                        <div class="clear2"></div>
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
                                                <a href="" title="Avaible" class="fa fa-lg fa-check" ></a>
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
                                        <td>${item.itemCategory_id}</td>
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
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="clear"></div>
                        <div id="tnt_pagination">
                            <span class="disabled_tnt_pagination">Prev</span>
                            <a href="#1">1</a><a href="#2">2</a>
                            <a href="#3">3</a>
                            <span class="active_tnt_link">4</span>
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
                        Guide.com &copy; 2012
                        <span><a class="link" target="_blank" href="http://www.templatemonster.com/" rel="nofollow">Website Template</a> by TemplateMonster.com</span><span>More <a href="http://www.websitetemplatesonline.com" title="WTO - website templates and Flash templates">Free Web Templates</a> at WTO. All <a href="http://www.magentothemesworld.com" title="Best Magento Templates">premium Magento themes</a> at magentothemesworld.com!</span>
                    </div>
                </div>
            </footer>
        </div>
        <script type="text/javascript"> Cufon.now();</script>
    </body>
</html>



