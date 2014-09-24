<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
     <%
        if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
            response.sendRedirect("login.jsp");
        }
    %>
<%@ include file="../main.html" %>

<body id="page5">
	<div class="main">
        <!--==============================header=================================-->
        <header>
            <div class="container_12">
                <div class="wrapper">
                    <div class="grid_12">
                        <div class="wrapper border-bot">
                            <h1><a href="index.html">Library</a></h1>
                            <nav>
                                 <ul class="menu">
                                    <li><a class="active" href="${pageContext.request.contextPath}/home.jsp">Main</a></li>
                                    <li><a href="">Logout</a></li>
                                </ul>
                            </nav>
                        </div>
                        
                    </div>
                </div>
            </div>
        </header>
        
        <!--==============================content================================-->
        <section id="content"><div class="ic"><div class="inner_copy">All <a href="http://www.magentothemesworld.com" title="Best Magento Templates">premium Magento themes</a> at magentothemesworld.com!</div></div>
            <div class="container_12">
                <div class="wrapper">
                    <article class="grid_8">
                    	<div class="indent-right">
                        	<h3 class="prev-indent-bot">Rental Order</h3>
                                <ul id="tabs">
                                    <li><a href="" title="tab1" class="notActive">Select Books</a></li>
                                    <li><a href="" title="tab2" class="activeTab">Rentals Info</a></li>
                                </ul>
                                <div id="content3"> 
                                    <div class="success_box">All of the fields were successfully validated!</div>
                                    <div class="error_box"></div>
                           
                            <form id="form" name="form" action="SaveRentHeader" method="post" >                    
                                <fieldset>
                                    <input type="hidden" value="<%= session.getAttribute("userid")%>" name="employee"/>
                                    <label><span class="text-form">Customer*</span>
                                          <select name="selectedCustomer" id="selectedCustomer" >
                                              <option value="" selected >Select</option>
                                            <c:forEach items="${customersList}" var="customer">
					   <option value="${customer.id}">${customer.firstname} ${customer.lastname}</option>
                                            </c:forEach>
                                          </select></label>
			
                            <br>
                            <div class="CSSTableGenerator" >
                            <table id="booksTable">
                                <tbody>
                                    <tr>
                                        <td width="70%">Title</td>
                                        <td width="10%">Rent Price</td>
                                        <td width="2%">Actions</td>
                                    </tr>
                                <c:forEach items="${booksList}" var="book">
                                    <tr>
                                        <input type="hidden" name="selectedBooks" value="${book.id}"/>
                                        <td>${book.title}</td>
                                        <td>${book.rentPrice} <%=request.getParameter("currency")%></td>
                                        <td>
                                            <a  onclick="deleteRow(this,${book.rentPrice})" title="Delete" class="fa fa-lg fa-trash-o"></a> 
                                        </td>
                                    </tr>
                                </c:forEach>
                                    <tr>
                                        <td colspan="3"><span id="total" style="margin-left:80%;"> Total: <%= request.getParameter("totalPrice")%></span></td>
                                    </tr>
                                </tbody>
                            </table>        
                                </div>
                            		<div class="wrapper">
                                        <div class="extra-wrap">		
                                            <div class="buttons">
							<input type="submit" name="Submit" value="Submit" class="button"/>
                                                        <a href="./GetRentHeaders"><input type="button" name="Cancel" value="Cancel" class="button"/></a>
                                            </div> 
										
                                        </div>
										
                                      </div>                      
                                </fieldset>						
                            </form>
                        </div>
                    </article>
                    
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
	<script type="text/javascript"> Cufon.now(); </script>
</body>
<script type="text/javascript">
   var totalPrice = <%=request.getParameter("totalPrice")%>;
function deleteRow(r,price)
{
var i = r.parentNode.parentNode.rowIndex;
totalPrice = totalPrice- price;
$('#total').html('Total: '+totalPrice);
document.getElementById("booksTable").deleteRow(i);
}    

new FormValidator('form', [
{
    name:'selectedCustomer',
    display: 'Customer',    
    rules: 'required'
}
], function(errors, event) {
    var SELECTOR_ERRORS = $('.error_box'),
        SELECTOR_SUCCESS = $('.success_box');
        
    if (errors.length > 0) {
        SELECTOR_ERRORS.empty();
        
        for (var i = 0, errorLength = errors.length; i < errorLength; i++) {
            SELECTOR_ERRORS.append(errors[i].message + '<br />');
        }
        
        SELECTOR_SUCCESS.css({ display: 'none' });
        SELECTOR_ERRORS.fadeIn(200);
    } else {
        SELECTOR_ERRORS.css({ display: 'none' });
        SELECTOR_SUCCESS.fadeIn(200);
        document.getElementById("form").submit();
    }
    
    if (event && event.preventDefault) {
        event.preventDefault();
    } else if (event) {
        event.returnValue = false;
    }
});
</script>
</html>