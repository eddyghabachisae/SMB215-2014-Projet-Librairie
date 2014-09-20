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
    <script>
        $(function() {
            $("#orderdatepicker").datepicker();
        });
        $(function() {
            $("#shippingdatepicker").datepicker();
        });
        $(function() {
            $("#deliverydatepicker").datepicker();
        });
        
        function refreshsupplierbranches() {

            var supplier = document.getElementById('supplier').value;
            document.getElementById('supplierbranch').value = '';
            if (supplier === '') {
                document.getElementById('supplierbranch').disabled = true;
            } else {
                document.getElementById('supplierbranch').disabled = false;
                for (var i = 1; i <= document.getElementById('supplierbranch').length - 1; i++) {
                    
                if (document.getElementById('supplierbranch').options[i].className !== supplier) {
                        document.getElementById('supplierbranch').options[i].hidden = true;
                    } else {
                        document.getElementById('supplierbranch').options[i].hidden = false;
                    }
                }
            }
        }
    </script>
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
                                        <li><b><% out.print(session.getAttribute("username"));%></b></li>
                                        <li><a class="active" href="${pageContext.request.contextPath}/home.jsp">Main</a></li>
                                    <li><a href="logout.jsp">Logout</a></li>
                                    </ul>
                                </nav>
                            </div>

                        </div>
                    </div>
                </div>
            </header>

            <!--==============================content================================-->
            <section id="content"><div class="ic"></div>
                <div class="container_12">
                    <div class="wrapper">
                        <article class="grid_8">
                            <div class="indent-right">
                                <h3 class="prev-indent-bot">Purchase Order</h3>
                                <div id="content3"> 
                                    <div class="success_box">All of the fields were successfully validated!</div>
                                    <div class="error_box"></div>


                                    <form id="form" name="form" action="../SaveCountry?id=<%=request.getParameter("id")%>" method="post">                    
                                        <fieldset>

                                            <label><span class="text-form">Branch* </span>

                                                <select id="branch">
                                                    <option value="">Select</option>
                                                    <c:forEach items="${branches}" var="brh">
                                                        <option value="${brh.id}">${brh.name}</option>
                                                    </c:forEach> 
                                                </select>
                                            </label>
                                            <label><span class="text-form">Supplier* </span>
                                                <select id="supplier" onchange="refreshsupplierbranches()">
                                                    <option value="">Select</option>
                                                    <c:forEach items="${suppliers}" var="sup">
                                                        <option value="${sup.id}">${sup.name}</option>
                                                    </c:forEach> 
                                                </select>
                                            </label>

                                            <label><span class="text-form">Supplier Branch* </span>
                                                <select id="supplierbranch"  disabled>
                                                    <option value="">Select</option>
                                                    <c:forEach items="${supplierbranches}" var="sbr">
                                                        <option class="${sbr.supplier}" value="${sbr.id}">${sbr.name}</option>
                                                    </c:forEach> 
                                                </select>
                                            </label>


                                            <label><span class="text-form">Order Date* </span><input type="text" class="inputText" id="orderdatepicker"  
                                                                                                    name="orderdate" value="<%=request.getParameter("orderdate")%>"></label>

                                            <label><span class="text-form">Shipping Date </span><input type="text" class="inputText" id="shippingdatepicker"  
                                                                                                       name="shippingdate" value="<%=request.getParameter("shippingdate")%>"></label>

                                            <label><span class="text-form">Delivery Date </span><input type="text" class="inputText" id="deliverydatepicker"  
                                                                                                       name="deliverydate" value="<%=request.getParameter("deliverydate")%>"></label>

                                            <div class="wrapper">
                                                <div class="extra-wrap">

                                                    <div class="buttons">
                                                        <input type="submit" name="Submit" value="Submit" class="button"/>
                                                        <a href="GetPODetail"><input type="button" name="AddPOD" value="Add Item" class="button"/></a>
                                                        <a href="../GetCountries"><input type="button" name="Cancel" value="Cancel" class="button"/></a>
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
        <script type="text/javascript"> Cufon.now();</script>
    </body>
    <script type="text/javascript">

        new FormValidator('form', [{
                name: 'branch',
                display: 'Branch',
                rules: 'required'
            },
            {
                name: 'supplier',
                display: 'Supplier',
                rules: 'required'
            },
            {
                name: 'supplierbranch',
                display: 'Supplier branch',
                rules: 'required'
            },
            {
                name: 'orderdate',
                display: 'Order Date',
                rules: 'required'
            }], function(errors, event) {
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
