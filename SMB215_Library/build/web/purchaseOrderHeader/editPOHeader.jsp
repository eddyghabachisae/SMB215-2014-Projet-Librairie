<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <%
        if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
            response.sendRedirect("login.jsp");
        }
    %>
    <head>
        <title>PO Header</title>
        <%@ include file="../main.html" %>
        <script>
            $(function() {
                if (mode !== 'view') {
                    $("#orderdatepicker").datepicker();
                }
            });
            $(function() {
                if (mode === 'edit') {
                    $("#shippingdatepicker").datepicker();
                }
            });
            $(function() {
                if (mode === 'edit') {
                    $("#deliverydatepicker").datepicker();
                }
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
            function selectedvalues() {
                var selectbranch = document.getElementById('branch');
                var branch_id = selectbranch.value;
                var selectsupplierbranch = document.getElementById('supplierbranch');
                var supplierbranch_id = selectsupplierbranch.value;
                var myform = document.getElementById('form');
                myform.action = "SavePOHeader?id=<%=request.getParameter("id")%>&branch=" + branch_id + "&supplierbranch=" + supplierbranch_id + "&employee=" + <%= session.getAttribute("userid")%>;
            }
            
            function addselectedvalues(){
                var selectbranch = document.getElementById('branch');
                var branch_id = selectbranch.value;
                var selectsupplierbranch = document.getElementById('supplierbranch');
                var supplierbranch_id = selectsupplierbranch.value;
                document.getElementById('addpod').href =  document.getElementById('addpod').href +'&branch='+branch_id+'&supplierbranch='+ supplierbranch_id;
            }
            
            function editselectedvalues(){
                var selectbranch = document.getElementById('branch');
                var branch_id = selectbranch.value;
                var selectsupplierbranch = document.getElementById('supplierbranch');
                var supplierbranch_id = selectsupplierbranch.value;
                document.getElementById('editpod').href =  document.getElementById('editpod').href +'&branch='+branch_id+'&supplierbranch='+ supplierbranch_id;
            }
        </script>
    </head>

    <body id="page5">
        <div class="main">
            <!--==============================header=================================-->
            <header>
                <div class="container_12">
                    <div class="wrapper">
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


                                    <form id="form" name="form" action="" method="post">                    
                                        <fieldset>

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

                                            <label><span class="text-form">Branch* </span>

                                                <select id="branch">
                                                    <option value="">Select</option>
                                                    <c:forEach items="${branches}" var="brh">
                                                        <option value="${brh.id}">${brh.name}</option>
                                                    </c:forEach> 
                                                </select>
                                            </label>

                                            <script>
                                                if ("<%=request.getParameter("supplier")%>" !== "") {
                                                    var val = <%=request.getParameter("supplier")%>;
                                                    $('#supplier').val(val);
                                                    refreshsupplierbranches();
                                                }
                                            </script>

                                            <script>
                                                if ("<%=request.getParameter("supplierbranch")%>" !== "") {
                                                    var val = <%=request.getParameter("supplierbranch")%>;
                                                    $('#supplierbranch').val(val);
                                                }
                                            </script>

                                            <script>
                                                if ("<%=request.getParameter("branch")%>" !== "") {
                                                    var val = <%=request.getParameter("branch")%>;
                                                    $('#branch').val(val);
                                                }
                                            </script>

                                            <label><span class="text-form">Order Date* </span><input type="text" class="inputText" id="orderdatepicker"  
                                                                                                     name="orderdate" value="<%=request.getParameter("orderdate")%>"></label>

                                            <label><span class="text-form">Shipping Date </span><input type="text" class="inputText" id="shippingdatepicker"  
                                                                                                       name="shippingdate" value="<%=request.getParameter("shippingdate")%>"></label>

                                            <label><span class="text-form">Delivery Date </span><input type="text"  class="inputText" id="deliverydatepicker"  
                                                                                                       name="deliverydate" value="<%=request.getParameter("deliverydate")%>"></label>

                                            <% if ((request.getParameter("id") != null) && (request.getParameter("id") != "")) {%>                                                               <br>
                                            <div class="CSSTableGenerator" >
                                                <table>
                                                    <tbody>
                                                        <tr>
                                                            <td>Item</td>
                                                            <td>Quantity</td>
                                                            <td>Unit cost <%= (session.getAttribute("mainCurrency")!=null?session.getAttribute("mainCurrency"):"")%></td>
                                             <% if(session.getAttribute("secondaryCurrency")!=null) {%>               
                                                            <td>Unit cost 
                                            <%= session.getAttribute("secondaryCurrency")%>
                                        </td><%}%>
                                                            <td>Item total <%= (session.getAttribute("mainCurrency")!=null?session.getAttribute("mainCurrency"):"")%></td>
                                        <% if(session.getAttribute("secondaryCurrency")!=null) {%>
                                        <td>Item total 
                                            <%= session.getAttribute("secondaryCurrency")%>
                                        </td><%}%>
                                                            <% if ((request.getParameter("deliverydate") == null) || (request.getParameter("deliverydate").equals(""))) {%>
                                                            <td width="10%">Actions</td>
                                                            <%}%>
                                                        </tr>

                                                        <c:forEach items="${podetails}" var="pod">
                                                            <tr>
                                                                <td>${pod.itemname}</td>
                                                                <td>${pod.quantity}</td>
                                                                <td>${pod.unitcost}</td>
                                                                <% if(session.getAttribute("secondaryCurrency")!=null) {%>               
                                                                <td>${pod.secondaryunitcost}</td><%}%>
                                                                <td>${pod.total}</td>
                                                                <% if(session.getAttribute("secondaryCurrency")!=null) {%>               
                                                                <td>${pod.secondarytotal}</td><%}%>
                                                                <% if ((request.getParameter("deliverydate") == null) || (request.getParameter("deliverydate").equals(""))) {%>
                                                                <td>

                                                                    <a id="editpod" onclick="editselectedvalues()" href="GetPODetail?pohid=<%=request.getParameter("id")%>&amp;id=${pod.id}" title="Edit" class="fa fa-lg fa-pencil-square-o" ></a>
                                                                    <a href="DeletePODetail?pohid=<%=request.getParameter("id")%>&amp;id=${pod.id}" title="Delete" class="fa fa-lg fa-trash-o"></a> 
                                                                </td>
                                                                <%}%>


                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                                        <br>
                                            <div class="CSSTableGenerator" style="width:200px;">
                                                <table>
                                                    <tbody>
                                                        <tr>
                                                            <td>Total <%= (session.getAttribute("mainCurrency")!=null?session.getAttribute("mainCurrency"):"")%></td>
                                                            <% if(session.getAttribute("secondaryCurrency")!=null) {%>
                                        <td>Total 
                                            <%= session.getAttribute("secondaryCurrency")%>
                                        </td><%}%>
                                                        </tr>
                                                        <tr>
                                                            <td><%=request.getParameter("total")%></td>
                                                            <% if(session.getAttribute("secondaryCurrency")!=null) {%>
                                        <td><%=request.getParameter("totalsecondary")%>
                                        </td><%}%>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <%}%>
                                            <div class="wrapper">
                                                <div class="extra-wrap">



                                                    <div class="buttons">
                                                        <input type="submit" name="Submit" id="submit" value="Submit" class="button" onclick="selectedvalues()"/>
                                                        <% if ((request.getParameter("id") != null) && (request.getParameter("id") != "")) {%>                                                               
                                                        <a href="GetPODetail?pohid=<%=request.getParameter("id")%>" id="addpod" onclick="addselectedvalues()"><input type="button" id="add" name="AddPOD" value="Add Item" class="button"/></a>
                                                            <%}%>
                                                        <a href="GetPOHeaders"><input type="button"  name="Cancel" value="Cancel" class="button"/></a>
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

            <script>
                var mode = '<%=request.getParameter("mode")%>';
                if ((mode === 'edit') || (mode === 'view')) {
                    document.getElementById('supplier').disabled = true;
                    document.getElementById('supplierbranch').disabled = true;
                    document.getElementById('branch').disabled = true;
                }
                if  ((mode !== 'edit') || ((mode === 'edit') && ('<%=request.getParameter("total")%>'==='0.0'))) {
                    document.getElementById('shippingdatepicker').disabled = true;
                    document.getElementById('deliverydatepicker').disabled = true;
                }
                if (mode === 'view') {
                    document.getElementById('branch').disabled = true;
                    document.getElementById('orderdatepicker').disabled = true;
                    document.getElementById('submit').style.visibility = 'hidden';
                    document.getElementById('add').style.visibility = 'hidden';
                }
            </script>

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
