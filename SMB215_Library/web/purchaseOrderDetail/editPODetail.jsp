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
        <title>PO Detail</title>
        <%@ include file="../main.html" %>
        <script>
            function selecteditem() {
            var select = document.getElementById('item');
            var item_id = select.value;
            var myform = document.getElementById('form');
            myform.action = "SavePODetail?id=<%=request.getParameter("id")%>&pohid=<%=request.getParameter("pohid")%>&selecteditem=" + item_id;
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
                                <h3 class="prev-indent-bot">Purchase Order Detail</h3>
                                <div id="content3"> 
                                    <div class="success_box">All of the fields were successfully validated!</div>
                                    <div class="error_box"></div>


                                    <form id="form" name="form" action="" method="post">                    
                                        <fieldset>

                                            <label><span class="text-form">Item* </span>

                                                <select id="item">
                                                    <option value="">Select</option>
                                                    <c:forEach items="${items}" var="itm">
                                                        <option value="${itm.id}">${itm.name}</option>
                                                    </c:forEach> 
                                                </select>
                                            </label>
                                           
                                            <label><span class="text-form">Quantity* </span><input type="text" class="inputText" id="quantity"  
                                                                                                    name="quantity" value="<%=request.getParameter("quantity")%>"></label>

                                            <label><span class="text-form">Unit cost* </span><input type="text" class="inputText" id="unitcost"  
                                                                                                       name="unitcost" value="<%=request.getParameter("unitcost")%>"></label>
                                        
                                            <div class="wrapper">
                                                <div class="extra-wrap">

                                                    <div class="buttons">
                                                        <input type="submit" name="Submit" value="Submit" class="button" onclick="selecteditem()"/>
                                                        <a href="GetPOHeader?mode=edit&amp;id=<%=request.getParameter("pohid")%>"><input type="button" name="Cancel" value="Cancel" class="button"/></a>
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
                name: 'item',
                display: 'Item',
                rules: 'required'
            },
            {
                name: 'quantity',
                display: 'Quantity',
                rules: 'required| numeric'
            },
            {
                name: 'unitcost',
                display: 'Unit cost',
                rules: 'required| numeric'
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
