<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <%@ include file="../main.html" %>
    <script>
        function selectedmainbranch() {
            var select = document.getElementById('mainbranch');
            var mainbranch_id = select.value;
            var myform = document.getElementById('form');
            myform.action = "SaveLibrary?selectedmainbranch=" + mainbranch_id;

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
                                        <li><a class="active" href="../home.jsp">Main</a></li>
                                        <li><a href="">Logout</a></li>
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
                                <h3 class="prev-indent-bot">Settings</h3>

                                <div id="content3"> 
                                    <div class="success_box">All of the fields were successfully validated!</div>
                                    <div class="error_box"></div>

                                    <form id="form" name="form" action="SaveLibrary" method="post">                    
                                        <fieldset>
                                            <label><span class="text-form">Name* </span><input type="text" class="inputText" name="name" value="<%=request.getParameter("name")%>"></label>
                                            <label><span class="text-form">Main branch* </span>

                                                <select id="mainbranch">
                                                    <option value="">Select</option>
                                                    <c:forEach items="${branches}" var="brh">
                                                        <option value="${brh.id}">${brh.name}</option>
                                                    </c:forEach> 
                                                </select>
                                            </label>
                                            <script>
                                                if ("<%=request.getParameter("mainbranch")%>" !== "") {
                                                    var val = <%=request.getParameter("mainbranch")%>;
                                                    $('#mainbranch').val(val);

                                                }
                                            </script>

                                            <label><span class="text-form">Website</span><input type="text" class="inputText" name="website" value="<%=request.getParameter("website")%>"></label>

                                            <label><span class="text-form">Rental days* </span><input type="text" class="inputText" name="rentaldays" value="<%=request.getParameter("rentaldays")%>"></label>
                                            <label><span class="text-form">Reservation days* </span><input type="text" class="inputText" name="reservationdays" value="<%=request.getParameter("reservationdays")%>"></label>
                                            <label><span class="text-form">Maximum reserve* </span><input type="text" class="inputText" name="maxreserve" value="<%=request.getParameter("maxreserve")%>"></label>
                                            <label><span class="text-form">Rental alert* </span><input type="text" class="inputText" name="rentalalert" value="<%=request.getParameter("rentalalert")%>"></label>
                                            <label><span class="text-form">Reservation alert* </span><input type="text" class="inputText" name="reservationalert" value="<%=request.getParameter("reservationalert")%>"></label>
                                            <label><span class="text-form">Main currency* </span><input type="text" class="inputText" name="maincurrency" value="<%=request.getParameter("maincurrency")%>"></label>
                                            <label><span class="text-form">Secondary currency </span><input type="text" class="inputText" name="secondarycurrency" value="<%=request.getParameter("secondarycurrency")%>"></label>
                                            <label><span class="text-form">Secondary currency rate </span><input type="text"  class="inputText" name="secondarycurrencyrate" value="<%=request.getParameter("secondarycurrencyrate")%>"></label>

                                            <div class="wrapper">
                                                <div class="extra-wrap">		
                                                    <div class="buttons">
                                                        <input type="submit" name="Submit" value="Submit" class="button" onclick="selectedmainbranch()" />
                                                        <a href="settings.jsp"><input type="button" name="Cancel" value="Cancel" class="button"/></a>
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

        new FormValidator('form', [{
                name: 'name',
                display: 'Name',
                rules: 'required'
            },
            {
                name: 'rentaldays',
                display: 'Rental days',
                rules: 'required|numeric'
            }, {
                name: 'reservationdays',
                display: 'Reservation days',
                rules: 'required|numeric'
            }, {
                name: 'maxreserve',
                display: 'Maximum reserve',
                rules: 'required|numeric'
            }, {
                name: 'rentalalert',
                display: 'Rental alert',
                rules: 'required|numeric'
            }, {
                name: 'reservationalert',
                display: 'Resesrvation alert',
                rules: 'required|numeric'
            }, {
                name: 'secondarycurrenctrate',
                display: 'Secondary currency rate',
                rules: 'numeric'
            }, {
                name: 'mainbranch',
                display: 'Main branch',
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