<%-- 
    Document   : settings
    Created on : Aug 24, 2014, 4:44:46 PM
    Author     : Douha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
        <% 
        if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
      response.sendRedirect("login.jsp");
        }
    %>
    <head>
        <title>Settings</title>
        <%@ include file="homeMain.html" %>
    </head>

<body id="page1">
	<div class="main">
        <!--==============================header=================================-->
        <header>
            <div class="container_12">
                <div class="wrapper p3">
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
                <h3 class="prev-indent-bot">Settings</h3>
                <article class="grid_2">
                    <div class="box">
                       <a href="#" class="imgCenter"> <figure class="fa-5x fa fa-sitemap blueColor"></figure></a>
                        <div class="padding">
                            <strong class="title-3 ">Branches</strong>
                        </div>
                    </div>
                </article>
                <article class="grid_2">
                    <div class="box">
					<a href="GetCountries" class="imgCenter"> <figure class="fa-5x fa fa-globe blueColor"></figure></a>
                        <div class="padding">
                            <strong class="title-3 ">Countries</strong>
                        </div>
                    </div>
                </article>
                <article class="grid_2">
                    <div class="box">
					  <a href="province/viewProvince.jsp" class="imgCenter"> <figure class="fa-5x fa fa-globe blueColor"></figure></a>
                        <div class="padding">
                            <strong class="title-3 ">Provinces</strong>
                        </div>
                    </div>
                </article>
                <article class="grid_2">
                    <div class="box">
					  <a href="city/viewCity.jsp" class="imgCenter"> <figure class="fa-5x fa fa-globe blueColor"></figure></a>
                        <div class="padding">
                            <strong class="title-3 ">Cities</strong>
                        </div>
                    </div>
                </article>
                <article class="grid_2">
                    <div class="box">
					  <a href="GetProfessions" class="imgCenter"> <figure class="fa-5x fa fa-globe blueColor"></figure></a>
                        <div class="padding">
                            <strong class="title-3 ">Professions</strong>
                        </div>
                    </div>
                </article>
                <article class="grid_2">
                    <div class="box">
                        <a href="GetLibrarySettings" class="imgCenter"> <figure class="fa-5x fa fa-wrench blueColor"></figure></a>
                        <div class="padding">
                            <strong class="title-3 ">Settings</strong>
                        </div>
                    </div>
                </article>
              
		
		
                
                <div class="clear"></div>
            </div>
        </header>
        
        <!--==============================content================================-->
        <section id="content"><div class="ic"></div>
            <div class="container_12">
                <div class="wrapper">
                    
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
	<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>


