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
        <title>Supplier</title>
        <%@ include file="../main.html" %>
    <script type="text/javascript">
        function validateisactive() {

            if (document.getElementById('isactive').checked) {
                document.getElementById('deactivationlabel').style.display = 'none';
                document.getElementById('deactivationreason').value = '';
                document.getElementById('deactivationreason').style.display = 'none';
            } else {
                document.getElementById('deactivationlabel').style.display = 'block';
                document.getElementById('deactivationreason').style.display = 'block';
            }
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
                                <h3 class="prev-indent-bot">Supplier</h3>

                                <div id="content3"> 
                                    <div class="success_box">All of the fields were successfully validated!</div>
                                    <div class="error_box"></div>


                                    <form id="form" name="form" action="../SaveSupplier?id=<%=request.getParameter("id")%>" method="post">                    
                                        <fieldset>
                                            <label><span class="text-form">Name* </span><input type="text" class="inputText" name="name" value="<%=request.getParameter("name")%>"></label>
                                            <label><span class="text-form">Website </span><input type="text" class="inputText" name="website" value="<%=request.getParameter("website")%>"></label>
                                            <label><span class="text-form">Remarks </span><textarea class="inputText" name="remarks"><%=request.getParameter("remarks")%></textarea></label>

                                            <label><span class="text-form">Active?</span>
                                                <input type="checkbox" id="isactive" name="isactive" 
                                                       onchange="validateisactive()">
                                            </label>
                                            <label id="deactivationlabel"><span class="text-form">Deactivation reason </span><textarea class="inputText" name="deactivationreason" id="deactivationreason"><%=request.getParameter("deactivationreason")%></textarea></label>



                                            <div class="wrapper">
                                                <div class="extra-wrap">		
                                                    <div class="buttons">
                                                        <input type="submit" name="Submit" value="Submit" class="button"  />
                                                        <a href="../GetSuppliers"><input type="button" name="Cancel" value="Cancel" class="button"/></a>
                                                    </div> 

                                                </div>

                                            </div>                      
                                        </fieldset>						
                                        <script>
                                            <% if (request.getParameter("id").equals("")
                        || request.getParameter("isactive").equals("true")) {%>
    document.getElementById('isactive').checked = true;
    validateisactive();
                                            <%}%>
                                        </script>
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

        new FormValidator('form', [{
                name: 'name',
                display: 'Name',
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
