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
    <link rel="stylesheet" type="text/css" href="./public/stylesheets/dataTable.css">
    <script type="text/javascript" language="javascript" src="./public/javascripts/dataTable.js"></script>
    <script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#example').dataTable();
			} );
    </script>
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
                        <div style="margin-left:80%;">
                            <a href="./GetRentHeaders"><input type="submit" name="Submit" value="Back to List" class="button"/></a>
                        </div>
                        <ul id="tabs">
                                    <li><a href="" title="tab1" class="activeTab">Select Books</a></li>
                                    <li><a href="" title="tab2" class="notActive">Rentals Info</a></li>
                       </ul>
                        <div id="content3"> 
                     <div class="error_box"></div>
                     <form id="form" name="form" action="./SaveSelectedBook" method="post" >                    
                         
                         <table id="example" class="display" cellspacing="0" width="100%">
                             <thead>
                               <td width="10%">Select</td>
                               <td>Title</td>
                               <td width="10%">Barcode</td>
                               <td width="20%">Rent Price</td>  
                             </thead>
                             <tbody>
                                 <c:forEach items="${booksList}" var="book">
                                    <tr>
                                        <td><input name="selectedBooks" type="checkbox" value="${book.id}"/></td>
                                        <td>${book.title}</td>
                                        <td>${book.getItem().getBarcode()}</td>
                                        <td>${book.rentPrice} <%=request.getParameter("currency")%></td>
                                    </tr>
                                 </c:forEach>
                             </tbody>
                         </table>
                      
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
                   ISAE &copy; 2014 </div>
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



