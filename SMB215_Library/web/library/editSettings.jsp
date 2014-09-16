<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
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
                                <h3 class="prev-indent-bot">Item Category</h3>

                                <div id="content3"> 
                                    <div class="success_box">All of the fields were successfully validated!</div>
                                    <div class="error_box"></div>
                             
                                    <form id="form" name="form" action="" method="post" enctype="multipart/form-data">                    
                                        <fieldset>
                                            <label><span class="text-form">Name* </span><input type="text" class="inputText" value="< %= lib.getName() %>"></label>
                                            <label><span class="text-form">Website</span><input type="text" class="inputText" value="< %= lib.getWebsite() %>"></label>
                                             <label><span class="text-form">Main branch</span>
                                                                          </label>
                                            
                                          <!--  <script>
                                            var val =< %=lib.getMainBranch() %>;
                                            $('#sel').val(val);
                                            </script> -->
                                         <label><span class="text-form">Rental days* </span><input type="text" class="inputText" value="< %=lib.getRentalDays()%>"></label>
                                        <label><span class="text-form">Reservation days* </span><input type="text" class="inputText" value="< %=lib.getReservationDays()%>"></label>
                                        <label><span class="text-form">Rental alert* </span><input type="text" class="inputText" value="< %=lib.getRentalAlert()%>"></label>
                                        <label><span class="text-form">Reservation alert* </span><input type="text" class="inputText" value="< %=lib.getReservationAlert()%>"></label>
                                        <label><span class="text-form">Main currency* </span><input type="text" class="inputText" value="< %=lib.getMainCurrency()%>"></label>
                                        <label><span class="text-form">Secondary currency </span><input type="text" class="inputText" value="< %=lib.getSecondaryCurrency()%>"></label>
                                        <label><span class="text-form">Secondary currency rate </span><input type="text"  class="inputText" value="< %=lib.getSecondaryCurrencyRate()%>"></label>
                                       
                                            <div class="wrapper">
                                                <div class="extra-wrap">		
                                                    <div class="buttons">
							<input type="submit" name="Submit" value="Submit" class="button"/>
                                                        <a href="..\settings.jsp"><input type="button" name="Cancel" value="Cancel" class="button"/></a>
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
                name: 'code',
                display: 'Code',
                rules: 'required'
            },
            {
                name: 'description',
                display: 'Description',
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