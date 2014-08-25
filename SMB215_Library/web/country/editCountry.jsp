<%@page import="country.Country"%>
<%@page import="country.CountryBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        	<h3 class="prev-indent-bot">Country Form</h3>
                                    <div class="success_box">All of the fields were successfully validated!</div>
                                    <div class="error_box"></div>
                                     <%
                                            String action = "../AddCountry";
                                            int id = 0;
                                            String shortName = "";
                                            String name = "";
                                            if (request.getParameter("id") != null) {
                                                action = "../ModifyCountry";
                                                id = Integer.parseInt(request.getParameter("id"));
                                                CountryBean cntBean = new CountryBean();
                                                Country cnt = cntBean.getCountry(id);
                                                id = cnt.getId();
                                                shortName = cnt.getShortName();
                                                name = cnt.getName();
                                            }
                                        %>
                            <form id="form" name="form" action="<%= action%>" method="post" enctype="multipart/form-data">                    
                                <fieldset>
                                       <input type="hidden" id="txtCountryId" name="txtCountryId" value ="<%=String.valueOf(id)%>">
                                      <label><span class="text-form">Short Name* </span><input type="text" class="inputText" id="txtCountryShortName" 
                                             name="txtCountryShortName" value="<%= shortName%>"></label>
                                      <label><span class="text-form">Name* </span><input type="text" class="inputText" id="txtCountryName" name="txtCountryName" 
                                       value="<%= name%>"></label>                              
                                      
					<div class="wrapper">
                                        <div class="extra-wrap">
											
                                            <div class="buttons">
							<input type="submit" name="Submit" value="Submit" class="button"/>
                                                        <a href="viewCountry.jsp"><input type="button" name="Cancel" value="Cancel" class="button"/></a>
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
                	Guide.com &copy; 2012
                    <span><a class="link" target="_blank" href="http://www.templatemonster.com/" rel="nofollow">Website Template</a> by TemplateMonster.com</span><span>More <a href="http://www.websitetemplatesonline.com" title="WTO - website templates and Flash templates">Free Web Templates</a> at WTO. All <a href="http://www.magentothemesworld.com" title="Best Magento Templates">premium Magento themes</a> at magentothemesworld.com!</span>
                </div>
            </div>
        </footer>
    </div>
	<script type="text/javascript"> Cufon.now(); </script>
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
