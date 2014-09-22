<%@page import="itemCategory.ItemCategory"%>
<%@page import="itemCategory.ItemCategoryBean"%>
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
                        
                        <div class="clear2"></div>
                        <ul id="tabs">
                                    <li><a href="" title="tab1" class="activeTab">Select Books</a></li>
                                    <li><a href="" title="tab2" class="notActive">Rentals Info</a></li>
                       </ul>
                        <div id="content3"> 
                            <div class="error_box"></div>
                     <form id="form" name="form" action="./SaveSelectedBook" method="post" >                    
                          
                        <div class="CSSTableGenerator" >
                            <table >
                                <tbody>
                                    <tr>
                                        <td width="10%">Select</td>
                                        <td>Title</td>
                                        <td width="20%">Rent Price</td>
                                    </tr>
                                <c:forEach items="${booksList}" var="book">
                                    <tr>
                                        <td><input name="selectedBooks" type="checkbox" value="${book.id}"/></td>
                                        <td>${book.title}</td>
                                        <td>${book.rentPrice}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                         <fieldset>
                             <div class="wrapper">
                                <div class="extra-wrap">		
                                  <div class="buttons">
					<input type="button" name="Submit" value="Submit" class="button" id="submitBtn"/>
                                        <a href="GetBooks"><input type="button" name="Cancel" value="Cancel" class="button"/></a>
                                </div> 

                            </div>

                          </div> 
                         </fieldset>
                     </form>
                        </div>
                        <div class="clear"></div>
                        
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
    
    <script>
        $('#submitBtn').click(function () {
            var atLeastOneIsChecked = $('input:checkbox').is(':checked');
            if(atLeastOneIsChecked == false){
                $('.error_box').html("Select One At Least!");
               $('.error_box').css('display','block'); 
            }
            else{
              document.getElementById("form").submit();  
            }
            
        });
    </script>
</html>



