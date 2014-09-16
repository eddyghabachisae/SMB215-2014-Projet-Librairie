<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
    <title>Settings</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../public/stylesheets/reset.css" type="text/css" media="screen">
    <link rel="stylesheet" href="../public/stylesheets/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="../public/stylesheets/grid.css" type="text/css" media="screen">   
    <link rel="stylesheet" href="../public/font-awesome-4.1.0/css/font-awesome.min.css" type="text/css" />
    <link rel="stylesheet" href="../public/stylesheets/table.css" type="text/css" />
    <link rel="stylesheet" href="../public/stylesheets/pagination.css" type="text/css" />
    <link rel="stylesheet" href="../public/stylesheets/tabs.css" type="text/css">
    <script src="../public/javascripts/jquery-1.7.1.min.js" type="text/javascript"></script>
    <script src="../public/javascripts/cufon-yui.js" type="text/javascript"></script>
    <script src="../public/javascripts/cufon-replace.js" type="text/javascript"></script>
    <script src="../public/javascripts/Asap_400.font.js" type="text/javascript"></script>
    <script src="../public/javascripts/Asap_italic_400.font.js" type="text/javascript"></script> 
    <!--- validation!--->
	<link rel="stylesheet" href="../public/stylesheets/validate.css" type="text/css" media="screen"> 
	<script type="text/javascript" src="../public/javascripts/jquery.min.js"></script>	
	<script type="text/javascript" src="../public/javascripts/validate.min.js"></script>
     <!--- validation!--->
    
	<!--[if lt IE 8]>
    <div style=' clear: both; text-align:center; position: relative;'>
        <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
        	<img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
        </a>
    </div>
	<![endif]-->
    <!--[if lt IE 9]>
   		<script type="text/javascript" src="js/html5.js"></script>
        <link rel="stylesheet" href="css/ie.css" type="text/css" media="screen">
	<![endif]-->
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
                                        <li><a class="active" href="../home.jsp">Main</a></li>
                                        <li><a href="">Inbox</a></li>
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
                                <h3 class="prev-indent-bot">Library settings</h3>

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
                name: 'txtCountryShortName',
                display: 'Short Name',
                rules: 'required'
            },
            {
                name: 'txtCountryName',
                display: 'Name',
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