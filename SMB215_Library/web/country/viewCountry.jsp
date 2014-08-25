<%@page import="country.CountryBean"%>
<%@page import="country.Country"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@ include file="../main.html" %>
<body id="page1">
	<div class="main">
        <!--==============================header=================================-->
        <header>
            <div class="container_12">
                <div class="wrapper p3">
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
                
                <div class="clear"></div>
            </div>
        </header>
        
        <!--==============================content================================-->
        <section id="content"><div class="ic"><div class="inner_copy">All <a href="http://www.magentothemesworld.com" title="Best Magento Templates">premium Magento themes</a> at magentothemesworld.com!</div></div>
            <div class="container_12">
                <div class="wrapper">
				<div class="pull-right">
				<a href="editCountry.jsp"><input type="submit" name="Submit" value="Add" class="button"/></a>
				</div>
				<div class="clear2"></div>
                    <div class="CSSTableGenerator" >
                <table >
				   <tbody>
				       <tr>
                                            <td>Short Name</td>
                                            <td>Name</td>
					    <td width="10%">Actions</td>
				       </tr>
                                       <%
                                            CountryBean cntBean = new CountryBean();
                                            List<Country> list = cntBean.getCountries();
                                            for (Country cnt : list) {
                                        %>
				       <tr>
                                           <td><%=String.valueOf(cnt.getShortName())%></td>
                                           <td><%=cnt.getName()%></td>
                                           <td>
                                                <a href="editCountry.jsp?id=<%=String.valueOf(cnt.getId())%>" class="fa fa-lg fa-pencil-square-o"></a>
                                                <a href="../DeleteCountry?id=<%=String.valueOf(cnt.getId())%>" class="fa fa-lg fa-trash-o"></a> 
                                            </td>
				       </tr>
				      <%
                                            }
                                      %>
				   </tbody>
                </table>
            </div>
            <div class="clear"></div>
			<div id="tnt_pagination">
			<span class="disabled_tnt_pagination">Prev</span>
			<a href="#1">1</a><a href="#2">2</a>
			<a href="#3">3</a>
			<span class="active_tnt_link">4</span>
			<a href="#5">5</a>
			<a href="#6">6</a>
			<a href="#7">7</a>
			<a href="#8">8</a>
			<a href="#9">9</a>
			<a href="#10">10</a>
			<a href="#forwaed">Next</a></div>

			
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
</html>



