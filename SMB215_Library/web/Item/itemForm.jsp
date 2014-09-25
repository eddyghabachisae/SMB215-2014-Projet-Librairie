<%@page import="Item.Item"%>
<%@page import="Item.Item"%>
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
            <section id="content">
                <div class="container_12">
                    <div class="wrapper">
                        <article class="grid_8">
                            <div class="indent-right">
                                <h3 class="prev-indent-bot">Item</h3>
                                <ul id="tabs">
                                    <li><a href="#" title="tab1" class="activeTab">Main Info</a></li>
                                    <% if(request.getParameter("book").equals("true")){ %>
                                                <li><a href="./GetBook?id=<%=request.getParameter("book_id")%>" title="tab2" class="notActive">Book Info</a></li>
                                                <li><a href="./GetBookStatus?book_id=<%=request.getParameter("book_id")%>&id=" title="tab2" class="notActive">Book Status Info</a></li>
                                    <% }%>
                                    
                                </ul>

                                <div id="content3"> 
                                    <div class="success_box">All of the fields were successfully validated!</div>
                                    <div class="error_box"></div>
                                    <%
                                    if(request.getParameter("isExist")!=null && request.getParameter("isExist").equals("false"))
                                    {%>
                                    <div class="msg_box">Barcode Already Exist !</div>
                                    <% } %>
                                    <form id="form" name="form" action="SaveItem?id=<%=request.getParameter("id")%>" method="post" >                    
                                        <fieldset>
                                             <label><span class="text-form">Barcode* </span><input type="text" class="inputText" id="barcode" 
                                                                                               name="barcode" value="<%=request.getParameter("barcode")%>" onchange="checkBarcode()"></label>                   
                                                                                               <a href="#" onclick="generateBracode()" style="margin-left:30%;">If Not Available Click Here To Generate Your Own Barcode</a>
                                            <label><span class="text-form">Name* </span><input type="text" class="inputText" id="name" 
                                                                                               name="name" value="<%=request.getParameter("name")%>"></label>                   
                                          
                                            <label><span class="text-form">Sale price* </span><input type="text" class="inputText" id="saleRentPrice" 
                                                                                                          name="saleRentPrice" value="<%=request.getParameter("saleRentPrice")%>"></label>
                                            <label><span class="text-form">Min Limit In Stock* </span><input type="text" class="inputText" id="minLimit" 
                                                                                                    name="minLimit" value="<%=request.getParameter("minLimit")%>"></label>
                                            <label><span class="text-form">Max Limit In Stock* </span><input type="text" class="inputText" id="maxLimit" 
                                                                                                    name="maxLimit" value="<%=request.getParameter("maxLimit")%>"></label>
                                                                                                    <%  String available= request.getParameter("available");
                                                                                                    %>
                                            <label><span class="text-form">Available? </span><input  name="available" type="checkbox" value="true" <%= (available.equals("true") ? "checked" : "") %> /></label>
                                                                                                     <%  String active= request.getParameter("active");
                                                                                                    %>
                                            <label><span class="text-form">Active?</span><input  name="active" type="checkbox" value="true" <%= (active.equals("true") ? "checked" : "") %>/></label>
                                                                                                      <%  String book= request.getParameter("book");
                                                                                                        %>
                                            <label><span class="text-form">Book ?</span><input  name="book" type="checkbox" value="true" <%=(book.equals("true") ? "checked" : "") %>/></label>
                                            <label><span class="text-form">Category*</span>
                                                <select name="category" id="category" >
                                                    <option value="">Select</option>
                                                    <c:forEach items="${itemCategoryList}" var="itemCat">
                                                        <c:set var="itemID" value="${itemCat.id}" />
                                                        <option value="${itemCat.id}" >${itemCat.code}</option>
                                                    </c:forEach>
                                                </select></label>
                                            <script>
                                                 if ("<%=request.getParameter("category")%>" !== "") {
                                                     var val = <%=request.getParameter("category")%>;
                                                     $('#category').val(val);
                                                 }
                                                </script>
                                            <div class="wrapper">
                                                <div class="text-form">Description</div>
                                                <div class="extra-wrap">
                                                    <textarea name="description"><%=request.getParameter("description")%></textarea>
                                                    <div class="clear2"></div>			
                                                    <div class="buttons">
                                                        <input type="submit" name="Submit" value="Submit" class="button"/>
                                                        <a href="GetItems"><input type="button" name="Cancel" value="Cancel" class="button"/></a>
                                                    </div> 

                                                </div>

                                            </div>                      
                                        </fieldset>						
                                    </form>
                                </div>
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
        <script type="text/javascript"> Cufon.now();</script>
    </body>
    <script type="text/javascript">
        function generateBracode() {
		$('#barcode').val(<%=request.getParameter("nextBarcodeNb")%>);

		}

        function checkBarcode(){
            var barcode = document.getElementById("barcode").value;
            var id = <%=request.getParameter("id")%>;
            window.location = "CheckBarcode?barcode="+barcode+"&id="+id;
        }
        new FormValidator('form', [
            {   name: 'barcode',
                display: 'Barcode',
                rules: 'required'
            },{
                name: 'name',
                display: 'Name',
                rules: 'required'
            },
            {
                name: 'saleRentPrice',
                display: 'Sale Rent price',
                rules: 'required|numeric'
            }, {
                name: 'minLimit',
                display: 'Min Limit',
                rules: 'required|numeric'
            }, {
                name: 'maxLimit',
                display: 'Max Limit',
                rules: 'required|numeric'
            }, {
                name: 'category',
                display: 'Category',
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

                SELECTOR_SUCCESS.css({display: 'none'});
                SELECTOR_ERRORS.fadeIn(200);
            } else {
                SELECTOR_ERRORS.css({display: 'none'});
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